package task_2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Person> persons;
        File file = new File(PersonsListApp.FILE_JSON);
        if (file.exists() && !file.isDirectory()) {
            persons = PersonsListApp.readPersonsFromFile(PersonsListApp.FILE_JSON);
        } else {
            persons = preparePersonList();
        }
        PersonsListApp.savePersonsToFile(PersonsListApp.FILE_JSON, persons);
        PersonsListApp.savePersonsToFile(PersonsListApp.FILE_XML, persons);
        PersonsListApp.savePersonsToFile(PersonsListApp.FILE_BIN, persons);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:\n1.Показать список лиц\n2.Добавить лицо\n3.Изменить данные лица\n4.Удалить лицо\n5.Выход");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    PersonsListApp.displayPersons(persons);
                    break;
                case "2":
                    PersonsListApp.addPerson(sc, persons);
                    PersonsListApp.displayPersons(persons);
                    break;
                case "3":
                    PersonsListApp.renewPerson(sc, persons);
                    PersonsListApp.displayPersons(persons);
                    break;
                case "4":
                    PersonsListApp.removePersonFromList(sc, persons);
                    PersonsListApp.displayPersons(persons);
                    break;
                case "5":
                    PersonsListApp.savePersonsToFile(PersonsListApp.FILE_JSON, persons);
                    PersonsListApp.savePersonsToFile(PersonsListApp.FILE_XML, persons);
                    PersonsListApp.savePersonsToFile(PersonsListApp.FILE_BIN, persons);
                    System.out.println("Всего доброго)");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Невозможно осуществить действие.");
                    break;
            }
        }
    }

    static List<Person> preparePersonList() {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Анна Иванова", 32));
        list.add(new Person("Сергей Петров", 40));
        list.add(new Person("Алина Громова", 50));
        return list;
    }
}
