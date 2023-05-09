import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankSystemTest {

    private BankService service;

    @BeforeEach
    public void setUp() {
        service = new BankService();
    }

    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount("123456", 5000, "John Doe", "johndoe@gmail.com", "555-555-1234");
        service.addAccount(account);
        account.deposit(1000);
        Assertions.assertEquals(6000, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount("123456", 5000, "John Doe", "johndoe@gmail.com", "555-555-1234");
        service.addAccount(account);
        account.withdraw(2000);
        Assertions.assertEquals(3000, account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientBalance() {
        BankAccount account = new BankAccount("123456", 5000, "John Doe", "johndoe@gmail.com", "555-555-1234");
        service.addAccount(account);
        account.withdraw(7000);
        Assertions.assertEquals(5000, account.getBalance());
    }

    @Test
    public void testTransfer() {
        BankAccount account1 = new BankAccount("123456", 5000, "John Doe", "johndoe@gmail.com", "555-555-1234");
        BankAccount account2 = new BankAccount("654321", 10000, "Jane Smith", "janesmith@gmail.com", "555-555-5678");
        service.addAccount(account1);
        service.addAccount(account2);
        service.transfer(account1, account2, 2000);
        Assertions.assertEquals(3000, account1.getBalance());
        Assertions.assertEquals(12000, account2.getBalance());
    }

    @Test
    public void testTransferInsufficientBalance() {
        BankAccount account1 = new BankAccount("123456", 5000, "John Doe", "johndoe@gmail.com", "555-555-1234");
        BankAccount account2 = new BankAccount("654321", 10000, "Jane Smith", "janesmith@gmail.com", "555-555-5678");
        service.addAccount(account1);
        service.addAccount(account2);
        service.transfer(account1, account2, 7000);
        Assertions.assertEquals(5000, account1.getBalance());
        Assertions.assertEquals(10000, account2.getBalance());
    }

    @Test
    public void testGetAccount() {
        BankAccount account = new BankAccount("123456", 5000, "John Doe", "johndoe@gmail.com", "555-555-1234");
        service.addAccount(account);
        Assertions.assertEquals(account, service.getAccount("123456"));
    }

    @Test
    public void testGetAccountNonexistent() {
        Assertions.assertNull(service.getAccount("999999"));
    }

    @Test
    public void testGetTotalBalance() {
        BankAccount account1 = new BankAccount("123456", 5000, "John Doe", "johndoe@gmail.com", "555-555-1234");
        BankAccount account2 = new BankAccount("654321", 10000, "Jane Smith", "janesmith@gmail.com", "555-555-5678");
        service.addAccount(account1);
        service.addAccount(account2);
        Assertions.assertEquals(15000, service.getTotalBalance());
    }
}
