package account;

import java.util.Date;

public class CheckingAccount extends Account{
    private int overdraft;

    public CheckingAccount(String name, int balance, double rate, Date openDate, int overdraft) {
        super(name, balance, rate, openDate);
        this.overdraft = overdraft;
    }

    public int getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(int overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public boolean withdraw(int money) {
       if(getBalance()+overdraft >= money){
           if(!super.withdraw(money)){
               overdraft -= money-getBalance();
               setBalance(0);
           }
           return true;
       }
       else
           return false;
    }

    @Override
    public String toString() {
        return "Checking" + super.toString() + ", overdraft=" + overdraft;
    }
}
