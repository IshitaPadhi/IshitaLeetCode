import java.util.*;

class Solution {
    public ArrayList<Integer> topKSumPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {

                pq.add(nums1[i] + nums2[j]);

                if (pq.size() > k) {
                    pq.remove();
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            ans.add(pq.remove());
        }

        Collections.reverse(ans);

        return ans;
    }
}
