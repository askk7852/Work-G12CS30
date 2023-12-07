package pain;

public class tester {

	public static void main(String[] args) {
		
		linkedlist LL = new linkedlist();
		LL.push(1);
		LL.push(2);
		LL.push(3);
		LL.push(4);
		LL.push(5);

		LL.display();
		
//		System.out.println(LL.find(3).getData());
		
		LL.pop();
		LL.display();
		LL.pop();
		LL.display();
		LL.pop();
		LL.display();
		LL.pop();
		LL.display();
	}

}
