class Trie {
    static class Node{
        Node children[]=new Node[26];
        int prefixcount;
        int endcount;
        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
    public static Node root;
    public Trie() {
        root=new Node();
    }

    public void insert(String word) {
        Node curr=root;
        for(int level=0;level<word.length();level++){
            int idx=word.charAt(level)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
            curr.prefixcount++;
        }
        curr.endcount++;

    }

    public int countWordsEqualTo(String word) {
        Node curr=root;
        for(int level=0;level<word.length();level++){
            int idx=word.charAt(level)-'a';
            if(curr.children[idx]==null){
                return 0;
            }
            curr=curr.children[idx];
       
        }
        return curr.endcount;
}

    public int countWordsStartingWith(String prefix) {
        Node curr=root;
        for(int i=0;i<prefix.length();i++){
            int idx=prefix.charAt(i)-'a';
            if(curr.children[idx]==null){
                return 0;
            }
            curr=curr.children[idx];
           
        }
       return curr.prefixcount;
    }

    public void erase(String word) {
        if(countWordsEqualTo(word)==0){
            return;
        }
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            curr=curr.children[idx];
            curr.prefixcount--;
        }
        curr.endcount--;
        
    }
}

