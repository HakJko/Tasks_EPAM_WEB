package edu.epam.ik.service;

import edu.epam.ik.domain.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentServiceImpl implements StudentService{

    private static final Map<Integer, Student> INTEGER_STUDENT_MAP = new HashMap<>();
    public static final AtomicInteger STUDENT_ID_AUTO_INC = new AtomicInteger();

    @Override
    public void createStudent(Student student) {
        final int studentId = STUDENT_ID_AUTO_INC.incrementAndGet();
        student.setId(studentId);
        INTEGER_STUDENT_MAP.put(studentId, student);
    }

    @Override
    public List<Student> readAll() {
        return new ArrayList<>(INTEGER_STUDENT_MAP.values());
    }

    @Override
    public Student read(int id) {
        return INTEGER_STUDENT_MAP.get(id);
    }

    @Override
    public boolean update(Student student, int id) {
        if (INTEGER_STUDENT_MAP.containsKey(id)) {
            student.setId(id);
            INTEGER_STUDENT_MAP.put(id, student);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return INTEGER_STUDENT_MAP.remove(id) != null;
    }
}
