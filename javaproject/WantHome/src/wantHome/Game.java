package wantHome;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Game extends JFrame{
	
	JLabel la1 =new JLabel("Areum");
    JLabel la2 =new JLabel("Aromi");
    
    final int FLYING_UNIT=10;
	
	Game() {
		setUndecorated(true);
		setTitle("I want go home");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		setLocation(0,0);
		addKeyListener(new MyKeyListener());
		
		la1.setLocation(50,50);
        la1.setSize(100,20);
        
        la2.setLocation(50,370);
        la2.setSize(100,20);
        
        add(la1);
		add(la2);
		
		WantHome.introBackground = new ImageIcon(Main.class.getResource("../images/map.png")).getImage();
    }	
	
	class MyKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode =e.getKeyCode();
            
            switch(keyCode){
                case KeyEvent.VK_UP:
                	if(la1.getY() < 40)
                		la1.setLocation(la1.getX(), la1.getY()+FLYING_UNIT);
                    la1.setLocation(la1.getX(), la1.getY()-FLYING_UNIT); System.out.println(la1.getX()+" "+la1.getY()); break;
                case KeyEvent.VK_DOWN:
                	if(la1.getY() > 210)
                		la1.setLocation(la1.getX(), la1.getY()-FLYING_UNIT);
                    la1.setLocation(la1.getX(), la1.getY()+FLYING_UNIT); System.out.println(la1.getX()+" "+la1.getY()); break;
                case KeyEvent.VK_RIGHT:
                    la1.setLocation(la1.getX()+FLYING_UNIT, la1.getY()); break;
                case KeyEvent.VK_LEFT:
                    la1.setLocation(la1.getX()-FLYING_UNIT, la1.getY()); break;
                case 87:
                	if(la2.getY() < 310)
                		la2.setLocation(la2.getX(), la2.getY()+FLYING_UNIT);
	                la2.setLocation(la2.getX(), la2.getY()-FLYING_UNIT); System.out.println(la2.getX()+" "+la2.getY()); break;
	            case 83:
	            	if(la2.getY() > 510)
                		la2.setLocation(la2.getX(), la2.getY()-FLYING_UNIT);
	                la2.setLocation(la2.getX(), la2.getY()+FLYING_UNIT); System.out.println(la2.getX()+" "+la2.getY()); break;
	            case 68:
	                la2.setLocation(la2.getX()+FLYING_UNIT, la2.getY()); break;
	            case 65:
	                la2.setLocation(la2.getX()-FLYING_UNIT, la2.getY()); break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
	}
}
