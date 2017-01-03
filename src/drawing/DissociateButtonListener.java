package drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DissociateButtonListener implements ActionListener {

    Drawing drawing;

    public DissociateButtonListener(Drawing draw) {
        this.drawing = draw;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        GroupForm groupForm = new GroupForm();
        for (Shape s : drawing.shapes) {
            drawing.shapes.remove(s);
        }
    }
}
