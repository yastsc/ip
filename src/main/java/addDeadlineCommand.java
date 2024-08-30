import java.time.LocalDate;

public class addDeadlineCommand extends Command {
    private String description;
    private String by;
    private LocalDate date;

    public addDeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    public addDeadlineCommand(String description, LocalDate date) {
        this.description = description;
        this.date = date;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {

    }
}
