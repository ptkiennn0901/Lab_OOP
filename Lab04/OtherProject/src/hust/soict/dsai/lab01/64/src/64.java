import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays; 

public class daysOfMonth {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter month: ");
		String month = sc.nextLine();
		System.out.println("Enter year: ");
		int year = sc.nextInt();
		if (isValid(month, year)==true) {
			if (month.equals("January") || month.equals("Jan.") || month.equals("Jan") || month.equals("1")) {
				System.out.println(31);
			}
			if (month.equals("February") || month.equals("Feb.") || month.equals("Feb") || month.equals("2")) {
				if (isLeapYear(year)) {
					System.out.println(29);
				}else {
					System.out.println(28);
				}
			}
			if (month.equals("March") || month.equals("Mar.") || month.equals("Mar") || month.equals("3")) {
				System.out.println(31);
			}
			if (month.equals("April") || month.equals("Apr.") || month.equals("Apr") || month.equals("4")) {
				System.out.println(30);
			}
			if (month.equals("May") ||  month.equals("5")) {
				System.out.println(31);
			}
			if (month.equals("June") || month.equals("June") || month.equals("Jun") || month.equals("6")) {
				System.out.println(30);
			}
			if (month.equals("July") || month.equals("July") || month.equals("Jul") || month.equals("7")) {
				System.out.println(31);
			}
			if (month.equals("August") || month.equals("Aug.") || month.equals("Aug") || month.equals("8")) {
				System.out.println(31);
			}
			if (month.equals("September") || month.equals("Sep.") || month.equals("Sep") || month.equals("9")) {
				System.out.println(30);
			}
			if (month.equals("October") || month.equals("Oct.") || month.equals("Oct") || month.equals("10")) {
				System.out.println(31);
			}
			if (month.equals("November") || month.equals("Nov.") || month.equals("Nov") || month.equals("11")) {
				System.out.println(30);
			}
			if (month.equals("December") || month.equals("Dec.") || month.equals("Dec") || month.equals("12")) {
				System.out.println(31);
			}
		}else {
			System.out.println("Invalid input");
		}
	}
	
	public static boolean isValid(String month, int year) {
		Set<String> strMonth = new HashSet<>(Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"));
		Set<String> threelettersMonth = new HashSet<>(Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));
		Set<String> abbMonth = new HashSet<>(Arrays.asList("Jan.", "Feb.", "Mar.", "Apr.", "May", "June", "July", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."));
		Set<String> numMonth = new HashSet<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"));
		if (strMonth.contains(month)==false && threelettersMonth.contains(month)==false && abbMonth.contains(month)==false && numMonth.contains(month)==false) {
			return false;
		}
		if (year<0) {
			return false;
		}
		return true;
	}
	
	public static boolean isLeapYear(int year) {
		if (year%4==0) {
			if (year%400==0) {
				return true;
			}
			if (year%100==0) {
				return false;
			}
			return true;
		}
		return false;
	}
}
