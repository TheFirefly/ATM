public class ATMAccount {
	
	private String name;
	private int pin;
	private long balance;
	private long funds;

	public long checkBalance() {
		return this.balance;
	}

	public long withdrawFunds(long funds) {
		if ((balance - funds) < 0) {
			System.out.println("Error");
		} else {
			balance = balance - funds;
			return balance;
		}
	}

	public String changeName(String name) {
		
	}

}