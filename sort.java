//Frank Fiumara
//9/11/18
//Lab 1

package sorting;//changes default package for organization reasons
import java.util.Arrays;
import java.util.Random;//imports

public class sort {
private static int quickSwaps = 0;//static variable counters
private static int quickComparisons = 0;
private static int bubblePass = 0;
private static double newPass;
private static double newComp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int k = 0; k < 10; k++) {//makes 10 instances of the random arrays
			Random r = new Random(); //creates an instance of a random

			int arr1[] = new int[100];//creates an array with a set number of values
			int arr2[] = Arrays.copyOf(arr1, 100);
			double avgComparison = 0;//base values for the comparisons
			double avgPass=0;

			int low = 0;//lows and highs for quicksort
			int high = arr1.length - 1;
			for (int i = 0; i < arr1.length; i++) {
				arr1[i] = r.nextInt(100) + 1;//generates original array of numbers to be sorted
				arr2[i] = arr1[i];
			}
			System.out.print("The original list is: ");
			System.out.print(Arrays.toString(arr1));//prints original array
			System.out.println("");//spacing
			bubbleSorting(arr1);
			System.out.print("The bubble sorted list is: ");
			System.out.print(Arrays.toString(arr1));//prints bubble sorted arrays
			System.out.println("");
			quickSorting(arr2, low, high);
			System.out.println("Quick sort Swaps list: " + quickSwaps);//prints quick sort swaps
			System.out.println("Quick sort comparisons list: " + quickComparisons);//prints quick sort comparisons
			System.out.print("Quick sorted list 1: ");
			System.out.print(Arrays.toString(arr2));
			System.out.println("");

			 newComp = (avgComparison+quickComparisons);//values for averaging purposes
			 newPass = (avgPass + bubblePass);
		}
System.out.println("The average quick sort comparisons is: " + (newComp/10));//averages
		System.out.println("The average bubble sort comparisons is: "+(newPass)/10);
	}
	public static void bubbleSorting(int array[]){//sorting (in ascending order)


		for(int a = 0; a < array.length-1; ++a) {//sets the initial bounds of the sort to hit every number in the array
			for(int ini = 1; ini < (array.length); ++ini) {
				if(array[ini-1]>array[ini]) {//checks each value and swaps it with a larger number
					
					int swap = array[ini-1];	//Creates a placeholder to hold the first
					array[ini-1] = array[ini];	//sets placeholder equal to other value
					array[ini] = swap;//sets up the loop for another pass with a new value
					bubblePass = bubblePass+1;

				}
			
			}
			
	}
	System.out.print("Bubble Sort Passes: ");
	System.out.println(bubblePass);

}
	public static void quickSorting(int array[], int low ,int high){

		if (array.length == 0) {//removes chance of zero array
			return;
		}
		if (low >= high) {//does not sort arrays where the low is greater than the highest val
			return;
		}
		// pick the pivot
		int middle = low + (high - low) / 2;//declares array center
		int pivot = array[middle];//picks out specific value in array center

		// make left < pivot and right > pivot
		int i = low;
		int j = high;
		while (i <= j) {//while the low is less than the high increases the low and subtracts the high
			while (array[i] < pivot) {
				i++;
			}

			while (array[j] > pivot) {
				j--;
			}

			if (i <= j) {//if low less than the high creates temporary value for swapping purposes
				int swap = array[i];
				array[i] = array[j];//similar to bubble sort, replaces first val with temporary holder then swaps to values
				array[j] = swap;
				i++;
				j--;
				quickSwaps = quickSwaps+1;//swap counter
			}
		quickComparisons = quickComparisons+1;//comparisons counter
		}

		// recursively sort two sub parts
		if (low < j)
			quickSorting(array, low, j);//executing the sort based on which condition is needed, ie if the low is smaller thn sub high,
										//the following variables are used as opposed to the high values.

		if (high > i)
			quickSorting(array, i, high);



	}
}




