package org.gsstore.Pages;

import java.io.FileWriter;
import java.io.IOException;

public class HomePage extends BasePage{
    public void writeDataToCSV(String data, String fileName) throws IOException {
        FileWriter csvWriter = new FileWriter(fileName, true); // Append mode
        csvWriter.append(data);
        csvWriter.append("\n");
        csvWriter.flush();
        csvWriter.close();
    }
}
