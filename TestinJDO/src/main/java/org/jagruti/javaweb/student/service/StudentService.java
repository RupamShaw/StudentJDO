/**
 * 
 */
package org.jagruti.javaweb.student.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.jagruti.javaweb.student.database.DatabaseClass;
import org.jagruti.javaweb.student.exception.DataNotFoundException;
import org.jagruti.javaweb.student.model.Student;
import org.jagruti.javaweb.student.model.StudentStatus;

/**
 * @author Dell
 *
 */
public class StudentService {
	private Map<Long, Student> students = DatabaseClass.getStudents();

	String className = getClass().getSimpleName();

	public StudentService() {
		System.out.println("StudentService constructor()");

	}

	public List<Student> getAllStudents() {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(className + "." + methodName + "() ");
		return new ArrayList<Student>(students.values());
	}

	/**
	 * without exception public Student getStudentbyId(long id) {
	 * 
	 * return students.get(id); }
	 */
	public Student getStudentbyId(long id) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(className + "." + methodName + "() ");

		Student student = students.get(id);
		/*if (student == null) {
			throw new DataNotFoundException("student with id " + id + " not found");
		}*/
		return student;

	}

	public StudentStatus getStudentStatusbyId(long id) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(className + "." + methodName + "() ");

		Student student = students.get(id);
		StudentStatus ss = new StudentStatus(true);
		if (student == null) {
			ss.setStatus(false);
		}
		return ss;

	}

	public Student addStudent(Student student) {
		// student.setId(students.size() + 1);
		// students.put(student.getId(), student);
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(className + "." + methodName + "() ");
		return new DatabaseClass().addStudent(student);

	}

	public Student updateStudent(Student student) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(className + "." + methodName + "() ");

		if (student.getId() <= 0) {
			return null;
		}

		student.setCreated(new Date());
		// students.put(student.getId(), student);
		return new DatabaseClass().updateStudent(student);
	}

	public void removeStudent(long id) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(className + "." + methodName + "() ");

		new DatabaseClass().removeStudent(id);
	}

}
