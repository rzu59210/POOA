package drawing;

import java.awt.*;

/**
 * Created by JM on 23/01/2017.
 */
public class TextDecorator extends Shape{

    private String text;
    private Shape shape;

    public TextDecorator(Shape shape) {

        this.text = "";
        this.shape = shape;
        this.origin = this.shape.getOrigin();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void paint(Graphics g) {
        if(text != null) {
            this.shape.paint(g);
            g.drawString(text, this.shape.getOrigin().x, this.shape.getOrigin().y);
        }
    }

    @Override
    public void setOrigin(Point p) {
        this.origin = p;
        shape.setOrigin(p);
    }

    @Override
    public boolean isOn(Point p) {
        return this.shape.isOn(p);
    }

    @Override
    public Shape clone() {
        return this.shape.clone();
    }
}
