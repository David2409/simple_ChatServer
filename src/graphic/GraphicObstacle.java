package graphic;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class GraphicObstacle {
	public Vector2 pos;
	public Vector2 size;
	public Vector2 maxSize;
	public Vector2 MinSize;
	public List<GraphicObstacle> childObjects = new ArrayList<GraphicObstacle>(5);
	public Object parent;
	public Color backgroundColor;
	public Color color;
	public VerticalRespond verticalRespond;
	public HorizontaRespond horizontaRespond;
	
	public void Draw(Graphics2D graphics){
		//Calculates The Position of the Child Elements and itself and draws that;
		throw new UnsupportedOperationException("Not Yet Implemented");
	}
	
	public void ReDraw(Graphics2D graphics){
		
		//Only Draws
		throw new UnsupportedOperationException("Not Yet Implemented");
	}
	
	public void Calculate(){
		//Only Calculate The Position
		switch (verticalRespond.name()) {
			case "TOP":
				break;
			case "CENTER":
				break;
			case "BOTTEM":
				break;
		}
		for(int i = 0; i < childObjects.size(); i++){
			childObjects.get(i).Calculate();
		}
	}
	private void CalculateVertical(){
		switch (verticalRespond.name()) {
			case "TOP":
				break;
			case "CENTER":
				break;
			case "BOTTEM":
				break;
		}
	}
	
	private void CalculateHorizontal(){
		
	}
	
	private int ChildElementWidth(){
		return 0;
	}
	
	private int ChildElementHeight(){
		return 0;
	}
	
	public void AddChild(Object child){
		throw new UnsupportedOperationException("Not Yet Implemented");
		//childObjects.add(null);
		}
	
	public Object GetChild(int index){
		return childObjects.get(index);
	}
	
	public void RemoveChild(Object o){
		childObjects.remove(o);
	}
	
	public Object GetParent(){
		return parent;
	}
}