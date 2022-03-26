package htbla.kaindorf.third_grade.pos.q2.Account.beans;

import htbla.kaindorf.third_grade.pos.q2.Account.AccountGUI;

import javax.swing.*;
import java.util.Random;

public class AccountUser implements Runnable {
    private String username;
    private Account account;
    private Random random;
    private AccountGUI gui;

    private static boolean isRunning;

    public AccountUser(String username, Account account, Random random, AccountGUI gui) {
        this.username = username;
        this.account = account;
        this.random = random;
        this.gui = gui;
    }

    public static void setRunning(boolean isRunning) {
        AccountUser.isRunning = isRunning;
    }

    public static boolean isRunning() {
        return isRunning;
    }

    @Override
    public void run() {
        int amount;
        log("[!] Performing Test!");
        while (isRunning) {
            synchronized (account) {
                amount = random.nextInt(40) + 10;
                amount *= (random.nextBoolean() ? -1 : 1);

                if (account.getBalance() + amount < 0) {

                    log(String.format("wants to %s %d€ - waiting!",
                            (amount < 0 ? "withdraw" : "deposit"),
                            amount));

                    account.notifyAll();
                    try {
                        account.wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (account.getBalance() + amount < 0) {
                    log("finished");
                    break;
                }
                account.makeWithdraw(amount);

                log(String.format("%s %d€",
                        (amount < 0 ? "withdraws" : "deposits"),
                        (amount < 0 ? amount * -1 : amount)));
                updateBalance();

                account.notifyAll();
                try {
                    account.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(random.nextInt(1000)+1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void log(String text) {
        SwingUtilities.invokeLater(() -> gui.log(username, text));
    }

    private void updateBalance() {
        SwingUtilities.invokeLater(() -> gui.updateBalance());
    }
}
