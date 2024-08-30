package star.main;

import star.exception.StarException;
import star.task.Deadline;
import star.task.Event;
import star.task.Task;
import star.task.ToDo;

import java.io.*;
import java.util.ArrayList;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Task> load() throws StarException {
        ArrayList<Task> tasks = new ArrayList<>();

        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return tasks;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String input;
            while ((input = reader.readLine()) != null) {
                String[] inputs = input.split(" \\| ");

                Task task;
                switch (inputs[0]) {
                case "T":
                    task = new ToDo(inputs[2]);
                    break;
                case "D":
                    task = new Deadline(inputs[2], inputs[3]);
                    break;
                case "E":
                    task = new Event(inputs[2], inputs[3]);
                    break;
                default:
                    throw new StarException("uh oh! there was an error during parsing: an unexpected task" +
                            "type was found.");
                }

                if (Integer.parseInt(inputs[1]) == 1) {
                    task.markDone();
                }
                tasks.add(task);
            }

        } catch (FileNotFoundException e) {
            throw new StarException("uh oh! the file of tasks couldn't be found :(");
        } catch (IOException e) {
            throw new StarException("uh oh! an IO exception occurred :(");
        }
        return tasks;
    }

    public void save(ArrayList<Task> taskList) throws StarException {

        File fileDir = new File("./data");
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (Task task : taskList) {
                    writer.write(task.getOutput() + System.lineSeparator());
                }
            } catch (IOException e) {
                System.out.println("something went wrong while saving :0 " + e.getMessage());
            }
    }
}
