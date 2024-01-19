package sem.task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static sem.task2.ToDoListApplication.*;

public class Program {
    public static void main(String[] args) {
        List<ToDoV2> tasks;
        File file = new File(FILE_JSON);
        if (file.exists()&&!file.isDirectory()){
            tasks =  loadTasksFromFile(file.getName());
        }
        else {
            tasks = prepareTasks();
            saveTaskToFile( FILE_JSON, tasks);
            saveTaskToFile( FILE_BIN, tasks);
            saveTaskToFile( FILE_XML, tasks);

        }
        printTasks(tasks);

        Scanner scanner = new Scanner(System.in);


    }
    static List<ToDoV2>  prepareTasks(){
        List<ToDoV2> list = new ArrayList<>();
        list.add(new ToDoV2("купить воду"));
        list.add(new ToDoV2("сходить в кино"));
        list.add(new ToDoV2("помыть пол"));

        return list;
    }
}
