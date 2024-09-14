package star.command;

import star.exception.StarException;
import star.main.Storage;
import star.main.TaskList;
import star.main.Ui;
import star.task.Task;
import star.task.ToDo;

/**
 * Represents a Command to add a new ToDo task to the task list.
 * Inherits from the Command class.
 */
public class AddToDoCommand extends Command {
    private String description;
    private String tag;

    /**
     * Constructs a new addToDoCommand with the new ToDo task description.
     * @param description which is the description of the task to be added.
     */
    public AddToDoCommand(String description) {
        this.description = description;
    }

    /**
     * Constructs a new addToDoCommand with the new ToDo task description and assigned tag.
     * @param description which is the description of the task to be added.
     * @param tag which is the tag assigned to the task.
     */
    public AddToDoCommand(String description, String tag) {
        this.description = description;
        this.tag = tag;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws StarException {
        ToDo todo;
        if (tag == null) {
            todo = new ToDo(description);
        } else {
            System.out.println(tag);
            todo = new ToDo(description, tag);
        }
        tasks.addTask(todo);
        storage.save(tasks.getTasks());
        return ui.addSuccessMsg(todo, tasks.length());
    }
}
