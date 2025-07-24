package com.DSA2;

import java.util.Arrays;

public class AVLTree {
	public class Node
	{
		int value;
		Node left;
		Node right;
		int height;
		public Node(int value)
		{
			this.value=value;
		}
		public int getValue()
		{
			return value;
		}
	}
	private Node root;
	AVLTree()
	{
		
	}
	
	public int height()
	{
		return height(root);
	}
	public int height(Node node)
	{
		if(node==null)
		{
			return -1;
		}
		return node.height;
	}
	public boolean isEmpty()
	{
		return root==null;
	}
	
	public void display()
	{
		display(root,"ROOT NODE:");
	}
	private void display(Node node,String details)
	{
		if(node==null)
		{
			return;
		}
		System.out.println(details  + node.getValue());
		display(node.left,"LEFT CHILD OF:" + node.getValue()+" is ");
		display(node.right,"RIGHT CHILD OF:"+ node.getValue()+" is ");
	}
	public void insert(int[]arr)
	{
		for(int x:arr)
		{
			insert(x);
		}
	}
	
	public void insert(int value)
	{
		root=check(root,value);
	}
	public Node check(Node root,int x)
	{
		if(root==null)
		{
			root=new Node(x);
			return root;
		}
		if(x>root.value)
		{
			root.right=check(root.right,x);
		}
		if(x<root.value)
		{
			root.left=check(root.left,x);
		}
		
		root.height=Math.max(height(root.left), height(root.right))+1;
		
		return rotated(root);
	}
	public Node rotated(Node root)
	{
		if(height(root.left)-height(root.right)>1)
		{
			if(height(root.left.left)-height(root.left.right)>0)
			{
				//left left case
				return rightRotate(root);
			}
			if(height(root.left.left)-height(root.left.right)<0)
			{
				//left right case
				root.left=leftRotate(root.left);
				return rightRotate(root);
			}
		}
		if(height(root.left)-height(root.right)<-1)
		{
			if(height(root.right.left)-height(root.right.right)<0)
			{
				//right right case
				return leftRotate(root);
			}
			if(height(root.right.left)-height(root.right.right)>0)
			{
				//right left case
				root.right=rightRotate(root.right);
				return leftRotate(root);
			}
		}
		return root;
	}
	//Right Rotate
	public Node rightRotate(Node p)
	{
		Node child=p.left;
		Node t=child.right;
		child.right=p;
		p.left=t;

		p.height=Math.max(height(p.left), height(p.right))+1;
		child.height=Math.max(height(child.left), height(child.right))+1;
		return child;
	}
	
	//leftRotate
	public Node leftRotate(Node c)
	{
		Node p=c.right;
		Node t=p.left;
		p.left=c;
		c.right=t;
		p.height=Math.max(height(p.left), height(p.right))+1;
		c.height=Math.max(height(c.left), height(c.right))+1;
		return p;
	}
	
	
	public boolean isBalanced()
	{
		return balanced( root);
	}
	
	public boolean balanced(Node root)
	{
		if(root==null)
		{
			return true;
		}
		return(height(root.right)-height(root.left)<=1&&balanced(root.right)&&balanced(root.left));
		
	}
	public static void main(String[] args) {
		AVLTree bst=new AVLTree();
		for(int i=0;i<1000;i++)
		{
			bst.insert(i);
		}
		System.out.println(bst.height());
		
	}
	public void sortedArray(int[]arr,BinarySearchTree bst)
	{
		if(arr.length==0)
		{
			return;
		}
		int mid=arr.length/2;
		bst.insert(arr[mid]);
		sortedArray(Arrays.copyOfRange(arr, 0, mid),bst);
		sortedArray(Arrays.copyOfRange(arr, mid+1, arr.length),bst);
	}
	//this is inorder traversal of the binary  search tree
	public void preOrder()
	{
		preOrder(root);
	}
	public void preOrder(Node root)
	{
		if(root!=null)
		{
			System.out.println(root.value);
			preOrder(root.left);
			preOrder(root.right);
		}
		return;
		
	}
	// this is inorder traversal of the bianary search tree
	public void inOrder()
	{
		inOrder(root);
	}
	public void inOrder(Node root)
	{
		if(root==null)
		{
			return;
		}
		inOrder(root.left);
		System.out.println(root.value);
		inOrder(root.right);
	}
	//in this postOrder of the Binary Search tree
	public void postOrder()
	{
		postOrder(root);
	}
	public void postOrder(Node root)
	{
		if(root==null)
		{
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.value);
	}
	
	
	
	
	
	
	
	
	
}
