package drawing;

import java.awt.*;
import java.util.ArrayList;

public class GroupForm extends Shape {

    private ArrayList<Shape> shapes;

    public GroupForm() {
        this.shapes = new ArrayList<>();
    }

    public void addForm(Shape shape) {
        this.shapes.add(shape);
        this.origin = shape.origin;
    }

    public void removeForm(Shape shape) {
        this.shapes.remove(shape);
    }

    public boolean isEmpty() {
        return shapes.isEmpty();
    }

    public boolean contains(Shape shape) {
        if (shapes.contains(shape))
            return true;

        return false;
    }

    public ArrayList<Shape> getShapeList() {
        return shapes;
    }

    @Override
    public void paint(Graphics g) {
        for (Shape shape : shapes) {
            shape.paint(g);
        }
    }

    @Override
    public boolean isOn(Point p) {
        for (Shape shape : shapes) {
            if (shape.isOn(p)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Shape clone() {
        GroupForm compositeShape = new GroupForm();
        compositeShape.origin = this.origin;
        for(Shape shape : this.shapes) {
            compositeShape.addForm(shape.clone());
        }
        return compositeShape;
    }

    @Override
    public void setOrigin(Point p) {
        int newX = this.origin.x - p.x;
        int newY = this.origin.y - p.y;

        for (Shape shape : shapes) {
            Point newPoint = new Point(shape.origin.x - newX, shape.origin.y - newY);
            shape.setOrigin(newPoint);
        }
        this.origin = p;
    }
}
