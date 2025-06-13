import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;


public class Module {
	private String module_name;
	private double ict_marks;
	private double CW_marks;
	
	//constructor for module class
	public Module(String module_name, double ict_marks, double CW_marks) {
		this.module_name = module_name;
		this.ict_marks = ict_marks;
		this.CW_marks = CW_marks;
	}
	
	//getter for module_name
	public String getModule_name() {
		return module_name;
	}
	
	//setter for module_name
	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}
	
	//getter for ict_marks
	public double getIct_marks() {
		return ict_marks;
	}
	
	//setter for ict_marks
	public void setIct_marks(double ict_marks) {
		this.ict_marks = ict_marks;
	}
	
	//getter for CW_marks
	public double getCW_marks() {
		return CW_marks;
	}
	
	//setter for CW_marks
	public void setCW_marks(double CW_marks) {
		this.CW_marks = CW_marks;
	}
	
	//method to calculate final mark for module
	public double final_marks() {
		double final_mark = (ict_marks + CW_marks)/2;
		return final_mark;
	}
	
	//method to format module details into a string format
	public String toString() {
		return "Module{Module name = '" + module_name + "', ICT marks = " + ict_marks + ", Coursework marks = " + CW_marks + "}";
	}
}