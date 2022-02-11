package awilcherCSC202Mod1;

import java.util.*;

public class ConvertBase

{

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String ans = "";
		boolean exit = false;

		System.out.println("Welcome to Base Converter.");
		System.out.println("Please select an option from the menu below.");

		while (!exit) {
			int choice = menu();

			// if exit is chosen
			if (choice == 5)
				exit = true;
			else if (choice == 4) {
				// get hex code
				System.out.print("Enter the positive base number:");
				String hex = s.nextLine().toUpperCase();

				// verify a valid "number" - hex does not go above F
				if (!hex.matches("[A-F0-9]+")) {
					System.out.println("This is not a valid number. ");
					continue;
				}
				// determine base to change to
				int base = convToBase();

				 //int decimal = Integer.parseInt(hex, 16);

				int decimal = fromHex(hex, -1);

				if (base == 10)
					System.out.println("Your base number of " + hex + " converted to base " + base + " is " + decimal);

				else {
					ans = toBase(decimal, base);
					System.out.println("Your base number of " + hex + " converted to base " + base + " is " + ans);
				}

			}

			// all other options
			else {
				int solv = 0;
				// get the starting base number
				System.out.print("Enter the positive base number:");
				int num = s.nextInt();

				// which base are you changing to?
				int base = convToBase();

				// changing from decimal
				if (choice == 3) {
					if (base == 16)
						ans = toHex(num);
					else
						ans = toBase(num, base);
				}
				// changing from octal
				else if (choice == 2) {
					solv = toDecimal(num, 8, 0);
					if (base != 10) {
						if (base == 16)
							ans = toHex(solv);
						else
							ans = toBase(solv, base);
					}
				}

				// changing from binary
				else if (choice == 1) {
					solv = toDecimal(num, 2, 0);
					if (base != 10) {
						if (base == 16)
							ans = toHex(solv);
						else
							ans = toBase(solv, base);
					}
				}

				// results

				if (base == 10)
					System.out.println("Your base number of " + num + " converted to base " + base + " is " + solv);
				else
					System.out.println("Your base number of " + num + " converted to base " + base + " is " + ans);
			}
		}
		System.out.println("*****END*****");

	}

	public static int menu() {
		Scanner scan = new Scanner(System.in);

		System.out.println("\n1. Convert from binary");
		System.out.println("2. Convert from octal");
		System.out.println("3. Convert from decimal");
		System.out.println("4. Convert from hexadecimal");
		System.out.println("5. Exit");
		System.out.println("Option:");
		int c = scan.nextInt();

		return c;
	}

	

	public static int convToBase() {
		Scanner s = new Scanner(System.in);
		// gather what base you are converting to
		System.out.println("Which base would you like to convert to? (Numerical values only)");
		int b = s.nextInt();
		return b;
	}

	public static String toBase(int y, int base) {
		int rem;
		if (y > 0) {
			rem = y % base;
			return (toBase(y / base, base) + "" + rem);
		} else
			return "";
	}

	public static int toDecimal(int n, int begBase, int c) {
		int rem;
		if (n > 9) {
			rem = n % 10;
			n = n / 10;
			c++;
			return (int) (toDecimal(n, begBase, c) + (rem * Math.pow(begBase, c - 1)));

		} else
			return (int) (n * Math.pow(begBase, c));

	}

	public static String toHex(int n) {
		int rem;
		if (n > 15) {
			rem = n % 16;
			if (rem == 15)
				return (toHex(n / 16) + "F");
			else if (rem == 14)
				return (toHex(n / 16) + "E");
			else if (rem == 13)
				return (toHex(n / 16) + "D");
			else if (rem == 12)
				return (toHex(n / 16) + "C");
			else if (rem == 11)
				return (toHex(n / 16) + "B");
			else if (rem == 10)
				return (toHex(n / 16) + "A");
			else
				return (toHex(n / 16) + rem);

		} else {
			if (n == 15)
				return (toHex(n / 16) + "F");
			else if (n == 14)
				return (toHex(n / 16) + "E");
			else if (n == 13)
				return (toHex(n / 16) + "D");
			else if (n == 12)
				return (toHex(n / 16) + "C");
			else if (n == 11)
				return (toHex(n / 16) + "B");
			else if (n == 10)
				return (toHex(n / 16) + "A");
			else
				return "" + n;
		}

	}

	public static int fromHex(String h, int c) {
		int d = 0;
		char digit = h.charAt(h.length() - 1);
		// work through string
		if (h.length() == 1) {

			if (Character.compare(digit, 'F') == 0) {
				c++;
				d = (int) (15 * Math.pow(16, c));
			} else if (Character.compare(digit, 'E') == 0) {
				c++;
				d = (int) (14 * Math.pow(16, c));
			} else if (Character.compare(digit, 'D') == 0) {
				c++;
				d = (int) (13 * Math.pow(16, c));
			} else if (Character.compare(digit, 'C') == 0) {
				c++;
				d = (int) (12 * Math.pow(16, c));
			} else if (Character.compare(digit, 'B') == 0) {
				c++;
				d = (int) (11 * Math.pow(16, c));
			} else if (Character.compare(digit, 'A') == 0) {
				c++;
				d = (int) (10 * Math.pow(16, c));
			} else if (Character.isDigit(digit)) {
				c++;
				d = (((int)digit -48) * (int) Math.pow(16, c));
			}
		} else {
			h = h.substring(0, h.length() - 1);
			if (Character.compare(digit, 'F') == 0) {
				c++;
				d = fromHex(h, c) + (int) (15 * Math.pow(16, c));
			} else if (Character.compare(digit, 'E') == 0) {
				c++;
				d = fromHex(h, c) + (int) (14 * Math.pow(16, c));
			} else if (Character.compare(digit, 'D') == 0) {
				c++;
				d = fromHex(h, c) + (int) (13 * Math.pow(16, c));
			} else if (Character.compare(digit, 'C') == 0) {
				c++;
				d = fromHex(h, c) + (int) (12 * Math.pow(16, c));
			} else if (Character.compare(digit, 'B') == 0) {
				c++;
				d = fromHex(h, c) + (int) (11 * Math.pow(16, c));
			} else if (Character.compare(digit, 'A') == 0) {
				c++;
				d = fromHex(h, c) + (int) (10 * Math.pow(16, c));
			} else if (Character.isDigit(digit)) {
				c++;
				d = fromHex(h, c) + (((int)digit -48) * (int) Math.pow(16, c));
			}
		}

		return d;
	}

}