package edu.epam.ik.service;

import edu.epam.ik.domain.Student;

import java.util.List;

public interface StudentService {

    void createStudent(Student student);

    List<Student> readAll();

    Student read(int id);

    boolean update(Student student, int id);

    boolean delete(int id);

}
