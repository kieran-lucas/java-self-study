class Account {
    public void deposit(double amount) {
        System.out.println("Deposit: " + amount);
    }
}

interface Withdrawable {
    void withdraw(double amount);
}

class SavingAccount extends Account implements Withdrawable {
    @Override
    public void withdraw(double amount) {
        System.out.println("Withdraw: " + amount);
    }
}

class FixedDepositAccount extends Account {
}

public class Main {
    public static void main(String[] args) {
        SavingAccount account1 = new SavingAccount();
        FixedDepositAccount account2 = new FixedDepositAccount();

        account1.deposit(20000.0);
        account1.withdraw(10000.0);

        account2.deposit(5000.0);
    }
}
