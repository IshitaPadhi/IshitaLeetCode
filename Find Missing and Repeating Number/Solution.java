/*class Solution {//brute force 
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int missing=0,repeating=0;
        int ans[]=new int[2];
        int count[]=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
        count[nums[i]]++;
        }
        for(int i=1;i<=nums.length;i++){
            if(count[i]==2){
                repeating=i;
            }
            
            if(count[i]==0){
                missing=i;
            }

        }
        ans[0]=repeating;
        ans[1]=missing;
        return ans;

    }
}*/
class Solution{//O(n)-tc,//o(1)-sc //approach 2 - 2 equations 
    public int[] findMissingRepeatingNumbers(int[] nums){
        int ans[]=new int[2];
        long n=nums.length;
        //S-SN=x-y
        //S2-S2N=x^2-y^2
        long  SN=(n*(n+1))/2;
        long  S2N=(n*(n+1)*(2*n+1))/6;
        long S=0;
        long S2=0;
        for(int i=0;i<n;i++){
            S+=nums[i];
            S2+=(long)nums[i]*nums[i];
        }
        long val1=S-SN;//x-y
        long val2=S2-S2N;//(x-y)(x+y)=val2, X+Y=val2/val1
        val2=val2/val1;
        long x= (val1+val2)/2;
        long y=x-val1;
        ans[0]=(int)x;
        ans[1]=(int)y;
        return ans;//x repeating y missing



    }
}
