package awilcher_m4q2;

import java.time.LocalDate;
import java.util.Scanner;

public class Portfolio {
	private Stack<Stock> stocks;
	private double capGains;

	public Portfolio() {
		super();
	}

	public Portfolio(Stack<Stock> stocks, double capGains) {
		super();
		this.stocks = stocks;
		this.capGains = capGains;
	}

	public String toString() {
		stocks.print();
		return " Current capital gains: " + capGains + "\n";
	}

	public void buy() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Year:");
		int y = scan.nextInt();
		System.out.println("Month:");
		int m = scan.nextInt();
		System.out.println("Day:");
		int d = scan.nextInt();
		System.out.println("Number of shares:");
		double num = scan.nextDouble();
		System.out.println("Price per share:");
		double cost = scan.nextDouble();
		Stock st = new Stock(LocalDate.of(y, m, d), num, cost);
		stocks.push(st);
	}

	public void sell(double numShares, double cost) {
		Stack<Stock> thoseSold = new Stack<>();
		double amtCollected = numShares * cost;
		System.out.println("The sale of " + numShares + " @$" + cost + " gives you $" + amtCollected + " cash");
		double basis = 0;
		double sharesLeftToSell = numShares;

		/*
		 * **************************************
		 * 
		 * WRITE CODE HERE TO ADJUST THE STACK FOR THE STOCK SALES
		 * 
		 * 
		 */
		//loop thru while there are still shares left to sell
		while (sharesLeftToSell > 0) {
			//Assign variable to stock we're looking at
			Stock next = stocks.peek();
			//if num of shares of stock are higher than those selling
			if (next.getNumShares() > sharesLeftToSell) {
				//pop shares to variable
				Stock toSell = stocks.pop();
				
				//work with number of shares
				double shares = toSell.getNumShares();
				shares = shares - sharesLeftToSell;
				toSell.setNumShares(shares);
				
				//add number of shares kept back to portfolio stack
				stocks.push(toSell);
				
				//create new node with shares sold and add to sold stack
				Stock remain = new Stock(toSell.getDatPurchased(), sharesLeftToSell, toSell.getPricePaid());
				thoseSold.push(remain);	
				
				//adjust number of shares left to sell
				sharesLeftToSell = 0;

			} 
			//if num of shares is less than num selling
			else if (next.getNumShares() < sharesLeftToSell) {
				//push shares from stocks stack to sold stack
				//get remaming number of shares to sell
				thoseSold.push(next);
				stocks.pop();
				sharesLeftToSell = sharesLeftToSell - next.getNumShares();

			} //if num of shares is equal to num selling
			else {
				//push number of shares sold from stocks stack to sold stack
				//set shares left to sell to zero
				thoseSold.push(next);
				stocks.pop();
				sharesLeftToSell = 0;
			}
		}

		System.out.println("\n\n I am writing this code for my CSC202 quiz");
		System.out.println("\n\n");

		capGains = capGains + (amtCollected - basis);

		System.out.println("You sold the following stocks:");
		thoseSold.print();
		// Needed to alter the print on the List and add a peek() to the Stack class

	}

	public Stack<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(Stack<Stock> stocks) {
		this.stocks = stocks;
	}

	public double getCapGains() {
		return capGains;
	}

	public void setCapGains(double capGains) {
		this.capGains = capGains;
	}

}
