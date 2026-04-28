import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;
    public void add(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        root.add(data);
    }

    // public void add(String data) {
    //     if (root == null) {
    //         root = new Node(data);
    //         return;
    //     }
    //     root.add(data);
    // }

    public void preTraverse(Node node) {
        if (node == null) return;
        // System.out.printf("[%d]", node.data);
        System.out.printf("[%s]", node.data);
        preTraverse(node.left);
        preTraverse(node.right);
    }

    public void inTraverse(Node node) {
        if (node == null) return;
        inTraverse(node.left);
        // System.out.printf("[%d]", node.data);
        System.out.printf("[%s]", node.data);
        inTraverse(node.right);
    }

    public void postTraverse(Node node) {
        if (node == null) return;
        postTraverse(node.left);
        postTraverse(node.right);
        // System.out.printf("[%d]", node.data);
        System.out.printf("[%s]", node.data);
    }

    //menghitung node
    public int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    //menghitung daun
    public int countLeaves(Node node) {
        if (node == null) {
            return 0;
        }
        // jika tidak punya anak kiri dan kanan → daun
        if (node.left == null && node.right == null) {
            return 1;
        }
        return countLeaves(node.left) + countLeaves(node.right);
    }

    //menghitung tinggi tree
    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int tinggiKiri = getHeight(node.left);
        int tinggiKanan = getHeight(node.right);
        return 1 + Math.max(tinggiKiri, tinggiKanan);
    }

    //levelTraverse
    public void levelTraverse(Node node) {
        if (node == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.printf("[%d]", current.data);

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // tree.add("Mango");
        // tree.add("Apple");
        // tree.add("Banana");
        // tree.add("Cherry");

        // System.out.print("In-Order : ");
        // tree.inTraverse(tree.root);

        System.out.println("=== Memasukkan Data ke dalam Tree ===");
        for (int i = 0; i < 10; i++) {
            int nilai = (int) (Math.random() * 100);
            System.out.printf("Nilai %d dimasukkan.\n", nilai);
            tree.add(nilai);
        }

        // System.out.println("\n=== Hasil Traversal Binary Search Tree ===\n");

        // System.out.print("Pre-Order  (Root, Left, Right) : ");
        // tree.preTraverse(tree.root);
        // System.out.println();

        // System.out.print("In-Order   (Left, Root, Right) : ");
        // tree.inTraverse(tree.root);
        // System.out.println();

        // System.out.print("Post-Order (Left, Right, Root) : ");
        // tree.postTraverse(tree.root);
        // System.out.println();

        System.out.print("Level-Order : ");
        tree.levelTraverse(tree.root);
        System.out.println();

        // System.out.println("\nJumlah node dalam tree: " + tree.countNodes(tree.root));
        // System.out.println("Jumlah daun dalam tree: " + tree.countLeaves(tree.root));
        // System.out.println("Tinggi tree: " + tree.getHeight(tree.root));



    }

}