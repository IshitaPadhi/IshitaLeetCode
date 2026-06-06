class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> n=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            n.add(nums[i]);
        }
        for(int i=0;i<nums.length-k;i++){
            n.remove();
        }
        return n.peek();
    }
}