package pain;

public class Node {
	
	private int data;
	private Node next;
	private Node prev;
	
	public Node() {
		data = 0;
		next = null;
		prev = null;
	}
	
	public Node(int data) {
		this.data = data;
		next = null;
		prev = null;
	}	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	
	
}
