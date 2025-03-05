package org.example.controller;

import org.example.model.Department;
import org.example.model.Human;
import org.example.model.Group;

import java.util.Arrays;
import java.util.List;

public class DepartmentCreator {
    public static Department createDepartment(String name, Human head, List<Group> groups) {
        return new Department(name, head, groups);
    }

    // Метод для створення кафедри з групами
    public static Department createDepartmentWithGroups(String name, Human head) {
        List<Group> groups = Arrays.asList(
                GroupCreator.createGroupWithStudents("Група 101", head)
        );
        return new Department(name, head, groups);
    }
}