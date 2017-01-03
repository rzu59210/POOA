package drawing;

import javax.swing.*;
import java.awt.*;
import java.util.*;


/**
 * JPanel pouvant afficher des objets de type Shape
 */
public class Drawing extends JPanel implements Iterable<Shape> {

    private static final long serialVersionUID = 1L;

    ArrayList<Shape> shapes;
    ArrayList<Observer> observers;

    public Drawing() {
        super();
        shapes = new ArrayList<Shape>();
        observers = new ArrayList<Observer>();
    }

    /**
     * Impl�mentation de l'interface Iterable<Shape>
     */
    public Iterator<Shape> iterator() {
        return shapes.iterator();
    }

    /**
     * Ajoute une forme au dessin et redessine
     */
    public void addShape(Shape s) {
        shapes.add(s);
        notifyObservers();
        this.repaint();
    }

    /**
     * Red�finition de la m�thode paintComponent() de JComponent
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape s : shapes) {
            s.paint(g);
        }
    }

    /**
     * Enl�ve toutes les formes et redessine
     */
    public void clear() {
        shapes.clear();
        notifyObservers();
        this.repaint();
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer obs : observers)
            obs.update(this);

    }

    public void removeForm(Shape shape){
        this.shapes.remove(shape);
    }

    public int countForms() {
        return shapes.size();
    }

}
