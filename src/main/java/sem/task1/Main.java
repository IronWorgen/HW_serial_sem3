package sem.task1;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        //task1
        UserData userData = new UserData("ivan" , 10, "password");
        try (FileOutputStream fileOutputStream = new FileOutputStream("userdata.bin")){
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(userData);
        }catch (IOException e){
            e.printStackTrace();
        }

        try(FileInputStream in = new FileInputStream("userData.bin")){
            ObjectInputStream objectInputStream = new ObjectInputStream(in);
            UserData userData1 = (UserData) objectInputStream.readObject();
            System.out.println(userData1.getName());
            System.out.println(userData1.getPassword());
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
