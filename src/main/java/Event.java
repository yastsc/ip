import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Objects;

public class Event extends Task {
    public Event(String description) {
        super(description);
    }

    public String getDateTime() {
        String[] strArray = super.getDescription().split("/");
        String[] startArr = strArray[1].split(" ", 2);
        String startRes = (startArr.length > 1) ? startArr[1] : "";
        String[] endArr = (strArray.length > 2) ? strArray[2].split(" ", 2) : null;
        String endRes = ((endArr != null)) ? (endArr.length > 2) ? endArr[1] : "" : "";
        LocalDate d1 = null;
        DateTimeFormatter formatterDate = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("yyyy-MM-dd").toFormatter();
        if (startRes.contains("-")) {
            d1 = LocalDate.parse(startRes, formatterDate);
        }
        return "(from: "  + ((d1 != null) ? d1.format(DateTimeFormatter.ofPattern("MMM d yyyy")) : startRes) +
                ((!Objects.equals(endRes, "")) ? " to: " + endRes + ")" : ")");
    }

    public String getTask() {
        String[] strArray = super.getDescription().split("/");
        String[] startArr = strArray[0].split(" ", 2);
        return startArr[1];
    }

    public String toString() {
            return "[E]" + "[" + super.getStatusIcon() + "] " + getTask() + getDateTime();
    }
}
