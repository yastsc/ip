public class listCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.printList(tasks.getTasks(), "here's everything in your list!");
    }
}
