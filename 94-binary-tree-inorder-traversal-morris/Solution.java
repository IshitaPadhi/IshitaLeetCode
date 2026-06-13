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
    public List<Integer> getInorder(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null){
            //if left is null 
            if(curr.left==null){
                ans.add(curr.data);
                curr=curr.right; //go right
            }else{
            TreeNode pred=curr.left; //left subtree
            while(pred.right!=null && pred.right!=curr){
                pred=pred.right; //rightmost in the left subtree to find inorder predecessor 
            }
            if(pred.right==null){//if there is no thread, create a thread
                pred.right=curr; // connect rightmost child of left subtree to
                //the curr
                curr=curr.left;//traverse left
            }else{
                pred.right=null; //if thread already exists,we have traveresed that path so remove the thread
                ans.add(curr.data); //print current
                curr=curr.right;//traverse right 

            }
        }

        }
        return ans;
    }

}
