package star.command;

import star.main.Storage;
import star.main.TaskList;
import star.main.Ui;

/**
 * Represents a Command to print the current task list.
 * Inherits from the Command class.
 */
public class listCommand extends Command {

    @Override
    public StringBuilder execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printList(tasks.getTasks(), "here's everything in your list!");
        return null;
    }
}
