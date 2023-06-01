package file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * FileProcessor interface
 */
public interface FileProcessor {
    /**
     * Used to read from a file
     * @param filename to be read from
     * @return read data from file
     */
    static String readFile(String filename) {
        String data = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            data = reader.readLine();
        } catch (IOException e) {
            System.out.printf("Error reading from file: %s", e.getMessage());
        }

        return data;
    }

    /**
     * Used to write to a file
     * @param filename to be written to
     * @param data to be written to file
     */
    static void writeToFile(String filename, String data) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            writer.write(data);
        } catch (IOException e) {
            System.out.printf("Error writing to file: %s", e.getMessage());
        }
    }
}
