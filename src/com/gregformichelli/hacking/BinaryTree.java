package com.gregformichelli.hacking;

public class BinaryTree {
	
	private BinaryNode root;	

	public BinaryTree() {
	}
	
	public boolean addNode(BinaryNode n) {
		
		if(root == null) {
			this.root = n;
			return true;
		}
		
		return addNode(n, root);
	}
	
	public boolean addNode(BinaryNode n, BinaryNode addTo) {
		// add a node at the first open slot
		// favors the left
		if(addTo.getLeft() == null) {
			addTo.setLeft(n);
			return true;
		}
		else if(addTo.getRight() == null) {
			addTo.setRight(n);
			return true;
		}
		
		return (addNode(n, addTo.getLeft()) || addNode(n, addTo.getRight()));
	}

	@Override
	public boolean equals(Object that) {
		if (this == that)
			return true;
		if (that == null)
			return false;
		if (getClass() != that.getClass())
			return false;
		BinaryTree other = (BinaryTree) that;
		
		// recursive walk, Depth first left hand side first (in order traversal)
		return areNodesEqual(root, other.root);
	}
	
	public boolean areNodesEqual(BinaryNode n1, BinaryNode n2) {
		if (n1 == null) {
			if (n2 != null)
				return false;
		} 

		if ( !areNodesEqual(n1.getLeft(), n2.getLeft())) {
			return false;
		}
		if ( !areNodesEqual(n1.getRight(), n2.getRight())) {
			return false;
		}
		
		return true;
	}
	
	public void printInOrder() {
		printInOrder(root);
	}
	
	/**
	 * Does an in order DFS and brings the nodes
	 * 
	 */
	private void printInOrder(BinaryNode n) {
		
		//print left, root, right
		if(n.getLeft() != null) {
			printInOrder(n.getLeft());
		}
		System.out.print("<" + n.getData() + ">,");
		if(n.getRight() != null) {
			printInOrder(n.getRight());
		}
	}
	
	private void printPostOrder(BinaryNode n) {
		
	}
	
	private void printPreOrder(BinaryNode n) {
		
	}
	
	public int getMaxDepth() {
		return getMaxDepth(root);
	}
	
	public int getMaxDepth(BinaryNode n) {
		if( n == null) {
			return 0;
		}
		return 1 + Math.max( getMaxDepth(root.getLeft()), getMaxDepth(root.getRight()) );
	}
	
	public int getMinDepth() {
		return getMinDepth(root);
	}
	
	public int getMinDepth(BinaryNode n) {
		if( n == null) {
			return 0;
		}
		return 1 + Math.min( getMinDepth(root.getLeft()), getMinDepth(root.getRight()) );
	}
	
	public boolean isBalanced() {
		return(getMaxDepth() - getMinDepth() <= 1 );
	}
	
//	public String writeTree(TreeNode n)
//		
//	  if (!) {
//	    sb.append("#");
//	  } else {
//	    out << p->data << " ";
//	    writeBinaryTree(p->left, );
//	    writeBinaryTree(p->right, );
//	  }
//	}
	
}
