import java.util.Objects;
import java.util.Scanner;

public class Star {

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

    public static void main(String[] args) {
        int start = 0;
        lineBreak();
        Hi();
        lineBreak();
        while (start == 0) {
            start = Echo();
        }
        lineBreak();
        Bye();
        lineBreak();
    }
}
