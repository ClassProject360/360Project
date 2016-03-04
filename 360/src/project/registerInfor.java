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
	
	public void cusInfor(String name, String lastName, String age, String sex, 
			String address, String city, String state, String zip, String phone, String email){
		
//		System.out.println("name lastname = " + name +" " + lastName + "\n");
//		System.out.println(" age and sexe = " + age +" " + sex + "\n");
//		System.out.println("address city = " + address +" " + city + "\n");
//		System.out.println("state zipcode = " + state +" " + zip + "\n");
//		System.out.println("phone  email = " + phone +" " + email + "\n");
		
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
		File log = new File("src/project/infor.txt");

		try{
		    if(!log.exists()){
		       // System.out.println("We had to make a new file.");
		        log.createNewFile();
		    }

		    FileWriter fileWriter = new FileWriter(log, true);

		    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		    bufferedWriter.write("ID " + id + " name " + name + " lastname " + lastName 
		    		+ "age " + age + " sex " + sex 
		    		+ "address " + address + " city " + city 
		    		+ "state " + state + " zipcode " + zip
		    		+ "phone " + phone + " email " + email + "\n");
		    bufferedWriter.close();

		   // System.out.println("Done");
		} catch(IOException e) {
		    System.out.println("COULD NOT OPEN FILE!!");
		}
		
		
	}
	
	public static int numofline() throws IOException{
		BufferedInputStream is = new BufferedInputStream(new FileInputStream("src/project/infor.txt"));
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
	public static String readfromLine(int lineNum){
		String line = null;
		try {
			
			line = Files.readAllLines(Paths.get("src/project/infor.txt")).get(lineNum);
			System.out.println(line);
			return line;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return line;
		
	}
	
//	public static void main(String[] args) {
//		readfromLine(1);
//	}

}
