
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//This class should extend JFrame and implement the ActionListener Interface
public class CalculatorGUI extends JFrame implements ActionListener {
	// complete the implementation of the different user interface components
	private JLabel numOne = new JLabel("Num1:");
	private JTextField amountField1 = new JTextField(5);
	private JLabel numTwo = new JLabel("Num2:");
	private JTextField amountField2 = new JTextField(5);
	private JButton sum = new JButton("+");
	private JButton sub = new JButton("-");
	private JButton mult = new JButton("*");
	private JButton div = new JButton("/");
	private JLabel result = new JLabel("Result");

	// create the three panels topPanel, middlePanel and bottomPanel
	private JPanel topPanel = new JPanel();

	// declare a new BankAccount object (myAccount) with account number and name of
	// your choice here
	Calculator cal = new Calculator();

	public CalculatorGUI() {

		// set the title for the frame
		setTitle("Simple Calculator");
		// exists the application when frame is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set the frame size and location
		setSize(800, 100);
		setLocationRelativeTo(null);
		// add the action listeners for your buttons
		sum.addActionListener(this);
		sub.addActionListener(this);
		mult.addActionListener(this);
		div.addActionListener(this);

		// add the Label to the Top here
		topPanel.add(numOne);
		topPanel.add(amountField1);
		topPanel.add(numTwo);
		topPanel.add(amountField2);
		topPanel.add(sum);
		topPanel.add(sub);
		topPanel.add(mult);
		topPanel.add(div);
		topPanel.add(result);

		add(BorderLayout.NORTH, topPanel);
		// add the middlePanel to the CENTER of the frame here

		// set the fame visibility to true
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		try {
			// write code to get text from amountField and convert to double here
			String amount1 = amountField1.getText();
			Double dAmount1 = Double.parseDouble(amount1);
			String amount2 = amountField2.getText();
			Double dAmount2 = Double.parseDouble(amount2);

			// write event handler for deposit button here
			if (e.getSource() == sum) {
				cal.add(dAmount1, dAmount2);
			} else if (e.getSource() == sub) {
				cal.sub(dAmount1, dAmount2);
			} else if (e.getSource() == mult) {
				cal.mult(dAmount1, dAmount2);
			} else if (e.getSource() == div) {
				if (dAmount2 == 0) {
					JOptionPane.showMessageDialog(null, "Can not divide by 0 !", "Inane warning",
							JOptionPane.ERROR_MESSAGE);
				} else {
					cal.div(dAmount1, dAmount2);
				}
			}
			// write event handler for withdraw button here

			result.setText("Result = " + cal.getRes());

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "The Amount You Entered isn't Acceppted!", "Inane warning",
					JOptionPane.WARNING_MESSAGE);
		}
	}
}
