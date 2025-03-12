package org.example.controller;

import org.example.model.Group;
import org.example.model.Human;
import org.example.model.Student;

import java.util.Arrays;
import java.util.List;

public class GroupCreator {
    public static Group createGroup(String name, Human head, List<Student> students) {
        return new Group(name, head, students);
    }

    // Додатковий метод для створення групи зі студентами
    public static Group createGroupWithStudents(String name, Human head) {
        List<Student> students = Arrays.asList(
                StudentCreator.createStudent("Андрій", "Миколайович", "Козак", Human.Sex.MALE),
                StudentCreator.createStudent("Ольга", "Василівна", "Лисенко", Human.Sex.FEMALE)
        );
        return new Group(name, head, students);
    }
}