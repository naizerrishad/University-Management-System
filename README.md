# University Management System

## Overview
This is a simple console-based University Management System developed in Java. It allows managing student registrations, their course modules, and marks. The system supports functionalities such as adding, deleting, searching students, storing/loading data from a file, and generating reports and summaries.

## Features
- Register students with unique IDs and their respective course details.
- Add three course modules for each student, including marks for ICT and coursework.
- Delete student records by student ID.
- Search and display detailed student information by ID.
- Store all student details to a text file (`Student.txt`) and load specific student data from the file.
- Generate individual student reports sorted by average marks.
- Generate a summary showing pass rates for each module.
- Simple menu-driven console interface.

## Technologies Used
- Java (Core)
- File I/O (using `BufferedWriter` and `Scanner` for persistence)
- Basic OOP concepts: Classes, objects, encapsulation, arrays

## How to Run
1. Compile the Java source files:
   ```bash
   javac UniManagementSystem.java Student.java Module.java
