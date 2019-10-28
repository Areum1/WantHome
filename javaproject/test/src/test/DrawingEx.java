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
			//�̰� �г��� ũ�⸦ �̹��� ũ�⸸ŭ �����ϴ� ���̱� ������ ���� �̹�����
			//��µǷ��� ũ�⸦ ���ϸ�ȵȴ�
			//�� �ּ� ó�� �� ���� -> ������ ����
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
	//�ñ������� painComponent()�����ư�
	//�������� �ý��� �����忡�� �� �ý��۽������ �����°� �ƴ϶� �׸��⸦ �����ؾ���
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
	//public paintComponents��
}