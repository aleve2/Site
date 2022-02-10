package site.apps.MortgageCalc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    // Signup and Login

    private static JLabel userLabel;
    private static JTextField userText;
    private static JTextField userText3;
    private static JLabel passLabel;
    private static JLabel confirmPassLabel;
    private static JPasswordField passText;
    private static JPasswordField passText2;
    private static JPasswordField passText3;
    private static JButton loginButton;
    private static JButton signupButton;
    private static JButton afterLogin;
    private static JLabel success;
    private static JLabel success2;
    public static String user;
    public static String pass;
    public static String pass2;
    static boolean proceed = false;
    static int x = 0;
    public static JPanel panel = new JPanel();
    public static JFrame frame = new JFrame();

    // Calculator
    private static JLabel loanLabel;
    private static JLabel interestLabel;
    private static JLabel yearLabel;
    private static JTextField loanText;
    private static JTextField interestText;
    private static JTextField yearText;
    private static JLabel calculate;
    private static JButton calculateButton;

    static final byte MONTHS_IN_A_YEAR = 12;
    static final byte PERCENT = 100;
    public static int loan;
    public static double interestRate;
    public static int years;
    public static double hundredRate;
    public static double monthlyRate;
    public static int paymentsNum;
    public static double numerator;
    public static double denominator;
    public static double combo;
    public static double result;


    public static void main(String[] args) {

        logIn();

    }

    public static void logIn() {

        JPanel panel = new JPanel();

        JFrame frameMort = new JFrame();
        frameMort.setSize(450, 300);
        frameMort.setTitle("Account Sign Up");
        frameMort.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMort.setLocationRelativeTo(null);

        frameMort.add(panel);


        panel.setLayout(null);

        userLabel = new JLabel();
        userLabel.setText("Username");
        userLabel.setBounds(10, 20, 140, 25);

        panel.add(userLabel);


        userText = new JTextField(20);
        userText.setBounds(120, 20, 165, 25);

        panel.add(userText);


        passLabel = new JLabel();
        passLabel.setText("Password");
        passLabel.setBounds(10, 50, 140, 25);

        panel.add(passLabel);

        passText = new JPasswordField();
        passText.setBounds(120, 50, 165, 25);

        panel.add(passText);

        confirmPassLabel = new JLabel();

        confirmPassLabel.setText("Confirm Password");
        confirmPassLabel.setBounds(10, 80, 140, 25);

        panel.add(confirmPassLabel);

        passText2 = new JPasswordField();
        passText2.setBounds(120, 80, 165, 25);

        panel.add(passText2);

        signupButton = new JButton();
        signupButton.setBounds(10, 120, 80, 25);
        signupButton.setText("Sign Up");
        signupButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String pass = passText.getText();
                String pass2 = passText2.getText();

                if (pass.equals(pass2) ) {
                    frame.dispose();
                    function();
                } else {
                    success.setForeground(new Color(0xDC0E0E));
                    success.setText("Passwords don't match.");
                }
            }
        });

        //loginButton.getActionForKeyStroke(KeyStroke.getKeyStroke());
        panel.add(signupButton);

        success = new JLabel("");
        success.setBounds(10, 160, 300, 25);
        panel.add(success);


        frame.setVisible(true);
    }


    public static void function() {



        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(450, 300);
        frame.setTitle("Account Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.add(panel);

        panel.setLayout(null);
        userLabel = new JLabel();
        userLabel.setText("Username");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText3 = new JTextField(20);
        userText3.setBounds(100, 20, 165, 25);
        panel.add(userText3);

        passLabel = new JLabel();

        passLabel.setText("Password");
        passLabel.setBounds(10, 50, 80, 25);
        panel.add(passLabel);

        passText3 = new JPasswordField();
        passText3.setBounds(100, 50, 165, 25);
        panel.add(passText3);

        loginButton = new JButton();
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.setText("Login");
        loginButton.addActionListener(new GUI() {
        });
        //loginButton.getActionForKeyStroke(KeyStroke.getKeyStroke());
        panel.add(loginButton);

        success = new JLabel("");
        success.setBounds(10, 110, 350, 25);
        panel.add(success);

        success2 = new JLabel("");
        success2.setBounds(10, 160, 350, 25);
        panel.add(success2);



        afterLogin = new JButton();
        afterLogin.setBounds(10, 140, 160, 25);
        afterLogin.setText("Proceed to Calculator");
        afterLogin.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getUser = userText3.getText();
                String getPass = passText3.getText();
                String user = userText.getText();
                String pass = passText.getText();
                if (getUser.equals(user) && getPass.equals(pass) && x == 1) {

                    frame.dispose();
                    proceedCalculator();

                } else {
                    success.setForeground(new Color(0xDC0E0E));
                    success.setText("Invalid login, try again.");
                }
            }
        });
        panel.add(afterLogin);




        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String getUser = userText3.getText();
        String getPass = passText3.getText();
        String user = userText.getText();
        String pass = passText.getText();

        if (getUser.equals(user) && getPass.equals(pass)) {
            success.setForeground(new Color(0x2FA700));
            success.setText("Login Successful! You may proceed to the Calculator.");
            x++;
            proceed = true;
            //buttonAfterLogin();

        } else {
            success.setForeground(new Color(0xDC0E0E));
            success.setText("Invalid login, try again.");
        }
    }


    public static void proceedCalculator(){

        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(450, 300);
        frame.setTitle("Loan Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        frame.add(panel);

        panel.setLayout(null);
        loanLabel = new JLabel();
        loanLabel.setText("Amount of Loan: ");
        loanLabel.setBounds(10, 20, 100, 25);
        panel.add(loanLabel);

        loanText = new JTextField(20);
        loanText.setBounds(130, 20, 165, 25);
        panel.add(loanText);

        interestLabel = new JLabel();
        interestLabel.setText("Annual Interest Rate: ");
        interestLabel.setBounds(10, 60, 125, 25);
        panel.add(interestLabel);

        interestText = new JTextField(20);
        interestText.setBounds(130, 60, 165, 25);
        panel.add(interestText);

        yearLabel = new JLabel();
        yearLabel.setText("Period(Years): ");
        yearLabel.setBounds(10, 100, 90, 25);
        panel.add(yearLabel);

        yearText = new JTextField(20);
        yearText.setBounds(130, 100, 165, 25);
        panel.add(yearText);

        calculate = new JLabel("");
        calculate.setBounds(10, 180, 350, 25);
        panel.add(calculate);


        calculateButton = new JButton();
        calculateButton.setBounds(10, 150, 130, 25);
        calculateButton.setText("Calculate");
        calculateButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int loan = Integer.parseInt(loanText.getText());
                double interestRate = Integer.parseInt(interestText.getText());
                int years = Integer.parseInt(yearText.getText());




                hundredRate = interestRate / PERCENT;
                monthlyRate = hundredRate / MONTHS_IN_A_YEAR;
                paymentsNum = years * MONTHS_IN_A_YEAR;

                numerator = monthlyRate * Math.pow((1 + monthlyRate), paymentsNum) ;
                denominator = Math.pow((1 + monthlyRate), paymentsNum) - 1;
                combo = numerator / denominator;
                result = loan * combo;

                calculate.setForeground(new Color(0x051559));
                calculate.setText("Your Monthly Mortgage: $" + result);
            }
        });
        panel.add(calculateButton);

        success = new JLabel("");
        success.setBounds(10, 110, 350, 25);
        panel.add(success);

        success2 = new JLabel("");
        success2.setBounds(10, 160, 350, 25);
        panel.add(success2);

        frame.setVisible(true);
    }

}




