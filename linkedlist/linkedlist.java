package pain;

public class linkedlist {

	//not actually Nodes, Node References
	private Node first;
	private Node last;
	
	public void push(int number) {
		Node temp = new Node();
		
		if(first == null && last == null) {
			first = temp;
		}
		
		else {//list not empty
			temp.setPrev(last);
			last.setNext(temp);
		}
		
		last = temp;
		
	}
	
	public void display() {
		
		Node temp = first;
		
		while(temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();	
		}
		System.out.println();
		temp = last;
		while(temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getPrev();	
		}
		System.out.println();
	}
	
	public void pop() {//remove node
		last = last.getPrev();
		last.setNext(null);
		//in C++, no auto garbage collection, so would need "delete last
	}
	
	public Node find(int target){
		Node temp = first;
		while(temp != null) {
			if(temp.getData() == target)
				return temp;
			else
				temp = temp.getNext();
		}
		return null;
	}
	
	public void pop(int target) {
		Node temp = find(target);
		
		if(temp == last)
			pop();
		else if(temp == first) {
			first = first.getNext();
			first.setPrev(null);
		}
		else {
			temp.getPrev().setNext(temp.getNext());
			temp.getNext().setPrev(temp.getPrev());
		}
	}
	
	public void swap(int number1, int number2) {
		if(number1 != number2) {
			Node node1 = find(number1);
			Node node2 = find(number2);
			
			boolean inOrder = true;
			Node temp = node2;
			while(temp != null) {
				if(temp == node1) {
					inOrder = false;
					break;
				}
				temp = temp.getNext();
			}
			
			if(!inOrder) {
				temp = node1;
				node1 = node2;
				node2 = temp;
			}	
			
			if(node1 == first && node2 != last && node1.getNext() != node2 && node1.getNext() != null && node1.getNext().getNext() != node2) {
				temp = first.getNext();
				Node temp2 = node2.getNext();
				first = node2;
				first.setNext(node1.getNext());
				first.getPrev().setNext(node1);
				node1.setNext(temp);
				temp2.setPrev(node1);
				node1.setPrev(node2.getPrev());
				temp.setPrev(first);
				first.setPrev(null);
			}
			
			if(node1 == first && node2 == last) {
				
			}
			
			else if() {
				
			}
		}
	}
	
	public linkedlist() {
		first = null;
		last = null;
	}
	
	public Node getFirst() {
		return first;
	}
	public void setFirst(Node first) {
		this.first = first;
	}
	public Node getLast() {
		return last;
	}
	public void setLast(Node last) {
		this.last = last;
	}
	
}
