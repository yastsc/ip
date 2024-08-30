public class undoneCommand extends Command {
    private int zeroIndex;

    public undoneCommand(int oneIndex) {
        this.zeroIndex = oneIndex - 1;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {

    }
}
