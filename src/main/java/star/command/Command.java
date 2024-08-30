package star.command;

import star.exception.StarException;
import star.main.Storage;
import star.main.TaskList;
import star.main.Ui;

public class Command {

    public void execute(TaskList tasks, Ui ui, Storage storage) throws StarException { }

    public boolean isExit() {
        return false;
    }
}
