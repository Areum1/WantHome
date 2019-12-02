package wantHome;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class GameStart extends JPanel {
	double randomValue = Math.random();
	int intRandom1 = (int)(randomValue * 500)+600;
	int intRandom2 = (int)(randomValue * 500)+700;
	
	BufferedImage bmap1,bmap2,bcha1,bcha2,bcha3,bcha4,bcha5,bcha6,benemy1;
	public int x1=140,x2;
	public int x,y;
	public static int y1=147;
	public static int y2=447;
	int flag=1;
	int eflag = 1;
	public GameStart(){
		String map1 = "../images/map1.png";
		String map2 = "../images/map2.png";
		String cha1 = "../images/cha1_1.png";
		String cha2 = "../images/cha1_2.png";
		String cha3 = "../images/cha1_3.png";
		String cha4 = "../images/cha2_1.png";
		String cha5 = "../images/cha2_2.png";
		String cha6 = "../images/cha2_3.png";
		String senemy1 = "../images/Android1.png";
		InputStream icha1 = this.getClass().getResourceAsStream(cha1);
		InputStream icha2 = this.getClass().getResourceAsStream(cha2);
		InputStream icha3 = this.getClass().getResourceAsStream(cha3);
		InputStream icha4 = this.getClass().getResourceAsStream(cha4);
		InputStream icha5 = this.getClass().getResourceAsStream(cha5);
		InputStream icha6 = this.getClass().getResourceAsStream(cha6);
		InputStream imap1 = this.getClass().getResourceAsStream(map1);
		InputStream imap2 = this.getClass().getResourceAsStream(map2);
		InputStream iene1 = this.getClass().getResourceAsStream(senemy1);
		
		try{
			bmap1 = ImageIO.read(imap1);
			bmap2 = ImageIO.read(imap2);
			bcha1 = ImageIO.read(icha1);
			bcha2 = ImageIO.read(icha2);
			bcha3 = ImageIO.read(icha3);
			bcha4 = ImageIO.read(icha4);
			bcha5 = ImageIO.read(icha5);
			bcha6 = ImageIO.read(icha6);
			benemy1 = ImageIO.read(iene1);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		new Thread(){
			public void run(){
				while(true){
					try{
						Thread.sleep(170);
						if(intRandom1 < 0) {
							intRandom1 = (int)(randomValue * 300)+650;
						}
						if(intRandom2 < 0) {
							intRandom2 = (int)(randomValue * 300)+700;
						}
					}catch(Exception E){
						E.printStackTrace();
					}
					x-=15;
					
					intRandom1 -= 30;
					intRandom2 -= 30;
//					System.out.println(intRandom);
					addKeyListener(new ChaJump());
					if(ChaJump.flag1 == 1 && y1 > 130) {
						y1 -= 80;
					}
					if(y1 != 147) {
						y1 +=10;
						ChaJump.flag1 = 0;
					}
					if(ChaJump.flag2 == 1 && y2 > 435) {
//						System.out.println("��� 1");
						y2 -= 80;
					}
					if(y2 != 447) {
//						System.out.println("��� 0");
						y2 +=10;
						ChaJump.flag2 = 0;
					}
					if(x>=GameStart.this.getWidth()){
						x=0;
						//y+= bimg.getHeight();
						if(y>=GameStart.this.getHeight()){
							break;
						}
					}
					repaint();
					//�ñ������� painComponent()�� ���ư�
					//�������� �ý��� �����忡�� �� �ý��۽������ �����°� �ƴ϶� �׸��⸦ �����ؾ���
				}
			}
		}.start();
	}
		
		
	@Override
	protected void paintComponent(Graphics arg0) {
		
		super.paintComponent(arg0);
//		System.out.println(x);
		Graphics2D g2d = (Graphics2D)arg0;
		g2d.drawImage(bmap1,x,y,this);
		g2d.drawImage(bmap2,x,y+300,this);
		g2d.drawImage(benemy1, intRandom1,184,this);
		g2d.drawImage(benemy1, intRandom2,484,this);
		
		switch(flag) {
		case 0:
//			System.out.println("��� 0");
			g2d.drawImage(bcha1,x1,y1,this);
			g2d.drawImage(bcha4,140,y2,this);
			flag = 1;
			break;
		case 1:
//			System.out.println("��� 1");
			g2d.drawImage(bcha2,x1,y1,this);
			g2d.drawImage(bcha5,140,y2,this);
			flag = 2;
			break;
		case 2:
//			System.out.println("��� 2");
			g2d.drawImage(bcha3,x1,y1,this);
			g2d.drawImage(bcha6,140,y2,this);
			flag = 0;
			break;
		}
				
//		System.out.println("Graphic");
		
	}
}