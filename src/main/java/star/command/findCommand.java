package star.command;

import star.main.Storage;
import star.main.TaskList;
import star.main.Ui;

public class findCommand extends Command {
    private String keyword;

    public findCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printList(tasks.findTasks(this.keyword), "these tasks match what you were looking for!");
    }
}
