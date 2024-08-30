import java.time.LocalDate;

public class addEventCommand extends Command {
    private String description;
    private String by;
    private LocalDate date1;
    private LocalDate date2;

    public addEventCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    public addEventCommand(String description, LocalDate date1, LocalDate date2) {
        this.description = description;
        this.date1 = date1;
        this.date2 = date2;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws StarException {
        Event event;
        if (date1 == null || date2 == null) {
            event = new Event(description, by);
        } else {
            event = new Event(description, date1, date2);
        }

        tasks.addTask(event);
        ui.addSuccessMsg(event, tasks.length());
        storage.save(tasks.getTasks());

    }
}
