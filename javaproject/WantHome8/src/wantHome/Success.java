package wantHome;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class Success extends JFrame{
    ImageIcon i = new ImageIcon("../images/map1.png");
    Image im=i.getImage();
    Success(){
        this.setTitle("이미지 그리기 연습");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MyPanel panel = new MyPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JButton("Hello"));
        
        this.add(panel);
        this.setSize(400,400);
        this.setVisible(true);
    }
    class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(im,0,0,getWidth(),getHeight(),this);
        }
    }
}