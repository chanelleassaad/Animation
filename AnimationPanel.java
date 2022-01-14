import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimationPanel extends JPanel {
	private final int WIDTH = 300, HEIGHT = 200;
	private final int DELAY = 20, IMAGE_SIZE = 35;
	private int x, y, deltaX, deltaY;
	private ImageIcon image;
	private Timer timer;
	public AnimationPanel() {
		image = new ImageIcon("happyFace.gif");
		
		x = 0; y = 40;
		deltaX = deltaY = 3;
		
		timer = new Timer(DELAY, new ReboundListener());
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.BLACK);
		timer.start();
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		image.paintIcon(this, g, x, y);
	}
	
	private class ReboundListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			x += deltaX;
			y += deltaY;
			
			if(x<=0 || x >= (WIDTH - IMAGE_SIZE))
				deltaX *= -1;
			if(y<=0 || y >= (HEIGHT - IMAGE_SIZE))
				deltaY *= -1;
			
			repaint();
		}
		
	}

}
