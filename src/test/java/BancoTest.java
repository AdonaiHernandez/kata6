import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BancoTest {

    private Bank bank;
    private final String accountCode = "1234-1234-1234-1234";

    @Before
    public void setUp(){
        bank = new Bank();
        bank.createAccount(accountCode);
    }

    @Test
    public void testAccountExist(){
        assertTrue(bank.accountExist(accountCode));
    }

    @Test
    public void testDeposit(){
        double amount = 100;
        bank.deposit(accountCode, amount);
        assertEquals(amount, bank.balanceCheck(accountCode), 0.0001f);
    }

    @Test
    public void testWithdraw(){
        double amount = 100;
        double withdrawAmount = 20;
        bank.deposit(accountCode, amount);
        bank.withdraw(accountCode, withdrawAmount);
        assertEquals(amount-withdrawAmount, bank.balanceCheck(accountCode), 0.0001f);
    }

    @Test
    public void testPositiveAmount(){
        double amount = 100;
        double withdrawAmount = 120;
        bank.deposit(accountCode, amount);
        bank.withdraw(accountCode, withdrawAmount);
        assertTrue(bank.balanceCheck(accountCode) >= 0);
    }

}
