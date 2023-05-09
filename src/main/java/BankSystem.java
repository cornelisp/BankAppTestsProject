public class BankSystem {
    public static void main(String[] args) {
        BankService service = new BankService();

        BankAccount account1 = new BankAccount("123456", 5000, "John Doe", "johndoe@gmail.com", "555-555-1234");
        BankAccount account2 = new BankAccount("654321", 10000, "Jane Smith", "janesmith@gmail.com", "555-555-5678");

        service.addAccount(account1);
        service.addAccount(account2);

        BankAccount account = service.getAccount("123456");
        account.deposit(1000);
        account.withdraw(2000);

        account = service.getAccount("654321");
        account.deposit(500);
        account.withdraw(1500);
    }
}
