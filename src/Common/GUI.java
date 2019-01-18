package Common;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GUI {
	public static void main(String[] args) {
		// 组件
		JButton button = new JButton();
		JLabel label = new JLabel();
		JTextField textField = new JTextField();
		JRadioButton radioButton = new JRadioButton();
		JCheckBox checkBox = new JCheckBox();
		// 容器
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JDialog dialog=new JDialog();
		// 布局
		FlowLayout flowLayout=new FlowLayout();
		BorderLayout borderLayout = new BorderLayout();
		CardLayout cardLayout=new CardLayout();
		GridLayout gridLayout=new GridLayout();
		// 2D绘图 JPanel覆写Paint方法实现画图
		// Graphics2D graphics2d=new GradientPaint(pt1, color1, pt2, color2);
		JColorChooser colorChooser = new JColorChooser();

		// 游戏

		// 画图

		// 软件
	}
}
