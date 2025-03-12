package org.example.model;

import java.util.List;
import java.util.Objects;

public class Group extends DepartmentBase {
    private List<Student> students;

    public Group(String name, Human head, List<Student> students) {
        super(name, head);
        this.students = students;
    }

    // Безпараметровий конструктор (необхідний для Gson)
    public Group() {}

    public List<Student> getStudents() {
        return students;
    }

    // Сетер для JSON-десеріалізації
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) &&
                Objects.equals(head, group.head) &&
                Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head, students);
    }

    @Override
    public String toString() {
        return String.format("Group{name='%s', Head=%s, Students=%s}", name, head, students);
    }
}