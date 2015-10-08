package org.jagruti.javaweb.student.dao;

import org.jagruti.javaweb.student.database.*;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;

import org.jagruti.javaweb.student.model.Student;

public class StudentJDODAO implements StudentDAO {

	String className = this.getClass().getSimpleName();

	public StudentJDODAO() {
		// TODO Auto-generated constructor stub
		System.out.println("StudentJDODAO --Constructor()");
		// System.out.println("Classname.Methodname"+className+"."+methodName);
	}

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println(className + "." + methodName + "() ");
		student.setCreated(new Date());
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			// System.out.println("Classname.Methodname"+className+"."+methodName);

			pm.makePersistent(student);

		} catch (Exception ex) {
			// pm.currentTransaction().rollback();
			throw new RuntimeException(ex);
		} finally {
			pm.close();

			return student;
		}
	}

	@Override
	public void removeStudent(long id) {
		// TODO Auto-generated method stub
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println(className + "." + methodName + "() ");

		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.currentTransaction().begin();

			// We don't have a reference to the selected Product.
			// So we have to look it up first,
			Student student = pm.getObjectById(Student.class, id); // student.getId());
			pm.deletePersistent(student);

			pm.currentTransaction().commit();
		} catch (Exception ex) {
			pm.currentTransaction().rollback();
			throw new RuntimeException(ex);
		} finally {
			pm.close();
		}

	}

	@Override
	public Student updateStudent(Student student) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println(className + "." + methodName + "() ");

		PersistenceManager pm = PMF.get().getPersistenceManager();
		String name = student.getName();
		Date created = student.getCreated();

		try {
			pm.currentTransaction().begin();
			// We don't have a reference to the selected Product.
			// So we have to look it up first,
			student = pm.getObjectById(Student.class, student.getId());
			student.setName(name);
			student.setCreated(created);
			pm.makePersistent(student);
			pm.currentTransaction().commit();
		} catch (Exception ex) {
			pm.currentTransaction().rollback();
			throw new RuntimeException(ex);
		} finally {
			pm.close();

			return student;
		}
	}

	// @SuppressWarnings("finally")
	@Override
	public List<Student> listStudents() {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(className + "." + methodName + "() ");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "";
		List<Student> ls = null;
		try {
			// TODO Auto-generated method stub
			query = "select from " + Student.class.getName();
			ls = (List<Student>) pm.newQuery(query).execute();
			// sop is for lazy reading
			System.out.println(className + "." + methodName + "() list size is " + ls.size());

		} catch (Exception ex) {
			// pm.currentTransaction().rollback();
			throw new RuntimeException(ex);
		} finally {
			/// @SuppressWarnings("unchecked")
			pm.close();
			return ls;
		}

	}

}
