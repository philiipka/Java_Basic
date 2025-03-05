package org.example.model;

import java.util.List;

public class University extends DepartmentBase {
    private List<Faculty> faculties;

    public University(String name, Human rector, List<Faculty> faculties) {
        super(name, rector);
        this.faculties = faculties;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    @Override
    public String toString() {
        return String.format("University{name='%s', Rector=%s, Faculties=%s}", name, head, faculties);
    }
}