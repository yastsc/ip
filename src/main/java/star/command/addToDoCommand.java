package star.command;

import star.exception.StarException;
import star.main.Storage;
import star.main.TaskList;
import star.main.Ui;
import star.task.ToDo;

public class addToDoCommand extends Command {
    private String description;

    public addToDoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws StarException {
        ToDo todo = new ToDo(description);
        tasks.addTask(todo);
        ui.addSuccessMsg(todo, tasks.length());
        storage.save(tasks.getTasks());
    }
}
