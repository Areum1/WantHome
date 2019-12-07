package wantHome;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Fail extends JFrame{
	
	private ImageIcon stopButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/StopButtonPressed.png"));
	private ImageIcon stopButtonImage = new ImageIcon(Main.class.getResource("../images/StopButton.png"));
	
	private JButton stopButton = new JButton(stopButtonImage);
	
	private ImageIcon againButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/AgainButtonPressed.png"));
	private ImageIcon againButtonImage = new ImageIcon(Main.class.getResource("../images/AgainButton.png"));
	
	private JButton againButton = new JButton(againButtonImage);
	
	private ImageIcon BackgroundImage = new ImageIcon(Main.class.getResource("../images/FailBackground.png"));
	
	private JButton backButton = new JButton(BackgroundImage);
	
    ImageIcon i = new ImageIcon("../images/map1.png");
    Image im=i.getImage();
    Fail(){
        this.setTitle("½ÇÆÐ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MyPanel panel = new MyPanel();
        panel.setLayout(new FlowLayout());
        
        backButton.setBounds(0, 0, 0, 0);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(BackgroundImage);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(BackgroundImage);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});        
        panel.add(backButton);
        
        stopButton.setBounds(840, 2, 60, 25);
        stopButton.setBorderPainted(false);
        stopButton.setContentAreaFilled(false);
        stopButton.setFocusPainted(false);
        stopButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				stopButton.setIcon(stopButtonEnteredImage);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				stopButton.setIcon(stopButtonImage);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});        
        panel.add(stopButton);
        
        againButton.setBounds(840, 2, 25, 25);
        againButton.setBorderPainted(false);
        againButton.setContentAreaFilled(false);
        againButton.setFocusPainted(false);
        againButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				againButton.setIcon(againButtonEnteredImage);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				againButton.setIcon(againButtonImage);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
				new WantHome();
				GameStart.score1 = 0;
				GameStart.score2 = 0;
				GameStart.street = 7000;
			}
		});        
        panel.add(againButton);
          
        this.add(panel);
        this.setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
        this.setVisible(true);
    }
    class MyPanel extends JPanel{
            
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(im,0,0,getWidth(),getHeight(),this);
        }
    }
}