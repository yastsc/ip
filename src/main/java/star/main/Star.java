package star.main;

import javafx.application.Platform;
import star.command.*;
import star.exception.StarException;


public class Star {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Star(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (StarException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    public String getResponse(String input) {
        boolean isExit = false;
        while (!isExit) {
            try {
//                System.out.println(ui.lineBreak()); // show the divider line ("_______")
                Command c = Parser.parse(input);
                System.out.println("hello");
                String output = c.execute(tasks, ui, storage);
                isExit = c.isExit();
                return output;
            } catch (StarException e) {
                return e.getMessage();
            } finally {
//                ui.lineBreak();
            }
        }
        return "";
    }
}

//        public void run() {
//            ui.showHi();
//            ui.lineBreak();
//            boolean isExit = false;
//            while (!isExit) {
//                try {
//                    String fullCommand = ui.readCommand();
//                    ui.lineBreak(); // show the divider line ("_______")
//                    Command c = Parser.parse(fullCommand);
//                    c.execute(tasks, ui, storage);
//                    isExit = c.isExit();
//                } catch (StarException e) {
//                    ui.showError(e.getMessage());
//                } finally {
//                    ui.lineBreak();
//                }
//            }
//        }

//        public static void main(String[] args) {
//            new Star("data/star.txt").run();
//        }



//public class star.main.Star {
//
//    private static star.task.Task[] tasks = new star.task.Task[100];
//    private static int len = 0;
//    private static String filePath = "./data/star.txt";
//
//    public star.main.Star() {
//    }
//
//    public static void Hi() {
//        String logo =
//                          "                                 ,,           \n"
//                        + "  ____  _                       ,,,,          \n"
//                        + " / ___|| |_ __ _ _ __     ,,,,,,,,,,,,,,,,    \n"
//                        + " \\___ \\| __/ _` | '__|     ,,,,,,,,,,,,,,     \n"
//                        + "  ___) | || (_| | |          ,,,,,,,,,,       \n"
//                        + " |____/ \\__\\__,_|_|          ,,,,,,,,,,       \n"
//                        + "                            ,,,      ,,,      ";
//
//        System.out.println(logo + "says hi! what's up?\n");
//    }
//    public static void lineBreak() {
//        System.out.println("____________________________________________________________");
//
//    }
//    public static void Bye() {
//        System.out.println("bye bye! come by again soon :)\n");
//    }
//
//    public static int Echo() {
//        Scanner scanner;
//        scanner = new Scanner(System.in);
//        String userInput = scanner.nextLine();
//        if (!Objects.equals(userInput, "bye")) {
//            lineBreak();
//            System.out.println(userInput);
//            lineBreak();
//        } else {
//            return 1;
//        }
//        return 0;
//    }
//
//    public static int Store(int i) throws star.exception.StarException {
//        Scanner scanner;
//        scanner = new Scanner(System.in);
//        String userInput = scanner.nextLine();
//        String[] strArray = userInput.split(" ");
//        if (Objects.equals(userInput, "bye")) {
//            return 1;
//        } else if (Objects.equals(userInput, "list")) {
//            for (int x = 0; x < len; x++) {
//                if (tasks[x] != null) {
//                    System.out.println(String.format("%d. ", x + 1) + tasks[x]);
//                } else {
//                    int y = 0;
//                    while (tasks[x + y] == null) {
//                        y++;
//                    }
//                    tasks[x] = tasks[x + y];
//                    tasks[x + y] = null;
//                    System.out.println(String.format("%d. ", x + 1) + tasks[x]);
//                }
//            }
//            lineBreak();
//        } else if (Objects.equals(strArray[0], "delete")) {
//            int tasknum = Integer.parseInt(strArray[1]);
//            len--;
//            System.out.println("okay! this task has been removed: \n" + tasks[tasknum - 1] + "\n" +
//                    String.format((len == 1) ? "now you have %d task left!" : "now you have %d tasks left!", len));
//            tasks[tasknum - 1] = null;
//            lineBreak();
//            saveTasks(false);
//        } else if (Objects.equals(strArray[0], "mark")) {
//            int tasknum = Integer.parseInt(strArray[1]);
//            tasks[tasknum - 1].markDone();
//            lineBreak();
//            saveTasks(false);
//        } else if (Objects.equals(strArray[0], "unmark")) {
//            int tasknum = Integer.parseInt(strArray[1]);
//            tasks[tasknum - 1].markUndone();
//            lineBreak();
//            saveTasks(false);
//        } else if (userInput.contains("todo")) {
//            if (Objects.equals(userInput, "todo")) {
//                throw star.exception.StarException.emptyTodo();
//            } else {
//                lineBreak();
//                tasks[i] = new star.task.ToDo(userInput);
//                len++;
//                System.out.println("you have a new task: \n" + tasks[i] + "\n" +
//                        String.format((len == 1) ? "you now have %d task in the list!" : "you now have %d tasks in the list!", len));
//                lineBreak();
//                saveTasks(true);
//            }
//        } else if (userInput.contains("event")) {
//            if (Objects.equals(userInput, "event")) {
//                throw star.exception.StarException.emptyEvent();
//            } else {
//                lineBreak();
//                tasks[i] = new star.task.Event(userInput);
//                len++;
//                System.out.println("you have a new task: \n" + tasks[i] + "\n" +
//                        String.format((len == 1) ? "you now have %d task in the list!" : "you now have %d tasks in the list!", len));
//                lineBreak();
//                saveTasks(true);  // Append new task to file
//            }
//        } else if (userInput.contains("deadline")) {
//            if (Objects.equals(userInput, "deadline")) {
//                throw star.exception.StarException.emptyDeadline();
//            } else {
//                lineBreak();
//                tasks[i] = new star.task.Deadline(userInput);
//                len++;
//                System.out.println("you have a new task: \n" + tasks[i] + "\n" +
//                        String.format((len == 1) ? "you now have %d task in the list!" : "you now have %d tasks in the list!", len));
//                lineBreak();
//                saveTasks(true);  // Append new task to file
//            }
//        } else {
//            throw star.exception.StarException.unknownCommand();
//        }
//        return 0;
//    }
//
//
//    private static void saveTasks(boolean append) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, append))) {
//            if (!append) {
//                for (int i = 0; i < len; i++) {
//                    if (tasks[i] != null) {
//                        writer.write(tasks[i].toString());
//                        writer.newLine();
//                    }
//                }
//            } else {
//                if (tasks[len - 1] != null) {
//                    writer.write(tasks[len - 1].toString());
//                    writer.newLine();
//                }
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private static void loadTasks() {
//        try (BufferedReader reader = new BufferedReader(new FileReader("./data/star.txt"))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                if (line.startsWith("T")) {
//                    tasks[len] = new star.task.ToDo(line);
//                } else if (line.startsWith("E")) {
//                    tasks[len] = new star.task.Event(line);
//                } else if (line.startsWith("D")) {
//                    tasks[len] = new star.task.Deadline(line);
//                }
//                len++;
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    // achieve this

//    public static void main(String[] args) {
//        lineBreak();
//        Hi();
//        lineBreak();
//        loadTasks();
//        int start = 0;
//        int count = len;
//        while (start == 0) {
//            try {
//                start = Store(count);
//                count++;
//            } catch (star.exception.StarException e) {
//                lineBreak();
//                System.out.println(e.getMessage());
//                lineBreak();
//            }
//        }
//        lineBreak();
//        Bye();
//        lineBreak();
//    }
//}