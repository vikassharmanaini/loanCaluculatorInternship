import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

public class Main extends JFrame {
    JLabel balenceLabel= new JLabel("Loan Balance");
    JTextField balenceTextField= new JTextField();
    JLabel intrestLabel = new JLabel("Interest Rate");
    JTextField intrestTextField =new JTextField();
    JLabel monthLabel =new JLabel();
    JTextField monthTextField =new JTextField();
    JLabel paymentLabel =new JLabel();
    JTextField paymentTextField =new JTextField();
    JButton computeButton =new JButton();
    JButton newLoanButton =new JButton();
    JButton monthsButton =new JButton();
    JButton paymentButton =new JButton();
    JLabel analyisLabel =new JLabel();
    JTextArea analysisTextArea =new JTextArea();
    JButton exitButton =new JButton();
    Font myFont=new Font("Arial",Font.PLAIN,16);
    Color lightyellow=new Color(255,255,128);
    boolean computePayment;
    public static void main(String[] args) {
        new Main().show();

    }
    public Main(){
        setTitle("Loan Assistant");
        setResizable(false);
        addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints;

        balenceLabel.setFont(myFont);
        gridBagConstraints=new GridBagConstraints();
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=0;
        gridBagConstraints.anchor=GridBagConstraints.WEST;
        gridBagConstraints.insets=new Insets(10,10,0,0);
        getContentPane().add(balenceLabel,gridBagConstraints);

        balenceTextField.setPreferredSize(new Dimension(100,25));
        balenceTextField.setFont(myFont);
        gridBagConstraints=new GridBagConstraints();
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=0;
        gridBagConstraints.anchor=GridBagConstraints.WEST;
        gridBagConstraints.insets=new Insets(10,10,0,10);
        getContentPane().add(balenceTextField,gridBagConstraints);
        balenceTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                balenceTextFieldActionPerformed(e);
            }
        });
        intrestLabel.setFont(myFont);
        gridBagConstraints=new GridBagConstraints();
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=1;
        gridBagConstraints.anchor=GridBagConstraints.WEST;
        gridBagConstraints.insets=new Insets(10,10,0,0);
        getContentPane().add(intrestLabel,gridBagConstraints);

        intrestTextField.setPreferredSize(new Dimension(100,25));
        intrestTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        intrestTextField.setFont(myFont);
        gridBagConstraints=new GridBagConstraints();
        gridBagConstraints.gridx=1;
        gridBagConstraints.gridy=1;
        gridBagConstraints.anchor=GridBagConstraints.WEST;
        gridBagConstraints.insets=new Insets(10,10,0,10);
        getContentPane().add(intrestTextField,gridBagConstraints);
        intrestTextField.addActionListener(new ActionListener ()
        {
            public void actionPerformed(ActionEvent e)
            {
                interestTextFieldActionPerformed(e);
            }
        });

        monthLabel.setText("Number of Payments");
        monthLabel.setFont(myFont);
        gridBagConstraints=new GridBagConstraints();
        gridBagConstraints.gridx=0;
        gridBagConstraints.gridy=2;
        gridBagConstraints.anchor=GridBagConstraints.WEST;
        gridBagConstraints.insets=new Insets(10,10,0,0);
        getContentPane().add(monthLabel,gridBagConstraints);

        monthTextField.setPreferredSize(new Dimension(100,25));
        monthTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        monthTextField.setFont(myFont);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 10, 0, 10);
        getContentPane().add(monthTextField, gridBagConstraints);
        monthTextField.addActionListener(new ActionListener ()
        {
            public void actionPerformed(ActionEvent e)
            {
                monthTextFieldActionPerformed(e);
            }
        });

        paymentLabel.setText("Monthly Payment");
        paymentLabel.setFont(myFont);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(10, 10, 0, 0);
        getContentPane().add(paymentLabel, gridBagConstraints);

        paymentTextField.setPreferredSize(new Dimension(100,25));
        paymentTextField.setFont(myFont);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(10, 10, 0, 10);
        getContentPane().add(paymentTextField, gridBagConstraints);
        paymentTextField.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e)
            {
                paymentTextFieldActionPerformed(e);
            }
        });

        computeButton.setText("Compute Monthly Payment");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        getContentPane().add(computeButton, gridBagConstraints);
        computeButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                computeButtonActionPerformed(e);
            }
        });

        newLoanButton.setText("New Loan Analysis");
        newLoanButton.setEnabled(false);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(10, 0, 10, 0);
        getContentPane().add(newLoanButton, gridBagConstraints);
        newLoanButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                newLoanButtonActionPerformed(e);
            }
        });

        monthsButton.setText("X");
        monthsButton.setFocusable(false);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        getContentPane().add(monthsButton, gridBagConstraints);
        monthsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                monthsButtonActionPerformed(e);
            }
        });

        paymentButton.setText("X");
        paymentButton.setFocusable(false);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        getContentPane().add(paymentButton, gridBagConstraints);
        paymentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                paymentButtonActionPerformed(e);
            }
        });

        analyisLabel.setText("Loan Analysis:");
        analyisLabel.setFont(myFont);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets(0, 10, 0, 0);
        getContentPane().add(analyisLabel, gridBagConstraints);

        analysisTextArea.setPreferredSize(new Dimension(250, 150));
        analysisTextArea.setFocusable(false);
        analysisTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        analysisTextArea.setFont(new Font("Courier New", Font.PLAIN, 14));
        analysisTextArea.setEditable(false);
        analysisTextArea.setBackground(Color.WHITE);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.insets = new Insets(0, 10, 0, 10);
        getContentPane().add(analysisTextArea, gridBagConstraints);

        exitButton.setText("Exit");
        exitButton.setFocusable(false);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        getContentPane().add(exitButton, gridBagConstraints);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitButtonActionPerformed(e);
            }
        });
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (0.5 * (screenSize.width - getWidth())), (int) (0.5 * (screenSize.height - getHeight())), getWidth(), getHeight());
        paymentButton.doClick();
    }

    private void computeButtonActionPerformed(ActionEvent e){
        double balance, interest, payment;
        int months;
        double monthlyInterest, multiplier;
        double loanBalance, finalPayment;
        if (validateDecimalNumber(balenceTextField)) {
            balance = Double.valueOf(balenceTextField.getText()).doubleValue();
        }
        else{
            JOptionPane.showConfirmDialog(null, "Invalid or empty Loan Balance entry.\nPlease correct.", "Balance Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (validateDecimalNumber(intrestTextField)) {
            interest = Double.valueOf(intrestTextField.getText()).doubleValue();
        }
        else {
            JOptionPane.showConfirmDialog(null, "Invalid or empty Interest Rate entry.\nPlease correct.", "Interest Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        monthlyInterest = interest / 1200;
        if (computePayment) {
// Compute loan payment
            if (validateDecimalNumber(monthTextField)) {
                months = Integer.valueOf(monthTextField.getText()).intValue();
            }
            else {
                JOptionPane.showConfirmDialog(null, "Invalid or empty Number of Payments entry.\nPlease correct.", "Number of Payments Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if (interest == 0)
            {
                payment = balance / months;
            }
            else
            {
                multiplier = Math.pow(1 + monthlyInterest, months);
                payment = balance * monthlyInterest * multiplier / (multiplier - 1);
            }
            paymentTextField.setText(new DecimalFormat("0.00").format(payment));
        }else {
            if (validateDecimalNumber(paymentTextField)) {
                payment = Double.valueOf(paymentTextField.getText()).doubleValue();
                if (payment <= (balance * monthlyInterest + 1.0)) {
                    if (JOptionPane.showConfirmDialog(null, "Minimum payment must be $" + new DecimalFormat("0.00").format((int) (balance * monthlyInterest + 1.0)) + "\n" + "Do you want to use the minimum payment?", "Input Error", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                        paymentTextField.setText(new DecimalFormat("0.00").format((int) (balance * monthlyInterest + 1.0)));
                        payment = Double.valueOf(paymentTextField.getText()).doubleValue();
                    } else {
                        paymentTextField.requestFocus();
                        return;
                    }
                }
            }
            else {
                JOptionPane.showConfirmDialog(null, "Invalid or empty Monthly Payment entry.\nPlease correct.", "Payment Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if (interest == 0)
            {
                months = (int)(balance / payment);
            }else{
                months = (int)((Math.log(payment) - Math.log(payment - balance * monthlyInterest)) / Math.log(1 + monthlyInterest));
            }
            monthTextField.setText(String.valueOf(months));
        }

        payment = Double.valueOf(paymentTextField.getText()).doubleValue();

        //analysis
        analysisTextArea.setText("Loan Balance: $" + new DecimalFormat("0.00").format(balance));
        analysisTextArea.append("\n" + "Interest Rate: " + new DecimalFormat("0.00").format(interest) + "%");
        // process all but last payment
        loanBalance = balance;
        for (int paymentNumber = 1; paymentNumber <= months - 1; paymentNumber++)
        {
            loanBalance += loanBalance * monthlyInterest - payment;
        }
        finalPayment = loanBalance;
        if (finalPayment > payment) {
            // apply one more payment
            loanBalance += loanBalance * monthlyInterest - payment;
            finalPayment = loanBalance;
            months++;
            monthTextField.setText(String.valueOf(months));
        }
        analysisTextArea.append("\n\n" + String.valueOf(months - 1) + " Payments of $" + new DecimalFormat("0.00").format(payment));
        analysisTextArea.append("\n" + "Final Payment of: $" + new DecimalFormat("0.00").format(finalPayment));
        analysisTextArea.append("\n" + "Total Payments: $" + new DecimalFormat("0.00").format((months - 1) * payment + finalPayment));
        analysisTextArea.append("\n" + "Interest Paid $" + new DecimalFormat("0.00").format((months - 1) * payment + finalPayment - balance));
        computeButton.setEnabled(false);
        newLoanButton.setEnabled(true);
        newLoanButton.requestFocus();
    }
    private void newLoanButtonActionPerformed(ActionEvent event){
        if (computePayment) {
            paymentTextField.setText("");
        }
        else {
            monthTextField.setText("");
        }
        analysisTextArea.setText("");
        computeButton.setEnabled(true);
        newLoanButton.setEnabled(false);
        balenceTextField.requestFocus();
    }


    private void monthsButtonActionPerformed(ActionEvent e){
        computePayment = false;
        paymentButton.setVisible(true);
        monthsButton.setVisible(false);
        monthTextField.setText("");
        monthTextField.setEditable(false);
        monthTextField.setBackground(lightyellow);
        monthTextField.setFocusable(false);
        paymentTextField.setEditable(true);
        paymentTextField.setBackground(Color.WHITE);
        paymentTextField.setFocusable(true);
        computeButton.setText("Compute Number of Payments");
        balenceTextField.requestFocus();
    }
    private void paymentButtonActionPerformed(ActionEvent e){
        computePayment = true;
        paymentButton.setVisible(false);
        monthsButton.setVisible(true);
        monthTextField.setEditable(true);
        monthTextField.setBackground(Color.WHITE);
        monthTextField.setFocusable(true);
        paymentTextField.setText("");
        paymentTextField.setEditable(false);
        paymentTextField.setBackground(lightyellow);
        paymentTextField.setFocusable(false);
        computeButton.setText("Compute Monthly Payment");
        balenceTextField.requestFocus();
    }


    private void exitButtonActionPerformed(ActionEvent e){
        System.exit(0);
    }
    private void balenceTextFieldActionPerformed(ActionEvent event){
        balenceTextField.transferFocus();
    }

    private void interestTextFieldActionPerformed(ActionEvent e){
        intrestTextField.transferFocus();
    }

    private void monthTextFieldActionPerformed(ActionEvent e){
        monthTextField.transferFocus();
    }

    private void paymentTextFieldActionPerformed(ActionEvent e){
        paymentTextField.transferFocus();
    }

    private  boolean validateDecimalNumber(JTextField textField){
        String s = textField.getText().trim();
        boolean hasDecimal = false;
        boolean valid = true;
        if (s.length() == 0) {
            valid = false;
        }else {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    continue;
                } else if (c == '.' && !hasDecimal) {
                    hasDecimal = true;
                }else {
                    valid=false;
                }
            }
        }
        textField.setText(s);
        if (!valid)
        {
            textField.requestFocus();
        }
        return valid;
    }
}
