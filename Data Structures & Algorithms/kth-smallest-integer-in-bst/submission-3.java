/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int count = 0;
    private int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = -1;

        helper(root,k);
        return result;
        
    }
    public void helper(TreeNode root, int k){
        if(root == null || result != -1) return;

        helper(root.left,k);
        count ++;
        if(count == k){
            result = root.val;
            return;
        }
        helper(root.right,k);
    }
}
