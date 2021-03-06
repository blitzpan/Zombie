import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;

public class Border extends JComponent {
	private int xC = 9;
	private int yC = 5;
	private int marginL = ComData.wWidth - ComData.gWidth;//���margin
	private int paneWidth = ComData.gWidth / xC;
	private int paneHeight = ComData.gHeight / yC;
	
	@Override
	protected void paintComponent(Graphics g) {
		//��5������
		for(int i=1; i<6; i++){
			g.drawLine(marginL, paneHeight * i, marginL + ComData.gWidth, paneHeight * i);
		}
		//��8������
		for(int i=0; i<9; i++){
			g.drawLine(marginL + paneWidth * i, 0, marginL + paneWidth * i, ComData.gHeight);
		}
		
		
		
		
		
		g.setColor(new Color(168,148,128));//���ñ߿���ɫ
        g.drawRoundRect(marginL, 0, ComData.gWidth, ComData.gHeight, 20, 20); //��һ��Բ�Ǿ���
        
        
        
        
        
        
        //�������  
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,  
                                               RenderingHints.VALUE_ANTIALIAS_ON);  
        Graphics2D g2 = (Graphics2D)g;  
        g2.addRenderingHints(rh);  
        //��͸��  
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));  
        //���������ɫ�����������˽��䣬��������  
        g2.setPaint(new GradientPaint(this.getWidth()/2  
                                      , 1  
                                      , new Color(255,255,255)  
                                      , this.getWidth()/2  
                                      , this.getHeight() -1  
                                      , new Color(0,0,255)));  
        //���Բ�Ǿ���  
        g2.fillRoundRect(marginL, 0, ComData.gWidth, ComData.gHeight, 20, 20);
	}

}
