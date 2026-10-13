public class PersonalBankingLedger {
    private String name, accNo;
    private double balance, totalDeposits, totalWithdrawals;

    // Parameterized Constructor
    public PersonalBankingLedger(String name, String accNo, double balance) {
        this.name = name.trim().toUpperCase();
        this.accNo = accNo.trim();
        this.balance = balance;
    }

    // Overloaded Deposit Methods
    public void deposit(double amount) { deposit(amount, "Deposit"); }
    public void deposit(double amount, String desc) {
        balance += amount;
        totalDeposits += amount;
        System.out.printf("Deposit Amount       : Rs. %.2f\nTransaction Status   : Deposit Successful\nUpdated Balance      : Rs. %.2f\n\n", amount, balance);
    }

    // Overloaded Withdrawal Methods
    public void withdraw(double amount) { withdraw(amount, "Withdrawal"); }
    public void withdraw(double amount, String desc) {
        System.out.printf("Withdrawal Amount : Rs. %.2f\n", amount);
        if (amount <= balance) {
            balance -= amount;
            totalWithdrawals += amount;
            System.out.printf("Transaction Status : Withdrawal Successful\nUpdated Balance    : Rs. %.2f\n\n", balance);
        } else {
            System.out.printf("Transaction Status : Insufficient Balance\nAvailable Balance : Rs. %.2f\n\n", balance);
        }
    }

    // Account Summary & Verification
    public void displaySummary(String checkName) {
        System.out.println("----------- ACCOUNT SUMMARY -----------");
        System.out.println("Account Holder       : " + name);
        System.out.println("Account Number       : " + accNo);
        System.out.printf("Total Deposits       : Rs. %.2f\nTotal Withdrawals    : Rs. %.2f\nFinal Balance        : Rs. %.2f\n", totalDeposits, totalWithdrawals, balance);
        System.out.println("Account Holder Verification: " + (name.equalsIgnoreCase(checkName.trim()) ? "Names Match" : "Names Do Not Match"));
    }

    public static void main(String[] args) {
        System.out.println("=========== PERSONAL BANKING LEDGER ===========");
        PersonalBankingLedger acc = new PersonalBankingLedger("RAVI KUMAR", "1234567890", 10000.00);
        System.out.println("Account Holder Name : RAVI KUMAR\nAccount Number      : 1234567890\nRs. 10000.00\n------------- TRANSACTION DETAILS -------------");

        acc.deposit(5000.00);
        acc.withdraw(2000.00);
        acc.withdraw(20000.00);

        acc.displaySummary("RAVI KUMAR");
    }
}