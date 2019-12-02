package FebWeek3;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class DrawingEx extends JPanel {
	BufferedImage bimg,bimg1,bimg2,bimg3;
	int x,y,x1;
	int flag=1;
	public DrawingEx(){
		String map1 = "map2.png";
		String cha3 = "walk0008.png";
		String cha2 = "walk0004.png";
		String cha1="walk0002.png";
		InputStream in = this.getClass().getResourceAsStream(cha1);
		InputStream in1 = this.getClass().getResourceAsStream(cha2);
		InputStream in2 = this.getClass().getResourceAsStream(cha3);
		InputStream mapima = this.getClass().getResourceAsStream(map1);
		try{
			bimg = ImageIO.read(in);
			bimg1 = ImageIO.read(in1);
			bimg2 = ImageIO.read(in2);
			bimg3 = ImageIO.read(mapima);
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
						Thread.sleep(140);
					}catch(Exception E){
						E.printStackTrace();
					}
					x1-=20;
					if(x>=DrawingEx.this.getWidth()){
						x=0;
						//y+= bimg.getHeight();
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
		
		super.paintComponent(arg0);
		System.out.println(x);
		Graphics2D g2d = (Graphics2D)arg0;
		g2d.drawImage(bimg3,x1,y,this);
		
		switch(flag) {
		case 0:
			System.out.println("깃발 0");
			g2d.drawImage(bimg,x+70,y+147,this);
			flag = 1;
			break;
		case 1:
			System.out.println("깃발 1");
			g2d.drawImage(bimg1,x+70,y+147,this);
			flag = 2;
			break;
		case 2:
			System.out.println("깃발 2");
			g2d.drawImage(bimg2,x+70,y+147,this);
			flag = 0;
			break;
		}
				
		System.out.println("Graphic");
		
	}
	//public paintComponents가
}