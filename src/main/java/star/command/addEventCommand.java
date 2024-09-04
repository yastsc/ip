package star.command;

import star.exception.StarException;
import star.main.Storage;
import star.main.TaskList;
import star.main.Ui;
import star.task.Event;

import java.time.LocalDateTime;

/**
 * Represents a Command to add a new Event task to the task list.
 * Inherits from the Command class.
 */
public class addEventCommand extends Command {
    private String description;
    private String by;
    private LocalDateTime date1;
    private LocalDateTime date2;

    /**
     * Constructs an addEventCommand with the Event task description and event date and time.
     * @param description which is the task description.
     * @param by which is the event date and time in String form.
     */
    public addEventCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    /**
     * Constructs an addEventCommand with the Event task description and event date and time.
     * @param description which is the task description.
     * @param date1 which is the start date and time of the event.
     * @param date2 which is the end date and time of the event.
     */
    public addEventCommand(String description, LocalDateTime date1, LocalDateTime date2) {
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
