package wantHome;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class GameStart extends JPanel {
	BufferedImage bmap1,bmap2,bcha1,bcha2,bcha3,bcha4,bcha5,bcha6;
	int x1,x2,y,x;
	int flag=1;
	public GameStart(){
		String map1 = "../images/map1.png";
		String map2 = "../images/map2.png";
		String cha1 = "../images/cha1_1.png";
		String cha2 = "../images/cha1_2.png";
		String cha3 = "../images/cha1_3.png";
		String cha4 = "../images/cha2_1.png";
		String cha5 = "../images/cha2_2.png";
		String cha6 = "../images/cha2_3.png";
		InputStream icha1 = this.getClass().getResourceAsStream(cha1);
		InputStream icha2 = this.getClass().getResourceAsStream(cha2);
		InputStream icha3 = this.getClass().getResourceAsStream(cha3);
		InputStream icha4 = this.getClass().getResourceAsStream(cha4);
		InputStream icha5 = this.getClass().getResourceAsStream(cha5);
		InputStream icha6 = this.getClass().getResourceAsStream(cha6);
		InputStream imap1 = this.getClass().getResourceAsStream(map1);
		InputStream imap2 = this.getClass().getResourceAsStream(map2);
		try{
			bmap1 = ImageIO.read(imap1);
			bmap2 = ImageIO.read(imap2);
			bcha1 = ImageIO.read(icha1);
			bcha2 = ImageIO.read(icha2);
			bcha3 = ImageIO.read(icha3);
			bcha4 = ImageIO.read(icha4);
			bcha5 = ImageIO.read(icha5);
			bcha6 = ImageIO.read(icha6);
		}catch(Exception e){
			e.printStackTrace();
		}
		new Thread(){
			public void run(){
				while(true){
					try{
						Thread.sleep(150);
					}catch(Exception E){
						E.printStackTrace();
					}
					x-=20;
					if(x>=GameStart.this.getWidth()){
						x=0;
						//y+= bimg.getHeight();
						if(y>=GameStart.this.getHeight()){
							break;
						}
					}
					repaint();
					//궁극적으로 painComponent()가 돌아감
					//저명령을 시스템 스레드에게 함 시스템스레드는 돌리는게 아니라 그리기를 수행해야함
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
		
		switch(flag) {
		case 0:
//			System.out.println("깃발 0");
			g2d.drawImage(bcha1,140,y+147,this);
			g2d.drawImage(bcha4,140,y+447,this);
			flag = 1;
			break;
		case 1:
//			System.out.println("깃발 1");
			g2d.drawImage(bcha2,140,y+147,this);
			g2d.drawImage(bcha5,140,y+447,this);
			flag = 2;
			break;
		case 2:
//			System.out.println("깃발 2");
			g2d.drawImage(bcha3,140,y+147,this);
			g2d.drawImage(bcha6,140,y+447,this);
			flag = 0;
			break;
		}
				
//		System.out.println("Graphic");
		
	}
}
class Key implements KeyListener{
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode) {
		case KeyEvent.VK_UP:
			System.out.println("위 캐릭터 점프");
			
			break;
		
		case 87:
			System.out.println("아래 캐릭터 점프");
			break;
		}
		
		System.out.println(e);
	}
}

//	class MyKeyListener implements KeyListener{
//
//        @Override
//        public void keyTyped(KeyEvent e) {
//        }
//
//        @Override
//        public int keyPressed(KeyEvent e) {
//            int keyCode =e.getKeyCode();
//            
//            switch(keyCode){
//                case KeyEvent.VK_UP:
//                	if( < 40) {
//                		return y;
//                	}
//                		
//                case 87:
//                	if(la2.getY() < 310)
//                		la2.setLocation(la2.getX(), la2.getY()+FLYING_UNIT);
//	                la2.setLocation(la2.getX(), la2.getY()-FLYING_UNIT); System.out.println(la2.getX()+" "+la2.getY()); break;
//            }
//        }
//
//        @Override
//        public void keyReleased(KeyEvent e) {
//        }
//	}
//}