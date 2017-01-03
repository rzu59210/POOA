package drawing;

import java.awt.Color;

public class RectangleButtonListener extends ShapeButtonListener {

	private Drawing drawing;
	public RectangleButtonListener(Drawing drawing){
		super(drawing);
		this.drawing = drawing;
	}
	
	@Override
	protected Shape createShape() {
		double width = Math.abs(destination.getX()-origin.getX());
		double height = Math.abs(destination.getY()-origin.getY());
		Rectangle r = new Rectangle(origin, (int)width, (int)height, Color.BLUE);
		return r;
	}

}
