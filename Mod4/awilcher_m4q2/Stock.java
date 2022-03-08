package awilcher_m4q2;

import java.time.LocalDate;

public class Stock {
	private LocalDate datePurchased;
	private double numShares;
	private double pricePaid;
	
	public Stock() {
		
	}

	public Stock(LocalDate datPurchased, double numShares, double pricePaid) {
		super();
		this.datePurchased = datPurchased;
		this.numShares = numShares;
		this.pricePaid = pricePaid;
	}
	
	public String toString() {
		return numShares + " shares @ $" + pricePaid + " on " + datePurchased + ". Basis: $" + value() ;
	}
	
	public double value() {
		return numShares * pricePaid;
	}

	public LocalDate getDatPurchased() {
		return datePurchased;
	}

	public void setDatPurchased(LocalDate datePurchased) {
		this.datePurchased = datePurchased;
	}

	public double getNumShares() {
		return numShares;
	}

	public void setNumShares(double numShares) {
		this.numShares = numShares;
	}

	public double getPricePaid() {
		return pricePaid;
	}

	public void setPricePaid(double pricePaid) {
		this.pricePaid = pricePaid;
	}
	

}
