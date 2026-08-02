/*class Solution {//brute force
    public int majorityElement(int[] nums) {//SC-O(1),TC->O(n^2)
        int n=nums.length;
        for(int i=0;i<n;i++){
            int count =0;
            for(int j=0;j<n;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
            if(count>n/2){
                return nums[i];
            }
        }
        return -1;

    }
}*/
/*class Solution{//HashMap Approach- TC->)(n) [freq count+map traversal] but SC->O(n)
    public int majorityElement(int[] nums){
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int x:map.keySet()){
            if(map.get(x)>n/2){
                return x;
            }
        }
        return -1;
 
    }
}*/
class Solution{//Moore's voting algorithm
    public int majorityElement(int[] nums){
        //first pass finds the majority element 
        // Candidate = jo abhi majority lag raha hai
        int el = 0;
        int cnt=0;
        //we will traverse the whole array
        for(int i=0;i<nums.length;i++){
            //if el is cancelled i.e. count=0 so prev candidate is not majority we will make the current element to be el
            if(cnt==0){
                el=nums[i];
                cnt=1;
            }else if(nums[i]==el){
                cnt++; //if curr element is equal to el we increase count
            }else{
                cnt--;//else we decrease count
            }
        }
        //now we will check if the el we got is actually the majority element or not
        int count1=0;
        //count the actual freq of el
        for(int i=0;i<nums.length;i++){
            if(el==nums[i]){
                count1++;// actual count of el
            }
        }
        if(count1>nums.length/2){
            return el; //if freq count > n/2 return that el as ans
        }
     return -1; //else return -1 

    }
}