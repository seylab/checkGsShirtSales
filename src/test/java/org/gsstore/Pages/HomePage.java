package org.gsstore.Pages;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HomePage extends BasePage{

    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String password = "1";

    public void writeDataToCSV(String data, String fileName) throws IOException {
        FileWriter csvWriter = new FileWriter(fileName, true); // Append mode
        csvWriter.append(data);
        csvWriter.append("\n");
        csvWriter.flush();
        csvWriter.close();
    }

    public Connection dbConnection(String url, String user, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void saveToDB(String date, String time, String sales) {
        String sql = "INSERT INTO shirts.shirts (date,time,sales) VALUES (?,?,?)";
        Connection conn = dbConnection(url, user, password);

        try (PreparedStatement statement = conn.prepareStatement(sql);){
            statement.setString(1, date);
            statement.setString(2, time);
            statement.setString(3, sales);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Failed to insert data.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }
}
