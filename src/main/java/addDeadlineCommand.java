import java.time.LocalDate;
import java.time.LocalDateTime;

public class addDeadlineCommand extends Command {
    private String description;
    private String by;
    private LocalDateTime date;

    public addDeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    public addDeadlineCommand(String description, LocalDateTime date) {
        this.description = description;
        this.date = date;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws StarException {
        Deadline deadline;
        if (date == null) {
            deadline = new Deadline(description, by);
        } else {
            deadline = new Deadline(description, date);
        }

        tasks.addTask(deadline);
        ui.addSuccessMsg(deadline, tasks.length());
        storage.save(tasks.getTasks());
    }
}
