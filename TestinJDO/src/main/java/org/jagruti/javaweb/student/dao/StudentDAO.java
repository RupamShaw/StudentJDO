package org.jagruti.javaweb.student.dao;

import java.util.List;

import org.jagruti.javaweb.student.model.Student;

public interface StudentDAO {
	Student addStudent(Student Student);
	void removeStudent(long id);
	Student updateStudent(Student Student);
	List<Student> listStudents();
}
