package org.example.controller;

import org.example.model.Student;
import org.example.model.University;
import org.example.model.Human;
import org.example.model.Faculty;

import java.util.Arrays;
import java.util.List;

public class UniversityCreator {
    public static University createUniversity(String name, Human rector, List<Faculty> faculties) {
        return new University(name, rector, faculties);
    }

    // Метод для створення університету з факультетами
    public static University createTypicalUniversity() {
        Human rector = new Student("Іван", "Петрович", "Сидоренко", Human.Sex.MALE);
        List<Faculty> faculties = Arrays.asList(
                FacultyCreator.createFacultyWithDepartments("Факультет інформаційних технологій", rector)
        );
        return new University("Національний університет", rector, faculties);
    }
}