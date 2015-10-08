package org.jagruti.javaweb.student.database;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jagruti.javaweb.student.model.Student;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import org.jagruti.javaweb.student.dao.*;

public class DatabaseClass {
	String className = this.getClass().getSimpleName();

	public static Map<Long, Student> getStudents() {
		Map<Long, Student> students = new HashMap<>();
		// datastore();
		// this thread gives with package name class name
		// String className=
		// Thread.currentThread().getStackTrace()[1].getClassName();
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println("DatabaseClass." + methodName + "() ");

		StudentJDODAO studentDAO = new StudentJDODAO();
		List<Student> lStudent = studentDAO.listStudents();
		// Result[] results = getResults();
		// Map<String, Result[]> resultsMap = new HashMap<String, Result[]>();
		if (lStudent.size() == 0) {
			System.out.println("DatabaseClass." + methodName + "() in if");
			students.put(1L, new Student(1, "Rupam!"));
			// students.put(2L, new Student(2L, "Deepak"));
			// System.out.println("end of if"+students);
		} else{

			for (Student student : lStudent) {
				students.put(student.getId(), student);
			}
		// sop is for lazy reading of hashmap
		System.out.println("DatabaseClass." + methodName + "() in else hashmap students size"+students.size());
		// students.put(1L, new Student(1, "Rupam!"));
		}
		return students;
	}

	public static void datastore() {
		DatastoreService ds = new DatastoreServiceFactory().getDatastoreService();
		Entity e = new Entity("Student", 2);
		e.setProperty("Name", "test1");
		e.setProperty("Created", new Date());
		ds.put(e);

		/**
		 * retrieving of entity user
		 * 
		 * Key k=KeyFactory.createKey("User",id) Entity usr=ds.get(k);
		 */
	}

	public Student addStudent(Student student) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println(className + "." + methodName + "() ");
		StudentDAO studentDAO = new StudentJDODAO();
		studentDAO.addStudent(student);
		// student.setId(students.size() + 1);
		// students.put(student.getId(), student);
		return student;
	}

	public Student updateStudent(Student student) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println(className + "." + methodName + "() ");

		if (student.getId() <= 0) {
			return null;
		}

		student.setCreated(new Date());
		StudentDAO studentDAO = new StudentJDODAO();
		// students.put(student.getId(), student);
		return studentDAO.updateStudent(student);
	}

	public void removeStudent(long id) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println(className + "." + methodName + "() ");

		StudentDAO studentDAO = new StudentJDODAO();

		studentDAO.removeStudent(id);
		// students.remove(id);
	}

	public DatabaseClass() {
		// TODO Auto-generated constructor stub
		// System.out.println("in"+className+"constructor");
		System.out.println("inDatabase constructor");
	}
}
