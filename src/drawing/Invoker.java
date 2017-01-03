package drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Invoker implements ActionListener {

    Drawing drawing;
    private ArrayList<Command> Lst_Commande;
    private ArrayList<Command> Lst_RedoCommand;

    public Invoker(Drawing drawing) {
        this.drawing = drawing;
        Lst_Commande = new ArrayList<>();
        Lst_RedoCommand = new ArrayList<>();
    }

    public void doAction(Command command) {
        Lst_Commande.add(command);
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
                if (Lst_Commande.size() > 0) {
                    Lst_RedoCommand.add(Lst_Commande.get(Lst_Commande.size() - 1));
                    Lst_Commande.get(Lst_Commande.size() - 1).unexecute();
                    Lst_Commande.remove(Lst_Commande.size() - 1);
                    drawing.repaint();
                }
                break;
            case "Redo":
                if (Lst_RedoCommand.size() > 0) {
                    Lst_RedoCommand.get(Lst_RedoCommand.size() - 1).execute();
                    Lst_Commande.add(Lst_RedoCommand.get(Lst_RedoCommand.size() - 1));
                    Lst_RedoCommand.remove(Lst_RedoCommand.size() - 1);
                    drawing.repaint();
                }
                break;

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {System.out.println("Command : " + e.getActionCommand());
        executeCommand(e.getActionCommand());
    }
}
