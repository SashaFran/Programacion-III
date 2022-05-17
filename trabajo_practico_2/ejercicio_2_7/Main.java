package ejercicio_2_7;

public class Main {

    public static void main(String[] args)    {
        TreeWithNode tree = new TreeWithNode();
        tree.root = new TreeNode(1);
        tree.root.setLeft(new TreeNode(2));
        tree.root.setRight(new TreeNode(3));
        tree.root.getLeft().left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
 
        System.out.println("Preorder traversal of binary tree is ");
//        tree.printPreorder();
 
        System.out.println("\nInorder traversal of binary tree is ");
//        tree.printInorder();
 
        System.out.println("\nPostorder traversal of binary tree is ");
//        tree.printPostorder();
    }
}
