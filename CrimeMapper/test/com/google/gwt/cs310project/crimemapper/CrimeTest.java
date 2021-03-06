package com.google.gwt.cs310project.crimemapper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.google.gwt.cs310project.crimemapper.client.*;
import com.google.gwt.cs310project.crimemapper.server.*;

import java.util.ArrayList;

public class CrimeTest {

	// TODO: Create test cases for the 'soon to be created' test files.
	CrimeDataServiceImpl cdsi;
	CrimeDataByYear cdl2003;
	int crimeYear;
	String crimeType;
	int crimeTypeNum;

	@Before
	public void setUp(){
		cdsi = new CrimeDataServiceImpl();
		cdl2003 = cdsi.getCrimeDataByYear("file:./war/data/crime_2003.csv");
		crimeYear = cdl2003.getYear();
		crimeType = "Theft From Auto Over $5000";
		crimeTypeNum = 215;
		
	}

	@Test
	public void testCrimeDataEquals() {
		CrimeData cm1 = new CrimeData("Commercial Break and Enter",
				2014, 1, "8XX BEATTY ST");
		CrimeData cm2 = new CrimeData("Commercial Break and Enter",
				2014, 1, "8XX BEATTY ST");
		CrimeData cm3 = new CrimeData("Theft From Auto Under $5000",
				2014, 1, "8XX BEATTY ST");
		CrimeData cm4 = new CrimeData("Commercial Break and Enter",
				2013, 1, "8XX BEATTY ST");
		CrimeData cm5 = new CrimeData("Commercial Break and Enter",
				2014, 2, "8XX BEATTY ST");
		CrimeData cm6 = new CrimeData("Commercial Break and Enter",
				2014, 1, "9XX BEATTY ST");
		Object o1 = new Object();
		Object n1 = null;
		assertTrue(cm1.equals(cm2));
		assertFalse(cm1.equals(cm3));
		assertFalse(cm1.equals(cm4));
		assertFalse(cm1.equals(cm5));
		assertFalse(cm1.equals(cm6));
		assertFalse(cm1.equals(o1));
		assertFalse(cm1.equals(n1));
	}

	@Test
	public void testGetCrimeData() {
		ArrayList<CrimeData> cdl1 = new ArrayList<CrimeData>();
		cdl1.add(new CrimeData("Commercial Break and Enter",
				2014, 1, "8XX BEATTY ST"));
		cdl1.add(new CrimeData("Mischief Over $5000",
				2013, 2, "9XX BEATTY ST"));
		cdl1.add(new CrimeData("Mischief Under $5000",
				2012, 3, "10XX BEATTY ST"));
		cdl1.add(new CrimeData("Theft From Auto Over $5000",
				2011, 4, "11XX BEATTY ST"));
		cdl1.add(new CrimeData("Theft From Auto Under $5000",
				2010, 5, "12XX BEATTY ST"));
		cdl1.add(new CrimeData("Theft Of Auto Over $5000",
				2009, 6, "13XX BEATTY ST"));
		cdl1.add(new CrimeData("Theft Of Auto Under $5000",
				2008, 7, "14XX BEATTY ST"));
		int id = 1;
		for(CrimeData cd: cdl1){
			cd.setID(id);
			id++;
		}

		ArrayList<CrimeData> cdl2 = cdsi.parseCrimeData("file:./test/test.csv");
		
		assertTrue(cdl1.size() == cdl2.size());
		for (int i = 0; i < 7; i++) {
			assertTrue(cdl1.get(i).equals(cdl2.get(i)));
		}
	}

	@Test 
	public void testCrimeDataYear(){
		//testing year
		assertEquals(crimeYear, 2003);
	}

	@Test 
	public void testNumberOfOccurences(){
		//testing number of occurrences
		int num = cdl2003.getNumberOfCrimeTypeOccurrences(crimeType);
		assertEquals(crimeTypeNum, num);
	}
}
