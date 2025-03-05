import org.example.controller.*;
import org.example.model.*;

public class Run {
    public static void main(String[] args) {
        // Використання UniversityCreator для створення університету
        University university = UniversityCreator.createTypicalUniversity();

        System.out.println("Університет: " + university.getName());
        System.out.println("Ректор: " + formatHuman(university.getHead()));
        System.out.println();

        for (Faculty f : university.getFaculties()) {
            System.out.println("Факультет: " + f.getName());
            System.out.println("Декан: " + formatHuman(f.getHead()));
            System.out.println();

            for (Department d : f.getDepartments()) {
                System.out.println("Кафедра: " + d.getName());
                System.out.println("Завідувач кафедри: " + formatHuman(d.getHead()));
                System.out.println();

                for (Group g : d.getGroups()) {
                    System.out.println("Група: " + g.getName());
                    System.out.println("Староста: " + formatHuman(g.getHead()));
                    System.out.println("Студенти:");

                    for (Student s : g.getStudents()) {
                        System.out.println("- " + formatHuman(s));
                    }
                    System.out.println();
                }
            }
        }
    }

    private static String formatHuman(Human human) {
        return human.getFirstName() + " " + human.getMiddleName() + " " + human.getLastName() + " (" + human.getSex() + ")";
    }
}