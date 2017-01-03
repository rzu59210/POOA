package drawing;

import java.awt.*;

import javax.swing.*;

/**
 * Classe Interface graphique pour l'application de dessin
 */
public class Paint {

    private JFrame frame;

    private JButton clearButton;
    private JButton circleButton;
    private JButton rectangleButton;
    private JButton groupButton;
    private JButton dissociateButton;
    private JButton duplicateButton;

    private JPanel buttonPanel;
    private JPanel mainPanel;

    private Drawing drawing;


    private StatusObserver statusObs;


    public void run() {
        frame = new JFrame("Paint");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel(new BorderLayout());
        drawing = new Drawing();
        drawing.setBackground(Color.WHITE);
        clearButton = new JButton("Clear");
        circleButton = new JButton("Circle");
        rectangleButton = new JButton("Rectangle");
        groupButton = new JButton("Grouper");
        dissociateButton = new JButton("Dissocier");
        duplicateButton = new JButton("Dupliquer");

        buttonPanel = new JPanel();
        buttonPanel.add(clearButton);
        buttonPanel.add(circleButton);
        buttonPanel.add(rectangleButton);
        buttonPanel.add(groupButton);
        buttonPanel.add(dissociateButton);
        //buttonPanel.add(duplicateButton);
        statusObs = new StatusObserver();

        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(drawing, BorderLayout.CENTER);
        mainPanel.add(statusObs, BorderLayout.SOUTH);

        Invoker invoker = new Invoker(drawing);
        clearButton.addActionListener(new ClearButtonListener(drawing));
        circleButton.addActionListener(invoker);
        rectangleButton.addActionListener(invoker);
        groupButton.addActionListener(invoker);
        dissociateButton.addActionListener(invoker);
        duplicateButton.addActionListener(invoker);

        DrawingMouseListener l = new DrawingMouseListener(drawing, invoker);
        drawing.addMouseListener(l);
        drawing.addMouseMotionListener(l);
        drawing.addObserver(statusObs);

        frame.getContentPane().add(mainPanel);
        frame.setSize(640, 480);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Paint app = new Paint();
        app.run();
    }
}
