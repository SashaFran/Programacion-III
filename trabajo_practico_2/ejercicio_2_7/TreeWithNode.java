package ejercicio_2_7;

public class TreeWithNode {

	 TreeNode root;
	
	public TreeWithNode() {
		this.root = null;
	}
	
	public void add(Integer value) {
		if (this.root == null)
			this.root = new TreeNode(value);
		else
			this.add(this.root,value);
	}
	
	private void add(TreeNode actual, Integer value) {
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setLeft(temp);
			} else {
				add(actual.getLeft(),value);
			}
		} else if (actual.getValue() < value) {
			if (actual.getRight() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setRight(temp);
			} else {
				add(actual.getRight(),value);
			}
		}
	}

	public TreeNode getRoot() {
		return root;
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	public void insert(int i) {
		TreeNode newNode = new TreeNode(i);
		 if(root == null){
			 root = newNode;
		 }else{
			 TreeNode current = root;
			 TreeNode parent;
			 while(true){
				 parent = current;
				 if(i < current.getValue()){
					 current = current.getLeft();
					 if(current == null){
						 parent.setLeft(newNode);
						 return;
					 }
				 }else{
					 current = current.getRight();
					 if(current == null){
						 parent.setRight(newNode);
						 return;
					 }
				 }
			 }
		 }
	}
	
    public int getHeight(TreeNode root) {
        int height = -1;

        if (root == null) {
            return height;
        } else {
            height = 1 + Math.max(getHeight(root.getLeft()), getHeight(root.getRight()));
        }

        return height;
    }
    
    public void printInorder(TreeNode node){
        if (node == null)
            return;
 
        /* first recur on left child */
        printInorder(node.getLeft());
 
        /* then print the data of node */
        System.out.print(node.getValue() + " ");
 
        /* now recur on right child */
        printInorder(node.getRight());
    }
    
    public void printPostorder(TreeNode node){
        if (node == null)
            return;
 
        // first recur on left subtree
        printPostorder(node.getLeft());
 
        // then recur on right subtree
        printPostorder(node.getRight());
 
        // now deal with the node
        System.out.print(node.getValue() + " ");
    }
    
    public void printPreorder(TreeNode node){
        if (node == null)
            return;
 
        /* first print data of node */
        System.out.print(node.getValue() + " ");
 
        /* then recur on left sutree */
        printPreorder(node.getLeft());
 
        /* now recur on right subtree */
        printPreorder(node.getRight());
    }
    
    public void delete(Integer data) {
    	 
        deleteNode(this.root, data);
    }
    
    private Integer minValue(TreeNode node) {
    	 
        if(node.getLeft() != null) {
            return minValue(node.getLeft());
        }
        return node.getValue();
    }
 
    private TreeNode deleteNode(TreeNode root, Integer data) {
 
        if(root == null) return root;
 
        if(data < root.getValue()) {
            root.setLeft(deleteNode(root.getLeft(), data));
        } else if(data > root.getValue()) {
            root.setRight(deleteNode(root.getRight(), data));
        } else {
            // node with no leaf nodes
            if(root.getLeft() == null && root.getRight() == null) {
                System.out.println("deleting "+data);
                return null;
            } else if(root.getLeft() == null) {
                // node with one node (no left node)
                System.out.println("deleting "+data);
                return root.getRight();
            } else if(root.getRight() == null) {
                // node with one node (no right node)
                System.out.println("deleting "+data);
                return root.getLeft();
            } else {
                // nodes with two nodes
                // search for min number in right sub tree
                Integer minValue = minValue(root.getRight());
                root.setValue(minValue);
                root.setRight(deleteNode(root.getRight(), minValue));
                System.out.println("deleting "+data);
            }
        }
 
        return root;
    }
    
    public int longestConsecutive(TreeNode root)
    {
        if (root == null)
            return 0;
 
        Result res = new Result();
         
        // call utility method with current length 0
        longestConsecutiveUtil(root, 0, root.getValue(), res);
         
        return res.res;
    }
 
    // Utility method to return length of longest
    // consecutive sequence of tree
    private void longestConsecutiveUtil(TreeNode root, int curlength,
                                        int expected, Result res)
    {
        if (root == null)
            return;
 
        // if root data has one more than its parent
        // then increase current length
        if (root.getValue() == expected)
            curlength++;
        else
            curlength = 1;
 
        // update the maximum by current length
        res.res = Math.max(res.res, curlength);
 
        // recursively call left and right subtree with
        // expected value 1 more than root data
        longestConsecutiveUtil(root.getLeft(), curlength, root.getValue() + 1, res);
        longestConsecutiveUtil(root.getRight(), curlength, root.getValue() + 1, res);
    }
    
	
	

}
