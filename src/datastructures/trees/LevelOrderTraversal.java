package datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
	}
}

public class LevelOrderTraversal {

	public static void levelOrder(Node root) {
		Node temp = root;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		do {
			temp = queue.poll();
			if (temp != null) {
				System.out.print(temp.data + " ");
				queue.add(temp.left);
				queue.add(temp.right);
			}
			queue.remove(temp);
		} while (!queue.isEmpty());
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		levelOrder(root);
	}

}
