import java.util.Arrays;
import java.util.Scanner;

public class arrayOperation {
	public static void main(String[] args) {
		int[] default_array = {1789, 2035, 1899, 1456, 2013};
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter array: ");
		String input = sc.nextLine();
		if (input.length()!=0) {
			String[] strArray = input.split(" ");
			int n = strArray.length;
			int[] array = new int[n];
			for (int i=0; i<n; i++) {
				array[i] = Integer.parseInt(strArray[i]);
			}
			merge_sort(array, 0, n-1);
			double sum = 0;
			System.out.println("Sorted array: ");
			for (int i=0; i<n; i++) {
				sum += array[i];
				System.out.print(array[i] + " ");
			}
			System.out.println("\nSum: " + sum + "\nAverage: " + (sum/n));
		}else {
			int[] array = default_array;
			int n = array.length;
			merge_sort(array, 0, n-1);
			double sum = 0;
			System.out.println("Sorted array: ");
			for (int i=0; i<n; i++) {
				sum += array[i];
				System.out.print(array[i] + " ");
			}
			System.out.println("\nSum: " + sum + "\nAverage: " + (sum/n));
		}
	}
	
	public static void merge_sort(int[] array, int l, int r) {
		if (l<r) {
			int m = l+ (r-l)/2;
			
			merge_sort(array, l, m);
			merge_sort(array, m+1, r);
			
			merge(array, l, m, r);
		}
	}
	
	public static void merge(int[] array, int l, int m, int r) {
		int n1 = m-l+1;
		int n2 = r-m;
		
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for (int i=0; i<n1; i++) {
			left[i] = array[l+i];
		}
		for (int j=0; j<n2; j++) {
			right[j] = array[m+1+j];
		}
		
		int i = 0;
		int j = 0;
		int k = l;
		
		while (i<n1 && j<n2) {
			if (left[i] <= right[j]) {
				array[k] = left[i];
				i++;
			}else {
				array[k] = right[j];
				j++;
			}
			k++;
		}
		
		while (i<n1) {
			array[k] = left[i];
			i++;
			k++;
		}
		
		while (j<n2) {
			array[k] = right[j];
			j++;
			k++;
		}
		
		
	}
}
