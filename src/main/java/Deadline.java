import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Objects;

public class Deadline extends Task {
    private String by;
    private LocalDate date;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }
    public Deadline(String description, LocalDate date) {
        super(description);
        this.date = date;
    }

//    public String getDeadline() {
//        String[] strArray = super.getDescription().split("/", 2);
//        String[] startArr = strArray[1].split(" ");
//        DateTimeFormatter formatterDate = new DateTimeFormatterBuilder()
//                .parseCaseInsensitive()
//                .appendPattern("d/M/yyyy").toFormatter();
//        DateTimeFormatter formatterTime = new DateTimeFormatterBuilder()
//                .parseCaseInsensitive()
//                .appendPattern("HHmm")
//                .toFormatter();
//        String endDate = (startArr.length > 1) ? startArr[1] : "";
//        String endTime = (startArr.length > 1) ? startArr[2] : "";
//        LocalDate d1 = null;
//        LocalTime t1 = null;
//        if (!Objects.equals(endDate, "")) {
//            d1 = LocalDate.parse(endDate, formatterDate);
//        }
//        if (!Objects.equals(endTime, "")) {
//            t1 = LocalTime.parse(endTime, formatterTime);
//        }
//        return "(by: " + ((d1 != null) ? d1.format(DateTimeFormatter.ofPattern("MMM d yyyy")) : "") + " " +
//                ((t1 != null) ? t1.format(DateTimeFormatter.ofPattern("hh:mm a")) : "") + ")";
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
            SimpleDateFormat formatter = new SimpleDateFormat("MMM d yyyy");
            return String.format("D | %d | %s | %s", isDone ? 1 : 0, description, formatter.format(date));
        }
        return String.format("D | %d | %s | %s", isDone ? 1 : 0, description, by);
    }

    @Override
    public String toString() {
        if (by == null) {
            SimpleDateFormat formatter = new SimpleDateFormat("MMM d yyyy");
            return String.format("[D] %s (by: %s)", super.toString(), formatter.format(date));
        }
        return String.format("[D] %s (by: %s)", super.toString(), by);
    }
}
