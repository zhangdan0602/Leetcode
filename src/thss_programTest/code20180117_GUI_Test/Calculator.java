package thss_programTest.code20180117_GUI_Test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author:zd
 * @date:2019年1月18日上午9:54:25
 * @parameter
 * @return
 */
public class Calculator extends JFrame {
	private String nums[] = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+" };
	private JButton[] func = new JButton[16];
	private JTextField textField;
	private JPanel jPanel;
	private JPanel content;
	private char c;
	private double rs = 0;
	private double pre = 0;
	private double now = 0;
	private boolean isPressed = false;

	public Calculator() {
		super("计算器");
		textField = new JTextField(20);
		textField.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
		textField.setBackground(Color.white);
		textField.setText("" + 0);
		jPanel = new JPanel();
		jPanel.add(textField);
		content = new JPanel();
		GridLayout gridLayout = new GridLayout(4, 4);
		content.setLayout(gridLayout);
		CalHandler calHandler = new CalHandler();
		for (int i = 0; i < func.length; i++) {
			func[i] = new JButton(nums[i]);
			func[i].setFont(new Font(Font.SERIF, Font.PLAIN, 20));
			func[i].addActionListener(calHandler);
			content.add(func[i]);
		}
		this.add(jPanel, BorderLayout.NORTH);
		this.add(content);

	}

	public class CalHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < nums.length; i++) {
				if (e.getSource() == func[i]) {
					if (func[i].getText() == ".") {
						textField.setText(textField.getText() + ".");
					} else if (func[i].getText() == "+") {
						c = '+';
						pre = Double.valueOf(textField.getText());
						isPressed = true;
					} else if (func[i].getText() == "-") {
						c = '-';
						pre = Double.valueOf(textField.getText());
						isPressed = true;
					} else if (func[i].getText() == "*") {
						c = '*';
						pre = Double.valueOf(textField.getText());
						isPressed = true;
					} else if (func[i].getText() == "/") {
						c = '/';
						pre = Double.valueOf(textField.getText());
						isPressed = true;
					} else if (func[i].getText() == "=") {
						operate(c);
						now = Double.valueOf(textField.getText());
						isPressed = true;
					} else {
						if (textField.getText().equals("0")) {
							textField.setText(func[i].getText());
						} else if (!isPressed) {
							textField.setText(textField.getText() + func[i].getText());
						} else {
							textField.setText("" + func[i].getText());
							isPressed = false;
						}

					}
					break;
				}
			}

		}

		private void operate(char c) {
			now = Double.valueOf(textField.getText());
			switch (c) {
			case '+':
				rs = pre + now;
				break;
			case '-':
				rs = pre - now;
				break;
			case '*':
				rs = pre * now;
				break;
			case '/':
				rs = pre / now;
				break;
			}
			textField.setText("" + rs);
			rs = 0;

		}

	}

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.setSize(400, 400);
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.setVisible(true);
	}
}
