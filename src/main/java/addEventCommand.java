import java.time.LocalDate;

public class addEventCommand extends Command {
    private String description;
    private String by;
    private LocalDate date;

    public addEventCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    public addEventCommand(String description, LocalDate date) {
        this.description = description;
        this.date = date;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws StarException {
        Event event;
        if (date == null) {
            event = new Event(description, by);
        } else {
            event = new Event(description, date);
        }

        tasks.addTask(event);
        ui.addSuccessMsg(event, tasks.length());
        storage.save(tasks.getTasks());

    }
}
