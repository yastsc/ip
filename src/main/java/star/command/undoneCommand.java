package star.command;

import star.exception.StarException;
import star.main.Storage;
import star.main.TaskList;
import star.main.Ui;

public class undoneCommand extends Command {
    private int zeroIndex;

    public undoneCommand(int oneIndex) {
        this.zeroIndex = oneIndex - 1;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws StarException {
        tasks.markUndone(zeroIndex);
        ui.undoneMsg(tasks.getTask(zeroIndex));
        storage.save(tasks.getTasks());
    }
}
