package pain;

import java.util.Scanner;

public class SearchSort {

	public static void seqPop(int[] number) {
		for(int x = 0; x < number.length; x++)
			number[x] = x + 1; //ie. the number at index 0 is 1, number at index 99 is 100
	}
	public static void ranPop(int[] number, int max, int min) {
		for(int x = 0; x < number.length; x++)
			number[x] = (int)(Math.random() * (max - min + 1) + min); //random gen number at index x
	}
	public static boolean sortCheck(int[] number) {
		boolean sorted = false;
		int counter = 0;
		for(int x = 0; x < number.length - 1; x++) {
			if(number[x] <= number[x+1]) {
				counter++;
				if(counter == 99)
					sorted = true;
			}
		}
		return sorted;
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
	public static void shuffle(int[] number) {
		int[] temp = new int[100];
		for(int x = 0; x < number.length; x++) {
			temp[x] = number[x];
			int rand = (int)(Math.random() * (99 - 0 + 1));
			number[x] = number[rand];
			number[rand] = temp[x];
		}
	}
	public static void lineSearch(int[] number, int fInt) {
		int counter = 0;
		for(int x = 0; x < number.length; x++) {
			if(number[x] == fInt) {
				counter++;
				System.out.println("The number " + fInt + " is at index " + x + ".");
			}	
		}
		if(counter == 0)
			System.out.println("The number " + fInt + " in not in the array.");
	}
	public static void binSearch(int[] number, int fInt) { //remake

		
	}
	public static void search(int[] number) {
		Scanner input = new Scanner(System.in);
		System.out.println("Which number would you like to find?");
		int fInt = input.nextInt();
		
		System.out.println("1. Linear Search");
		System.out.println("2. Binary Search");
		int searchMethod = input.nextInt();
		
		if(searchMethod == 1)
			lineSearch(number, fInt);
		else if(searchMethod == 2)
			binSearch(number, fInt);
	}
	public static void bubSortu(int[] number) {
		for(int x = 0; x < number.length - 1; x++) {
			for(int y = x + 1; y < number.length; y++) {
				if(number[x] > number[y]) {
					int temp = number[x];
					number[x] = number[y];
					number[y] = temp;
				}
			}
		}
	}
	public static void bubSorts(int[] number) {
		boolean check = false;
		do {
			for(int x = 0; x < number.length - 1; x++) {
				if(number[x] > number[x+1]) {
					int temp = number[x];
					number[x] = number[x+1];
					number[x+1] = temp;
				}
			}
			check = sortCheck(number);
		}while(check == false);
	}
	public static void selecSort(int[] number) { 
		for(int x = 0; x < number.length - 1; x++) {
			int mIndex = x;
			for(int y = x + 1; y < number.length; y++) {
				if(number[y] < number[mIndex])
					mIndex = y;
			}
			int temp = number[mIndex];
			number[mIndex] = number[x];
			number[x] = temp;
		}
	}
	public static void inSort(int[] number) {
		for(int x = 1; x < number.length; x++) {
			int y = x - 1;
			int temp = number[x];
			while(y >= 0 && number[y] > temp) {
				number[y+1] = number[y];
				y--;
			}
			number[y+1] = temp;
		}
	}
	public static int[] radSort(int[] number) {
		int copy[] = new int[number.length];
		for(int x = 0; x < 3; x++) {
			int counter = 0;
			for(int y = 0; y < 10; y++) {
				for(int z = 0; z < number.length; z++) {
					if((number[z]/((int)Math.pow(10, x)))%10 == y) {
						copy[counter] = number[z];
						counter++;
					}
				}
			}
			number = copy;
			copy = new int[number.length];
		}
		return number;
	}
	public static void quickSort(int[] number, int ls, int rs) {
		if (ls < rs) {
			int pivotx = mid(number, ls, rs);
			quickSort(number, ls, pivotx - 1);
			quickSort(number, pivotx + 1, rs);
		    }
		}
		public static int mid(int[] number, int ls, int rs) {
		    int pivot = number[rs];
		    int counter = ls - 1;
		    for (int x = ls; x < rs; x++) {
		        if (number[x] <= pivot) {
		            counter++;
		            int temp = number[counter];
		            number[counter] = number[x];
		            number[x] = temp;
		        }
		    }
		    int temp = number[counter + 1];
		    number[counter + 1] = number[rs];
		    number[rs] = temp;
		    
		    return counter + 1;
		}
	public static void sort(int[] number) {
		Scanner input = new Scanner(System.in);
		System.out.println("1. Bubble Sort (Unstable)");
		System.out.println("2. Bubble Sort (Stable)");
		System.out.println("3. Selection Sort");
		System.out.println("4. Insertion Sort");
		System.out.println("5. Radix Sort");
		System.out.println("6. Quick Sort");
		int sortMethod = input.nextInt();
		
		int ls = 0;
		int rs = number.length - 1;
		
		if(sortMethod == 1)
			bubSortu(number);
		else if(sortMethod == 2)
			bubSorts(number);
		else if(sortMethod == 3)
			selecSort(number);
		else if(sortMethod == 4)
			inSort(number);
		else if(sortMethod == 5)
			radSort(number);
		else if(sortMethod == 6)
			quickSort(number, ls, rs);
	}
	public static void replace(int[] number) {
		Scanner input = new Scanner(System.in);
		System.out.println("Which number would you like to replace?");
		int rep = input.nextInt();
		System.out.println("Which number would you like to replace it with?");
		int repInt = input.nextInt();
		for(int x = 0; x < number.length; x++) {
			if(number[x] == rep)
				number[x] = repInt;
		}
	}
	public static void platelet() {
		System.out.println("\n~                          ~\n");
		System.out.println("  Roadwork is delayed, ");
		System.out.println("  and we are deeply sorry.");
		System.out.println("  THE PLATELETS TEAM");
		System.out.println("\n~                          ~\n");
	}
	public static void main(String[] args) {
		int menumber = 1;
		int max = 100;
		int min = 1;
		
		int[] number = new int[100];
		do {
			Scanner input = new Scanner(System.in);
			System.out.println("0. Exit Program");
			System.out.println("1. Populate Array Sequentially");
			System.out.println("2. Populate Array Randomly");
			System.out.println("3. Sort Check");
			System.out.println("4. Display");
			System.out.println("5. Shuffle Array");
			System.out.println("6. Search Options");
			System.out.println("7. Sort Options");
			menumber = input.nextInt();
			if(menumber == 0)
				menumber = 0;
			else if(menumber == 1)
				seqPop(number);
			else if(menumber == 2)
				ranPop(number, max, min);
			else if(menumber == 3) {
				boolean sorted = sortCheck(number);
				if(sorted == true)
					System.out.println("The array is in ascending order");
				else if(sorted == false)
					System.out.println("The array is not in ascending order.");
			}
			else if(menumber == 4)
				display(number);
			else if(menumber == 5)
				shuffle(number);
			else if(menumber == 6)
				search(number);
			else if(menumber == 7)
				sort(number);
			else
				platelet();
		}while(menumber > 0 || menumber < 0);
	}
}
