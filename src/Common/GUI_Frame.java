package Common;

import java.awt.Button;
import java.awt.CheckboxMenuItem;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author:zd
 * @date:2019年1月17日下午4:22:29
 * @parameter
 * @return
 */
public class GUI_Frame extends Frame implements ActionListener{
	Button btn1,btn2;
	TextField textField;
	PopupMenu popupMenu;
	Button button;
	public GUI_Frame(String string) {
		
		button=new Button("press me");
		this.add(button);
		popupMenu=new PopupMenu("popup");
		MenuItem menuItem1=new MenuItem("1");
		MenuItem menuItem2=new MenuItem("2");
		this.add(popupMenu);
		button.addActionListener(this);
		popupMenu.add(menuItem1);
		popupMenu.add(menuItem2);
		this.setSize(150, 100);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		Dialog dialog =new Dialog(this, "hi", false);
		dialog.setSize(100, 60);
//		dialog.show();
		this.setVisible(true);		
		
	}



	/*
	public GUI_Frame() {
		
		Label label = new Label("hello");
		this.add(label);
		this.setSize(new Dimension(400, 400));
		this.setTitle("my frame");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		btn1=new Button("show");
		btn2=new Button("exit");
		textField=new TextField(20);
		setLayout(new FlowLayout());
		add(textField);
		add(btn1);
		add(btn2);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		this.setVisible(true);//最后
		
		
		
		
		
	}
	*/
	public static void main(String[] args) {
		//GUI_Frame frame=new GUI_Frame();
		//frame.setVisible(true);
		
		
		//new GUI_Frame();
		
		new GUI_Frame("menu show");
		
		/*
		MenuBar menuBar=new MenuBar();
		frame.setMenuBar(menuBar);
		Menu menu1=new Menu("1");
		MenuItem item1=new MenuItem("01");
		CheckboxMenuItem checkboxMenuItem=new CheckboxMenuItem("001");
		
		MenuItem item2=new MenuItem("10");
		MenuItem item3=new MenuItem("11");
		menu1.add(item1);
		menu1.add(item2);
		menu1.addSeparator();
		menu1.add(item3);
		menu1.add(checkboxMenuItem);
		Menu menu2=new Menu("2");
		Menu menu3=new Menu("3");
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.setHelpMenu(menu3);
		*/
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		popupMenu.show(button, 10, 10);
		
		//textField.setText("pressed:"+e.getActionCommand()+"按钮");
		if (e.getSource()==btn2) {
			for (int i = 0; i < 5; i++) {
				System.exit(0);
			}
		}
		
	}
	
	
}


