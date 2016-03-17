import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.UUID;



public class test {

	public static void main(final String args[]) throws Exception {
	    File f = File.createTempFile(test.class.getName(), "src/test.txt");
	    f.deleteOnExit();

	    System.out.println(f.getPath());

	    // put some dummy content into our file
	    BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
	    for (int i = 0; i < 1000; i++) {
	        w.write(UUID.randomUUID().toString());
	        w.write('\n');
	    }
	    w.flush();
	    w.close();

	            // append "some uuids" to our file
	    int bufLength = 4096;
	    byte[] appendBuf = "some uuids\n".getBytes();
	    byte[] writeBuf = appendBuf;
	    byte[] readBuf = new byte[bufLength];

	    int writeBytes = writeBuf.length;

	    RandomAccessFile rw = new RandomAccessFile(f, "rw");
	    int read = 0;
	    int write = 0;

	    while (true) {
	                    // seek to read position and read content into read buffer
	        rw.seek(read);
	        int bytesRead = rw.read(readBuf, 0, readBuf.length);

	                    // seek to write position and write content from write buffer
	        rw.seek(write);
	        rw.write(writeBuf, 0, writeBytes);

	                    // no bytes read - end of file reached
	        if (bytesRead < 0) {
	                            // end of
	            break;
	        }

	                    // update seek positions for write and read
	        read += bytesRead;
	        write += writeBytes;
	        writeBytes = bytesRead;

	                    // reuse buffer, create new one to replace (short) append buf
	        byte[] nextWrite = writeBuf == appendBuf ? new byte[bufLength] : writeBuf;
	        writeBuf = readBuf;
	        readBuf = nextWrite;
	    };

	    rw.close();

	            // now show the content of our file
	    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));

	    String line;
	    while ((line = reader.readLine()) != null) {
	        System.out.println(line);
	    }
	}
	
	
}
