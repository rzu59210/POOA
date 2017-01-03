package drawing;

public class CommandMove implements Command{

    private Drawing drawing;

    public CommandMove(Drawing drawing) {
        this.drawing = drawing;
    }

    @Override
    public void execute() {

    }

    @Override
    public void unexecute() {

    }
}
