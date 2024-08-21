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

    public static void main(String[] args) {
        lineBreak();
        Hi();
        lineBreak();
        Bye();
        lineBreak();
    }
}
