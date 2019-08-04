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
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        maxPath(root);
        return ans;
    }
    
    private int maxPath(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = maxPath(root.left);
        int r = maxPath(root.right);
        int pl = 0;
        int pr = 0;
        if(root.left != null && root.val == root.left.val){
            pl = l + 1;
        }
        if(root.right != null && root.val == root.right.val){
            pr = r + 1;
        }
        ans = Math.max(pl + pr, ans);
        return Math.max(pl, pr);
    }
}