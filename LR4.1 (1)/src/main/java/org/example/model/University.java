package org.example.model;

import java.util.List;
import java.util.Objects;

public class University extends DepartmentBase {
    private List<Faculty> faculties;

    // Конструктор з параметрами
    public University(String name, Human rector, List<Faculty> faculties) {
        super(name, rector);
        this.faculties = faculties;
    }

    // Порожній конструктор (необхідний для Gson)
    public University() {}

    // Геттери та сеттери
    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    // equals() для коректного порівняння об'єктів
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(head, that.head) &&
                Objects.equals(faculties, that.faculties);
    }

    // hashCode() для унікальної ідентифікації об'єкта
    @Override
    public int hashCode() {
        return Objects.hash(name, head, faculties);
    }

    @Override
    public String toString() {
        return String.format("University{name='%s', Rector=%s, Faculties=%s}", name, head, faculties);
    }
}