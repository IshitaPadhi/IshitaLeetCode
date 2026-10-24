// class Solution {//Brute force 
// //TC IS O(N^2)*LOG(256) AT MAX OF LOG(26) IF LOWERCASE CHARS ARE GIVEN AND SC IS O(256)
//     public int kDistinctChar(String s, int k) {
//         int maxLen=0;
//         int n=s.length();
//         for(int i=0;i<n;i++){
//         HashMap<Character,Integer>map=new HashMap<>();
//         for(int j=i;j<n;j++){
//             map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
//             if(map.size()<=k){
//                 maxLen=Math.max(maxLen,j-i+1);
//             }else{
//                 break;
//             }
//         }

//         }
//         return maxLen;
//     }
// }
class Solution{//O(2N)+log(256) and the inner while loop is causing extra time complexity so we try to optimise it further and sc is o(256) for the hashmap we are using to store the characters so we change while to if 
//while = shrink until valid; if = shrink once and move on.
//if approach mein hum window ko temporarily invalid rehne dete hain, kyunki humein har step par valid window chahiye hi nahi. Humein sirf longest valid substring ki maximum length track karni hai.
    int maxLen=0;
    int l=0;
    int r=0;
    int n=s.length();
    HashMap<Character,Integer>map=new HashMap<>();
    while(r<n){
        map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
        if(map.size()>k){
            //when it exceeds the given size=k we start moving the left index to the right in order to shrink our window
            char ch=s.charAt(l);
            map.put(ch,map.get(ch)-1);
            //we will remove the leftest character from the map and we increment the l or if the freq of the char reduces to zero we remove it
            if (map.get(ch) == 0) {
            map.remove(ch);
            }
            l++;
        }
        if(map.size()<=k){
            maxLen=Math.max(maxLen,r-l+1); //if it is within the range then we compute the comparision between maxLen and the substring size
        }
        r++;
        
    }
    return maxLen;
}
}
