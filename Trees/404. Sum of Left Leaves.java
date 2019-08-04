/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0; //base case of recursion
        
        int ans = 0;
        if(root.left != null){ //找左节点是否是左孩子
            if(root.left.left == null && root.left.right == null){ //是左孩子
                ans += root.left.val;
            }
            else{
                ans = ans + sumOfLeftLeaves(root.left);
            }
        }
        ans += sumOfLeftLeaves(root.right);
        return ans;
    }
}