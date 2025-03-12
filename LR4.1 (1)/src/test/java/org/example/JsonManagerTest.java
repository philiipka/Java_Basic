package org.example;

import org.example.model.*;
import org.example.utils.JsonManager;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonManagerTest {
    @Test
    void testJsonSerialization() {
        // Створення ректора університету
        Human rector = new Student("John", "Doe", "", Human.Sex.MALE);

        // Створення oldUniversity
        University oldUniversity = new University("Test University", rector, Arrays.asList(
                new Faculty("Engineering", new Student("Dr. Smith", "Brown", "", Human.Sex.MALE), Arrays.asList(
                        new Department("Software", new Student("Dr. Alice", "Johnson", "", Human.Sex.FEMALE), Arrays.asList(
                                new Group("SE-101", new Student("Alice", "Smith", "", Human.Sex.FEMALE), Arrays.asList(
                                        new Student("Alice", "Smith", "", Human.Sex.FEMALE),
                                        new Student("Bob", "Johnson", "", Human.Sex.MALE)
                                )),
                                new Group("SE-102", new Student("Charlie", "Brown", "", Human.Sex.MALE), Arrays.asList(
                                        new Student("Charlie", "Brown", "", Human.Sex.MALE),
                                        new Student("Dave", "Williams", "", Human.Sex.MALE)
                                ))
                        )),
                        new Department("Electronics", new Student("Dr. Robert", "Wilson", "", Human.Sex.MALE), Arrays.asList(
                                new Group("EE-201", new Student("Eve", "Davis", "", Human.Sex.FEMALE), Arrays.asList(
                                        new Student("Eve", "Davis", "", Human.Sex.FEMALE),
                                        new Student("Frank", "Miller", "", Human.Sex.MALE)
                                )),
                                new Group("EE-202", new Student("Grace", "Moore", "", Human.Sex.FEMALE), Arrays.asList(
                                        new Student("Grace", "Moore", "", Human.Sex.FEMALE),
                                        new Student("Henry", "Taylor", "", Human.Sex.MALE)
                                ))
                        ))
                ))
        ));

        // Запис у файл
        String filePath = "university.json";
        JsonManager.saveToJson(oldUniversity, filePath);

        // Зчитування з файлу
        University newUniversity = JsonManager.loadFromJson(filePath, University.class);

        // Порівняння oldUniversity та newUniversity
        assertEquals(oldUniversity, newUniversity, "Помилка: JSON-збереження або зчитування працює неправильно");
    }
}