package star.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private String by;
    private LocalDateTime[] dates;

    public Event(String description, String by) {
        super(description);
        this.by = by;
    }

    public Event(String description, LocalDateTime... dates) {
        super(description);
        this.dates = dates;
    }

//    public String getDateTime() {
//        String[] strArray = super.getDescription().split("/");
//        String[] startArr = strArray[1].split(" ", 2);
//        String startRes = (startArr.length > 1) ? startArr[1] : "";
//        String[] endArr = (strArray.length > 2) ? strArray[2].split(" ", 2) : null;
//        String endRes = ((endArr != null)) ? (endArr.length > 2) ? endArr[1] : "" : "";
//        LocalDate d1 = null;
//        DateTimeFormatter formatterDate = new DateTimeFormatterBuilder()
//                .parseCaseInsensitive()
//                .appendPattern("yyyy-MM-dd").toFormatter();
//        if (startRes.contains("-")) {
//            d1 = LocalDate.parse(startRes, formatterDate);
//        }
//        return "(from: "  + ((d1 != null) ? d1.format(DateTimeFormatter.ofPattern("MMM d yyyy")) : startRes) +
//                ((!Objects.equals(endRes, "")) ? " to: " + endRes + ")" : ")");
//    }
//
//    public String getTask() {
//        String[] strArray = super.getDescription().split("/");
//        String[] startArr = strArray[0].split(" ", 2);
//        return startArr[1];
//    }

    @Override
    public String getOutput() {
        if (by == null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy HH:mm");
            if (dates.length == 2) {
                return String.format("E | %d | %s | from %s to %s", isDone ? 1 : 0,
                        description, dates[0].format(formatter), dates[1].format(formatter));
            } else if (dates.length == 1) {
                return String.format("E | %d | %s | at %s", isDone ? 1 : 0,
                        description, dates[0].format(formatter));
            } else {
                return String.format("E | %d | %s | no dates provided", isDone ? 1 : 0, description);
            }
        }
        return String.format("E | %d | %s | %s", isDone ? 1 : 0, description, by);
    }

    @Override
    public String toString() {
        if (by == null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy H/h:mm");
            if (dates.length == 2) {
                return String.format("[E] %s (from: %s to: %s)", super.toString(),
                        dates[0].format(formatter), dates[1].format(formatter));
            } else if (dates.length == 1) {
                return String.format("[E] %s (at: %s)", super.toString(), dates[0].format(formatter));
            } else {
                return String.format("[E] %s (no dates provided)", super.toString());
            }
        }
        return String.format("[E] %s (by: %s)", super.toString(), by);
    }
}
