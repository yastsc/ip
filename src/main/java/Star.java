import java.io.*;
import java.util.Objects;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;

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

        public void run() {
            ui.showHi();
            ui.lineBreak();
            boolean isExit = false;
            while (!isExit) {
                try {
                    String fullCommand = ui.readCommand();
                    ui.lineBreak(); // show the divider line ("_______")
                    Command c = Parser.parse(fullCommand);
                    c.execute(tasks, ui, storage);
                    isExit = c.isExit();
                } catch (StarException e) {
                    ui.showError(e.getMessage());
                } finally {
                    ui.lineBreak();
                }
            }
        }

        public static void main(String[] args) {
            new Star("data/star.txt").run();
        }
    }



//public class Star {
//
//    private static Task[] tasks = new Task[100];
//    private static int len = 0;
//    private static String filePath = "./data/star.txt";
//
//    public Star() {
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
//    public static int Store(int i) throws StarException {
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
//                throw StarException.emptyTodo();
//            } else {
//                lineBreak();
//                tasks[i] = new ToDo(userInput);
//                len++;
//                System.out.println("you have a new task: \n" + tasks[i] + "\n" +
//                        String.format((len == 1) ? "you now have %d task in the list!" : "you now have %d tasks in the list!", len));
//                lineBreak();
//                saveTasks(true);
//            }
//        } else if (userInput.contains("event")) {
//            if (Objects.equals(userInput, "event")) {
//                throw StarException.emptyEvent();
//            } else {
//                lineBreak();
//                tasks[i] = new Event(userInput);
//                len++;
//                System.out.println("you have a new task: \n" + tasks[i] + "\n" +
//                        String.format((len == 1) ? "you now have %d task in the list!" : "you now have %d tasks in the list!", len));
//                lineBreak();
//                saveTasks(true);  // Append new task to file
//            }
//        } else if (userInput.contains("deadline")) {
//            if (Objects.equals(userInput, "deadline")) {
//                throw StarException.emptyDeadline();
//            } else {
//                lineBreak();
//                tasks[i] = new Deadline(userInput);
//                len++;
//                System.out.println("you have a new task: \n" + tasks[i] + "\n" +
//                        String.format((len == 1) ? "you now have %d task in the list!" : "you now have %d tasks in the list!", len));
//                lineBreak();
//                saveTasks(true);  // Append new task to file
//            }
//        } else {
//            throw StarException.unknownCommand();
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
//                    tasks[len] = new ToDo(line);
//                } else if (line.startsWith("E")) {
//                    tasks[len] = new Event(line);
//                } else if (line.startsWith("D")) {
//                    tasks[len] = new Deadline(line);
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
//            } catch (StarException e) {
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