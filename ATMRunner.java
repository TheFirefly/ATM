import java.util.Scanner;

public class ATMRunner {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		ATMAccount account = new ATMAccount("Bob", 1234, 100);
		
		ATMAccount account1 = new ATMAccount("Alice", 3333, 250);

		ATMAccount account2 = new ATMAccount("JT", 0001, 999999999);

		ATMAccount[] accounts = {account, account1, account2};

		ATM atm = new ATM(accounts);

		System.out.println("Please login: ");
		String line = input.nextLine();
		if (atm.validateInput(line)) {
			System.out.println("Successfully logged in!");
			System.out.println("What would you like to do now?");
			System.out.println("Check Balance, Withdraw Funds, Change Name, Change PIN, Logout");
			String command = input.nextLine();
			atm.validateInput(command);
		} else {
			return;
		}

	}

}