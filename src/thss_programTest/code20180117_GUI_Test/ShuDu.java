package thss_programTest.code20180117_GUI_Test;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author:zd
 * @date:2019年1月18日上午10:47:52
 * @parameter
 * @return
 */
public class ShuDu extends JFrame {

	private JFrame mainFrame;
	private JPanel mainPanel;
	private JButton buttons[];
	private int[] butNum;
	private Vector<String> optionalNum;

	public ShuDu() {
		mainFrame = new JFrame("4*4方格排序游戏");
		mainPanel = new JPanel();
		buttons = new JButton[16];
		butNum = new int[16];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
		}
		optionalNum = new Vector<String>();
		initButtonNum();// 随机排列
	}

	public void launchFrame() {
		mainFrame.setSize(400, 400);
		mainFrame.setDefaultCloseOperation(3);
		mainPanel.setLayout(new GridLayout(4, 4, 3, 3));
		mainFrame.getContentPane().add(mainPanel);
		for (int i = 0; i < butNum.length; i++) {
			buttons[i].addActionListener(new operateHandler());
			mainPanel.add(buttons[i]);
		}
		mainFrame.setVisible(true);
	}

	private void initButtonNum() {
		for (int i = 0; i < butNum.length; i++) {
			optionalNum.add(String.valueOf(i));
		}
		int index = -1;
		String str = null;
		for (int i = 0; i < butNum.length; i++) {
			index = (int) (Math.random() * optionalNum.size());
			str = optionalNum.get(index);
			if (str.equals("0")) {
				buttons[i].setText("");
				butNum[i] = 0;
			} else {
				buttons[i].setText(str);
				butNum[i] = Integer.parseInt(str);
			}
			optionalNum.remove(index);
		}

	}

	public class operateHandler implements ActionListener {
		int num = -1;
		int location = -1;
		int aim = -1;
		int i = 0;

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand().length() == 0) {
				return;
			}
			num = Integer.parseInt(e.getActionCommand());
			while (i < 16) {
				if (num == butNum[i++]) {
					location = i - 1;
					break;
				}
			}
			int candidates[] = { location - 1, location + 1, location - 4, location + 4 };
			for (int j = 0; j < 4; j++) {
				if (check(candidates[j])) {
					aim = candidates[j];
				}
			}
			if (aim >= 0 & aim < 16) {
				String temp = buttons[location].getText();
				int tempNum = butNum[location];
				buttons[location].setText("");
				butNum[location] = 0;
				buttons[aim].setText(temp);
				butNum[aim] = tempNum;
			}
			if (evaluate()) {
				int choice = JOptionPane.showConfirmDialog(mainFrame, "success", null, JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_NO_OPTION) {
					initButtonNum();
				} else {
					System.exit(0);
				}
			}
		}

		private boolean evaluate() {
			int i, j;
			for (i = 0; i < butNum.length; i++) {
				if (butNum[i] != i) {
					break;
				}
			}
			if (i == 16) {
				return true;
			}
			for (i = 0; i < butNum.length; i++) {
				if (butNum[i] != i + 1) {
					break;
				}
			}
			if (i == 15) {
				return true;
			}

			for (i = 0, j = 15; j >= 0; i++, j--) {
				if (butNum[j] != i + 1) {
					break;
				}
			}
			if (i == 16) {
				return true;
			}
			
			for (i = 0, j = 15; j > 0; i++, j--) {
				if (butNum[j] != i + 1) {
					break;
				}
			}
			if (i == 15) {
				return true;
			}
			return false;
		}

		private boolean check(int index) {
			if (index >= 0 && index < 16 && butNum[index] == 0) {
				return true;
			} else {
				return false;
			}
		}

	}
	
	public static void main(String[] args) {
		ShuDu shuDu=new ShuDu();
		shuDu.launchFrame();
	}
}
