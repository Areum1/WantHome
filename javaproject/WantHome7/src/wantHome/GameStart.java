package wantHome;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class GameStart extends JPanel {
	boolean running = true;
	double randomValue = Math.random();
	int intRandom1 = (int)(randomValue * 500)+600;
	int intRandom2 = (int)(randomValue * 500)+700;
	int intRandom3 = (int)(randomValue * 500)+500;
	int intRandom4 = (int)(randomValue * 500)+600;
	int menu1 = (int)(Math.random()*3);
	int menu2 = (int)(Math.random()*3);
	
	public static int street = 7000;
	
	Music gameMusic = new Music("gameMusic.mp3", true);
	
	BufferedImage bmap1,bmap2,bcha1,bcha2,bcha3,bcha4,bcha5,bcha6,benemy1,benemy2,benemy3,benemy4;
	BufferedImage bsit1, bsit2;
	public int x1=140,x2;
	public int x,y;
	public static int y1=147;
	public static int y2=447;
	int flag=1;
	int eflag = 1;
	
	public static int score1 = 0;
	public static int score2 = 0;
	public static int finish = 0;
	public GameStart(){
		// 게임 음악 켜기
		gameMusic.start();
		
		// 사용하려는 이미지들을 String안에 넣기
		String map1 = "../images/map1.png";
		String map2 = "../images/map2.png";
		String cha1 = "../images/cha1_1.png";
		String cha2 = "../images/cha1_2.png";
		String cha3 = "../images/cha1_3.png";
		String cha4 = "../images/cha2_1.png";
		String cha5 = "../images/cha2_2.png";
		String cha6 = "../images/cha2_3.png";
		String senemy1 = "../images/coin_bronze.png";
		String senemy2 = "../images/coin_silver.png";
		String senemy3 = "../images/coin_bronze.png";
		String senemy4 = "../images/coin_silver.png";
		String sit1 = "../images/cha1_sit.png";
		String sit2 = "../images/cha2_sit.png";
		
		// inputStream안에 넣기
		InputStream icha1 = this.getClass().getResourceAsStream(cha1);
		InputStream icha2 = this.getClass().getResourceAsStream(cha2);
		InputStream icha3 = this.getClass().getResourceAsStream(cha3);
		InputStream icha4 = this.getClass().getResourceAsStream(cha4);
		InputStream icha5 = this.getClass().getResourceAsStream(cha5);
		InputStream icha6 = this.getClass().getResourceAsStream(cha6);
		InputStream imap1 = this.getClass().getResourceAsStream(map1);
		InputStream imap2 = this.getClass().getResourceAsStream(map2);
		InputStream iene1 = this.getClass().getResourceAsStream(senemy1);
		InputStream iene2 = this.getClass().getResourceAsStream(senemy2);
		InputStream iene3 = this.getClass().getResourceAsStream(senemy3);
		InputStream iene4 = this.getClass().getResourceAsStream(senemy4);
		InputStream isit1 = this.getClass().getResourceAsStream(sit1);
		InputStream isit2 = this.getClass().getResourceAsStream(sit2);
				
		
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
			benemy2 = ImageIO.read(iene2);
			benemy3 = ImageIO.read(iene3);
			benemy4 = ImageIO.read(iene4);
			bsit1 = ImageIO.read(isit1);
			bsit2 = ImageIO.read(isit2);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		class Thread1 extends Thread{
			public void run(){
				while(running){
					try{
						
						// 캐릭터 앞까지 오면 새로운 위치에 이미지를 띄울 수 있도록 랜덤을 이용하여 위치를 조정한다
						Thread.sleep(170);
						if(intRandom1 < 280) {
							intRandom1 = (int)(randomValue * 200)+800;
							menu1 = (int)(Math.random()*2);
						}
						if(intRandom2 < 280) {
							intRandom2 = (int)(randomValue * 250)+800;
							menu1 = (int)(Math.random()*2);
						}
						if(intRandom3 < 280 ) {
							intRandom3 = (int)(randomValue * 250)+800;
							menu2 = (int)(Math.random()*2);
						}
						if(intRandom4 < 280) {
							intRandom4 = (int)(randomValue * 200)+800;
							menu2 = (int)(Math.random()*2);
						}
						
						
					}catch(Exception E){
						E.printStackTrace();
					}
					x-=15; // 뒤의 배경이미지가 생동감을 살려주기 위해 15씩 움직인다
					street -=25; // 게임에 시간이 얼만큼 남았는지 알려주기 위해 25씩 작아진다(게임 왼쪽 위에 올라가는 남은 거리의 변수이다)
					
					// 실버코인과 브론즈 코인을 움직이기 위해 30씩 움직인다
					// 캐릭터 앞까지 다가오면 위의 코드가 작용하여 다시 랜덤하게 나온다
					intRandom1 -= 30; 
					intRandom2 -= 30;
					intRandom3 -= 30;
					intRandom4 -= 30;
					addKeyListener(new ChaJump()); // 방향키와 w,s 키를 입력받기 위해 만들었다
					
					// addKeyListener에서 위 화살표가 눌리고 y1의 크기가 130이 넘을 경우에 점프하는 것처럼 30을 뺀다
					if(ChaJump.flag1 == 1 && y1 > 130) {
						y1 -= 30;
					}
					// 147을 지정하면 위 화살표를 두 번 눌러도 점프가 한 번된다 10씩 더해주는 건 점프하고 중력이 작용하는 것처럼 보인다
					if(y1 != 147) {
						y1 +=10;
						ChaJump.flag1 = 0;
					}
					// 위와 원리 동일
					if(ChaJump.flag2 == 1 && y2 > 435) {
						y2 -= 30;
					}
					if(y2 != 447) {
						y2 +=10;
						ChaJump.flag2 = 0;
					}
					if(x>=GameStart.this.getWidth()){
						x=0;
						if(y>=GameStart.this.getHeight()){
							break;
						}
					}
					// 성공과 실패를 나누는 곳
					// 만약 거리가 다 지날 때까지 70점을 넘지 않는다면 실패창이 뜨게 한다
					if(street <=0) {
						running = false;
						gameMusic.close();
						new Fail();
					}
					// 거리를 지나기 전에 70점을 도달한 사람이 있다면 성공창을 뜨게 한다
					if(score1 >= 70 || score2 >=70) {
						running = false;
						gameMusic.close();
						new Success(score1, score2);
					}
					repaint();
				}
				
			}
		}
		Thread1 th = new Thread1();
		th.start();
	}
	
	
	
		
	@Override
	protected void paintComponent(Graphics arg0) {
		
		super.paintComponent(arg0);
		Graphics2D g2d = (Graphics2D)arg0;
		// 뒷 배경 지나가게 한다
		g2d.drawImage(bmap1,x,y,this);
		g2d.drawImage(bmap2,x,y+300,this);
		
		// 실버코인과 브론즈 코인이 움직이는 코드 만약 제대로 키보드를 누르면 -100으로 가서 새롭게 랜덤을 돌린다
		switch(menu1) {
		case 0:
			g2d.drawImage(benemy1, intRandom1-40,184,this);
			if(ChaJump.answer1 == 1) {
				System.out.println("score1 ="+score1);
				intRandom1 = -100;
				ChaJump.answer1 = 0;
				score1 +=1; // 브론즈 코인은 1점
			}
			break;
		case 1:
			g2d.drawImage(benemy2, intRandom2-40,184,this);
			if(ChaJump.answer1 == 2) {
				System.out.println("score1 ="+score1);
				intRandom2 = -100;
				ChaJump.answer1 = 0;
				score1 +=3; // 실버 코인은 3점
			}
			break;
		}		
		switch(menu2) {
		case 0:
			g2d.drawImage(benemy3, intRandom3,484,this);
			if(ChaJump.answer2 == 1) {
				System.out.println("score2 ="+score2);
				intRandom3 = -100;
				ChaJump.answer2 = 0;
				score2 +=1;
			}//answer1 if
			break;
		case 1:
			g2d.drawImage(benemy4, intRandom4,484,this);
			if(ChaJump.answer2 == 2) {
				System.out.println("score2 ="+score2);
				intRandom4 = -100;
				ChaJump.answer2 = 0;
				score2 +=3;
			}//answer2 if
			break;
		}//switch menu2
		
		// 앉는다는 신호가 ChaJump에서 오면 그림을 바꾸고 다시 일어나게 한다
		if(ChaJump.sit1 == 1) {
			g2d.drawImage(bsit1,x1,y1+20,this);
			ChaJump.sit1 =0;
		}//sit2 if
		 
		// 캐릭터가 움직이도록 보이기 위해 3개의 비슷한 이미지를 돌려가며 현실감을 높인다
		else {
			switch(flag) {
			case 0:
				g2d.drawImage(bcha1,x1,y1,this);
				flag = 1;
				break;
			case 1:
				g2d.drawImage(bcha2,x1,y1,this);
				flag = 2;
				break;
			case 2:
				g2d.drawImage(bcha3,x1,y1,this);
				flag = 0;
				break;
			}//flag
		}//else
		
		if(ChaJump.sit2 == 1) {
			g2d.drawImage(bsit2,x1,y1+320,this);
			ChaJump.sit2 =0;
		} //sit2 if
		else {
			switch(flag) {
			case 0:
				g2d.drawImage(bcha4,140,y2,this);
				flag = 1;
				break;
			case 1:
				g2d.drawImage(bcha5,140,y2,this);
				flag = 2;
				break;
			case 2:
				g2d.drawImage(bcha6,140,y2,this);
				flag = 0;
				break;
			}//flag switch
		}//else
		
		g2d.setFont(g2d.getFont().deriveFont(18f)); 
		g2d.drawString("남은 거리 : "+street, 10, 30); 
//		g2d.dispose(); 
		
		g2d.setFont(g2d.getFont().deriveFont(18f)); 
		g2d.drawString("플레이어 1의 점수 : "+score1, 690, 30); 
//		g2d.dispose(); 
		
		g2d.setFont(g2d.getFont().deriveFont(18f)); 
		g2d.drawString("플레이어 2의 점수 : "+score2, 690, 330); 
		g2d.dispose(); 
	}
}