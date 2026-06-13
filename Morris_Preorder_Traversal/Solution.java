/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
    public List<Integer> preorder(TreeNode root) {
       List<Integer> ans=new ArrayList<>();
       TreeNode curr= root;
       while(curr!=null){
        if(curr.left==null){
            ans.add(curr.data);
            curr=curr.right;
        }else{
            TreeNode pred=curr.left;
            while(pred.right!=null && pred.right!=curr){
                pred=pred.right;
            }
            if(pred.right==null){
                pred.right=curr;
                ans.add(curr.data);
                curr=curr.left;
            }else{
                pred.right=null;
                curr=curr.right;
            }
        }
       }
       return ans;
    }
}
