import java.util.HashSet;
import java.util.Set;

public class FindElementContaminatedBinaryTree {

    public static void main(String[] args) {

    }

    class FindElements {

        Set<Integer> values = new HashSet<>();

        public FindElements(TreeNode root) {
            root.val = 0;
            values.add(root.val);
            recover(root);
        }

        public void recover(TreeNode root){
            int x = root.val;
            if (root.left != null){
                root.left.val = (x * 2) + 1;
                values.add(root.left.val);
                recover(root.left);
            }
            if (root.right != null){
                root.right.val = (x * 2) + 2;
                values.add(root.right.val);
                recover(root.right);
            }
        }

        public boolean find(int target) {
            return values.contains(target);
        }
    }

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

}
