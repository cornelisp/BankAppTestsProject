import java.util.ArrayList;

public class BankService {
    private final ArrayList<BankAccount> accounts;

    public BankService() {
        accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public BankAccount getAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public int getTotalBalance() {
        int total = 0;
        for (BankAccount account : accounts) {
            total += account.getBalance();
        }
        return total;
    }

    public void transfer(BankAccount account1, BankAccount account2, int i) {
        if (account1.getBalance() >= i) {
            account1.withdraw(i);
            account2.deposit(i);
        }
    }
}
