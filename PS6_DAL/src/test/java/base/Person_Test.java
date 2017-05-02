package base;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {
	static PersonDomainModel per1 = new PersonDomainModel();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse("1990-01-01");
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		per1.setFirstName("Isaiah");
		per1.setLastName("Rashad");
		per1.setStreet("1 Main Street");
		per1.setPostalCode(19709);
		per1.setCity("Chatanooga");
		per1.setBirthday(LocalDate.of(1990, 01, 01));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void addPersonTest() {
		PersonDAL.addPerson(per1);
		assertNotNull("This person exists!");
	}
	@Test
	public void getPersonTest() {
		String FirstName = per1.getFirstName();
		assertEquals("Isaiah",FirstName);
	}
	@Test
	public void updatePersonTest() {
		per1.setFirstName("Tut");
		PersonDAL.updatePerson(per1);
		assertEquals("Tut", per1.getFirstName());
	}
	@Test
	public void deletePersonTest() {
		PersonDAL.deletePerson(per1.getPersonID());
		assertNull("Person does not exist");
	}

}
