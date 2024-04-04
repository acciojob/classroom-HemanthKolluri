package com.driver;

import java.util.ArrayList;
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

    public void saveStudentTeacherPair(String studentName, String teacherName) {
        // Implement logic to save student-teacher pair
        if (studentMap.containsKey(studentName) && teacherMap.containsKey(teacherName)) {
            List<String> students = teacherStudentMapping.getOrDefault(teacherName, new ArrayList<>());
            students.add(studentName);
            teacherStudentMapping.put(teacherName, students);
        } else {
            if (!studentMap.containsKey(studentName)) {
                // Handle the case where the student doesn't exist
                System.out.println("Error: Student '" + studentName + "' does not exist.");
            }
            if (!teacherMap.containsKey(teacherName)) {
                // Handle the case where the teacher doesn't exist
                System.out.println("Error: Teacher '" + teacherName + "' does not exist.");
            }
        }

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
