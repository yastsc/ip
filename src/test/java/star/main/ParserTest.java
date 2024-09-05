package star.main;

import org.junit.jupiter.api.Test;
import star.command.DoneCommand;
import star.command.ExitCommand;
import star.command.ListCommand;
import star.exception.StarException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {
    @Test
    public void parseTest() throws StarException {
        assertTrue(Parser.parse("bye") instanceof ExitCommand);
        assertTrue(Parser.parse("mark 1") instanceof DoneCommand);
        assertTrue(Parser.parse("list") instanceof ListCommand);
    }
}
