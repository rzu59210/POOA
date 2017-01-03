package drawing;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

/**
 * Classe Interface graphique pour l'application de dessin
 */
public class Paint {

    private JFrame frame;
    private JButton clearButton;
    private JButton circleButton;
    private JButton rectangleButton;
    private JButton groupButton;
    private JButton duplicateButton;
    private JPanel buttonPanel;
    private JPanel mainPanel;

    private Drawing drawing;
    private JLabel nbCircles;
    private JLabel nbFigures;
    private JLabel nbRectangles;
    private JTextField nbCirclesText;
    private JTextField nbRectanglesText;
    private JTextField nbFigureText;
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

        buttonPanel = new JPanel();
        buttonPanel.add(clearButton);
        buttonPanel.add(circleButton);
        buttonPanel.add(rectangleButton);
        buttonPanel.add(groupButton);
        //buttonPanel.add(duplicateButton);
     /*   statusPanel.add(buttonPanel, BorderLayout.SOUTH);
        statusPanel.add(nbFigureText , BorderLayout.SOUTH);
        statusText.add(nbFigures , BorderLayout.SOUTH);
        statusText.add(nbFigureText , BorderLayout.SOUTH);*/


        statusObs = new StatusObserver();




     /*   statusText.add(nbCirclesText, BorderLayout.WEST);
        statusText.add(nbRectanglesText, BorderLayout.EAST); */


        /*statusPanel.add(nbCircles, BorderLayout.WEST);
        statusPanel.add(nbRectangles, BorderLayout.EAST);
        statusPanel.add(statusText, BorderLayout.SOUTH); */

        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(drawing, BorderLayout.CENTER);
        mainPanel.add(statusObs, BorderLayout.SOUTH);
        //listeners pour les boutons
        clearButton.addActionListener(new ClearButtonListener(drawing));
        circleButton.addActionListener(new CircleButtonListener(drawing));
        rectangleButton.addActionListener(new RectangleButtonListener(drawing));
        groupButton.addActionListener(new GroupButtonListener(drawing));

        //listeners pour la zone de dessin
        DrawingMouseListener l = new DrawingMouseListener(drawing);
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
