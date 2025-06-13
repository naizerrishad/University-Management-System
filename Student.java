import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;


public class Student {
	private String name;
	private String id;
	private String course;
	private Module module1;
	private Module module2;
	private Module module3;
	
	//Constructor for student class
	public Student(String name, String id, String course) {
		this.name = name;
		this.id = id;
		this.course = course;
	}
	
	//getter for name
	public String getName() {
		return name;
	}
	
	//setter for name
	public void setName(String name) {
		this.name = name;
	}
	
	//getter for id
	public String getId() {
		return id;
	}
	
	//setter for id
	public void setId(String id) {
		this.id = id;
	}
	
	//getter for course
	public String getCourse() {
		return course;
	}
	
	//setter for course
	public void setCourse(String course) {
		this.course = course;
	}
	
	//getter for module1 object
	public Module getModule1() {
		return module1;
	}
	
	//setter for module1 object
	public void setModule1(Module module1) {
		this.module1 = module1;
	}
	
	//getter for module2 object
	public Module getModule2() {
		return module2;
	}
	
	//setter for module2 object
	public void setModule2(Module module2) {
		this.module2 = module2;
	}
	
	//getter for module3 object
	public Module getModule3() {
		return module3;
	}
	
	//setter for module3 object
	public void setModule3(Module module3) {
		this.module3 = module3;
	}
	
	//method to add modules to each student object of this class
	public void add_module(Module module, int index) {
		switch (index) {
			case 1:
				this.module1 = module;
				break;
			case 2:
				this.module2 = module;
				break;
			case 3:
				this.module3 = module;
				break;
			default:
				System.out.println("Invalid module index.");
				break;
		}
	}
	
	//method to calculate total marks of student
	public double total_marks() {
		return module1.final_marks() + module2.final_marks() + module3.final_marks();
	}
	
	//method to calculate average of all 3 modules
	public double average_marks() {
		return total_marks()/3;
	}
	
	//method to determine the grade of student
	public String grade() {
		double average = average_marks();
		if (average >= 80) {
			return "Distinction";
		} else if (average >= 70) {
			return "Merit";
		} else if (average >= 40) {
			return "Pass";
		} else {
			return "Fail";
		}
	}
	
	//method to format student details into a string format
	public String toString() {
		return "Student{name='" + name + "', id='" + id + "', course='" + course + "', module1=" + module1 + ", module2=" + module2 + ", module3=" + module3 + "}";
	}
}