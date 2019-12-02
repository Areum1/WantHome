package wantHome;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Setting extends JFrame {

	private ImageIcon soundButtonImage = new ImageIcon(Main.class.getResource("../images/SoundOn.png"));
	private ImageIcon soundButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/SoundOff.png"));
	
	private JButton soundButton = new JButton(soundButtonImage);
	
	Setting(){
		soundButton.setBounds(500, 450, 150, 70);
		soundButton.setBorderPainted(false);
		soundButton.setContentAreaFilled(false);
		soundButton.setFocusPainted(false);
		soundButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				soundButton.setIcon(soundButtonEnteredImage);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				soundButton.setIcon(soundButtonImage);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		add(soundButton);
		
		WantHome.introBackground = new ImageIcon(Main.class.getResource("../images/SettingBackground.png")).getImage();
	}
}
