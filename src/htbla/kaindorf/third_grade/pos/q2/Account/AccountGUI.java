package htbla.kaindorf.third_grade.pos.q2.Account;

import htbla.kaindorf.third_grade.pos.q2.Account.beans.Account;
import htbla.kaindorf.third_grade.pos.q2.Account.beans.AccountUser;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class AccountGUI extends JFrame {

    private static DefaultListModel<String> dlm = new DefaultListModel<>();
    private Account account;
    private JLabel lbAccount = new JLabel();
    private JTextArea taLog = new JTextArea();
    private JList<String> userList = new JList<>();
    private Random random = new Random();

    public AccountGUI(String title) {
        initComponents();
        setTitle(title);
    }

    public static void main(String[] args) {
        AccountGUI gui = new AccountGUI("Account-Managment");
    }

    public void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 400);

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());

        //JList
        userList.setBorder(BorderFactory.createTitledBorder("User"));
        userList.setFont(new Font("Inter", Font.PLAIN, 12));
        userList.setModel(dlm);
        userList.setPreferredSize(new Dimension(150, 400));
        container.add(userList, BorderLayout.WEST);

        JPopupMenu listPopUpMenu = new JPopupMenu();
        JMenuItem miAddUser = new JMenuItem("Add User");
        JMenuItem miPerform = new JMenuItem("Perform Test");
        JMenuItem miStopTest = new JMenuItem("Stop Performing Test");

        miAddUser.addActionListener(this::addUser);
        miPerform.addActionListener(this::performTest);
        miStopTest.addActionListener(this::stopTest);

        listPopUpMenu.add(miAddUser);
        listPopUpMenu.add(miPerform);
        listPopUpMenu.add(miStopTest);
        userList.setComponentPopupMenu(listPopUpMenu);

        JPopupMenu listPopupMenuAccount = new JPopupMenu();
        JMenuItem miAddAccount = new JMenuItem("Create new Account");
        listPopupMenuAccount.add(miAddAccount);

        miAddAccount.addActionListener(this::addAccount);
        taLog.setComponentPopupMenu(listPopupMenuAccount);

        //Textarea
        taLog.setBorder(BorderFactory.createTitledBorder("Log-Output"));
        taLog.setFont(new Font("MonoLisa", Font.BOLD, 10));
        taLog.setEditable(false);
        JScrollPane scroll = new JScrollPane();
        ((DefaultCaret) taLog.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.setViewportView(taLog);

        container.add(scroll, BorderLayout.CENTER);


        //JLabel
        lbAccount.setBorder(BorderFactory.createTitledBorder("Balance"));
        lbAccount.setText("50.00 Euro");
        lbAccount.setFont(new Font("MonoLisa", Font.BOLD, 20));
        lbAccount.setHorizontalAlignment(SwingConstants.RIGHT);

        container.add(lbAccount, BorderLayout.SOUTH);


        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void addAccount(ActionEvent actionEvent) {
        account = new Account(50.0, lbAccount);
        taLog.setText("[i] New Account created");
        updateBalance();
    }

    private void performTest(ActionEvent actionEvent) {
        if (account == null) {
            JOptionPane.showMessageDialog(this, "Create account to perform test!");
        } else if (userList.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "Select users to perform test!");
        } else {
            AccountUser.setRunning(true);
            ArrayList<String> usernames = (ArrayList<String>) userList.getSelectedValuesList();
            for (String name : usernames) {
                new Thread(new AccountUser(name, account, random, this)).start();
            }
        }
    }

    private void stopTest(ActionEvent actionEvent) {
        if (AccountUser.isRunning()) {
            AccountUser.setRunning(false);
            taLog.append("\n[i] Test stopped");
        } else {
            JOptionPane.showMessageDialog(this, "There is no running test!");
        }
    }

    public void log(String name, String text) {
        taLog.append(String.format("\n%s: %s", name, text));
    }

    private void addUser(ActionEvent actionEvent) {
        String username = JOptionPane.showInputDialog("Enter username!");
        dlm.addElement(username);
    }

    public void updateBalance() {
        lbAccount.setText(String.format("%1.2f Euro", account.getBalance()));
    }
}