package star.command;

import star.main.Storage;
import star.main.TaskList;
import star.main.Ui;

/**
 * Represents a Command to print the current task list.
 * Inherits from the Command class.
 */
public class ListCommand extends Command {

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {

        return ui.printList(tasks.getTasks(), "here's everything in your list! \n");
    }
}
