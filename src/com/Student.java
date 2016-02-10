package com;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private int id;
	private Set<SubjectTitle> subjects;
	
	public Student(int id) {
		this.id = id;
		subjects = new HashSet<SubjectTitle>();
	}
	
	public void enrollIn(SubjectTitle title) {
		subjects.add(title);
	}
	
	public Boolean isEnrollInClass(SubjectTitle title) {
		return subjects.contains(title);
	}
	
	public int totalClassEnroll() {
		return subjects.size();
	}
}
