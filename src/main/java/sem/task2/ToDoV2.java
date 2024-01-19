package sem.task2;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

@Data
@NoArgsConstructor
public class ToDoV2 implements Externalizable {
    /**
     * название задачи
     */
    private String title;
    /**
     * статус выполнения задачи
     */
    private boolean isDone;

    public ToDoV2(String title) {
        this.title = title;
        isDone = false;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(title);
        out.writeBoolean(isDone);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        title = (String)in.readObject();
        isDone  = in.readBoolean();
    }
}
