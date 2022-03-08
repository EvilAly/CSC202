package awilcher_m4q2;

import java.time.LocalDate;
import java.util.Scanner;

public class StockPurchase {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Stack<Stock> myStocks = new Stack<>();
		loadPurchases(myStocks);
		Portfolio port = new Portfolio(myStocks,0);
		
		
		boolean more = true;
		while(more) {
			menu();
			System.out.println("CHOICE:");
			int ans = scan.nextInt();
			if(ans ==0)
				print(port);
			else if (ans ==1) {
				purchase(port);
			}
			else if (ans ==2) {
				sell(port);
			}
			else if (ans == 3) {
				System.out.println("The capital gains so far equal " + port.getCapGains());
			}
			else if (ans ==4) {
				System.out.println("Thanks for using my stock program");
				System.exit(0);
			}
				
			
		}		
		

	}
	

	public static void menu() {
		System.out.println("0. Print");
		System.out.println("1. Buy");
        System.out.println("2. Sell (LIFO)");
        System.out.println("3. Total Capital Gain or Loss So Far");
        System.out.println("4. Quit");
	}
	
	public static void purchase(Portfolio folio) {
		folio.buy();				
	}
	
	public static void sell(Portfolio folio) {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many shares do you want to sell?");
		double numShares = scan.nextDouble();
		System.out.println("What is the current price");
		double cost = scan.nextDouble();
		folio.sell(numShares,cost);
	}
	
	
	
	public static void loadPurchases(Stack<Stock> stocks) {
		stocks.push(new Stock(LocalDate.of(2019,10,21),100,45.00));
		stocks.push(new Stock(LocalDate.of(2019,10,29),50,42.50));
		stocks.push(new Stock(LocalDate.of(2019,11,5),20,46.20));
		stocks.push(new Stock(LocalDate.of(2019,11,9),35,48.00));		
	}
	
	public static void print(Portfolio folio) {
		
		
		System.out.println(folio.toString());
	}

}
