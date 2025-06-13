import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;


public class UniManagementSystem {
	
	// Array of student objects
	private static Student[] student_array = new Student[100];
	
	public static void main(String[] args) {
	
		
		boolean exit = false;
		
		while (!exit) {
			//menu
			Scanner scanner = new Scanner(System.in);
			System.out.println("1. Check available seats");
			System.out.println("2. Register student(with ID)");
			System.out.println("3. Delete student");
			System.out.println("4. Find student(with ID)");
			System.out.println("5. Store student details in a file");
			System.out.println("6. Load student's details from the file to the system");
			System.out.println("7. Summary");
			System.out.println("8. Exit");
			
			//to take users chosen menu input
			int menu_input = scanner.nextInt();
			scanner.nextLine();
			
			switch(menu_input) {
				case 1:
					available_seats();
					break;
				case 2:
					add_student(scanner);
					break;
				case 3:
					System.out.println("Enter student id to delete: ");
					String delete_id = scanner.nextLine();
					delete_student(delete_id);
					break;
				case 4:
					System.out.println("Enter desired student ID: ");
					String find_id = scanner.nextLine();
					find_student(find_id);
					break;
				case 5:
					store_student();
					break;
				case 6:
					System.out.println("Enter desired student ID: ");
					String load_id = scanner.nextLine();
					load_student(load_id);
					break;
				case 7:
					System.out.println("Choose option 'a' or option 'b': ");
					System.out.println("a. generate report for each student.");
					System.out.println("b. generate complete summary.");
					char option = scanner.next().charAt(0);;
					if (option == 'a') {
						generate_report();
					} else if (option == 'b') {
						generate_summary();
					} else {
						System.out.println("Invalid input(either 'a' or 'b')");
					}
					break;
				case 8:
					exit = true;
					System.out.println("Exiting the program");
					break;
				default:
					System.out.println("Invalid choice please try again.");
					break;
			}
		}	
	}
	
	//method to check available seats
	private static void available_seats() {
		int count = 0;
		for (Student element : student_array) {
			if (element != null) {
				count++;
			}
		}
		int remaining_seats = student_array.length - count;
		System.out.println("Available seats: " + remaining_seats);
	}
	
	//method to add students from user input to above created array
	private static void add_student(Scanner scanner) {
		System.out.println("Enter student name: ");
		String name = scanner.nextLine();
		System.out.println("Enter student ID: ");
		String id = scanner.nextLine();
		System.out.println("Enter student course: ");
		String course = scanner.nextLine();
		
		//use createModule method to create module objects and take inputs of the module details from the user
		System.out.println("Enter details for Module 1: ");
		Module module1 = createModule(scanner);
		System.out.println("Enter details for Module 2: ");
		Module module2 = createModule(scanner);
		System.out.println("Enter details for module 3: ");
		Module module3 = createModule(scanner);
		
		//Create a new student object
		Student new_student = new Student(name, id, course);
		
		//Add the 3 module objects to each student object
		new_student.add_module(module1, 1);
		new_student.add_module(module2, 2);
		new_student.add_module(module3, 3);
		

        //add student object to the array above
        for (int i = 0; i < student_array.length; i++) {
            if (student_array[i] == null) {
                student_array[i] = new_student;
                break;
            }
        }
        System.out.println("Student registered successfully.");
    }
	
	//method to delete a student object from the array
	private static void delete_student(String id) {
		boolean found = false;
		for (int i = 0; i < student_array.length; i++) {
			if (student_array[i] != null && student_array[i].getId().equals(id)) {
				student_array[i] = null;
				found = true;
				System.out.println("Student deleted successfully!");
				break;
			}
		} 
		if (!found) {
			System.out.println("Student " + id + " not found");
		}
	}
	
	//method to find a student and display student details 
	private static void find_student(String id) {
		boolean found = false;
		for (int i = 0; i < student_array.length; i++) {
			if (student_array[i] != null && student_array[i].getId().equals(id)) {
				System.out.println("Student found!");
				System.out.println("Student name: " + student_array[i].getName());
				System.out.println("Student id: " + student_array[i].getId());
				System.out.println("Course: " + student_array[i].getCourse());
				
				//Display module 1 details
				System.out.println("Module 1: " + student_array[i].getModule1().getModule_name());
				System.out.println("ICT Marks: " + student_array[i].getModule1().getIct_marks());
				System.out.println("Coursework Marks: " + student_array[i].getModule1().getCW_marks());
				System.out.println("Final Marks: " + student_array[i].getModule1().final_marks());
				
				//Display module 2 details
				System.out.println("Module 2: " + student_array[i].getModule2().getModule_name());
				System.out.println("ICT Marks: " + student_array[i].getModule2().getIct_marks());
				System.out.println("Coursework Marks: " + student_array[i].getModule2().getCW_marks());
				System.out.println("Final Marks: " + student_array[i].getModule2().final_marks());
				
				//Display module 3 details
				System.out.println("Module 3: " + student_array[i].getModule3().getModule_name());
				System.out.println("ICT Marks: " + student_array[i].getModule3().getIct_marks());
				System.out.println("Coursework Marks: " + student_array[i].getModule3().getCW_marks());
				System.out.println("Final Marks: " + student_array[i].getModule3().final_marks());
				
				found = true;
				break;
			} 
		} 
		
		if (!found)	{
			System.out.println("Student not found.");
		}
	}
	
