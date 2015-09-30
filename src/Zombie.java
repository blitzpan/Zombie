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
//����
public class Zombie{
	public static void main(String args[]){
		new ChessMainFrame("Zombie");
	}
}
//�������
class ChessMainFrame extends JFrame{
	//����
	Border image;	
	//����
	Container con;
	//������
	JToolBar jmain;	
	//���¿�ʼ
	JButton anew;
	//����
	JButton repent;
	//�˳�
	JButton exit;
	//��ǰ��Ϣ
	JLabel text;
	
	ChessMainFrame(String Title){
		//�ı�ϵͳĬ������
		Font font = new Font("Dialog", Font.PLAIN, 12);
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}
		//���п͸�����
		con = this.getContentPane();
		con.setLayout(null);
		//����������
		jmain = new JToolBar();
		text = new JLabel("��ӭʹ���������ϵͳ");
		//����������ʾ��Ϣ
		text.setToolTipText("��Ϣ��ʾ");
		anew = new JButton(" �� �� Ϸ ");
		anew.setToolTipText("���¿�ʼ�µ�һ��");
		exit = new JButton(" ��  �� ");
		exit.setToolTipText("�˳�����������");
		repent = new JButton(" ��  �� ");
		repent.setToolTipText("���ص��ϴ������λ��");

		//�������ӵ�������
		jmain.setLayout(new GridLayout(0,4));
		jmain.add(anew);
		jmain.add(repent);
		jmain.add(exit);
		jmain.add(text);
		jmain.setBounds(0,0,ComData.wWidth,30);
//		con.add(jmain);
		//������̱�ǩ
//		con.add(image = new JLabel(new ImageIcon("image\\Main.GIF")));
		con.add(image = new Border());
		image.setBounds(0, 0, ComData.wWidth, ComData.wHeight);
		
		//ע�ᴰ��رռ���
		this.addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent we){
					System.exit(0);
				}
			}
		);
		
		//�������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();
		
		if (frameSize.height > screenSize.height){
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width){
			frameSize.width = screenSize.width;
		}
		
		this.setLocation((screenSize.width - frameSize.width) / 2 - ComData.wWidth/2 ,(screenSize.height - frameSize.height ) / 2 - ComData.wHeight/2);
	
		//����
		this.setIconImage(new ImageIcon("image\\�콫.GIF").getImage());
//		this.setResizable(false);
		this.setTitle(Title);
		this.setSize(ComData.wWidth + 40,ComData.wHeight + 40);
		this.show();
	}
}//�������