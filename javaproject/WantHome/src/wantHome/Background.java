package wantHome;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Background extends Thread{
	private Image BackgroundImage = new ImageIcon(Main.class.getResource("../images/map.png")).getImage();
	private int x, y;
	
	public Background(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(BackgroundImage, x,y,null);
	}
}
