public class SerializeAndDeserializeBST {

    public static void main(String[] args) {
        TreeNode tree          = TreeNode.deserialize("8,3,10,1,6,null,14,null,null,4,7,13");
        String   serializeTree = new SerializeAndDeserializeBST().serialize(tree);
        System.out.println(serializeTree);
        System.out.println(new SerializeAndDeserializeBST().deserialize(serializeTree));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        /*
        BST has a property: left < root < right
        we can just do a preorder traversal
        root, left, right
        our structure will satisfy
        root, |all less than root|, |all greater than root|
        we can split our list up like that later
        */
        if (root == null) return "";

        return root.val + ","
              + serialize(root.left)
              + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] nodes = data.split(",");

        TreeNode root = new TreeNode();
        root.val = Integer.parseInt(nodes[0]);

        StringBuilder leftPart  = new StringBuilder();
        StringBuilder rightPart = new StringBuilder();

        for (int i = 1; i < nodes.length; i++) {
            int val = Integer.parseInt(nodes[i]);
            if (val < root.val) {
                leftPart.append(nodes[i]).append(",");
            }
            if (val > root.val) {
                rightPart.append(nodes[i]).append(",");
            }
        }

        root.left = deserialize(leftPart.toString());
        root.right = deserialize(rightPart.toString());

        return root;
    }
}
