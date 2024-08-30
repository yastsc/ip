package star.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private String by;
    private LocalDateTime date1;
    private LocalDateTime date2;

    public Event(String description, String by) {
        super(description);
        this.by = by;
    }

    public Event(String description, LocalDateTime date1, LocalDateTime date2) {
        super(description);
        this.date1 = date1;
        this.date2 = date2;
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
            return String.format("E | %d | %s | from %s to %s", isDone ? 1 : 0, description, date1.format(formatter),
                    date2.format(formatter));
        }
        return String.format("E | %d | %s | %s", isDone ? 1 : 0, description, by);
    }

    @Override
    public String toString() {
        if (by == null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy H/h:mm");
            return String.format("[E] %s (from: %s to: %s)", super.toString(), date1.format(formatter),
                    date2.format(formatter));
        }
        return String.format("[E] %s (from: %s to: %s)", super.toString(), by.split("/")[0], by.split("/")[1]);
    }
}
