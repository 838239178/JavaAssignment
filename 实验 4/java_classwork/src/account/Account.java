package account;

import java.util.Date;
import java.util.Queue;

public class Account {
    private String name;
    private int balance;
    private double rate;
    private Date openDate;

    public Account(String name, int balance, double rate, Date openDate) {
        this.name = name;
        this.balance = balance;
        this.rate = rate;
        this.openDate = openDate;
    }

    public boolean deposit(int money){
        if(money < 0) return false;
        balance += money;
        return true;
    }

    public boolean withdraw(int money){
        if(balance >= money){
            balance -= money;
            return true;
        }
        else
            return false;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", rate=" + rate +
                ", openDate=" + openDate +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

}
