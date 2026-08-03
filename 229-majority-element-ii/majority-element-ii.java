/*class Solution { //brute force approach 1 -> TC O(n^2) and SC is O(2) for a 2 sized ArrayList
    public List<Integer> majorityElement(int[] nums) {
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(!ans.contains(nums[i])){
                int cnt=0;
                for(int j=0;j<nums.length;j++){
                    if(nums[j]==nums[i]){
                        cnt++;
                    }
                }
                if(cnt>nums.length/3){
                    ans.add(nums[i]);
                }
            }
             if(ans.size()==2)break;
        }
        return ans;
       

    }
}*/
/*class Solution{ 
    public List<Integer> majorityElement(int[] nums){
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer> ans=new ArrayList<>();
        int n=nums.length;
        int minFreq=(n/3)+1;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        if(map.get(nums[i])==minFreq){
            ans.add(nums[i]);
        }
        if(ans.size()==2)break;
       
        return ans;
    }
}*/
class Solution{//O(n)->TC and SC-> O(1)
    public List<Integer> majorityElement(int[] nums){
        int el1=Integer.MIN_VALUE;
        int el2=Integer.MIN_VALUE;
        int count1=0;
        int count2=0;
        for(int i=0;i<nums.length;i++){
            if(count1==0 && nums[i]!=el2){
                count1=1;
                el1=nums[i];
            }else if(count2==0 && nums[i]!=el1){
                count2=1;
                el2=nums[i];
            }else if(nums[i]==el1){
                count1++;
            }else if(nums[i]==el2){
                count2++;
            }else{
                count1--;
                count2--;
            }

        }
        //to check if els found are actually majority and adding them to a list
        List<Integer>ans=new ArrayList<>();
        int cnt1=0;
        int cnt2=0;
        for(int i=0;i<nums.length;i++){
            if(el1==nums[i])cnt1++;
            if(el2==nums[i])cnt2++;
            
        }
        int min=(nums.length/3)+1;
        if(cnt1>=min){
            ans.add(el1);
        }
        if( el2!=el1 && cnt2>=min){
            ans.add(el2);
        }
        return ans;

    }
}