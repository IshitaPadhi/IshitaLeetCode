class Solution {
    public boolean isAnagram(String s, String t) {//O(n) is tc and o(k) is sc where k is the no of distinct elements
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1); //traverse s and add the characters along with their freq in hashmap
        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(!map.containsKey(ch)||map.get(ch)==0){
                return false; //traverse the second hashmap, let ch be the ith char,if map doesn't contain the char or it's freq has reduced to zero we return false 
            }
            map.put(ch,map.get(ch)-1); //then we put the updated(decreased) freq to the hashmap
        }
        return true;//return true otherwise
    }
}