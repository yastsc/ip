package star.main;

import star.exception.StarException;
import star.command.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Parser {

    static Command parse(String fullCommand) throws StarException {
        if (isExit(fullCommand)) {
            return new ExitCommand();
        }
        if (isDone(fullCommand)) {
            String[] newInput = fullCommand.split(" ");
            return new DoneCommand(Integer.parseInt(newInput[1]));
        }
        if (isUndone(fullCommand)) {
            String[] newInput = fullCommand.split(" ");
            return new UndoneCommand(Integer.parseInt(newInput[1]));
        }
        if (isFind(fullCommand)) {
            String[] newInput = fullCommand.split(" ");
            return new FindCommand(newInput[1]);
        }
        if (isList(fullCommand)) {
            return new ListCommand();
        }
        if (isDelete(fullCommand)) {
            String[] newInput = fullCommand.split(" ");
            return new DeleteCommand(Integer.parseInt(newInput[1]));
        }
        if (isTodo(fullCommand)) {
            String[] newInput = fullCommand.split(" ");
            return new AddToDoCommand(newInput[1]);
        }
        if (isDeadline(fullCommand)) {
            String[] newInput = validateDeadline(fullCommand);
            if (isDate(newInput[1])) {
                LocalDateTime date = parseDate(newInput[1]);
                return new AddDeadlineCommand(newInput[0], date);
            }
            return new AddDeadlineCommand(newInput[0], newInput[1]);
        }
        if (isEvent(fullCommand)) {
            String[] newInput = validateEvent(fullCommand);
            if (isDate(newInput[1]) && isDate(newInput[2])) {
                LocalDateTime date1 = parseDate(newInput[1]);
                LocalDateTime date2 = parseDate(newInput[2]);
                return new AddEventCommand(newInput[0], date1, date2);
            }
            return new AddEventCommand(newInput[0], newInput[1]);
        }
        else {
            throw StarException.unknownCommand();
        }
    }

    private static boolean isUndone(String input) {
        return input.startsWith("unmark");
    }

    private static boolean isDone(String input) {
        return input.startsWith("mark");
    }

    private static boolean isDelete(String input) {
        return input.startsWith("delete");
    }

    private static boolean isFind(String input) {
        return input.startsWith("find");
    }

    private static boolean isTodo(String input) {
        return input.startsWith("todo");
    }

    private static boolean isEvent(String input) {
        return input.startsWith("event");
    }

    private static boolean isDeadline(String input) {
        return input.startsWith("deadline");
    }

    private static boolean isExit(String input) {
        return Objects.equals(input, "bye");
    }

    private static boolean isList(String input) {
        return Objects.equals(input, "list");
    }

    public static boolean isDate(String input) {
        String[] splitInput = input.split("-");
        if (splitInput.length != 3 || isNotNumber(splitInput[0]) || isNotNumber(splitInput[1])) {
            return false;
        }
        return true;
    }

    public static LocalDateTime parseDate(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HHmm");
        return LocalDateTime.parse(input, formatter);

    }

    private static boolean isNotNumber(String input) {
        return !input.matches("[-+]?\\d*\\.?\\d+");
    }

    private static void validateTodo(String input) throws StarException {
        if (input.isEmpty()) {
            throw StarException.emptyTodo();
        }
    }

    private static String[] validateEventDeadline(String input, String replaceText, String splitText, String type) throws StarException {
        String[] splitInput = input.replaceFirst(replaceText, "").trim().split(splitText);

        for (int i = 0; i < splitInput.length; i++) {
            splitInput[i] = splitInput[i].trim();
        }

        if (splitInput.length < 2 || splitInput[0].isBlank() || splitInput[1].isBlank()) {
            if (type.equals("E")) {
                throw StarException.emptyEvent();
            } else {
                throw StarException.emptyDeadline();
            }
        }
        return splitInput;
    }

    private static String[] validateEvent(String input) throws StarException {
        String[] strArr = validateEventDeadline(input, "event", "/", "E");
        strArr[1] = strArr[1].replace("from ", ""); // 12/05/2020 0300 /to 31/05/2020 0600
        strArr[2] = strArr[2].replace("to ", "");
        return strArr;
    }

    private static String[] validateDeadline(String input) throws StarException {
        return validateEventDeadline(input, "deadline", "/by", "D");
    }




}
