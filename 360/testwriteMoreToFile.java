import java.util.*;
import java.io.*;
 
public class testwriteMoreToFile {
    private RandomAccessFile raf;
    private static String fileToBe;
 
    public void writeMoreToFile(String tagName, String newData) {
        try {
            try { 
                raf = new RandomAccessFile( new File(fileToBe), "rw");
            } catch (FileNotFoundException e) {
                raf = new RandomAccessFile(fileToBe, "rw");
            } 
 
            StringBuffer contents = new StringBuffer();
            String line = null;
            long prevFilePointer = 0;
 
            while ((line = raf.readLine()) != null) {
                if (line.substring(0,tagName.length()).equals(tagName)) {
                    contents.append(line).append(newData).append(",").append(System.getProperty("line.separator"));
                    raf.seek(prevFilePointer);
                    raf.writeChars(contents.toString());
                    break;
                }
                prevFilePointer = raf.getFilePointer();
            }
        } catch (IOException e2) { 
            e2.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException e2) { 
                e2.printStackTrace();
            }
        }
    }
 
    public static void main(String args[]) {
        String[] tagNames = new String[]{ "one dshflsdgknfsld "};
        String line = new String("1");
        String[] lines = new String[5];
        fileToBe = "src/test.txt";
        PrintWriter out = null;
        for(int i = 0; i < lines.length; i++) {
            lines[i] = tagNames[i]+":"+line;
        }
        try {
            out = new PrintWriter(fileToBe);
            for (int i = 0; i < lines.length; i++) {
                out.println(lines[i]);
            }
        } catch (IOException e2) { 
            e2.printStackTrace();
        } finally {
            out.close();
        }
 
        testwriteMoreToFile test = new testwriteMoreToFile();
 
        test.writeMoreToFile(tagNames[1], "6");
    }
}