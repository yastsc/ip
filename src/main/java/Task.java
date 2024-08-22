public class Task {

    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void markDone() {
        this.isDone = true;
        System.out.println("yay! this task is done: \n" + this);
    }

    public void markUndone() {
        this.isDone = false;
        System.out.println("oops it seems that this task isn't done yet: \n" + this);
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "]" + " " + getDescription();
    }
}
