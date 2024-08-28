import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Objects;

public class Deadline extends Task {
    public Deadline(String description) {
        super(description);
    }

    public String getDeadline() {
        String[] strArray = super.getDescription().split("/", 2);
        String[] startArr = strArray[1].split(" ");
        DateTimeFormatter formatterDate = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("d/M/yyyy").toFormatter();
        DateTimeFormatter formatterTime = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("HHmm")
                .toFormatter();
        String endDate = (startArr.length > 1) ? startArr[1] : "";
        String endTime = (startArr.length > 1) ? startArr[2] : "";
        LocalDate d1 = null;
        LocalTime t1 = null;
        if (!Objects.equals(endDate, "")) {
            d1 = LocalDate.parse(endDate, formatterDate);
        }
        if (!Objects.equals(endTime, "")) {
            t1 = LocalTime.parse(endTime, formatterTime);
        }
        return "(by: " + ((d1 != null) ? d1.format(DateTimeFormatter.ofPattern("MMM d yyyy")) : "") + " " +
                ((t1 != null) ? t1.format(DateTimeFormatter.ofPattern("hh:mm a")) : "") + ")";
    }

    public String getTask() {
        String[] strArray = super.getDescription().split("/");
        String[] startArr = strArray[0].split(" ", 2);
        return startArr[1];
    }

    @Override
    public String toString() {
            return "[D]" + "[" + super.getStatusIcon() + "] " + getTask() + getDeadline();
    }
}
