package hw.task2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.Transient;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Externalizable {
    private String name;
    private int age;
    @JsonIgnore
    private double gpa;
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    name =(String) in.readObject();
    age = in.readInt();
    }
}
