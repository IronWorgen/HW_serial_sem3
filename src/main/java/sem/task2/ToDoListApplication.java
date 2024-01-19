package sem.task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoListApplication {

    public static final String FILE_JSON = "tasks.json";
    public static final String FILE_BIN = "tasks.bin";
    public static final String FILE_XML = "tasks.xml";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public static void addNewTask(Scanner scanner, List<ToDoV2> tasks) {
        System.out.println("введите задачу");
        String newTaskTitle = scanner.nextLine();
        tasks.add(new ToDoV2(newTaskTitle));
        saveTaskToFile(FILE_JSON, tasks);
        saveTaskToFile(FILE_BIN, tasks);
        saveTaskToFile(FILE_XML, tasks);
        System.out.println("задача добавлена");
    }

    public static void markTaskAsDone(Scanner scanner, List<ToDoV2> tasks) {
        System.out.println("введите номер задачи для отметки как выполненая");
        String input = scanner.nextLine();

        try {
            int taskNumber = Integer.parseInt(input);
            if (taskNumber >= 0 && taskNumber < tasks.size()) {
                tasks.get(taskNumber).setDone(true);
                saveTaskToFile(FILE_JSON, tasks);
                saveTaskToFile(FILE_BIN, tasks);
                saveTaskToFile(FILE_XML, tasks);
            } else {
                System.out.println("Некорректный номер задачи");
            }


        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<ToDoV2> loadTasksFromFile(String filename) {
        List<ToDoV2> list = new ArrayList<>();
        File file = new File(filename);
        if (file.exists()) {
            try {
                if (filename.endsWith(".json")) {
                    list = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, ToDoV2.class));
                } else if (filename.endsWith(".bin")) {
                    try (ObjectInputStream objectOutputStream = new ObjectInputStream(new FileInputStream(file))) {
                        list = (List<ToDoV2>) objectOutputStream.readObject();
                    }
                } else if (filename.endsWith(".xml")) {

                    list = xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructCollectionType(List.class, ToDoV2.class));
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return list;
    }


    public static void saveTaskToFile(String fileName, List<ToDoV2> tasks) {
        try {
            if (fileName.endsWith(".json")) {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileName), tasks);
            } else if (fileName.endsWith(".json")) {
                try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_BIN))) {
                    objectOutputStream.writeObject(tasks);
                }
            } else if (fileName.endsWith(".xml")) {
                xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                xmlMapper.writeValue(new File(fileName), tasks);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printTasks(List<ToDoV2> tasks) {
        System.out.println("Список задач:");
        for (int i = 0; i < tasks.size(); i++) {
            ToDoV2 toDoV2 = tasks.get(i);
            String status = toDoV2.isDone() ? "[x]" : "[ ]";
            System.out.println((i + 1) + ". " + status + " " + toDoV2.getTitle());
        }
    }


}
