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
    static class Info{
        TreeNode node;
        int hd;
        public Info(TreeNode node,int hd){
            this.node=node;
            this.hd=hd;
        }
    }
    List<Integer> ans=new ArrayList<>();
    public void bottomViewHelper(TreeNode root){
        if(root==null){
            return;
        }
        Queue<Info>q=new LinkedList<>();
        HashMap<Integer,TreeNode>map=new HashMap<>();
        int min=0,max=0;
        q.add(new Info(root,0));
        while(!q.isEmpty()){
            Info curr=q.remove();
            map.put(curr.hd,curr.node);
            if(curr.node.left!=null){
                q.add(new Info(curr.node.left,curr.hd-1));
                min=Math.min(min,curr.hd-1);
            }
            if(curr.node.right!=null){
                q.add(new Info(curr.node.right,curr.hd+1));
                max=Math.max(max,curr.hd+1);
            }
        }
        for(int i=min;i<=max;i++){
            ans.add(map.get(i).data);
        }
    }
    public List<Integer> bottomView(TreeNode root) {
        ans.clear();
        bottomViewHelper(root);
        return ans;
    }
}
