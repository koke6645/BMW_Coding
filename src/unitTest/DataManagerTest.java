package unitTest;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;

import com.DataManager;
import com.SubjectTitle;

public class DataManagerTest {

	@Test
	public void testLoadData() {
		DataManager dataManager1 = new DataManager();
		
		try {
			dataManager1.LoadData("Test.csv");
			Assert.fail("Expect fail");
		}
		catch (Exception e) {
		}
		
		try {
			dataManager1.LoadData("TestData.csv");
		}
		catch (Exception e) {
			Assert.fail("Expect fail");
		}
		
	}

	@Test
	public void testGetTotalStudentsTakeMoreThanOneClass() {
		
		DataManager dataManager1 = new DataManager();
		dataManager1.LoadData("TestData.csv");
		
		Assert.assertEquals(2, dataManager1.getTotalStudentsTakeMoreThanOneClass());
		
	}

	@Test
	public void testGetTotalStudentinClass() {
		DataManager dataManager1 = new DataManager();
		dataManager1.LoadData("TestData.csv");
		
		Assert.assertEquals(2, dataManager1.getTotalStudentinClass(SubjectTitle.Chemistry));
		Assert.assertEquals(2, dataManager1.getTotalStudentinClass(SubjectTitle.Mathematics));
		Assert.assertEquals(2, dataManager1.getTotalStudentinClass(SubjectTitle.History));
	}

	@Test
	public void testValidateFields() throws Exception {
		
		DataManager dataManager1 = new DataManager();
		String[] fields1 = {"Chemistry", "Jame", "24453"};
		String[] fields2 = {"Chemistr", "Jame", "24453"};
		String[] fields3 = {"Chemistryy", "Jame", "24453"};
		String[] fields4 = {"", "Jame", "24453"};
		String[] fields5 = {"Jame", "24453"};
		String[] fields6 = {"Chemistry", "", "24453"};
		String[] fields7 = {"Chemistry", "Jame", "244a53"};
		String[] fields8 = {"Chemistry", "Jame", ""};
		
		Method validate = DataManager.class.getDeclaredMethod("validateFields",  new Class[]{String[].class});
		validate.setAccessible(true);
		
		Assert.assertTrue((Boolean)validate.invoke(dataManager1, new Object[]{fields1}));
		Assert.assertFalse((Boolean)validate.invoke(dataManager1, new Object[]{fields2}));
		Assert.assertFalse((Boolean)validate.invoke(dataManager1, new Object[]{fields3}));
		Assert.assertFalse((Boolean)validate.invoke(dataManager1, new Object[]{fields4}));
		Assert.assertFalse((Boolean)validate.invoke(dataManager1, new Object[]{fields5}));
		Assert.assertFalse((Boolean)validate.invoke(dataManager1, new Object[]{fields6}));
		Assert.assertFalse((Boolean)validate.invoke(dataManager1, new Object[]{fields7}));
		Assert.assertFalse((Boolean)validate.invoke(dataManager1, new Object[]{fields8}));
		
	}

}
