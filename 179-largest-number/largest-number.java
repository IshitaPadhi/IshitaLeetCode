class Solution {
    public String largestNumber(int[] nums) {
        String arr[]=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=String.valueOf(nums[i]);
        }
        //remember this custom operator
        Arrays.sort(arr,(a,b)->(b+a).compareTo(a+b));
        if(arr[0].equals("0")){
            return "0";
        }
        StringBuilder x = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            x.append(arr[i]);
        } 
        return x.toString();
    }
}