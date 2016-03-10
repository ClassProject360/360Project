package project;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class registerInfor {
	
	private int id;
	private String fileName;
	
	public registerInfor(){
		fileName = "src/project/infor.txt";
	}
	
	/**
	 * To write user information into the txt file after user click submit
	 * 
	 * @param name 
	 * @param lastName
	 * @param age
	 * @param sex
	 * @param address
	 * @param city
	 * @param state
	 * @param zip
	 * @param phone
	 * @param email
	 */
	public void cusInfor(String name, String lastName, String age, String sex, 
			String address, String city, String state, String zip, String phone, String email){
		
		try {
			if(numofline() == 0){
				id =1;
			} else {
				id = numofline() + 1;
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// write information to file infor.txt
		File log = new File(fileName);

		try{
		    if(!log.exists()){
		       // System.out.println("We had to make a new file.");
		        log.createNewFile();
		    }

		    FileWriter fileWriter = new FileWriter(log, true);

		    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		    bufferedWriter.write("ID: " + id + "   Name: " + name + " " + lastName 
		    		+ "   Age: " + age + "   Sex: " + sex 
		    		+ "   Address: " + address + " " + city 
		    		+ " " + state + " " + zip
		    		+ "   Phone: " + phone + "   Email: " + email + "\n");
		    bufferedWriter.close();

		} catch(IOException e) {
		    System.out.println("COULD NOT OPEN FILE!!");
		}
		
		
	}
	
	/**
	 * To count the number of line so that we can assignt an Id to the user
	 * @return number of line
	 * @throws IOException
	 */
	public int numofline() throws IOException{
		BufferedInputStream is = new BufferedInputStream(new FileInputStream(fileName));
	    try {
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        boolean empty = true;
	        while ((readChars = is.read(c)) != -1) {
	            empty = false;
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n') {
	                    ++count;
	                }
	            }
	        }

	        return (count == 0 && !empty) ? 1 : count;

	    } finally {
	        is.close();
	    }
	    
	}
	
	/**
	 * to read to information of that line number start at line 0 
	 * @param lineNum
	 * @return information of customer at that line 
	 */
	public String readfromLine(int lineNum){
		String line = null;
		try {
			
			line = Files.readAllLines(Paths.get(fileName)).get(lineNum);
			//System.out.println(line);
			return line;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
		
	}
	

}
