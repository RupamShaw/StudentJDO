package org.jagruti.javaweb.student.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jagruti.javaweb.student.model.Student;
import org.jagruti.javaweb.student.model.StudentStatus;
import org.jagruti.javaweb.student.service.StudentService;
import java.util.logging.Logger;
@Path("students")
@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
/*
 * @Produces(MediaType.APPLICATION_JSON)
 * 
 * @Consumes(MediaType.APPLICATION_JSON)
 */
public class StudentResource {
	private static final Logger log = Logger.getLogger(StudentResource.class.getName());
	
	public StudentResource() {
		// TODO Auto-generated constructor stub
	}

	String className = this.getClass().getSimpleName();

	@GET
	public List<Student> getStudents() {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		log.info("Information log message.");

        log.warning("Warning log message.");

        log.severe("Error log message.");
		System.out.println(className + "." + methodName + "() ");

		return new StudentService().getAllStudents();
	}

	@GET
	@Path("/{studentId}")
	public Student getStudentbyId(@PathParam("studentId") long id) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println(className + "." + methodName + "() ");

		return new StudentService().getStudentbyId(id);
	}

	@GET
	@Path("/status/{studentId}")
	public StudentStatus getStudentStatusbyId(@PathParam("studentId") long id) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println(className + "." + methodName + "() ");

		return new StudentService().getStudentStatusbyId(id);
	}

	@POST
	// @Path("/{studentId}")
	public Student addStudent(Student student) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println(className + "." + methodName + "() ");
		return new StudentService().addStudent(student);
	}

	@POST
	@Path("/{studentId}")
	public Student addStudentbyid(Student student) {
	//long id=	@PathParam("studentId");
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println(className + "." + methodName + "() ");
		//student.setId(studentId);
		return new StudentService().addStudent(student);
	}

	@PUT
	@Path("/{studentId}")

	public Student updateStudent(@PathParam("studentId") long id, Student student) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println(className + "." + methodName + "() ");

		student.setId(id);
		return new StudentService().updateStudent(student);
	}

	@DELETE
	@Path("/{studentId}")
	public void deleteStudent(@PathParam("studentId") long id) {
		String methodName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println(className + "." + methodName + "() ");

		new StudentService().removeStudent(id);
	}

}
