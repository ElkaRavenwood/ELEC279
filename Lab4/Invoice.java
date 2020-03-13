public class Invoice implements Comparable<Invoice>, PayAble{
	
	private String companyName;
	private Double amount;
	
	public Invoice(){
		companyName = "No Name";
		amount = 0.0;
	}
	
	public Invoice(String theName, Double theAmount){
		companyName = theName;
		if (theName == null || theAmount < 0)
        {
             System.out.println("Fatal Error creating Invoice.");
             System.exit(0);
        }
        companyName = theName;
        amount = theAmount;
	}
	
	public String getName(){
		return companyName;
	}
	
	public Double getAmount(){
		return amount;
	}
	
	public void setName(String newName){
		if (newName == null)
        {
             System.out.println("Fatal Error setting invoice name.");
             System.exit(0);
        }
       else
            companyName = newName;
	}
	
	public void setAmount(Double newAmount){
		if (newAmount < 0)
        {
             System.out.println("Fatal Error setting invoice name.");
             System.exit(0);
        }
       else
            amount = newAmount;
	}
	
	public String toString(){
		return companyName + " is owed " + amount;
	}
	
	/**
	 * Implementation of Comparable interface
	 * @param bill the invoice this one will be compared you
	 * @return the int representing their comparison
	 */
	public int compareTo(Invoice bill) {
		// if (amount == bill.getAmount()) {
		// 	return 0;
		// } else if (amount < bill.getAmount()) {
		// 	return -1;
		// } else {
		// 	return 1;
		// }
		return (int)(amount - bill.getAmount());
	}


	/**
	 * Used in printPayment. Finds the amount to pay
	 * @return the amount to pay
	 */
	public double amountToPay() {
		return amount;
	}

	/**
	 * Prints out information on the payment.
	 */
	public void printPayment() {
		System.out.println("Payment information for an invoice. Company name: " + companyName + "; payment " + amountToPay() +".");
	}


}