	//method to use Module class to create objects using user input
	private static Module createModule(Scanner scanner) {
		System.out.println("Enter module name: ");
		String module_name = scanner.nextLine();
		System.out.println("Enter ICT marks: ");
		double ict_marks = Double.parseDouble(scanner.nextLine());;
		System.out.println("Enter coursework marks: ");
		double CW_marks = Double.parseDouble(scanner.nextLine());;
		
		
		return new Module(module_name, ict_marks, CW_marks);
	}
	
	//method to store student details in a file
	private static void store_student() {
		try {
			File student_file = new File("Student.txt");
			boolean file_created = student_file.createNewFile();
			if (file_created) {
				System.out.println("File created: " + student_file.getName());
			} else {
				System.out.println("File already exists.");
			}
			//Add student details to the file
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(student_file))) {
				for (Student element : student_array) {
					if (element != null) {
						writer.write(element.toString());
						writer.newLine();
					}
				}
			} catch (IOException e) {
				System.out.println("Error while writing in a file.");
				e.printStackTrace();
			}
		} catch (IOException e) {
			System.out.println("Error while creating in a file.");
			e.printStackTrace();
		}
	}
	
	//method to load students from file to the system
	private static void load_student(String id) {
		boolean found = false;
		try {
			File student_file = new File("Student.txt");
			Scanner file_reader = new Scanner(student_file);
        
			while (file_reader.hasNextLine()) {
				String line = file_reader.nextLine();
            
				String[] details = line.split(","); 
				String student_id = details[1].substring(4).trim(); 
            
				if (student_id.equals(id)) { 
					System.out.println("Student " + id + " details:");
					System.out.println(line); 
                
					String student_name = details[0].substring(8).trim(); 
					String student_course = details[2].substring(8).trim(); 
                
					Module module1 = extractModule(details[3]);
					Module module2 = extractModule(details[4]);
					Module module3 = extractModule(details[5]);
                
					Student loaded_student = new Student(student_name, student_id, student_course);
					loaded_student.setModule1(module1);
					loaded_student.setModule2(module2);
					loaded_student.setModule3(module3);
                
					
					System.out.println("Loaded Student:");
					System.out.println(loaded_student);
                
					found = true;
					break;
				}
			}
        
			file_reader.close();
        
			if (!found) {
				System.out.println("Student with ID " + id + " not found.");
			}
		} catch (IOException e) {
			System.out.println("Error while reading the file.");
			e.printStackTrace();
		}
	}
	
	//method to parses the details string (representing each module) extracted from the toString() output and create Module
	private static Module extractModule(String moduleDetail) {
		String[] moduleParts = moduleDetail.split(", ");
    
		String module_name = moduleParts[0].substring(14).trim(); 
		double ict_marks = Double.parseDouble(moduleParts[1].substring(11).trim()); 
		double CW_marks = Double.parseDouble(moduleParts[2].substring(17, moduleParts[2].length() - 1).trim()); 
    
		return new Module(module_name, ict_marks, CW_marks);
	}
	
	//method to generate reports for all students in system
	private static void generate_report() {
		
		//sorting the objects in student_array using bubble sort 
		int bottom = student_array.length - 2;
		Student temp;
		boolean exchanged = true;
		
		while (exchanged) {
			exchanged = false;
			for (int i = 0; i <= bottom; i++) {
				if (student_array[i] != null && student_array[i + 1] != null && student_array[i].average_marks() < student_array[i + 1].average_marks()) {
					temp = student_array[i];
					student_array[i] = student_array[i + 1];
					student_array[i + 1] = temp;
					exchanged = true;
				}
			}
			bottom--;
		}
		
		for (Student element : student_array) {
			if (element != null) {
				System.out.println("Student Name: " + element.getName());
				System.out.println("Student ID: " + element.getId());
				System.out.println("Student course: " + element.getCourse());
				System.out.println("Module 1 mark: " + element.getModule1().final_marks());
				System.out.println("Module 2 mark: " + element.getModule2().final_marks());
				System.out.println("Module 3 mark: " + element.getModule3().final_marks());
				System.out.println("Total marks: " + element.total_marks());
				System.out.println("Average marks: " + element.average_marks());
				System.out.println("Grade: " + element.grade());
				System.out.println();
			}
		}
	}
	
	//method to generate summary
	private static void generate_summary() {
		int count = 0;
		int[] passed = new int[3];
		
		for (Student element : student_array) {
			if (element != null) {
				count++;
				
				if (element.getModule1().final_marks() > 40) {
					passed[0]++;
				}
				if (element.getModule2().final_marks() > 40) {
					passed[1]++;
				}
				if (element.getModule3().final_marks() > 40) {
					passed[2]++;
				}
			}
		}
		
		System.out.println("Total Students registered: " + count);
		System.out.println("Module 1 passed: " + passed[0] + " students");
		System.out.println("Module 2 passed: " + passed[1] + " students");
		System.out.println("Module 3 passed: " + passed[2] + " students");
	}
}


