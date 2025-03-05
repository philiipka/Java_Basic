package org.example.controller;

import org.example.model.Human;
import org.example.model.Student;

public class StudentCreator {
    public static Student createStudent(String firstName, String lastName, String middleName, Human.Sex sex) {
        return new Student(firstName, lastName, middleName, sex);
    }
}