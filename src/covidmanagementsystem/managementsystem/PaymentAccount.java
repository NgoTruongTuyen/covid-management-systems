/*
 *  Student's ID: 19127622
 *  Full name: Ngo Truong Tuyen
 *  Subject: Java Programming
 *  Assignment :
 *  Problem :
 */
package covidmanagementsystem.managementsystem;

import java.util.List;

/**
 *
 * @author zerotus
 */
public class PaymentAccount {
    private String id;
    private int balance;
    
    public PaymentAccount(String id) {
        this.id = id;
        this.balance = 0;
    }
    
    public PaymentAccount(String id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    public boolean pay(int money) {
        if (money > this.balance) {
            return false;
        } else {
            this.balance -= money;
        }
        
        return true;
    }
}
