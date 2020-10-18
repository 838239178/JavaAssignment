package account;

import java.util.Date;
import java.util.Random;

public class AccountTest {
    public static void main(String[] args) {
        Random r = new Random();
        Account[] accounts = new Account[3];
        accounts[0] = new Account("Tom", 10000, 0.03, new Date(2000-1900, 10, 13));
        accounts[1] = new CheckingAccount("Lily", 8000, 0.04, new Date(1998-1900,11,11), 3000);
        accounts[2] = new SavingAccount("Jack", 7500, 0.10, new Date(2003-1900, 9, 12));

        printAccount(accounts);

        System.out.println("deposit");
        for(Account s : accounts){
            s.deposit(r.nextInt(500)+500);
        }
        printAccount(accounts);

        System.out.println("withdraw");
        for(Account s : accounts){
            int ri = r.nextInt(15000)+5000;
            System.out.println(ri + " res: " + s.withdraw(ri));
        }
        printAccount(accounts);

    }

    public static void printAccount(Account[] accounts){
        System.out.println("list of account");
        for(Account s : accounts){
            System.out.println(s.toString());
        }
    }
}
