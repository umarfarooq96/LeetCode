public class LowestCommonAncestor {

    public static void main(String[] args) {
        Solution s  = new Solution();
        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);
        TreeNode t6 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t0 = new TreeNode(0);
        TreeNode t8 = new TreeNode(8);
        TreeNode t7 = new TreeNode(7);
        TreeNode t4 = new TreeNode(4);
        t3.left = t5;
        t3.right = t1;
        t5.left = t6;
        t5.right = t2;
        t2.left = t7;
        t2.right = t4;
        t1.left = t0;
        t1.right = t8;

        s.lowestCommonAncestor(t3, t5, t4);
    }

    static class Solution {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            return lca(root, p, q);
        }

        public TreeNode lca(TreeNode cur, TreeNode p, TreeNode q) {
            if (cur == null) return null;
            if (cur == p || cur == q) return cur;
            TreeNode left  = lca(cur.left, p, q);
            TreeNode right = lca(cur.right, p, q);

            /*
            if both left and right are null, that means we didn't find p or q in left or right of this guy, keep going up
            if only one is null, then we found it in one subtree -- so this can't be a LCA but it's parent might
                remember which one we found so we can bubble it up
            if found in both left and right, then this is an ancestor, return it.
             */
            if (left == null && right == null) {
                return null;
            } else if (left != null && right == null) {
                return left;
            } else if (left == null && right != null) {
                return right;
            } else {
                return cur;
            }
        }
    }
}
