import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
//主类
public class Zombie{
	public static void main(String args[]){
		new ChessMainFrame("Zombie");
	}
}
//主框架类
class ChessMainFrame extends JFrame{
	//棋盘
	Border image;	
	//窗格
	Container con;
	//工具栏
	JToolBar jmain;	
	//重新开始
	JButton anew;
	//悔棋
	JButton repent;
	//退出
	JButton exit;
	//当前信息
	JLabel text;
	
	ChessMainFrame(String Title){
		//改变系统默认字体
		Font font = new Font("Dialog", Font.PLAIN, 12);
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}
		//获行客格引用
		con = this.getContentPane();
		con.setLayout(null);
		//创建工具栏
		jmain = new JToolBar();
		text = new JLabel("欢迎使用象棋对弈系统");
		//当鼠标放上显示信息
		text.setToolTipText("信息提示");
		anew = new JButton(" 新 游 戏 ");
		anew.setToolTipText("重新开始新的一局");
		exit = new JButton(" 退  出 ");
		exit.setToolTipText("退出象棋程序程序");
		repent = new JButton(" 悔  棋 ");
		repent.setToolTipText("返回到上次走棋的位置");

		//把组件添加到工具栏
		jmain.setLayout(new GridLayout(0,4));
		jmain.add(anew);
		jmain.add(repent);
		jmain.add(exit);
		jmain.add(text);
		jmain.setBounds(0,0,ComData.wWidth,30);
//		con.add(jmain);
		//添加棋盘标签
//		con.add(image = new JLabel(new ImageIcon("image\\Main.GIF")));
		con.add(image = new Border());
		image.setBounds(0, 0, ComData.wWidth, ComData.wHeight);
		
		//注册窗体关闭监听
		this.addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent we){
					System.exit(0);
				}
			}
		);
		
		//窗体居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();
		
		if (frameSize.height > screenSize.height){
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width){
			frameSize.width = screenSize.width;
		}
		
		this.setLocation((screenSize.width - frameSize.width) / 2 - ComData.wWidth/2 ,(screenSize.height - frameSize.height ) / 2 - ComData.wHeight/2);
	
		//设置
		this.setIconImage(new ImageIcon("image\\红将.GIF").getImage());
//		this.setResizable(false);
		this.setTitle(Title);
		this.setSize(ComData.wWidth + 40,ComData.wHeight + 40);
		this.show();
	}
}//主框架类