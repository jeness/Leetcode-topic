/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution1 {
    public int findBottomLeftValue(TreeNode root) {
        //层次遍历bfs, 取每一层的第一个出来，直到取到最后一层的第一个，返回即可
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode first = q.peek();
            res = first.val;
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }
            }
        }
        return res;
    }
}

class Solution2 {
    public int findBottomLeftValue(TreeNode root) {
        //dfs
        return findBottomLeft(root, new int[]{0, 0}, 1); //depth初值=1，res[1]初值=0，说明要更新res[1], 再往下一层时，depth+1
    }
    
    private int findBottomLeft(TreeNode root, int[] res, int depth){
        if(res[1] < depth){
            res[0] = root.val;
            res[1] = depth;
        }
        if(root.left != null){
            findBottomLeft(root.left, res, depth+1);
        }
        if(root.right != null){
            findBottomLeft(root.right, res, depth+1);
        }
        
        return res[0];
    }
}