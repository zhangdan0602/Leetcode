package Common;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.*;

/**
 * @author:zd
 * @date:2019年1月17日下午2:05:17
 * @parameter
 * @return
 */
@SuppressWarnings("unchecked")
public class GUI_Applet extends Applet implements ItemListener {
	String[] description = { "red", "blue", "yellow" };
	Choice choice = new Choice();
	TextArea t = new TextArea(10, 30);// row column
	CheckboxGroup checkboxGroup = new CheckboxGroup();
	Button b1, b2, b3, b4, b5, b6;
	TextArea area = new TextArea(6, 30);
	String City[] = { "北京", "上海", "天津", "南京", "武汉" };
	Checkbox cb[] = new Checkbox[5];
	Checkbox radio[] = new Checkbox[5];
	CheckboxGroup cbGroup = new CheckboxGroup();
	int x1, y1, x2, y2;

	Label label1 = new Label("喜爱的城市：");
	Label label2 = new Label("喜爱的活动：");
	List list = new List();

	Color c1 = new Color(0, 0, 255);
	Color c2 = new Color(255, 50, 100);
	Color c3 = new Color(0, 250, 100);

	public void paint(Graphics g) {
		setForeground(c1);
		setBackground(c2);
		g.drawRect(20, 30, 50, 100);
		//setForeground(c3); // 将影响Applet中所有已经用其他任何颜色所绘制的图形及显示的文本
		//setBackground(Color.green);// 同上，所以在一个程序中不要用两遍引此方法
		g.drawRect(20, 230, 50, 100);
	}

	/*
	 * 
	 * char c[] = { '计', '算', '机', '专', '业' }; Font f1 = new Font("隶书",
	 * Font.ITALIC, 16); Font f2 = new Font("楷体", Font.ITALIC, 16); Color c1 =
	 * new Color(100, 200, 150);
	 * 
	 * public void paint(Graphics g) { g.setFont(f1); g.setColor(Color.RED);
	 * g.drawString("网络专业", 20, 30); g.setColor(c1); g.setFont(f2);
	 * g.drawChars(c, 0, 3, 20, 50); }
	 * 
	 */

	/*
	 * public void paint(Graphics g) { int x[]={30,60,115,72,67}; int
	 * y[]={40,30,15,52,100}; int m=x.length; g.drawLine(x1, y1, x2, y2);
	 * g.drawRect(10, 10, 30, 30); g.drawRoundRect(10, 50, 30, 30, 5, 5);
	 * g.drawOval(10, 90, 30, 30); g.drawPolygon(x, y, m); g.clearRect(10, 10,
	 * size().width, size().height); }
	 * 
	 */

