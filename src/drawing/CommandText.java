package drawing;

import sun.security.provider.SHA;

import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by JM on 23/01/2017.
 */
public class CommandText implements Command {

    private Drawing drawing;
    private Shape shape;
    private JFrame frame;
    private String currentName;
    private TextDecorator textDecorator;

    public CommandText(Drawing drawing) {

        this.drawing = drawing;
    }

    @Override
    public void execute() {
        for(Shape shape : this.drawing) {
            if(shape.isSelected()) {
                this.shape = shape;
                textDecorator = new TextDecorator(this.shape);
                showFrameText();
            }
        }
        drawing.repaint();
    }

    @Override
    public void unexecute() {
        textDecorator.setText(currentName);
        drawing.repaint();
    }


    private void showFrameText() {
        frame = new JFrame();
        frame.setTitle("Insert text");
        frame.setSize(160, 80);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton textButton = new JButton("Text");
        JButton cancelButton = new JButton("Cancel");
        JTextField textField = new JTextField();

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(textButton);
        buttonPanel.add(cancelButton);

        textButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentName = textDecorator.getText();
                textDecorator.setText(textField.getText());
                drawing.removeForm(shape);
                drawing.addShape(textDecorator);
                drawing.repaint();
                frame.dispose();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.add(textField, BorderLayout.CENTER);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(textPanel, BorderLayout.CENTER);

        frame.setContentPane(panel);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

