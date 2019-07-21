package graphic;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.net.ssl.ExtendedSSLSession;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Rectangle extends GraphicObstacle {
	
	public Rectangle(Vector2 iPos, Vector2 iSize, Color iColor, Color iBackgroundColor, Object iParent, VerticalRespond iVerticalRespond, HorizontaRespond iHorizontaRespond) {
		pos = iPos;
		size = iSize;
		color = iColor;
		backgroundColor = iBackgroundColor;
		parent = iParent;
		verticalRespond = iVerticalRespond;
		horizontaRespond = iHorizontaRespond;
		childObjects = new ArrayList<>();
	}
	
	@Override
	public void Draw(Graphics2D graphics){
		graphics.setColor(color);
		graphics.fillRect(pos.x, pos.y, size.x, size.y);
		graphics.setColor(backgroundColor);
		graphics.fillRect(pos.x, pos.y, size.x, size.y);

		for (int i = 0; i < childObjects.size(); i++) {
			childObjects.get(i).Draw(graphics);
		}
	}
	
	@Override
	public void ReDraw(Graphics2D graphics) {
		graphics.setColor(color);
		graphics.fillRect(pos.x, pos.y, size.x, size.y);
		graphics.setColor(backgroundColor);
		graphics.fillRect(pos.x, pos.y, size.x, size.y);

		for (int i = 0; i < childObjects.size(); i++) {
			childObjects.get(i).ReDraw(graphics);
		}
	}
	
	@Override
	public void Calculate() {
		
		for (int i = 0; i < childObjects.size(); i++) {
			
			childObjects.get(i).Calculate();
		}
	}
}