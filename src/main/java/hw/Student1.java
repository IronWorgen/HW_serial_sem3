package hw;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@AllArgsConstructor
@Data
public class Student1 implements Serializable {
   private  String name;
    private int age;

    transient double gpa;
}
