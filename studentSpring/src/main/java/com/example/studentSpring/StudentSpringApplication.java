package com.example.studentSpring;

import com.example.studentSpring.dao.StudentDao;
import com.example.studentSpring.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class StudentSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner -> {
//			createStudent(studentDao);
//			createMultipleStudent(studentDao);
//			readStudent(studentDao);
			//queryForStudents(studentDao);
			//queryForStudentsByLastName(studentDao);
			//updateStudent(studentDao);
			//deleteStudent(studentDao);
			deleteAllStudents(studentDao);
		};
	}

	private void deleteAllStudents(StudentDao studentDao) {

		System.out.println("Delete all students");
		int numofRows = studentDao.deleteAll();
		System.out.println("No. of rows delete " + numofRows);
	}

	private void deleteStudent(StudentDao studentDao) {

		int studentId = 3;
		System.out.println("Deleting student with id: " + studentId);
		studentDao.delete(studentId);
	}

	private void updateStudent(StudentDao studentDao) {

		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDao.findById(studentId);

		System.out.println("Updating student ..");
		myStudent.setFirstName("Scooby");

		studentDao.update(myStudent);

		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDao studentDao) {

		List<Student> theStudents = studentDao.findByLastName("Saini");
		for(Student tempStudent: theStudents ){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDao studentDao) {

		List<Student> theStudents = studentDao.findByAll();
		for(Student tempStudent: theStudents ){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDao studentDao) {

		System.out.println("Creating student object...");
		Student tempStudent = new Student("Daffy","Duck", "daffy@gmail.com");

		System.out.println("Saving object...");
		studentDao.save(tempStudent);

		System.out.println("Object id "+ tempStudent.getId());

		System.out.println("Retreving student with id " + tempStudent.getId());

		Student myStudent = studentDao.findById(tempStudent.getId());

		System.out.println("Found student " + myStudent);
	}

	private void createMultipleStudent(StudentDao studentDao) {

		System.out.println("Creating student object...");
		Student tempStudent1 = new Student("Anurag","Saini", "anuragsaini0987@gmail.com");
		Student tempStudent2 = new Student("Anjana","Saini", "anjanasaini0987@gmail.com");
		Student tempStudent3 = new Student("Soniya","Saini", "soniyasaini0987@gmail.com");

		System.out.println("Saving object...");
		studentDao.save(tempStudent1);
		studentDao.save(tempStudent2);
		studentDao.save(tempStudent3);

	}

	private void createStudent(StudentDao studentDao) {

		System.out.println("Creating student object...");
		Student tempStudent = new Student("Priyanka","Saini", "priyankasaini0987@gmail.com");

		System.out.println("Saving object...");
		studentDao.save(tempStudent);

		System.out.println("Object id "+ tempStudent.getId());
	}


}
