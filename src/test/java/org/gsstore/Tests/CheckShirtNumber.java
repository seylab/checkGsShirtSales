package org.gsstore.Tests;

import org.junit.After;
import org.junit.Test;
import org.gsstore.utilities.BrowserUtils;
import org.gsstore.utilities.Driver;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CheckShirtNumber extends IndexPage {

    LocalDate today = LocalDate.now();
    LocalTime now = LocalTime.now();


    @After
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void ShirtNumberAndSaveToCSV() throws IOException {
        Driver.get().get("https://www.gsstore.org/");
        Driver.get().manage().window().maximize();

        BrowserUtils.waitForPageToLoad(30);

        String quantityString = homePage.counter.getAttribute("data-quantity");
        int quantity = Integer.parseInt(quantityString);

        // Format date to "17.07.2024"
        String formattedDate = today.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String formattedTime = now.format(DateTimeFormatter.ofPattern("HH:mm"));


        // Prepare data for CSV
        String csvData = formattedDate + "," + formattedTime + "," + quantity;

        // Write data to CSV file in append mode
//        homePage.writeDataToCSV(csvData, "shirt_numbers.csv");
        homePage.writeDataToCSV(csvData, "C:\\Users\\MehmetOlgun\\AquaProjects\\checkGsShirtSales\\shirt_numbers.csv");

        System.out.println("Tarih ve Forma satis adedi : " + csvData);
    }

    @Test
    public void ShirtNumberAndSaveToDB()  {
        Driver.get().get("https://www.gsstore.org/");
        Driver.get().manage().window().maximize();

        BrowserUtils.waitForPageToLoad(30);

        String quantityString = homePage.counter.getAttribute("data-quantity");
        int quantity = Integer.parseInt(quantityString);

        // Format date to "17.07.2024"
        String formattedDate = today.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String formattedTime = now.format(DateTimeFormatter.ofPattern("HH:mm"));

        // Prepare data for CSV
        String csvData = formattedDate + "," + formattedTime + "," + quantity;
        homePage.saveToDB(formattedDate, formattedTime, quantityString);

        System.out.println("Tarih ve Forma satis adedi : " + csvData);
    }


}
