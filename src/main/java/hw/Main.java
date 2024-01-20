package hw;

import java.io.*;

/**
 * Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
 * Обеспечьте поддержку сериализации для этого класса.
 * Создайте объект класса Student и инициализируйте его данными.
 * Сериализуйте этот объект в файл.
 * Десериализуйте объект обратно в программу из файла.
 * Выведите все поля объекта, включая GPA, и ответьте на вопрос,
 * почему значение GPA не было сохранено/восстановлено.
 */
public class Main {
    public static void main(String[] args) {
        Student1 student1 = new Student1("ivan", 20, 1.2);
        try (FileOutputStream fileOutputStream = new FileOutputStream("Student.bin")) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student1);

        }catch (IOException e ){
            e.printStackTrace();
        }

        try (FileInputStream fileOutputStream = new FileInputStream("Student.bin")) {
            ObjectInputStream objectInputStream  = new ObjectInputStream(fileOutputStream);
            Student1 student = (Student1) objectInputStream.readObject();
            System.out.println(student.getName()+",  "+student.getAge()+ ", "+student.getGpa());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}

