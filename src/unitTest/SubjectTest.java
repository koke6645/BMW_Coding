package unitTest;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.Student;
import com.Subject;
import com.SubjectTitle;

public class SubjectTest {

	@Test
	public void testSubject() throws Exception {
		String title1 = SubjectTitle.Chemistry.name();
		Subject subject1 = new Subject(title1);
		
		Field title = Subject.class.getDeclaredField("title");
		title.setAccessible(true);	
		String subjectTitle = (String)title.get(subject1);
		Assert.assertEquals(title1, subjectTitle);
	}

	@Test
	public void testAddProfessor() throws Exception {
		String title1 = SubjectTitle.Chemistry.name();
		Subject subject1 = new Subject(title1);
		
		String professor1 = "Jame";
		String professor2 = "Mike";
		String professor3 = "Jame";
		
		subject1.addProfessor(professor1);
		subject1.addProfessor(professor2);
		subject1.addProfessor(professor3);
		subject1.addProfessor(professor1);
		
		Field professors = Subject.class.getDeclaredField("professors");
		professors.setAccessible(true);	
		Set<String> professorSet = (Set<String>)professors.get(subject1);
		Assert.assertEquals(2, professorSet.size());
		Assert.assertTrue(professorSet.contains(professor1));
		Assert.assertTrue(professorSet.contains(professor2));
	}

	@Test
	public void testAddStudent() throws Exception {
		String title1 = SubjectTitle.Chemistry.name();
		Subject subject1 = new Subject(title1);
		
		int id1 = 1233;
		int id2 = 3341;
		int id3 = 1233;
		
		subject1.addStudent(id1);
		subject1.addStudent(id2);
		subject1.addStudent(id3);
		subject1.addStudent(id1);
		
		Field students = Subject.class.getDeclaredField("students");
		students.setAccessible(true);	
		Set<Integer> studentSet = (Set<Integer>)students.get(subject1);
		Assert.assertEquals(2, studentSet.size());
		Assert.assertTrue(studentSet.contains(id1));
		Assert.assertTrue(studentSet.contains(id2));
	}

	@Test
	public void testGetTotalStudentEnroll() {
		String title1 = SubjectTitle.Chemistry.name();
		Subject subject1 = new Subject(title1);
		
		int id1 = 1233;
		int id2 = 3341;
		int id3 = 1233;
		
		subject1.addStudent(id1);
		subject1.addStudent(id2);
		subject1.addStudent(id3);
		subject1.addStudent(id1);
		
		Assert.assertEquals(2, subject1.getTotalStudentEnroll());
	}

}
