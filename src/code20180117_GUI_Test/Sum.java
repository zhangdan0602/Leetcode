package code20180117_GUI_Test;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

/**
 * @author:zd
 * @date:2019年1月18日上午8:45:40
 * @parameter
 * @return
 */
public class Sum extends Frame implements ActionListener {
	TextField num1, num2, num3;

	public Sum(String name) {
		Frame frame = new Frame();
		Panel panel = new Panel();
		Label la1 = new Label("num1:");
		num1 = new TextField(10);
		Label mul = new Label("+");
		Label la2 = new Label("num2:");
		num2 = new TextField(10);
		Button eq = new Button("=");
		eq.addActionListener(this);
		Label la3 = new Label("sum:");
		num3 = new TextField(10);

		panel.add(la1);
		panel.add(num1);
		panel.add(mul);
		panel.add(la2);
		panel.add(num2);
		panel.add(eq);
		panel.add(la3);
		panel.add(num3);
		frame.add(panel);
		this.pack();
		this.setLayout(new FlowLayout());
		this.setSize(new Dimension(100, 30));
		this.setTitle("sum");
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (num1.getText() == null || num2.getText() == null) {
			JOptionPane.showMessageDialog(null, "加数为空");
		}
		if (num1.getText() != null && num2.getText() != null) {
			num3.setText(String.valueOf(Integer.valueOf(num1.getText()) + Integer.valueOf(num2.getText())));
		}

	}

	public static void main(String[] args) {
		new Sum("sum");
	}
}
