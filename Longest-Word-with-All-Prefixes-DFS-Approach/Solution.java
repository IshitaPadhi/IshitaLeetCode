import java.util.*;

class Solution {

    public static String ans = "";

    static class Node {
        Node children[] = new Node[26];
        boolean eow;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {

            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static void dfs(Node root, StringBuilder temp) {

        if (root == null) {
            return;
        }

        for (int i = 0; i < 26; i++) {

            if (root.children[i] != null &&
                    root.children[i].eow == true) {

                char ch = (char) (i + 'a');

                temp.append(ch);

                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }

                dfs(root.children[i], temp);

                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public String completeString(List<String> nums) {

        root = new Node();
        ans = "";

        for (String word : nums) {
            insert(word);
        }

        dfs(root, new StringBuilder());

        return ans.equals("") ? "None" : ans;
    }
}
