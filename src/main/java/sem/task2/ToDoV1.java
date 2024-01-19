package sem.task2;

import lombok.Data;

import java.io.Serializable;

@Data
public class ToDoV1 implements Serializable {
    /**
     * название задачи
     */
    private String title;
    /**
     * статус выполнения задачи
     */
    private boolean isDone;

    public ToDoV1(String title) {
        this.title = title;
        isDone = false;
    }
}
