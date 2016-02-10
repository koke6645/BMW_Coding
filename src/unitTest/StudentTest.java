package unitTest;

import static org.junit.Assert.*;

import java.lang.reflect.*;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.Student;
import com.SubjectTitle;

public class StudentTest {

	@Test
	public void testStudent() throws Exception {
		
		int id1 = 12331;
		Student stud1 = new Student(id1);
		
		Field studentID = Student.class.getDeclaredField("id");
		studentID.setAccessible(true);	
		int id = (int)studentID.get(stud1);
		Assert.assertEquals(id1, id);
	}

	@Test
	public void testEnrollIn() throws Exception {
		int id1 = 12331;
		Student stud1 = new Student(id1);
		stud1.enrollIn(SubjectTitle.Chemistry);
		
		Field subjects = Student.class.getDeclaredField("subjects");
		subjects.setAccessible(true);
		Set<SubjectTitle> setSubject = (Set<SubjectTitle>)subjects.get(stud1);
		Assert.assertTrue(setSubject.contains(SubjectTitle.Chemistry));
	}

	@Test
	public void testTotalClassEnroll() throws Exception {
		int id1 = 12331;
		Student stud1 = new Student(id1);
		stud1.enrollIn(SubjectTitle.Chemistry);
		stud1.enrollIn(SubjectTitle.Chemistry);
		
		Field subjects = Student.class.getDeclaredField("subjects");
		subjects.setAccessible(true);
		Set<SubjectTitle> setSubject = (Set<SubjectTitle>)subjects.get(stud1);
		Assert.assertEquals(1, setSubject.size());
	}

}
