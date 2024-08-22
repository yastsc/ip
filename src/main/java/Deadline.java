public class Deadline extends Task {
    public Deadline(String description) {
        super(description);
    }

    public String getDeadline() {
        String[] strArray = super.getDescription().split("/");
        String[] startArr = strArray[1].split(" ", 2);
        String startRes = (startArr.length > 1) ? startArr[1] : "";
        return "(by: "  + startRes + ")";
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
