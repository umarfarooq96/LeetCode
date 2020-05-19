public class IsSameTree {

    public static void main(String[] args) {
        TreeNode p = new TreeNode(10);
        p.left = new TreeNode(5);
        p.right = new TreeNode(15);

        TreeNode q     = new TreeNode(10);
        TreeNode qleft = new TreeNode(5);
        qleft.right = new TreeNode(15);
        q.left = qleft;

        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            //if either are false but not both (previous if) then
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
