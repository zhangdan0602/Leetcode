package code20180117_GUI_Test;
/**
*@author:zd
*@date:2019年1月17日下午5:26:34
*@parameter
*@return
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 黑白棋面板
 * 
 * @author hyg
 * 
 */
public class BlackandWhiteChess extends JPanel {
	private static int BLACK = 1;
	private static int WHITE = -1;
	
	int[][] qizi = new int[8][8];
	int curQizi = BLACK; // 当前走棋方
	ArrayList a = new ArrayList();
	ArrayList tmp = new ArrayList();

	// 在指定位置画棋子
	private void drawQizi(int i, int j) {
		Graphics g = this.getGraphics();
		if (qizi[i][j] == BLACK) {
			g.setColor(Color.BLACK);
		} else if (qizi[i][j] == WHITE) {
			g.setColor(Color.WHITE);
		}
		g.fillOval(55 + 50 * i, 55 + 50 * j, 40, 40);
	}

	/**
	 * Create the panel
	 */
	public BlackandWhiteChess() {
		super();
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				System.out.println(x + ", " + y);
				// 计算索引
				int i = (x - 50) / 50;
				int j = (y - 50) / 50;
				System.out.println(i + ", " + j);
				if (i < 0 || i >= 8 || j < 0 || j >= 8 || qizi[i][j] != 0) // 如果指定位置超出范围或已经有棋子，直接返回。
					return;
				if (isValidPosition(curQizi, i, j)) { // 判断当前位置是否可以放棋子
					// 如果可以
					// 1. 更新棋盘
					//qizi[i][j] = curQizi;
					//drawQizi(i, j);
					refresh(curQizi,i,j);
					repaint();
					// 3. 判断对方是否有棋可走，如有
					if (checkNext(-1 * curQizi)) {
						// 2. 交换走棋方
						curQizi *= -1;
						repaint();
					} else if (checkNext(curQizi)) {
						// 若无，判断自己是否有棋可走，如有，给出提示
						JOptionPane.showConfirmDialog(null,
								(curQizi == BLACK ? "白方" : "黑方") + "无棋可走，"
										+ (curQizi == 1 ? "黑方" : "白方") + "继续",
								"提示", JOptionPane.CLOSED_OPTION,
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						// 游戏结束
						switch(whoWin()){
						case 1:  JOptionPane.showConfirmDialog(null, "双方都无棋可走，游戏结束",
								 "游戏结束，恭喜黑方获胜了！", JOptionPane.CLOSED_OPTION,
								 JOptionPane.INFORMATION_MESSAGE);
						         break;
						case -1: JOptionPane.showConfirmDialog(null, "双方都无棋可走，游戏结束",
								 "游戏结束，恭喜白方获胜了！", JOptionPane.CLOSED_OPTION,
								 JOptionPane.INFORMATION_MESSAGE);
						         break;
						case 0:  JOptionPane.showConfirmDialog(null, "双方都无棋可走，游戏结束",
								"游戏结束,双方平局", JOptionPane.CLOSED_OPTION,
								JOptionPane.INFORMATION_MESSAGE);
						        break;
						}
					}
				}
			}
		});
		qizi[3][3] = WHITE; // 1为黑，-1为白，0为无棋子
		qizi[3][4] = BLACK;
		qizi[4][3] = BLACK;
		qizi[4][4] = WHITE;
		// qizi[1][0] = 1;
		//
		// Graphics g = getGraphics();
		setBackground(Color.CYAN);
	}

	/**
	 * 验证参数代表的走棋方是否还有棋可走
	 * @param i 代表走棋方，1为黑方，-1为白方
	 * @return true/false
	 */
	protected boolean checkNext(int cur) {	
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(isValidPosition(cur,i,j))
					return true;
			}
		}
		return false;
	}

		
	/**
	 * 验证给定位置是否是合法位置
	 * @param cur 走棋方颜色
	 * @param i 横坐标
	 * @param j 纵坐标
	 * @return
	 */
	private boolean isValidPosition(int cur,int x,int y){
		//如果有棋子了，则此位置非法
		if(qizi[x][y]!=0)return false;
		//判断竖线上是否有符合要求的位置
		for(int i=0;i<8;i++){
			//若有
			if(qizi[i][y]==cur){
				//如果在该位置的下方
				if(i-x>=2){
					int count=0;
				    for(int k=x+1;k<i;k++)
				    {
				    	if(qizi[k][y]==-1*cur)
				    		count++;
				    }
				    if(count==(i-x-1))
				    	return true;
				}
				//如果在该位置的上方
				if((x-i)>=2)
			    	{
					int count=0;
					for(int k=x-1;k>i;k--)////////////////////////////////
				    {
						if(qizi[k][y]==-1*cur)
							count++;
				    }
					if(count==(x-i-1))
						return true;
			    }
			}
		}
		
		//判断横线上是否有符合要求的位置
		for(int j=0;j<8;j++){
			//若有
			if(qizi[x][j]==cur){
				//如果在左边
				if((y-j)>=2)
			    {
				    int count=0;
				    for(int k=y-1;k>j;k--)
				    {
				    	if(qizi[x][k]==cur*(-1))
				    		count++;
				    }
				    if(count==(y-j-1))
					    return true;
			    }
				//如果在右边
				if((j-y)>=2)
			    {
					int count=0;
				    for(int k=y+1;k<j;k++)
				    {
				    	if(qizi[x][k]==cur*(-1))
				    		count++;
				    }
				    if(count==(j-y-1))
					    return true;
			    }
			}
		}
		
		//判断斜线上是否有合法的位置
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				//若有
				if(qizi[i][j]==cur){
					//左上
					if(((x-i)==(y-j) && (x-i)>=2)){
						int yy=y-1;/////////////////////////
					    int count=0;
					    for(int k=x-1;k>i;k--)
					    {
					    	if(qizi[k][yy]==cur*(-1))    	
					    		count++;													
						    yy--;////////////////////////
					    }
					    if(count==(x-i-1))
						    return true;
					}
					//右下
					if(((x-i)==(y-j) && (i-x)>=2)){
						int yy=y+1;
						int count=0;
						for(int k=x+1;k<i;k++){
							if(qizi[k][yy]==cur*(-1))
								count++;
							yy++;
						}
						if(count==i-x-1)
							return true;
					}
					//右上
					if((x-i)==-(y-j)&&(i-x)>=2){
						int yy=y-1;
						int count=0;
						for(int k=x+1;k<i;k++){
							if(qizi[k][yy]==cur*(-1))
								count++;
							yy--;
						}
						if(count==i-x-1)
							return true;
					}
					//左下
					if((x-i)==-(y-j)&&(x-i)>=2){
						int yy=y+1;
						int count=0;
						for(int k=x-1;k>i;k--){
							if(qizi[k][yy]==cur*(-1))
								count++;
							yy++;
						}
						if(count==x-i-1)
							return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * refresh：
	 *  更新棋盘
	 * @param x 棋子的横坐标
	 * @param y 棋子的纵坐标
	 */
	private void refresh(int cur,int x,int y){
		//将竖线上的更新
		for(int i=0;i<8;i++)
		{
			if(qizi[i][y]==cur){
				//如果在该位置的下方
				if(i-x>=2){
					int count=0;
				    for(int k=x+1;k<i;k++)
				    {
				    	if(qizi[k][y]==-1*cur)
				    		count++;
				    }
				    if(count==(i-x-1)){
				    	for(int k=x;k<i;k++)
				    		qizi[k][y]=cur;
				    }			    		
				}	
				//如果在该位置的上方
				if(x-i>=2){
					int count=0;
					for(int k=x-1;k>i;k--){
						if(qizi[k][y]==(-1)*cur)
							count++;
					}
					if(count==(x-i-1)){
						for(int k=i+1;k<=x;k++)
							qizi[k][y]=cur;
					}
				}
		    }
		}
		
		//将横线上的更新
		for(int j=0;j<8;j++){
			if(qizi[x][j]==cur){
				//如果在该位置的左边
				if(y-j>=2){
					int count=0;
					for(int k=j+1;k<y;k++){
						if(qizi[x][k]==(-1)*cur)
							count++;
					}
					if(count==y-j-1){
						for(int k=j+1;k<=y;k++)
							qizi[x][k]=cur;
					}
				}
				//如果在该位置的右边
				if(j-y>=2){
					int count=0;
					for(int k=y+1;k<j;k++){
						if(qizi[x][k]==(-1)*cur)
							count++;
					}
					if(count==j-y-1){
						for(int k=y;k<j;k++)
							qizi[x][k]=cur;
					}
				}
			}
		}
		
		//将斜线上的更新
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				//若有
				if(qizi[i][j]==cur){
					//左上
					if(((x-i)==(y-j)&&(x-i)>=2)){
						int yy=y-1;/////////////////////////
					    int count=0;
					    for(int k=x-1;k>i;k--)
					    {
					    	if(qizi[k][yy]==cur*(-1))    	
					    		count++;													
						    yy--;////////////////////////
					    }
					    if(count==(x-i-1)){
					    	int yyy=y;
					    	for(int k=x;k>i;k--){
					    		qizi[k][yyy]=cur;
					    		yyy--;
					    	}
					    }
					}
					//右下
					if(((x-i)==(y-j) && (i-x)>=2)){
						int yy=y+1;
						int count=0;
						for(int k=x+1;k<i;k++){
							if(qizi[k][yy]==cur*(-1))
								count++;
							yy++;
						}
						if(count==i-x-1){
							int yyy=y;
							for(int k=x;k<i;k++){
								qizi[k][yyy]=cur;
								yyy++;
							}
						}
					}
					//右上
					if((x-i)==-(y-j)&&(i-x)>=2){
						int yy=y-1;
						int count=0;
						for(int k=x+1;k<i;k++){
							if(qizi[k][yy]==cur*(-1))
								count++;
							yy--;
						}
						if(count==i-x-1){
							int yyy=y;
							for(int k=x;k<i;k++){
								qizi[k][yyy]=cur;
								yyy--;
							}
						}
					}
					//左下
					if((x-i)==-(y-j)&&(x-i)>=2){
						int yy=y+1;
						int count=0;
						for(int k=x-1;k>i;k--){
							if(qizi[k][yy]==cur*(-1))
								count++;
							yy++;
						}
						if(count==x-i-1){
							int yyy=y;
							for(int k=x;k>i;k--){
								qizi[k][yyy]=cur;
								yyy++;
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * whoWin：
	 *根据棋盘上所剩的棋子数量来判断哪一方获胜
	 */
	private int whoWin()
	{
		int blackChess=0;
		int whiteChess=0;
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(qizi[i][j]==BLACK)
					blackChess++;
				if(qizi[i][j]==WHITE)
					whiteChess++;
			}
		}
		
		if(blackChess>whiteChess)
			return 1;  //黑方胜，返回1
		else if(blackChess<whiteChess)
			return -1; //白方胜，返回-1
		else 
			return 0;  //平局，返回0	
			
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// 当前走棋方
		if (curQizi == 1) { // 黑色
			g.setColor(Color.BLACK);
		} else if (curQizi == -1) { // 白色
			g.setColor(Color.WHITE);
		}
		g.fillOval(5, 5, 40, 40);
		g.setColor(Color.BLACK);

		// 画横线
		for (int i = 0; i <= 8; i++) {
			g.drawLine(50, 50 * i + 50, 450, 50 * i + 50);
		}
		// 画竖线
		for (int i = 0; i <= 8; i++) {
			g.drawLine(50 * i + 50, 50, 50 * i + 50, 450);
		}
		// 画标志
		String[] xl = { "A", "B", "C", "D", "E", "F", "G", "H" };
		String[] yl = { "1", "2", "3", "4", "5", "6", "7", "8" };
		for (int i = 0; i < yl.length; i++) {
			g.drawString(xl[i], 50 * i + 72, 40);
			g.drawString(yl[i], 40, 50 * i + 80);
		}
		// 画棋子
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (qizi[i][j] != 0) { //
					if (qizi[i][j] == 1) { // 黑色
						g.setColor(Color.BLACK);
					} else if (qizi[i][j] == -1) { // 白色
						g.setColor(Color.WHITE);
					}
					g.fillOval(55 + 50 * i, 55 + 50 * j, 40, 40);
				}
			}
		}
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		BlackandWhiteChess p = new BlackandWhiteChess();
		f.setContentPane(p);
		f.setSize(500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
