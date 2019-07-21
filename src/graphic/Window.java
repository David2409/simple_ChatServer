package graphic;
import java.awt.Graphics;
import java.awt.List;

import javax.swing.JPanel;

public class Window extends JPanel {
	
	private void draw(Graphics graphics){
		graphics.drawRect(0, 0, 100, 100);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
}