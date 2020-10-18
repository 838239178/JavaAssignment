package account;

import java.util.Date;

public class SavingAccount extends Account{
    public SavingAccount(String name, int balance, double rate, Date openDate) {
        super(name, balance, rate, openDate);
    }

    @Override
    public String toString() {
        return "Saving" + super.toString();
    }
}
