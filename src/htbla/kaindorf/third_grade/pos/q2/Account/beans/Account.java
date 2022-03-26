package htbla.kaindorf.third_grade.pos.q2.Account.beans;

import javax.swing.*;

public class Account {
    private double balance;
    private JLabel lbAccount;

    public Account(double balance, JLabel lbAccount) {
        this.balance = 50.0;
        this.lbAccount = lbAccount;

        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        lbAccount.setText(String.format("%1.2f", balance));
    }

    public void makeWithdraw(double amount) {
        balance += amount;
        synchronized (lbAccount) {
            lbAccount.setText(String.format("%1.2f", balance));
        }
    }

    public double getBalance() {
        return balance;
    }
}
