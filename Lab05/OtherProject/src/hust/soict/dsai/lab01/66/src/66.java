import java.util.Scanner;

public class MatrixAddition {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Use default array or enter a new array ? (type Yes or No)");
		String enter = sc.nextLine();
		if (enter.equals("Yes")) {
			System.out.println("Enter the number of rows: ");
			int n = sc.nextInt();
			System.out.println("\nEnter the number of columns: ");
			int m = sc.nextInt();
			
			int[][] mat1 = new int[n][m];
			int[][] mat2 = new int[n][m];
			sc.nextLine();
			System.out.println("Enter value for each row of matrix 1: ");
			for (int i=0; i<n; i++) {
				String input = sc.nextLine();
				String[] strRow = input.split(" ");
				for (int j=0; j<m; j++) {
					mat1[i][j] = Integer.parseInt(strRow[j]);
				}
			}
			System.out.println("Enter value for each row of matrix 2: ");
			for (int i=0; i<n; i++) {
				String input = sc.nextLine();
				String[] strRow = input.split(" ");
				for (int j=0; j<m; j++) {
					mat2[i][j] = Integer.parseInt(strRow[j]);
				}
			}
			int[][] sum_mat = new int[n][m];
			for (int i=0; i<n; i++) {
				for (int j=0; j<m; j++) {
					sum_mat[i][j] = mat1[i][j] + mat2[i][j];
				}
			}
			System.out.println("Sum matrix: ");
			printMat(sum_mat);
		}else {
			int[][] mat1 = {{1, 2}, {3, 4}};
			int[][] mat2 = {{5, 6}, {7, 8}};
			System.out.println("Default matrix 1: ");
			printMat(mat1);
			System.out.println("Default matrix 2: ");
			printMat(mat2);
			int n = mat1.length;
			int m = mat1[0].length;
			int[][] sum_mat = new int[n][m];
			for (int i=0; i<n; i++) {
				for (int j=0; j<m; j++) {
					sum_mat[i][j] = mat1[i][j] + mat2[i][j];
 				}
			}
			System.out.println("Sum matrix: ");
			printMat(sum_mat);
			
		}
	}
	
	public static void printMat(int[][] mat) {
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
