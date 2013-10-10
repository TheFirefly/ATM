public class ATMAccount {
	
	private String name;
	private int pin;
	private long balance;

	public ATMAccount(String name, int pin, long balance) {
		this.name = name;
		this.pin = pin;
		this.balance = balance;
	}

	public long checkBalance() {
		return this.balance;
	}

	public long withdrawFunds(long funds) {
		if ((this.balance - funds) < 0) {
			System.out.println("Error - Not enough in balance to take out that much.");
			return -1;
		} else {
			this.balance -= funds;
			return this.balance;
		}
	}

	public String getName() {
		return this.name;
	}

	public String changeName(String name) {
		this.name = name;
		return name;
	}

	public int getPin() {
		return this.pin;
	}

	public int changePin(int pin) {
		this.pin = pin;
		return pin;
	}

}