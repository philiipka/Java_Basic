package org.example.model;

import java.util.List;

public class Group extends DepartmentBase {
    private List<Student> students;

    public Group(String name, Human head, List<Student> students) {
        super(name, head);
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return String.format("Group{name='%s', Head=%s, Students=%s}", name, head, students);
    }
}