/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

/*class Solution {
    List<List<Integer>> treeTraversal(TreeNode root) {
       List<Integer>i=new ArrayList<>();
       List<Integer>pr=new ArrayList<>();
       List<Integer>po=new ArrayList<>();
       inorder(root,i);
       preorder(root,pr);
       postorder(root,po);
       List<List<Integer>> ans=new ArrayList<>();
       ans.add(i);
       ans.add(pr);
       ans.add(po);
       return ans;

    }
private void inorder(TreeNode root, List<Integer>i){
    if(root==null){
        return;
    }
    inorder(root.left,i);
    i.add(root.data);
    inorder(root.right,i);
}
private void preorder(TreeNode root, List<Integer>pr){
    if(root==null){
        return;
    }
    pr.add(root.data);
    preorder(root.left,pr);
    preorder(root.right,pr);
}
private void postorder(TreeNode root, List<Integer>po){
    if(root==null){
        return;
    }
    postorder(root.left,po);
    postorder(root.right,po);
    po.add(root.data);
}*/

class Solution {
    class Pair{
        TreeNode node;
        int state;
        public Pair(TreeNode node, int state){
            this.node=node;
            this.state=state;
        }
    }
    List<List<Integer>> treeTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            ans.add(inorder);
            ans.add(preorder);
            ans.add(postorder);
            return ans;
        }
        Stack<Pair>s=new Stack<>();
        s.push(new Pair(root,1)); //initally push root with state 1
        while(!s.isEmpty()){
            Pair curr=s.pop();
            TreeNode node=curr.node;
            int state=curr.state;
            if(state==1){
                preorder.add(node.data); //visit the node
                s.push(new Pair(node,2));//increment karke push it in the Stack
                //if left child is there then push it in the Stack
                if(node.left!=null){
                    s.push(new Pair(node.left,1));
                }

            }
            else if(state==2){
                inorder.add(node.data); // visit node
                s.push(new Pair(node,3));//increment karke push it in the Stack
                //if right child is there then push it in the Stack
                if(node.right!=null){
                    s.push(new Pair(node.right,1));
                }

            }else{
                postorder.add(node.data);
            }
        }
        ans.add(inorder);
        ans.add(preorder);
        ans.add(postorder);
        return ans;
        
    }
    }
