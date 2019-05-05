import org.apache.log4j.Logger;

import java.io.*;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        String temporaryString;
        String fileNameOriginal = "./src/main/resources/originalFile.txt";
        String fileNameModified = "./src/main/resources/modifiedFile.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileNameOriginal));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileNameModified))) {
            while ((temporaryString = bufferedReader.readLine()) != null) {
                bufferedWriter.write(RegexpsFormatter.formatMobileNumber(temporaryString));
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            logger.error("File not found!");
        }
    }
}
