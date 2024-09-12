package star.main;

import javafx.application.Platform;
import star.command.*;
import star.exception.StarException;


public class Star {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private boolean isExit = false;

    public Star(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (StarException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    public String getResponse(String input) {
        if (isExit) {
            return "";
        }
        try {
            Command c = Parser.parse(input);
            System.out.println("hello");
            String output = c.execute(tasks, ui, storage);
            isExit = c.isExit();
            return output;
        } catch (StarException e) {
            return e.getMessage();
        }
    }
}
