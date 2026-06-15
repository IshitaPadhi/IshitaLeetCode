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
        TreeNode tn;
        int hd;
        public Info(TreeNode tn, int hd){
        this.tn=tn;
        this.hd=hd;

        }
    }
    
    List<Integer> ans=new ArrayList<>();
    public void topViewHelper(TreeNode root){
              if (root == null) {
            return;
        }
        Queue<Info> q=new LinkedList<>();
        HashMap<Integer,TreeNode> map =new HashMap<>();
        int min=0,max=0;
        q.add(new Info(root,0));
        while(!q.isEmpty()){
            Info curr= q.remove();
                if(!map.containsKey(curr.hd)){ //if map does not exist in map first time occuring so put in map
                map.put(curr.hd,curr.tn);
                }
            if(curr.tn.left!=null){
                q.add(new Info(curr.tn.left,curr.hd-1));
                min=Math.min(min,curr.hd-1);
            }
            if(curr.tn.right!=null){
                q.add(new Info(curr.tn.right,curr.hd+1));
                max=Math.max(max,curr.hd+1);
            }
        
    }
    for(int i=min;i<=max;i++){
        ans.add(map.get(i).data);
    }
    }
    public List<Integer> topView(TreeNode root) {
    ans.clear();
    topViewHelper(root);
     return ans;
    }   
}
