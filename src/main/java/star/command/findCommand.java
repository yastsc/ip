package star.command;

import star.main.Storage;
import star.main.TaskList;
import star.main.Ui;

/**
 * Represents the Command to find tasks in the task list that contain a specific keyword.
 * Inherits from the Command class.
 */
public class findCommand extends Command {
    private String keyword;

    /**
     * Constructs a findCommand that finds tasks containing the given String keyword.
     * @param keyword which is the given String that is used to find tasks containing that keyword.
     */
    public findCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        return ui.printList(tasks.findTasks(this.keyword), "these tasks match what you were looking for!");
    }
}
