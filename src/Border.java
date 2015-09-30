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
	private int marginL = ComData.wWidth - ComData.gWidth;
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(new Color(168,148,128));//设置边框颜色
        g.drawRoundRect(marginL, 0, ComData.gWidth, ComData.gHeight, 20, 20); //画一个圆角矩形
          
        //消除锯齿  
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,  
                                               RenderingHints.VALUE_ANTIALIAS_ON);  
        Graphics2D g2 = (Graphics2D)g;  
        g2.addRenderingHints(rh);  
        //半透明  
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));  
        //设置填充颜色，这里设置了渐变，由下往上  
        g2.setPaint(new GradientPaint(this.getWidth()/2  
                                      , 1  
                                      , new Color(255,255,255)  
                                      , this.getWidth()/2  
                                      , this.getHeight() -1  
                                      , new Color(0,0,255)));  
        //填充圆角矩形  
        g2.fillRoundRect(marginL, 0, ComData.gWidth, ComData.gHeight, 20, 20);
	}

}
