package com;

import java.util.HashSet;
import java.util.Set;

public class Subject {

	private String title;
	private Set<String> professors;
	private Set<Integer> students;

	public Subject(String title) {
		this.title = title;
		professors = new HashSet<String>();
		students = new HashSet<Integer>();
	}

	public void addProfessor(String name) {
		professors.add(name);
	}

	public void addStudent(int id) {
		students.add(id);
	}

	public int getTotalStudentEnroll() {
		return students.size();
	}
}
