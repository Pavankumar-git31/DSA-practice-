package com.DSA2;

import java.awt.List;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
	private Node root;
	public BinaryTree()
	{

	}
	public static class Node
	{
		int value;
		Node right;
		Node left;
		public Node(int value)
		{
			this.value=value;
		}
	}

	public void insert(Scanner sc)
	{
		System.out.println("enter the root node value");
		int a=sc.nextInt();
		root=new Node(a);
		insert(sc,root);
	}
	public void insert(Scanner sc,Node node)
	{
		System.out.println("you want to enter the left of this"+node.value);
		boolean canInsertLeft=sc.nextBoolean();
		if(canInsertLeft)
		{
			System.out.println("enter the left node value of "+ node.value);
			int b=sc.nextInt();
			node.left=new Node(b);
			insert(sc,node.left);
		}
		System.out.println("you want to enter the right of this node "+ node.value);
		boolean canInsertRight=sc.nextBoolean();
		if(canInsertRight)
		{
			System.out.println("enter the right of this node"+ node.value);
			int c=sc.nextInt();
			node.right=new Node(c);
			insert(sc,node.right);
		}
	}
	public void display()
	{
		display(root);
	}
	private void display(Node node) {
		if(node==null)
		{
			return;
		}

		System.out.println(node.value+" ");
		display(node.left);
		display(node.right);

	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		BinaryTree bt=new BinaryTree();
		bt.insert(sc);
		bt.prettyDisplay();
	}

	public void prettyDisplay()
	{
		prettyDisplay(root,0);
	}
	public void prettyDisplay(Node node,int level)
	{
		if(node==null)
		{
			return;
		}
		prettyDisplay(node.right,level+1);

		if(level!=0)
		{
			for(int i=0;i<level-1;i++)
			{
				System.out.print("|\t\t");
			}
			System.out.println("|---------->"+ node.value);
		}
		else
		{
			System.out.println(node.value);
		}
		prettyDisplay(node.left,level+1);

	}

	public Node  findSuccessor(Node root,int key)
	{
		if(root==null) return null;
		Queue<Node>q=new ArrayDeque<>();
		q.offer(root);
		while(!q.isEmpty())
		{
			int size=q.size();
			Node current=q.poll();
			if(current.left!=null)
			{
				q.offer(current.left);
			}

			if(current.right!=null)
			{
				q.offer(current.right);
			}
			if(current.value==key)
			{
				break;
			}

		}
		return q.poll();
	}
	public boolean isPathExists(Node root,int[]arr)
	{
		if(root.value!=arr[0]) return false;
			
		return helper(root,arr,0);
	}
	public boolean helper(Node root,int[]arr,int i)
	{
		if(root==null)
		{
			return false;
		}
		if(i>=arr.length-1&&root.value!=arr[i])
		{
			return false;
		}
		if(root.right==null&&root.left==null&&i==arr.length-1) return true;
		return helper(root.left,arr,i+1)||helper(root.right,arr,i+1);
	}
	
	// checking the 4 how many paths exists
	
	public void pathCheck(Node root,int key)
	{
		List<Integer> al=new LinkedList<>();
		helperPathCheck(Node root,path,key);
	}
	public void helperPathCheck(Node root,List<Integer> path,int key);




}
