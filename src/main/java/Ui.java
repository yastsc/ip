import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private final Scanner scanner;
    private final PrintStream out;

    public Ui() {
        scanner = new Scanner(System.in);
        out = new PrintStream(System.out);
    }

    public void showHi() {
        String logo =
                "                                 ,,           \n"
                        + "  ____  _                       ,,,,          \n"
                        + " / ___|| |_ __ _ _ __     ,,,,,,,,,,,,,,,,    \n"
                        + " \\___ \\| __/ _` | '__|     ,,,,,,,,,,,,,,     \n"
                        + "  ___) | || (_| | |          ,,,,,,,,,,       \n"
                        + " |____/ \\__\\__,_|_|          ,,,,,,,,,,       \n"
                        + "                            ,,,      ,,,      ";

        out.println(logo + "says hi! what's up?\n");
    }

    public void lineBreak() {
        out.println("____________________________________________________________");

    }

    public void showBye() {
        out.println("bye bye! come by again soon :)\n");
    }

    public void addSuccessMsg(Task task, int size) {
        out.println("you have a new task: \n" + task + "\n" +
                String.format((size == 1) ? "you now have %d task in the list!"
                                            : "you now have %d tasks in the list!", size));

    }

    public void deleteSuccessMsg(Task task, int size) {
        out.println("okay! this task has been removed: \n" + task + "\n" +
                String.format((size == 1) ? "now you have %d task left!"
                                            : "now you have %d tasks left!", size));

    }

    public void doneMsg(Task task) {
        out.println("yay! this task is done: \n" + task);
    }

    public void undoneMsg(Task task) {
        out.println("oops it seems that this task isn't done yet: \n" + task);
    }

    public void printList(ArrayList<Task> tasks, String message) {
        out.println(message);
        for (int i = 0; i < tasks.size(); i++) {
            int oneIndex = i + 1;
            String output = String.format("%d. %s", oneIndex, tasks.get(i));
            out.println(output);
        }
    }

    public void showLoadingError() {
        out.println("oh no! something's not loading right :(");
    }

    public void showError(String e) {
        out.println(e);
    }

    public String readCommand() {
        return scanner.nextLine();
    }
}
