package drawing;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawingMouseListener implements MouseMotionListener, MouseListener {

    Drawing drawing;
    Shape currentShape = null;

    public DrawingMouseListener(Drawing d) {
        drawing = d;
    }

    public void mouseDragged(MouseEvent e) {
        if (currentShape != null) {
            currentShape.setOrigin(e.getPoint());
            drawing.repaint();
        }
    }

    public void mousePressed(MouseEvent e) {
        for (Shape s : drawing) {
            if (s.isOn(e.getPoint())) {
                currentShape = s;
                break;
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        currentShape = null;

    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
