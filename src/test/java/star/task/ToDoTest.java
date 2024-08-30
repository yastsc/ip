package star.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {
    @Test
    public void toDoTest() {
        ToDo task = new ToDo("play game");
        assertEquals("[T][ ] play game", task.toString(), "toString() works!");

        task.markDone();
        assertEquals("[T][X] play game", task.toString(), "markDone() works!");
    }
}
