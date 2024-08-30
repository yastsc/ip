import java.time.LocalDate;

public class addToDoCommand extends Command {
    private String description;

    public addToDoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {

    }
}
