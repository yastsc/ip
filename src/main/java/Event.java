public class Event extends Task {
    public Event(String description) {
        super(description);
    }

    public String getDateTime() {
        String[] strArray = super.getDescription().split("/");
        String[] startArr = strArray[1].split(" ", 2);
        String startRes = (startArr.length > 1) ? startArr[1] : "";
        String[] endArr = strArray[2].split(" ", 2);
        String endRes = (endArr.length > 1) ? endArr[1] : "";
        return "(from: "  + startRes + "to: " + endRes + ")";
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
