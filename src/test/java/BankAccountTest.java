import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount("123456", 5000, "John Doe", "johndoe@gmail.com", "555-555-1234");
    }

    @Test
    public void testDeposit() {
        account.deposit(1000);
        Assertions.assertEquals(6000, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        account.withdraw(2000);
        Assertions.assertEquals(3000, account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientBalance() {
        account.withdraw(7000);
        Assertions.assertEquals(5000, account.getBalance());
    }

    @Test
    public void testGetAccountNumber() {
        Assertions.assertEquals("123456", account.getAccountNumber());
    }

    @Test
    public void testGetBalance() {
        Assertions.assertEquals(5000, account.getBalance());
    }

    @Test
    public void testGetCustomerName() {
        Assertions.assertEquals("John Doe", account.getCustomerName());
    }

    @Test
    public void testGetEmail() {
        Assertions.assertEquals("johndoe@gmail.com", account.getEmail());
    }

    @Test
    public void testGetPhoneNumber() {
        Assertions.assertEquals("555-555-1234", account.getPhoneNumber());
    }
}
