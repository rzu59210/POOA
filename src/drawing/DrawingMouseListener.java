package drawing;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawingMouseListener implements MouseMotionListener, MouseListener {

    Drawing drawing;
    Shape currentShape = null;
    Point last;
    CommandMove commandMove;
    Point first;
    Invoker invoker;

    public DrawingMouseListener(Drawing d, Invoker invoker) {
        this.invoker = invoker;
        drawing = d;
    }

    public void mouseDragged(MouseEvent e) {
        if (currentShape != null) {
            currentShape.setOrigin(e.getPoint());
            drawing.repaint();
        }
    }

    public void mousePressed(MouseEvent e) {
        last = e.getPoint();
        for (Shape s : drawing) {
            if (s.isOn(e.getPoint())) {
                currentShape = s;
                first = currentShape.origin;
                currentShape.isSelected = true;
                System.out.println("Forme sélectionnée");
                break;
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        if(currentShape != null){
            commandMove = new CommandMove(drawing,currentShape,first);
            invoker.doAction(commandMove);
        }
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
