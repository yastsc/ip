package star.main;

import org.junit.jupiter.api.Test;
import star.command.doneCommand;
import star.command.exitCommand;
import star.command.listCommand;
import star.exception.StarException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {
    @Test
    public void parseTest() throws StarException {
        assertTrue(Parser.parse("bye") instanceof exitCommand);
        assertTrue(Parser.parse("mark 1") instanceof doneCommand);
        assertTrue(Parser.parse("list") instanceof listCommand);
    }
}
