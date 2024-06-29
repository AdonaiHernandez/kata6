import java.util.HashMap;
import java.util.Map;

public class Bank {

    private final Map<String, Account> accountList;

    public Bank(){
        accountList = new HashMap<>();
    }
    public void createAccount(String accountCode){
        accountList.put(accountCode, new Account(accountCode));
    }

    public boolean accountExist(String accountCode){
        return accountList.get(accountCode) != null;
    }

    public void deposit(String accountCode, double amount){

        Account account = accountList.get(accountCode);
        account.deposit(amount);

    }

    public double balanceCheck(String accountCode){
        Account account = accountList.get(accountCode);
        return account.getBalance();
    }

    public void withdraw(String accountCode, double amount){
        Account account = accountList.get(accountCode);
        account.withdraw(amount);
    }

    public class Account{
        private final String code;
        private double balance;

        public Account(String code){
            this.code = code;
        }

        public void deposit(double amount){
            balance += amount;
        }

        public void withdraw(double amount){
            if (balance - amount >= 0)
                balance -= amount;
        }

        public double getBalance() {
            return balance;
        }
    }

}
