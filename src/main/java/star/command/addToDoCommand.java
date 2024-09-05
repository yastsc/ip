package star.command;

import star.exception.StarException;
import star.main.Storage;
import star.main.TaskList;
import star.main.Ui;
import star.task.ToDo;

/**
 * Represents a Command to add a new ToDo task to the task list.
 * Inherits from the Command class.
 */
public class addToDoCommand extends Command {
    private String description;

    /**
     * Constructs a new addToDoCommand with the new ToDo task description.
     * @param description which is the description of the task to be added.
     */
    public addToDoCommand(String description) {
        this.description = description;
    }

    @Override
    public StringBuilder execute(TaskList tasks, Ui ui, Storage storage) throws StarException {
        ToDo todo = new ToDo(description);
        tasks.addTask(todo);
        storage.save(tasks.getTasks());
        return ui.addSuccessMsg(todo, tasks.length());
    }
}
