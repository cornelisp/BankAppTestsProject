import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankServiceTest {

    private BankService service;
    private BankAccount account1;

    @BeforeEach
    public void setUp() {
        service = new BankService();
        account1 = new BankAccount("123456", 5000, "John Doe", "johndoe@gmail.com", "555-555-1234");
        BankAccount account2 = new BankAccount("654321", 10000, "Jane Smith", "janesmith@gmail.com", "555-555-5678");
        service.addAccount(account1);
        service.addAccount(account2);
    }

    @Test
    public void testAddAccount() {
        BankAccount account3 = new BankAccount("789012", 7000, "Bob Johnson", "bobjohnson@gmail.com", "555-555-9012");
        service.addAccount(account3);
        Assertions.assertEquals(account3, service.getAccount("789012"));
    }

    @Test
    public void testGetAccount() {
        Assertions.assertEquals(account1, service.getAccount("123456"));
    }

    @Test
    public void testGetAccountNonexistent() {
        Assertions.assertNull(service.getAccount("999999"));
    }
}
