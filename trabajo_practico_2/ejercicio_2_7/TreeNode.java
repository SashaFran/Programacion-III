package ejercicio_2_7;

public class TreeNode {
	private Integer value;
	public TreeNode left;
	TreeNode right;

	public TreeNode(Integer value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public Integer getValue() {
		return value;
	}
	
	public boolean hasElement(TreeNode t,int x) {
		if(t.value == x) {
			return true;
		}
		return false;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	
}
	
	
