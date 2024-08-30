public class doneCommand extends Command {
    private int zeroIndex;

    public doneCommand(int oneIndex) {
        this.zeroIndex = oneIndex - 1;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {

    }
}
