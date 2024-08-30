package star.command;

import star.main.Storage;
import star.main.TaskList;
import star.main.Ui;

public class listCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printList(tasks.getTasks(), "here's everything in your list!");
    }
}
