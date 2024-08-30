package star.exception;

public class StarException extends Exception {
    public StarException(String message) {
        super(message);
    }

    public static StarException emptyTodo() {
        return new StarException("oopsie! a todo's description can't be empty.");
    }

    public static StarException emptyEvent() {
        return new StarException("oopsie! an event's description can't be empty.");
    }

    public static StarException emptyDeadline() {
        return new StarException("oopsie! a deadline's description can't be empty.");
    }

    public static StarException unknownCommand() {
        return new StarException("oopsie! uh oh, but I don't know what that means :(");
    }
}
