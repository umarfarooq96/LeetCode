import java.util.Arrays;
import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree {

    private static final String DELIMITER = "/";
    private static final String NULL_NODE = "NULL";

    public static void main(String[] args) {
        TreeNode node      = TreeNode.deserialize("5,2,3,null,null,2,4,3,1");
        String   serialize = new SerializeAndDeserializeBinaryTree().serialize(node);
        System.out.println(serialize);
        System.out.println(new SerializeAndDeserializeBinaryTree().deserialize(serialize));
    }

    public String serialize(TreeNode root) {
        if (root == null) return NULL_NODE + DELIMITER;
        return root.val + DELIMITER + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<String>();
        nodes.addAll(Arrays.asList(data.split(DELIMITER)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(LinkedList<String> nodes) {
        String node = nodes.remove();
        if (node.equals(NULL_NODE)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = buildTree(nodes);
        root.right = buildTree(nodes);
        return root;
    }
}
