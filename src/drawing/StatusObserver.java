package drawing;

import javax.accessibility.AccessibleContext;
import javax.swing.*;
import javax.swing.plaf.PanelUI;

/**
 * Created by kevin on 22/11/2016.
 */
public class StatusObserver extends JLabel implements Observer {
    private Drawing drawing = new Drawing();
    public static int increment = 0;

    @Override
    public void update(Object o) {
        this.drawing = (Drawing) o;
        this.setText("Nombre de figures :  " + drawing.countForms());
    }
}
