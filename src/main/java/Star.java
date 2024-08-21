import java.util.Objects;
import java.util.Scanner;

public class Star {

    private static String[] tasks = new String[100];
    private static int len = 0;

    public Star() {
    }

    public static void Hi() {
        String logo =
                          "                                 ,,           \n"
                        + "  ____  _                       ,,,,          \n"
                        + " / ___|| |_ __ _ _ __     ,,,,,,,,,,,,,,,,    \n"
                        + " \\___ \\| __/ _` | '__|     ,,,,,,,,,,,,,,     \n"
                        + "  ___) | || (_| | |          ,,,,,,,,,,       \n"
                        + " |____/ \\__\\__,_|_|          ,,,,,,,,,,       \n"
                        + "                            ,,,      ,,,      ";

        System.out.println(logo + "says hi! what's up?\n");
    }
    public static void lineBreak() {
        System.out.println("____________________________________________________________");

    }
    public static void Bye() {
        System.out.println("bye bye! come by again soon :)\n");
    }

    public static int Echo() {
        Scanner scanner;
        scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        if (!Objects.equals(userInput, "bye")) {
            lineBreak();
            System.out.println(userInput);
            lineBreak();
        } else {
            return 1;
        }
        return 0;
    }

    public static int Store(int i) {
        Scanner scanner;
        scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        if (Objects.equals(userInput, "bye")) {
            return 1;
        } else if (Objects.equals(userInput, "list")) {
            int y = 0;
            for (int x = 0; x < len; x++) {
                if (tasks[x] != null) {
                    System.out.println(String.format("%d. ", x + 1) + tasks[y]);
                    y++;
                } else {
                    System.out.println(String.format("%d. ", x + 1) + tasks[y + 1]);
                    y += 2;
                }
            }
            lineBreak();
        } else {
            lineBreak();
            tasks[i] = userInput;
            len++;
            System.out.println("added: " + userInput);
            lineBreak();
        }
        return 0;
    }

    public static void main(String[] args) {
        int start = 0;
        lineBreak();
        Hi();
        lineBreak();
        int count = 0;
        while (start == 0) {
            start = Store(count);
            count++;
        }
        lineBreak();
        Bye();
        lineBreak();
    }
}
