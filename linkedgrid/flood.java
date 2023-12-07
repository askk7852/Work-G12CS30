package linkedgrid;

import java.util.Scanner;

public class flood {

	public static void main(String[] args) {
		
		linkedgrid LG = new linkedgrid(20);
		Scanner input = new Scanner(System.in);
		int number = 0;
		
		do {
		LG.display();
		System.out.println("What number to flood with?");
		number = input.nextInt();
		LG.flood(number);
		}while(!LG.solved());

	}

}
