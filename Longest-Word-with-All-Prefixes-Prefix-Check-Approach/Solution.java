import java.util.*;

class Solution {

    static class Node {

        Node children[] = new Node[26];
        boolean eow;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    static Node root = new Node();

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

    public static boolean checkAllPrefixes(String word) {

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {

            int idx = word.charAt(i) - 'a';

            curr = curr.children[idx];

            if (curr == null || curr.eow == false) {
                return false;
            }
        }

        return true;
    }

    public static String completeString(List<String> nums) {

        root = new Node();

        for (int i = 0; i < nums.size(); i++) {
            insert(nums.get(i));
        }

        String ans = "";

        for (int i = 0; i < nums.size(); i++) {

            String word = nums.get(i);

            if (checkAllPrefixes(word)) {

                if (word.length() > ans.length()) {

                    ans = word;

                } else if (word.length() == ans.length()
                        && word.compareTo(ans) < 0) {

                    ans = word;
                }
            }
        }

        return ans.equals("") ? "None" : ans;
    }
}
