package star.main;

import star.task.Task;

import java.util.ArrayList;

public class Ui {

    public Ui() { }

    public String showHi() {
        String logo =
                "                                 ,,           \n"
                        + "  ____  _                       ,,,,          \n"
                        + " / ___|| |_ __ _ _ __     ,,,,,,,,,,,,,,,,    \n"
                        + " \\___ \\| __/ _` | '__|     ,,,,,,,,,,,,,,     \n"
                        + "  ___) | || (_| | |          ,,,,,,,,,,       \n"
                        + " |____/ \\__\\__,_|_|          ,,,,,,,,,,       \n"
                        + "                            ,,,      ,,,      ";

        return logo + "says hi! what's up?\n";
    }

    public String lineBreak() {
        return "____________________________________________________________";

    }

    public String showBye() {
        return "bye bye! come by again soon :)\n";
    }

    public String addSuccessMsg(Task task, int size) {
        return "you have a new task: \n" + task + "\n" +
                String.format((size == 1) ? "you now have %d task in the list!"
                                            : "you now have %d tasks in the list!", size);

    }

    public String deleteSuccessMsg(Task task, int size) {
        return "okay! this task has been removed: \n" + task + "\n" +
                String.format((size == 1) ? "now you have %d task left!"
                                            : "now you have %d tasks left!", size);

    }

    public String doneMsg(Task task) {
        return "yay! this task is done: \n" + task;
    }

    public String undoneMsg(Task task) {
        return "oops it seems that this task isn't done yet: \n" + task;
    }

    public StringBuilder printList(ArrayList<Task> tasks, String message) {
        StringBuilder output = new StringBuilder(message);
        for (int i = 0; i < tasks.size(); i++) {
            int oneIndex = i + 1;
            output.append(String.format("%d. %s", oneIndex, tasks.get(i))+ "\n");
        }
        return output;
    }

    public String showLoadingError() {
        return "oh no! something's not loading right :(";
    }

    public String showError(String e) {
        return e;
    }
}
