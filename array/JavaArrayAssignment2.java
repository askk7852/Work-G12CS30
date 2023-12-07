package pain;

import java.util.Scanner;

public class JavaArrayAssignment2 {
	public static void randomPop(int[] number, int max, int min) {
		for(int x = 0; x < number.length; x++)
			number[x] = (int) Math.floor(Math.random() * (max-min + 1) + min);//generate random number for number at index x
	}
	public static void sequentialPop(int[] number) {
		for(int x = 0; x < number.length; x++)
			number[x] = x + 1;//number at index x = (x+1), ie. number at index 3 is 4
	}
	public static void display(int[] number) {
		for(int x = 0; x < number.length; x++) {
			if(x % 10 == 0)
				System.out.println("\n");
		if(number[x] >= 100)
			System.out.print(number[x] + " ");
		else if(number[x] >= 10)
			System.out.print(number[x] + "  ");
		else if(number[x] >= 1)
			System.out.print(number[x] + "   ");
		}
		System.out.println("\n");
	}
	public static void shuffle(int[] number, int max, int min) {
		int[] temp = new int[100];//create temporary
		for(int x = 0; x < number.length; x++) {
			temp[x] = number[x];//set temp[x] = number[x]
			int rIn = (int) Math.floor(Math.random() * (max-min) + min);//generate random index
			number[x] = number[rIn];//number[x] = number[random index]
			number[rIn] = temp[x];//number[random index] = temporary
		}
	}
	public static void findNum(int[] number) {
		Scanner input = new Scanner(System.in);
		System.out.println("What number are you looking for?");
		int fIntd = input.nextInt();
		for(int x = 0; x < number.length; x++) {
			if(fIntd == number[x])
				System.out.println(fIntd + " is at index " + x);
			else if(x == number.length - 1 && fIntd != number[x])
				System.out.println("-1");
		}
	}
	public static int ascending(int[] number) {//public static int used to be integrated with shuffleSort method
		boolean b;
		int counter = 0;
		for(int x = 0; x < number.length - 1; x++) {
			if(number[x] < number[x+1]) {
				b = true;
				counter++;
				if(counter == 99) {
					System.out.println("The array is in ascending order.");
					return 1;
				}
			}
			else if(number[x] > number[x+1]) {
				b = false; //b value may need to be reintegrated
				System.out.println("The array is not in ascending order.");
				return 2;
			}
		}
		return 0;
	}
	public static void shuffleSort(int[] number) {
		int hidden = ascending(number);
		int max = 100;
		int min = 1;
		int[] temp = new int[100];//create temporary
			if(hidden == 2) {
				for(int counter = 0; counter < 10000; counter++) {
					for(int x = 0; x < number.length; x++) {
						temp[x] = number[x];//set temp[x] = number[x]
						int rIn = (int) Math.floor(Math.random() * (max-min) + min);//generate random index
						number[x] = number[rIn];//number[x] = number[random index]
						number[rIn] = temp[x];//number[random index] = temporary
					}
					hidden = ascending(number);
					if(hidden == 1) {
						System.out.println("The array is now in ascending order.");
						break;
					}
					if(counter == 9999 && hidden != 1)
						System.out.println("The array has been shuffled 10,000 times.");
				}
			}
	}
	public static void returnLow(int[] number) {
		//set lowest value to number n, if next number lower, lowest value = [n+1], if higher move on
		int lowest = number[0];//set lowest value to number[0]
			for(int x = 0; x < number.length-1; x++) {
				if(lowest > number[x+1])//if current lowest is higher than number at index (x+1)
					lowest = number[x+1];//change current lowest to number at index (x+1)
			}
			System.out.println(lowest);
	}
	public static void returnHigh(int[] number) {
		int highest = number[0];//set highest value to number[0]
		int temp = highest;//temp variable = variable highest
		for(int x = 0; x < number.length-1; x++) {
			if(temp < number[x+1])//if number at index (x+1) is higher than temp, replace highest with number
				highest = number[x+1];
				temp = highest;//temp = new highest
		}
		System.out.println(highest);
	}
	public static void occurances(int[] number) {
		Scanner input = new Scanner(System.in);
		int counter = 0;//initialize counter variable
		System.out.println("What number would you like to find the instances of?");
		int findN = input.nextInt();//input for desired number
		for(int x = 0; x < number.length; x++) {
			if(findN == number[x])
				counter++;//add 1 to counter every time there is instance of input number
		}
		System.out.println("There are " + counter + " instances of the number " + findN);
	}
	public static void Replace(int[] number) {
		Scanner input = new Scanner(System.in);
		System.out.println("What number do you want to replace?");
		int findN = input.nextInt();//input for replacing value
		System.out.println("What number do you want to replace it with?");
		int repN = input.nextInt();//input for replace value
		for(int x = 0; x < number.length; x++) {
			if(findN == number[x])
				number[x] = repN;//replace number at index x with replace value
		}
	}
	public static void sumHighest(int[] number) {
		int c = 0;
		int sum = 0;
		int tempsum = 0;
		for(int x = 0; x < number.length-9; x++) {
			sum = number[x] + number[x+1] + number[x+2] + number[x+3] + number[x+4] + number[x+5] + number[x+6] + number[x+7] + number[x+8] + number[x+9];
			if(sum > tempsum) {
				tempsum = sum;
				c = x;//for display, c = x, because x is local variable and can't be used outside for loop
			}
		}
		System.out.println("The highest sum occurs at index " + c + " to index " + (c+10) + "\nSum: " + tempsum);
	}
	public static void rReplace(int[] number, int max, int min) {
		int findN = (int) Math.floor(Math.random() * (max-min + 1) + min);//generate random number to be replaced
		int repN = (int) Math.floor(Math.random() * (max-min + 2) + min);//generate another random number to replace with
		for(int x = 0; x < number.length; x++) {
			if(findN == number[x])
				number[x] = repN;//replace number at index x with replace value
		}
		System.out.println("A random number has been replaced");
	}
	public static void construction(int[] number) {//placeholder method for code under construction
		System.out.println("\n~                          ~\n");
		System.out.println("  Roadwork is delayed,");
		System.out.println("  and we are deeply sorry. ");
		System.out.println("  THE PLATELETS TEAM\n");
		System.out.println("~                          ~\n");
	}
	public static void main(String[] args) {
		int menumber = 1;
		int max = 100;
		int min = 1;
		int[] number = new int[100];//instantiate array
		do {
			Scanner input = new Scanner(System.in);
			System.out.println("0. Exit Program");
			System.out.println("1. Populate Array Randomly");
			System.out.println("2. Populate Array Sequentially");
			System.out.println("3. Display Array");
			System.out.println("4. Shuffle Array");
			System.out.println("5. Find an Integer");
			System.out.println("6. Ascending");
			System.out.println("7. Shuffle Sort Until Ascending");
			System.out.println("8. Return Lowest");
			System.out.println("9. Return Highest");
			System.out.println("10. Occurances");
			System.out.println("11. Replace");
			System.out.println("12. Highest Sum of 10 Indices");
			menumber = input.nextInt();
			if(menumber == 0) //exit
				menumber = 0;//set menu number to 0, ends program
			else if(menumber == 1) //populate randomly (not display)
				randomPop(number, max, min);
			else if(menumber == 2) //populate sequentially (not display)
				sequentialPop(number);
			else if(menumber == 3) //display
				display(number);
			else if(menumber == 4) //shuffle (moving numbers around)
				shuffle(number, max, min);
			else if(menumber == 5) //find number
				findNum(number);
			else if(menumber == 6) //see if ascending
				ascending(number);
			else if(menumber == 7) //shuffle until ascending or 10000 times
				shuffleSort(number);
			else if(menumber == 8) //return lowest value
				returnLow(number);
			else if(menumber == 9) //return highest value
				returnHigh(number);
			else if(menumber == 10) //find instances of a number
				occurances(number);
			else if(menumber == 11) //find and replace a number
				Replace(number);
			else if(menumber == 12) //find highest sum of 10 indices
				sumHighest(number);
			else if(menumber == 13) //bonus hidden random replace for fun
				rReplace(number, max, min);
		}while(menumber !=0);
	}
}






