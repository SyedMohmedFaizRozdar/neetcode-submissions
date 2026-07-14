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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root,sb);
        return sb.toString();
    }
    public void buildString(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("N,");
            return;
        }

        sb.append(root.val).append(",");

        buildString(root.left,sb);
        buildString(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(queue);
    }
    public TreeNode helper(Queue<String> queue){
        if(queue.isEmpty()) return null;

        String val = queue.poll();

        if(val.equals("N")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));

        root.left = helper(queue);
        root.right = helper(queue);

        return root;
    }
}