	public void init() {

		/*
		 * setLayout(null); choice.add("北京"); choice.add("上海");
		 * choice.add("武汉"); choice.add("南京"); choice.addItemListener(this);
		 * list.add("听音乐"); list.add("看电视"); list.add("看电影"); list.add("看小说");
		 * list.add("打球"); list.addItemListener(this); add(choice);
		 * choice.setBounds(20,20,100,30); add(list);
		 * list.setBounds(20,50,100,60); add(label1);
		 * label1.setBounds(150,20,100,30); add(label2);
		 * label2.setBounds(150,50,100,30);
		 * 
		 * 
		 */

		// addMouseListener(new m1());
		// addMouseMotionListener(new m2());

		/*
		 * choice.addItem("123"); choice.addItem("456"); add(choice);
		 * choice.addItemListener(this);
		 * 
		 * add(new Label("这是一个选项事件例子")); add(area); add(new
		 * Label("   请选择中国的大城市：")); for (int i = 0; i < 5; i++) { cb[i] = new
		 * Checkbox(City[i]); add(cb[i]); cb[i].addItemListener(this); }
		 * 
		 * add(new Label("请选择中国最大的城市：")); for (int i = 0; i < 5; i++) { radio[i]
		 * = new Checkbox(City[i], cbGroup, false); add(radio[i]);
		 * radio[i].addItemListener(this); }
		 */
		/*
		 * Choice c = new Choice(); Button b1 = new Button("Button1"); Button b2
		 * = new Button("Button2"); Button b3 = new Button("Button3");
		 * setLayout(null); c.addItem("Item1"); c.addItem("Item2");
		 * c.addItem("Item3"); add(c); c.setBounds(80, 80, 100, 20); add(b1);
		 * b1.setBounds(20, 20, 100, 30); add(b2); b2.setBounds(150, 20, 100,
		 * 30); add(b3); b3.setBounds(200, 60, 80, 50);
		 */
		/*
		 * setLayout(new BorderLayout()); setForeground(Color.black); //设置前景色
		 * setFont(new Font("Arial",Font.PLAIN,20)); //设置字体，风格，字号
		 * add("North",new Label("我在Applet中",Label.CENTER)); Panel panel1=new
		 * Panel(); add("West",panel1); //在西边加入panel1对象
		 * panel1.setBackground(Color.blue); //设置panel1的背景色
		 * panel1.setForeground(Color.red); panel1.setLayout(new
		 * BorderLayout()); //在panel1中设置新布局 panel1.add("East",new Button("东"));
		 * panel1.add("West",new Button("西")); panel1.add("Center",new
		 * Label("我在Panel1中")); Panel panel2=new Panel(); add("East",panel2);
		 * ////在总布局的东边加入panel2对象 panel2.setBackground(Color.green);
		 * panel2.setLayout(new BorderLayout()); panel2.add("North",new
		 * Label("我在Panel2中")); panel2.add("South",new Button("我在Panel2中"));
		 */
		/*
		 * setLayout(new GridLayout(3, 3)); b1 = new Button("1"); b2 = new
		 * Button("2"); b3 = new Button("3"); b4 = new Button("4"); b5 = new
		 * Button("5"); b6 = new Button("6");
		 * 
		 * add("North", b1); add("South", b2); add("East", b3); add("West", b4);
		 * add("Center", b5); add("button6", b6);
		 * 
		 */
		/*
		 * CardLayout cardLayout = new CardLayout(); setLayout(cardLayout);
		 * setFont(new Font("Arial", Font.PLAIN, 24)); for (int i = 0; i <
		 * description.length; i++) { add(String.valueOf(i), new
		 * Button("card number is: " + i)); cardLayout.show(this,
		 * String.valueOf(2)); }
		 */
		/*
		 * Button bn, bs, be, bw, bc; setLayout(new BorderLayout(5, 10)); bn =
		 * new Button("north"); bs = new Button("south"); be = new
		 * Button("east"); bw = new Button("west"); bc = new Button("center");
		 * add("North", bn); add("South", bs); add("East", be); add("West", bw);
		 * add("Center", bc);
		 */
		/*
		 * // choice 下拉框选择；checkbox 多选；checkboxgroup 横向选择一个 Frame frame = new
		 * Frame(); //frame.setLayout(new GridLayout(2, 1)); Panel p1 = new
		 * Panel(); p1.setLayout(new GridLayout(1, 3)); // 多选 Checkbox c1 = new
		 * Checkbox("小肥牛"); Checkbox c2 = new Checkbox("小肥羊"); Checkbox c3 = new
		 * Checkbox("蜀王"); p1.add(c1); p1.add(c2); p1.add(c3); Choice choice1 =
		 * new Choice(); choice1.add(c1.getLabel()); choice1.add(c2.getLabel());
		 * choice1.add(c3.getLabel()); p1.add(choice1); c2.setState(true);
		 * frame.add(p1); frame.pack();// 不加pack,frame的大小是(0, 0) frame.show();
		 * // frame的关闭窗口的方法 frame.addWindowListener(new WindowAdapter() { public
		 * void windowClosing(WindowEvent e) { System.exit(0); } });
		 * 
		 * add(new Checkbox("1", checkboxGroup, true)); add(new Checkbox("2",
		 * checkboxGroup, false)); add(new Checkbox("3", checkboxGroup, false));
		 * 
		 * TextField t1, t2, t3, t4, t5; Label la6 = new Label(); t1 = new
		 * TextField(); t2 = new TextField(10); t3 = new TextField("123"); t4 =
		 * new TextField("456", 2); add(t1); add(t2); add(t3); add(t4);
		 * add(la6); t1.setEchoChar('*'); t2.setText("!!!!!!!!!!!!!");
		 * t3.setEditable(false); la6.setText(t4.getText());
		 * 
		 * TextArea ta1, ta2, ta3, ta4; ta1 = new TextArea(5, 10); ta2 = new
		 * TextArea("software", 8, 10); ta3 = new TextArea("software", 8, 10,
		 * 1); ta4 = new TextArea("software", 8, 10); ta2.append("engineering");
		 * ta3.setEditable(false); ta3.insert("engi", 2);
		 * ta4.replaceRange("school", 2, 4); add(ta1); add(ta2); add(ta3);
		 * add(ta4);
		 * 
		 * t.setEditable(false); add(t); choice.addItemListener(this);
		 * 
		 * for (int i = 0; i < description.length; i++) {
		 * choice.addItem(description[i]); } Label la4 = new
		 * Label(choice.getItem(1)); choice.addItem("purple"); Label la5 = new
		 * Label(String.valueOf(choice.getItemCount())); choice.insert("black",
		 * 1); choice.select(3); choice.remove(4); add(la4); add(la5);
		 * add(choice);
		 * 
		 * Label la1 = new Label(); Label la2 = new Label("计算机"); Label la3 =
		 * new Label("软件工程", Label.RIGHT); add(la1); add(la2); add(la3); add(new
		 * Label("网络工程", 2)); la1.setText(la2.getText()); la1.setAlignment(0);
		 * add(la1);
		 * 
		 * Button b1 = new Button(); Button b2 = new Button("ok"); add(b2);
		 * b1.setLabel(b2.getLabel()); add(b1);
		 * 
		 */
	}

	public static void main(String[] args) {
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

		// 产生事件的对象名
		if (e.getSource() == choice) {
			label1.setText("city: " + e.getItem());
		} else {
			label2.setText("enter: " + list.getSelectedItem());
		}
		// 输出的是对象：
		// area.append("你选择的是" + cbGroup.getSelectedCheckbox() + "\n");
		// 多选／横向单选／下拉选都可以使用e.getItem()
		area.append("你选择的是" + e.getItem() + "\n");
		// 下拉选也可以使用以下方法获取索引
		t.append("\n" + "index: " + choice.getSelectedIndex() + "\n" + choice.getSelectedItem() + " is selected.");
	}

	class m1 extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			x1 = e.getY();
			y1 = e.getY();
		}
	}

	class m2 extends MouseMotionAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			x2 = e.getX();
			y2 = e.getY();
			repaint();
		}
	}
}
