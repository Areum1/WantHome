package test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import wantHome.Main;

class FlyingTextEx extends JFrame{
    JPanel contentPane = new JPanel();
    JLabel la1;
    final int FLYING_UNIT=10;
    
    private ImageIcon PlayerImage1 = new ImageIcon("../images/map.png");
    
    FlyingTextEx(){
        this.setTitle("상하좌우키를 눌러 텍스트 움직이기");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        la1 = new JLabel("dfd",PlayerImage1,);
        
        this.setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.addKeyListener(new MyKeyListener());
        
        la1.setLocation(50,50);
        la1.setSize(100,20);
        contentPane.add(la1);
        
        setSize(900,600);
        setVisible(true);
        
        contentPane.requestFocus();
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
                    la1.setLocation(la1.getX(), la1.getY()-FLYING_UNIT); System.out.println(la1.getX()+" "+la1.getY()); break;
                case KeyEvent.VK_DOWN:
                	if(la1.getY() > 400)
                		la1.setLocation(la1.getX(), la1.getY()-FLYING_UNIT);
                    la1.setLocation(la1.getX(), la1.getY()+FLYING_UNIT); System.out.println(la1.getX()+" "+la1.getY()); break;
                case KeyEvent.VK_RIGHT:
                    la1.setLocation(la1.getX()+FLYING_UNIT, la1.getY()); break;
                case KeyEvent.VK_LEFT:
                    la1.setLocation(la1.getX()-FLYING_UNIT, la1.getY());
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
        
    }
}

public class textTest {

    public static void main(String[] args) {
        new FlyingTextEx();
    }
    
}
