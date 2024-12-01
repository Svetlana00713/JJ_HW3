package task_1;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person user1 = new Person("Милена", 28);
        try (FileOutputStream fileOutputStream = new FileOutputStream("user.bin");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(user1);
            System.out.println("Запись сохранена");
        }

        try (FileInputStream fileInputStream = new FileInputStream("user.bin");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            user1 = (Person) objectInputStream.readObject();
            System.out.println("Запись восстановлена");
        }
        System.out.println("Имя: " + user1.getName());
        System.out.println("Возраст: " + user1.getAge());

    }
}