/**
 * Testing class for backend logic.
 * 
 * Author: Nick Manachaichana
 */
package test;

import java.io.IOException;

import project.registerInfor;

/**
 * Test the registerInfor class which is the only non-GUI class
 * registerInfor will write user information to the file and it can read specific line 
 * and how many user or line in the file.
 * 
 * @author sawet manachaichana
 *
 */
public class registerTest {
	private registerInfor regisinfor;
	int line;
	private String infor;

	@Before
	public void setUp() throws Exception {
		regisinfor = new registerInfor();
	}

	/**
	 * Check if the numOfLine return the same number of how many line in the file
	 * In this case assume that we have 3 user or 3 line.
	 */
	@Test
	public void testNumOfLine() {
		try {
			line = regisinfor.numofline();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(line);
		assertEquals("Compare number of line in the current file(4 line)",
				line, 4);
	}

	/**
	 * Check if the readFromLine return the same result of the first line or line 0
	 */
	@Test
	public void testReadfromLine() {
		infor = regisinfor.readfromLine(3);
		assertEquals(
				"Compare infor of line 0 or ID 1",infor,
				"ID: 4   Name: John Smith   Age: 34   Sex: M   Address: 1234 34Th st Tacoma WA 98506   Phone: 2134672849   Email: John@email.com Score4: 0");
	}

}
