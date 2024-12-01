package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {
    private final String directoryPath;
    private final String filePrefix;

    public TextFileReader(String directoryPath, String filePrefix) {
        this.directoryPath = directoryPath;
        this.filePrefix = filePrefix;
    }

    public String read(int beg, int end) throws IOException {
        StringBuilder content = new StringBuilder();

        for (int i = beg; i <= end; i++) {
            String fileName = directoryPath + "/" + filePrefix + i;
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append(System.lineSeparator());
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + fileName);
                throw e;
            }
        }

        return content.toString();
    }
}
