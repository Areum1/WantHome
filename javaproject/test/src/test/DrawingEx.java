package test;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DrawingEx extends JPanel {
	BufferedImage bimg;
	int x,y;
	public DrawingEx(){
		String filename="../images/cat1.png";
		InputStream in = this.getClass().getResourceAsStream(filename);
		try{
			bimg = ImageIO.read(in);
			//this.setBounds(0, 0, bimg.getWidth(),bimg.getHeight());
			//이건 패널의 크기를 이미지 크기만큼 지정하는 것이기 때문에 여러 이미지가
			//출력되려면 크기를 정하면안된다
			//왜 주석 처리 한 거지 -> 정답은 위에
		}catch(Exception e){
			e.printStackTrace();
		}
		new Thread(){
			public void run(){
				while(true){
					try{
						Thread.sleep(1000);
					}catch(Exception E){
						E.printStackTrace();
					}
					x+=bimg.getWidth();
					if(x>=DrawingEx.this.getWidth()){
						x=0;
						y+= bimg.getHeight();
						if(y>=DrawingEx.this.getHeight()){
							break;
						}
					}
					repaint();
	//궁극적으로 painComponent()가돌아감
	//저명령을 시스템 스레드에게 함 시스템스레드는 돌리는게 아니라 그리기를 수행해야함
				}
			}
		}.start();
	}
	@Override
	protected void paintComponent(Graphics arg0) {
		
		//super.paintComponent(arg0);
		Graphics2D g2d = (Graphics2D)arg0;
		g2d.drawImage(bimg, x , y, this);
		System.out.println("Graphic");
		
	}
	//public paintComponents가
}