import static java.lang.Integer.min;

public class SecondMinimumNodeInABinaryTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(10);
        TreeNode right = new TreeNode(5);
        TreeNode left  = new TreeNode(5);
        left.left = new TreeNode(7);
        left.right = new TreeNode(5);
        right.left = left;

        right.right = new TreeNode(11);
        treeNode.right = right;

        System.out.println(findSecondMinimumValue(treeNode));
    }

    public static int findSecondMinimumValue(TreeNode root) {
        if (root.left == null || root.right == null){
            return -1;
        }
        if (root.left.val == root.right.val) {
            return -1;
        }
        if (root.right.val > root.left.val){
            return helper(root.right, root.right.val);
        }
        return helper(root.left, root.left.val);
    }

    public static int helper(TreeNode node, int curSecMin){
        if (node.right == null || node.left == null){
            return curSecMin;
        }
        if (node.left.val > node.right.val) {
            return helper(node.right, min(node.left.val, node.right.val));
        }
        return helper(node.left, min(node.left.val, node.right.val));
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
