package wantHome;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ChaJump implements KeyListener {
	static int flag1 = 0;
	static int flag2 = 0;
	static int sit1 = 0;
	static int sit2 = 0;
	static int answer1 = 0;
	static int answer2 = 0;
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode) {
		case KeyEvent.VK_UP:
			flag1 = 1; 
			answer1 = 1;
			break;
		case KeyEvent.VK_DOWN:
			sit1 = 1;
			answer1 = 2;
			break;
		case 87:
			flag2 = 1;
			answer2 = 1;
			break;
		case 83:
			sit2 =1;
			answer2 = 2;
			break;
		default:
			System.exit(0);
			break;
		}
		
//		System.out.println(e);
	}
}