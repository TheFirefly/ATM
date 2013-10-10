import java.util.Scanner;

public class ATMRunner {
	
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		ATMAccount account = new ATMAccount("Bob", 1234, 100);
		
		ATMAccount account1 = new ATMAccount("Alice", 3333, 250);

		ATMAccount account2 = new ATMAccount("JT", 0001, 999999999);

		ATMAccount[] accounts = {account, account1, account2};

		ATM atm = new ATM(accounts);

		System.out.println("Please login: ");
		String line = input.nextLine();
		if (atm.validateInput(line)) {
			System.out.println("Success");
		} else {
			System.out.println("Failure");
		}

	}

}