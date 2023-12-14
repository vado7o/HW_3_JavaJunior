package task1;

import java.io.*;

/**
 * Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
 * Обеспечьте поддержку сериализации для этого класса.
 * Создайте объект класса Student и инициализируйте его данными.
 * Сериализуйте этот объект в файл.
 * Десериализуйте объект обратно в программу из файла.
 * Выведите все поля объекта, включая GPA, и обсудите,
 * почему значение GPA не было сохранено/восстановлено.
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student student = new Student("Виктор Иванов", 23, 4.5);

        System.out.println("\nИмя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("Средний бал студента: " + student.getGPA());

        try (FileOutputStream fileOutputStream = new FileOutputStream("studentData.bin");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(student);
            System.out.println("\nОъект Student сериализован");
        }

        try (FileInputStream fileInputStream = new FileInputStream("studentData.bin");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            student = (Student) objectInputStream.readObject();
            System.out.println("\nОбъект Student десериализован");
        }

        System.out.println("\nИмя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("Средний бал студента: " + student.getGPA());
    }
}