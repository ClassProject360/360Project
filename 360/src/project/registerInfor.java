/**
 * To write and read information of customer, read specific line and read how may user or line.   
 * @author Nick manachaichana, Chris Kubec
 */
package project;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class registerInfor {
	
	private int id;
	private String fileName;
	private String imgPath = "../360/submissions/";
	
	public registerInfor(){
		fileName = "../360/submissions/infor.txt";
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
			String address, String city, String state, String zip, String phone, String email, File image){
		
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
		    		+ "   Phone: " + phone + "   Email: " + email + " Score" + id + ": 0\n");
		    bufferedWriter.close();
		    
		    /* Code snippet through finally found on Stack Overflow modified for use
		     *  in our project giving credit where credit is due.
		     *  URL: http://stackoverflow.com/questions/106770/standard-concise-way-to-copy-a-file-in-java
		     */
		    File destFile = new File(imgPath + "ID_" + id + ".png");
		    
		    if(!destFile.exists()) {
		        destFile.createNewFile();
		    }

		    FileChannel source = null;
		    FileChannel destination = null;

		    try {
		        source = new FileInputStream(image).getChannel();
		        destination = new FileOutputStream(destFile).getChannel();
		        destination.transferFrom(source, 0, source.size());
		    }
		    finally {
		        if(source != null) {
		            source.close();
		        }
		        if(destination != null) {
		            destination.close();
		        }
		    }

		} catch(IOException e) {
		    System.out.println("COULD NOT OPEN FILE!!");
		}
		
		
	}
	
	public String getFile() throws FileNotFoundException{
		String fileData = new Scanner(new File(fileName)).useDelimiter("\\A").next();
		return fileData;
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
			return line;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}
	
	/**
	 * Update the data to the file
	 * @param data
	 * @throws IOException
	 */
	public void updateData(String data) throws IOException{
		File out = new File(fileName);
		FileWriter fileW = new FileWriter(out, false);
		BufferedWriter bufferedWriter = new BufferedWriter(fileW);
	    bufferedWriter.write(data);
	    bufferedWriter.close();
	}

}
