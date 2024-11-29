import java.util.Scanner;

public class StarPrinter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of rows: ");
		int n = sc.nextInt();
		for (int i=0; i<n; i++) {
			String line = "";
			for (int j = 0; j<n-i; j++) {
				line += " ";
			}
			for (int j=0; j<2*i+1; j++) {
				line += "*";
			}
			for (int j = 0; j<n-i; j++) {
				line += " ";
			}
			System.out.println(line);
		}
	}
}
