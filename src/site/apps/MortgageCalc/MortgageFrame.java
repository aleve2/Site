package site.apps.MortgageCalc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MortgageFrame extends JFrame {

    // Signup and Login

    private static JLabel success;
    private static JLabel success2;

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
    public static double hundredRate;
    public static double monthlyRate;
    public static int paymentsNum;
    public static double numerator;
    public static double denominator;
    public static double combo;
    public static double result;


    // MortgagePanel panel;

    public MortgageFrame() {

        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(450, 300);
        frame.setTitle("Loan Calculator");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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



