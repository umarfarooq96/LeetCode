import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }

    TreeNode() {
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[]        nodes      = data.split(",");
        TreeNode        root       = new TreeNode(Integer.parseInt(nodes[0]));//root cannot be null here
        Queue<TreeNode> parenNodes = new LinkedList<>();
        int             idx        = 0;
        int             count      = 1;
        int             nextCount  = 0;
        parenNodes.offer(root);
        while (parenNodes.peek() != null) {
            while (count != 0) {
                TreeNode curr = parenNodes.poll();
                idx++;
                if (idx >= nodes.length) break;
                if (nodes[idx].equals("null")) {
                    curr.left = null;
                } else {
                    TreeNode lchild = new TreeNode(Integer.parseInt(nodes[idx]));
                    curr.left = lchild;
                    parenNodes.offer(lchild);
                    nextCount++;
                }
                idx++;
                if (idx >= nodes.length) break;
                if (nodes[idx].equals("null")) {
                    curr.right = null;
                } else {
                    TreeNode rchild = new TreeNode(Integer.parseInt(nodes[idx]));
                    curr.right = rchild;
                    parenNodes.offer(rchild);
                    nextCount++;
                }
                count--;
            }
            count = nextCount;
        }
        return root;
    }
}