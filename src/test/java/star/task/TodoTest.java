package star.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    @Test
    public void toDoTest() {
        Todo task = new Todo("play game");
        assertEquals("[T][ ] play game", task.toString(), "toString() works!");

        task.markDone();
        assertEquals("[T][X] play game", task.toString(), "markDone() works!");
    }
}
