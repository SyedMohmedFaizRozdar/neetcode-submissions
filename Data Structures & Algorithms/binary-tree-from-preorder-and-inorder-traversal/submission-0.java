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
    int preOrderIndex = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }

        return helper(preorder, 0, inorder.length-1);
    }
    public TreeNode helper(int[] preorder, int inorderStart, int inorderEnd){
        if(inorderStart > inorderEnd) return null;

        int rootval = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(rootval);
        int mid = map.get(rootval);

        root.left = helper(preorder,inorderStart,mid-1);

        root.right = helper(preorder,mid+1,inorderEnd);

        return root;
    }
}
