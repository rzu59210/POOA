package drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Invoker implements ActionListener {

    Drawing drawing;
    private ArrayList<Command> commandesList;
    private ArrayList<Command> commandesRedoList;

    public Invoker(Drawing drawing) {
        this.drawing = drawing;
        commandesList = new ArrayList<>();
        commandesRedoList = new ArrayList<>();
    }

    public void doAction(Command command) {
        commandesList.add(command);
        command.execute();
    }

    public void executeCommand(String command) {
        System.out.println("Execute cmd : " + command);
        switch (command) {
            case "Circle":
                doAction(new CommandCircleButton(this.drawing));
                break;
            case "Rectangle":
                doAction(new CommandRectangleButton(this.drawing));
                break;
            case "Grouper":
                doAction(new CommandGroupButton(this.drawing));
                break;
            case "Degrouper":
                doAction(new CommandDissociateButton(this.drawing));
                break;
            case "Dupliquer":
                doAction(new CommandCopyButton(this.drawing));
                break;
            case "Undo":
                if (commandesList.size() > 0) {
                    commandesRedoList.add(commandesList.get(commandesList.size() - 1));
                    commandesList.get(commandesList.size() - 1).unexecute();
                    commandesList.remove(commandesList.size() - 1);
                    drawing.repaint();
                }
                break;
            case "Redo":
                if (commandesRedoList.size() > 0) {
                    commandesRedoList.get(commandesRedoList.size() - 1).execute();
                    commandesList.add(commandesRedoList.get(commandesRedoList.size() - 1));
                    commandesRedoList.remove(commandesRedoList.size() - 1);
                    drawing.repaint();
                }
                break;

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Command : " + e.getActionCommand());
        executeCommand(e.getActionCommand());
    }
}
