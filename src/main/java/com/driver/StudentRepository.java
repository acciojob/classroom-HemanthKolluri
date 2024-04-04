package com.driver;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> teacherMap;
    private HashMap<String, List<String>> teacherStudentMapping;

    public StudentRepository() {
        this.studentMap = new HashMap<String, Student>();
        this.teacherMap = new HashMap<String, Teacher>();
        this.teacherStudentMapping = new HashMap<String, List<String>>();
    }

    public void saveStudent(Student student) {
        studentMap.put(student.getName(), student);
    }

    public void saveTeacher(Teacher teacher) {
        teacherMap.put(teacher.getName(), teacher);
    }

    public void saveStudentTeacherPair(String student, String teacher) {
        // Implement logic to save student-teacher pair
    }

    public Student findStudent(String student) {
        return studentMap.get(student);
    }

    public Teacher findTeacher(String teacher) {
        return teacherMap.get(teacher);
    }

    public List<String> findStudentsFromTeacher(String teacher) {
        return teacherStudentMapping.get(teacher);
    }

    public List<String> findAllStudents() {
        return List.copyOf(studentMap.keySet());
    }

    public void deleteTeacher(String teacher) {
        teacherMap.remove(teacher);
        teacherStudentMapping.remove(teacher);
    }

    public void deleteAllTeachers() {
        teacherMap.clear();
        teacherStudentMapping.clear();
    }
}
