public class deleteCommand extends Command {
    private int zeroIndex;

    public deleteCommand(int oneIndex) {
        this.zeroIndex = oneIndex - 1;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws StarException {
        Task deletedTask = tasks.getTask(zeroIndex);
        tasks.deleteTask(zeroIndex);
        ui.deleteSuccessMsg(deletedTask, tasks.length());
        storage.save(tasks.getTasks());
    }
}
