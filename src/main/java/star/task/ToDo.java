package star.task;

public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }
    public ToDo(String description, String tag) {
        super(description, tag);
    }

    @Override
    public String getOutput() {
        return hasTag() ? String.format("T | %d | %s | #%s", isDone ? 1 : 0, description, super.tag)
                : String.format("T | %d | %s", isDone ? 1 : 0, description);
    }

    @Override
    public String toString() {
            return hasTag() ? "[T]" + super.toString() + String.format(" #%s", super.tag)
                    : "[T]" + super.toString();
    }
}
