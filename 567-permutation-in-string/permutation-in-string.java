class Solution {
    public boolean isFreqSame(int freq[], int windowfreq[]){
        //o(1) since we know the number of comparisions
    for(int i=0;i<26;i++){
        if(freq[i]!=windowfreq[i]){
            return false;
        }
    }
    return true;

    }
    public boolean checkInclusion(String s1, String s2) {
        int freq[]=new int[26];
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
        }
        int windowsize=s1.length();
        for(int i=0;i<s2.length();i++){
            int windowindex=0;
            int idx=i; //to map the actual index
            int windowfreq[]=new int[26];
            while(windowindex<windowsize && idx<s2.length()){
                windowfreq[s2.charAt(idx)-'a']++;
                windowindex++;
                idx++;
            }
            if(isFreqSame(freq,windowfreq)){
                return true;
            }
        }
        return false;
    }
}