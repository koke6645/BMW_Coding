package com;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataManager dataManager = new DataManager();
		dataManager.LoadData("Data.csv");
		
		System.out.println("Number of students in Chemistry: " + dataManager.getTotalStudentinClass(SubjectTitle.valueOf("Chemistry")));
		System.out.println("Number of students take more than one Class: " + dataManager.getTotalStudentsTakeMoreThanOneClass());
	}

}
