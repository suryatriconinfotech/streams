import java.io.*;

public class FileIOExample {

    public static void main(String[] args) {

        String inputFilePath ="./input.txt";
        String outputFilePath = "./output.txt";

        String contentToWrite="";
        try {
            FileInputStream fis = new FileInputStream(inputFilePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Read from file: " + line);
                contentToWrite+=line;
            }
            br.close();
            fis.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: The file was not found.");

        } catch (IOException e) {
            System.err.println("Error: An I/O error occurred.");
       
        }


        //String contentToWrite = "This is a sample text to write into the file.";

        try {
            FileOutputStream fos = new FileOutputStream(outputFilePath);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write(contentToWrite);
            System.out.println("Successfully wrote to the file.");
            bw.close();
            fos.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: The file could not be created or opened.");

        } catch (IOException e) {
            System.err.println("Error: An I/O error occurred while writing to the file.");

        }
    }
}