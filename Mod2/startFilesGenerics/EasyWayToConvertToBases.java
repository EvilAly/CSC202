package startFilesGenerics;

import java.util.Scanner;

public class EasyWayToConvertToBases {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Give me an integer:");
		int value = scan.nextInt();
		System.out.println("Your value was " + value);
		System.out.println("In binary:  " + Integer.toBinaryString(value));
		System.out.println("In octal:  " + Integer.toOctalString(value));
		System.out.println("In hexadecimal:  " + Integer.toHexString(value));		

	}

}
