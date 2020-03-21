import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public static List<Integer> rightSideView(TreeNode root) {
        /*
        basically want the right-most node on each level
        let's do bfs
         */
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return Collections.emptyList();
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> curLevelNodes = new ArrayList<>();
            TreeNode lastOfLevel = null;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                curLevelNodes.add(node);
                lastOfLevel = node;
            }
            result.add(lastOfLevel.val);
            curLevelNodes.forEach(curLevelNode -> queue.addAll(allChildren(curLevelNode)));
        }
        return result;
    }

    static List<TreeNode> allChildren(TreeNode node) {
        List<TreeNode> children = new ArrayList<>();
        if (node.left != null) {
            children.add(node.left);
        }
        if (node.right != null) {
            children.add(node.right);
        }
        return children;
    }
}
