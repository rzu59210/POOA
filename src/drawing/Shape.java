package drawing;

import java.awt.Graphics;
import java.awt.Point;

/**
 * Classe abstraite de type forme dessinable.
 */
public abstract class Shape {
	
	protected Point origin;
	public boolean isSelected = false;

	public Point getOrigin() {
		return origin;
	}

	public void setOrigin(Point p)
	{
		origin = p;
	}
	
	/**
	 * dessine la forme sur un Graphics
	 */
	public abstract void paint(Graphics g);
	
	/**
	 * renvoie true si la forme occupe sur le point donn�
	 */
	public abstract boolean isOn(Point p);

	public abstract Shape clone();

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean selected) {
		isSelected = selected;
	}
}
