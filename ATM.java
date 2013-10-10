public class ATM {
	private ATMAccount[] accounts;
	private ATMAccount workingAccount;

	public ATM(ATMAccount[] accounts) {
		this.accounts = accounts;
	}

	public String[] formatInput(String input) {
		return (input.toLowerCase().replaceFirst(" ", "")).split(" ");
	}

	public boolean validateInput(String input) {
		String[] data = formatInput(input);
		String newInput = data[0];

		if (newInput.equals("checkbalance")) {
			if (checkBalance() != -1) {
				System.out.println("Your balance is: " + checkBalance());
				return true;
			} else {
				return false;
			}
		} else if (newInput.equals("withdrawfunds") && data[1] != null) {
			if (withdrawFunds(data[1]) != -1) {
				long left = withdrawFunds(data[1]);
				System.out.println("Successfully withdrew " + data[1] + ", Balance left: " + left);
				return true;
			} else {
				return false;
			}
		} else if (newInput.equals("changename") && data[1] != null) {
			String name = changeName(data[1]);
			System.out.println("Successfully changed name to: " + name);
			return true;
		} else if (newInput.equals("changepin") && data[1] != null) {
			int pin = changePin(data[1]);
			System.out.println("Successfully changed PIN to: " + pin);
			return true;
		} else if (newInput.equals("logout")) {
			logout();
			return true;
		} else if (newInput.equals("login") && data[1] != null && data[2] != null) {
			login(data[1], data[2]);
			return true;
		} else {
			return false;
		}
	}

	public void login(String name, int pin) {
		ATMAccount account = validate(name, pin);
		if (account != null) {
			this.workingAccount = account;
			System.out.println("Successfully logged in as: " + workingAccount.getName());
			System.out.println("What would you like to do now?");
			System.out.println("Check Balance, Withdraw Funds, Change Name, Change PIN, Logout");
			return;
		} else {
			System.out.println("Invalid username/password!");
			return;
		}
	}

	public void logout() {
		this.workingAccount = null;
		System.out.println("Successfully logged out! Come again next time!");
	}

	public long checkBalance() {
		if (this.workingAccount != null) {
			return workingAccount.checkBalance();
		} else {
			return -1;
		}
	}

	public long withdrawFunds(long funds) {
		if (this.workingAccount != null) {
			return this.workingAccount.withdrawFunds(funds);
		} else {
			return -1;
		}
	}

	public String changeName(String name) {
		this.workingAccount.changeName(name);
		return name;
	}

	public int changePin(int pin) {
		this.workingAccount.changePin(pin);
		return pin;
	}

	public ATMAccount validate(String name, int pin) {
		for (int i = 0 ; i < accounts.length ; i++) {
			if (this.accounts[i].getName().equals(name) && this.accounts[i].getPin() == pin) {
				return this.accounts[i];
			}
		}
		return null;
	}
}