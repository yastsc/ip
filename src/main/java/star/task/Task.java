package star.task;

/**
 * Represents a general Task.
 * Contains functions like displaying status, and getting output format.
 */
public class Task {

    protected String description;
    protected boolean isDone;

    /**
     * Constructs a general Task with the given description.
     * @param description which is a String that gives a description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Gets status icon corresponding to status of task.
     * @return a String of the icon.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * Marks the task as done.
     */
    public void markDone() {
        this.isDone = true;
//        System.out.println("yay! this task is done: \n" + this);
    }

    /**
     * Marks the task as undone.
     */
    public void markUndone() {
        this.isDone = false;
//        System.out.println("oops it seems that this task isn't done yet: \n" + this);
    }

    /**
     * Gets the name of the task.
     * @return a String of the description input, which is the name of the task.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Gets the output string of task to be saved in computer's hard drive.
     * @return a String of the output.
     */
    public String getOutput() {
        return String.format("X | %d | %s", isDone ? 1 : 0, description);
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "]" + " " + getDescription();
    }
}
