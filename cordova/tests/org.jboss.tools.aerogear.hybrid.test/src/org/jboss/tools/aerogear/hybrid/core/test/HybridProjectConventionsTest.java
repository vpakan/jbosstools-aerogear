package org.jboss.tools.aerogear.hybrid.core.test;

import org.eclipse.core.runtime.IStatus;
import org.jboss.tools.aerogear.hybrid.core.HybridProjectConventions;
import org.junit.Test;

import static org.junit.Assert.*;

public class HybridProjectConventionsTest {
	
	@Test
	public void testProjectNameValidationInvalids(){
		String[] invalidNames = {"","9","!project", " ", "9abc"};
		for (int i = 0; i < invalidNames.length; i++) {
			IStatus status = HybridProjectConventions.validateProjectName(invalidNames[i]);
			assertEquals(invalidNames[i] +" is validated as a project name but it should NOT", status.getSeverity(), IStatus.ERROR);			
		}
	}

	@Test
	public void testProjectNameValidationValids(){
		String[] validNames = {"My","MyProject"};
		for (int i = 0; i < validNames.length; i++) {
			IStatus status = HybridProjectConventions.validateProjectName(validNames[i]);
			assertEquals(validNames[i] +" is NOT validated as a project name but it should", status.getSeverity(), IStatus.OK);			
		}
	}
	
	@Test
	public void testProjectIDValidationInvalids(){
		String[] invalidIDs= {"","A", "9", "!id", " ", "9a.123", "ab", "_abc.def"};
		for (int i = 0; i < invalidIDs.length; i++) {
			IStatus status = HybridProjectConventions.validateProjectID(invalidIDs[i]);
			assertEquals(invalidIDs[i] +" is validated as a project ID but it should NOT",
					status.getSeverity(), IStatus.ERROR);
		}
	}

	@Test
	public void testProjectIDValidationValids(){
		String[] validIDs= {"abc.cde", "abc.cde.fgh", "A123._456","abc.cd_ef" };
		for (int i = 0; i < validIDs.length; i++) {
			IStatus status = HybridProjectConventions.validateProjectID(validIDs[i]);
			assertEquals(validIDs[i] +" is NOT validated as a project ID but it should",
					status.getSeverity(), IStatus.OK);
		}
	}
	
	@Test
	public void testApplicationNameValidationInvalids(){
		String[] appNames = {""," "};
		for (int i = 0; i < appNames.length; i++) {
			IStatus status = HybridProjectConventions.validateApplicationName(appNames[i]);
			assertEquals(appNames[i] + " is validated as an application name but it should NOT",
					status.getSeverity(), IStatus.ERROR);
		}
		IStatus warnStatus = HybridProjectConventions.validateApplicationName("012345678901234567890123456");
		assertEquals(warnStatus.getSeverity(), IStatus.WARNING);
	}

	@Test
	public void testApplicationNameValidationValids(){
		String[] appNames = {"My","My Project" ,"1 Project","A long project name", "A" };
		for (int i = 0; i < appNames.length; i++) {
			IStatus status = HybridProjectConventions.validateApplicationName(appNames[i]);
			assertEquals(appNames[i] + " is NOT validated as an application name but it should NOT",
					status.getSeverity(), IStatus.OK);
		}
	}
	
	
}
