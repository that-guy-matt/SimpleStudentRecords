package simpleStudentRecords;

import java.util.ArrayList;
import textio.TextIO;

class Student {
	/* student class contains student's name, id number, age, and grade.
	 * includes setter methods and getter methods to access data
	 */
	private String name;
	private int id;
	private int age;
	private double grade;
	
	// constructor method
	public Student(String name, int id, int age, double grade) {
		this.name = name;
		this.id = id;
		this.age = age;
		this.grade = grade;
	}
	
	// getter methods
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public int getAge() {
		return age;
	}
	
	public double getGrade() {
		return grade;
	}
	
	/* setter methods
	 * these setter methods do not change student name or id
	 * these values are permanent.
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	//display student details
	public void displayDetails() {
		System.out.println("\nStudent details:");
		System.out.println("Name: " + name);
		System.out.println("ID: " + id);
		System.out.println("Age: " + age);
		System.out.println("Grade: " + grade);
	} // end method display details
} // end class student

/* student management class controls student instances
 * this includes adding new students, updating and displaying
 * student info.
 */
class StudentManagement {
	private static ArrayList<Student> students = new ArrayList<>();
	private static int totalStudents = 0;
	private static int studentId = 1;
	
	// add new student
	public static void addStudent(String name, int age, double grade) {
		Student newStudent = new Student(name, studentId++, age, grade);
		students.add(newStudent);
		totalStudents++;
		System.out.println("\nStudent added successfully.\n");
	} // end addStudent method
	
	/* update student information
	 * note that student name cannot be updated
	 */
	public static void updateStudent(int studentId, int newAge, double newGrade) {
		for (Student student : students) {
			if (student.getId() == studentId) {
				student.setAge(newAge);
				student.setGrade(newGrade);
				System.out.println("\nStudent information updated successfully.\n");
				return;
			} // end if
		} // end for
		
		// if the previous block doesn't find student id, this warning runs.
		System.out.printf("Student with ID %s not found.%n", studentId);
		
	} // end updateStudent		
	
	// displays student info as well as a total count of student records
	public static void viewStudentDetails(int studentId) {
		for (Student student : students) {
			if (student.getId() == studentId) {
				student.displayDetails();
				System.out.println("\nTotal students records: " + totalStudents + "\n");
				return;
			} // end if
		} // end for
		
		// if the previous block doesn't run, this warning displays
		System.out.printf("Student with ID %s not found.%n", studentId);
		
	} // end viewStudentDetails
} // end class student management


public class SimpleStudentRecords {

	public static void main(String[] args) {
		
		while (true) {
			// display menu for administrator
			System.out.printf("""
Administrator Interface

1. Add a new student
2. Update student info
3. View student details
4. Exit
					""");
			
			System.out.print("Enter your choice: ");
			int choice = TextIO.getlnInt();
			
			switch (choice) {
			case 1: 
				addNewStudent();
				continue;
			case 2:
				updateStudentInfo();
				continue;
			case 3:
				viewStudentDetails();
				continue;
			case 4:
				System.out.println("Thank you for using the Simple Student Records program. Goodbye.");
				System.exit(1);
			default:
				System.out.println("Please enter one of the menu choices.");
				
			} // end switch
		} // end while menu
		
	} // end main
	
	/* method to add new student with name, age, and grade.
	 * note that student ID is created automatically
	 */
	private static void addNewStudent() {
		System.out.print("Enter student name: ");
		String name = TextIO.getln();
		
		System.out.print("Enter student age: ");
		int age = TextIO.getlnInt();
		
		System.out.print("Enter student grade: ");
		double grade = TextIO.getlnDouble();
		
		StudentManagement.addStudent(name, age, grade);
	}
	
	/* method to update student information
	 * note that only the students age and grade can be updated
	 */
	private static void updateStudentInfo() {
		System.out.print("Enter student ID to update: ");
		int studentId = TextIO.getlnInt();
		
		System.out.print("Enter new student age: ");
		int newAge = TextIO.getlnInt();
		
		System.out.print("Enter new grade: ");
		double newGrade = TextIO.getlnDouble();
		
		StudentManagement.updateStudent(studentId, newAge, newGrade);
	}
	
	// method to display student details
	private static void viewStudentDetails() {
		System.out.print("Enter student ID to view details: ");
		int studentId = TextIO.getlnInt();
		
		StudentManagement.viewStudentDetails(studentId);
	}
	
} // end class simpleStudentRecords 

