package hw.task2;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Student student = new Student("JsonFile", 20, 5.0);
        ObjectMapper objectMapper = new ObjectMapper();


        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.writeValue(new File("Student.json"), student);

        Student student1 = objectMapper.readValue(new File("Student.json"), objectMapper.getTypeFactory().constructType(Student.class));
        System.out.println(student1.getName()+",  "+student1.getAge()+ ", "+student1.getGpa());

        System.out.println("================================");
        student.setName("xmlFile");
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        xmlMapper.writeValue(new File("Student.xml"), student);

        student1 = xmlMapper.readValue(new File("Student.xml"), xmlMapper.constructType(Student.class));
        System.out.println(student1.getName()+",  "+student1.getAge()+ ", "+student1.getGpa());

    }

}
