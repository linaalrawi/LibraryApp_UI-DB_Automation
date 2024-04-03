package com.library.utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataBaseUtils {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static ResultSetMetaData rsMetaData;

    /**
     * Creates a database connection using the provided URL, username, and password.
     *
     * @param url      the URL of the database
     * @param username the username for accessing the database
     * @param password the password for accessing the database
     */
    public static void createConnection(String url, String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("CONNECTION SUCCESSFUL");
        } catch (SQLException e) {
            System.out.println("CONNECTION HAS FAILED: " + e.getMessage());
        }
    }

    /**
     * Creates a database connection using properties from the configuration file.
     * Retrieves the database URL, username, and password from the configuration reader.
     */
    public static void createConnection() {
        try {
            // Retrieves database connection properties from the configuration file
            String url = ConfigurationReader.getProperty("library2.db.url"); // Database URL
            String username = ConfigurationReader.getProperty("library2.db.username"); // Database username
            String password = ConfigurationReader.getProperty("library2.db.password"); // Database password

            // Establishes a database connection
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace(); // Prints the exception details if connection fails
        }
    }


    /**
     * Executes the specified SQL query and returns the result set.
     *
     * @param sql the SQL query to execute
     * @return the result set obtained from the query execution
     */
    public static ResultSet runQuery(String sql) {
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(sql); // Execute the query and set the value of ResultSet object
            rsMetaData = resultSet.getMetaData();  // Set the value of ResultSetMetaData for reuse
        } catch (SQLException e) {
            System.out.println("ERROR OCCURRED WHILE RUNNING QUERY: " + e.getMessage());
        }
        return resultSet;
    }

    /**
     * Closes the database resources (ResultSet, Statement, and Connection).
     * Checks if each resource is not null before attempting to close it to avoid NullPointerExceptions.
     */
    public static void destroy() {
        try {
            // Close the ResultSet if it is not null
            if (resultSet != null) {
                resultSet.close();
            }
            // Close the Statement if it is not null
            if (statement != null) {
                statement.close();
            }
            // Close the Connection if it is not null
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions that occur during resource closing
            System.out.println("ERROR OCCURRED WHILE CLOSING RESOURCES: " + e.getMessage());
        }
    }

    /**
     * Resets the cursor of the ResultSet to before the first row.
     * This method is useful when you want to iterate over the ResultSet from the beginning again.
     * If an exception occurs while resetting the cursor, it will be printed to the standard error stream.
     */
    private static void resetCursor() {
        try {
            // Move the cursor to before the first row
            resultSet.beforeFirst();
        } catch (SQLException e) {
            // Print the stack trace of the exception if an error occurs
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the total number of rows in the ResultSet.
     * This method moves the cursor to the last row of the ResultSet to count the rows.
     * If an exception occurs during the process, it will be printed to the standard output stream.
     * Finally, it resets the cursor to before the first row.
     *
     * @return The total number of rows in the ResultSet.
     */
    public static int getRowCount() {
        int rowCount = 0;
        try {
            // Move the cursor to the last row to count the total number of rows
            resultSet.last();
            rowCount = resultSet.getRow();
        } catch (SQLException e) {
            // Print the error message if an exception occurs
            System.out.println("ERROR OCCURRED WHILE GETTING ROW COUNT: " + e.getMessage());
        } finally {
            // Reset the cursor to before the first row regardless of whether an exception occurred
            resetCursor();
        }
        return rowCount;
    }

    /**
     * Retrieves the total number of columns in the ResultSetMetaData.
     * This method gets the column count from the ResultSetMetaData associated with the current ResultSet.
     * If an exception occurs during the process, it will be printed to the standard output stream.
     *
     * @return The total number of columns in the ResultSetMetaData.
     */
    public static int getColumnCount() {
        int columnCount = 0;
        try {
            // Get the column count from the ResultSetMetaData
            columnCount = rsMetaData.getColumnCount();
        } catch (SQLException e) {
            // Print the error message if an exception occurs
            System.out.println("ERROR OCCURRED WHILE GETTING COLUMN COUNT: " + e.getMessage());
        }
        return columnCount;
    }

    /**
     * Retrieves the names of all columns in the ResultSetMetaData as a list of strings.
     * This method iterates through each column in the ResultSetMetaData and adds its name to the list.
     * If an exception occurs during the process, it will be printed to the standard output stream.
     *
     * @return A list containing the names of all columns in the ResultSetMetaData.
     */
    public static List<String> getAllColumnNamesAsList() {
        List<String> columnNameList = new ArrayList<>();
        try {
            // Iterate through each column in the ResultSetMetaData
            for (int colIndex = 1; colIndex <= getColumnCount(); colIndex++) {
                // Get the name of the current column and add it to the list
                String columnName = rsMetaData.getColumnName(colIndex);
                columnNameList.add(columnName);
            }
        } catch (SQLException e) {
            // Print the error message if an exception occurs
            System.out.println("ERROR OCCURRED WHILE getAllColumnNamesAsList: " + e.getMessage());
        }
        return columnNameList;
    }

    /**
     * Retrieves the data of a specified row from the ResultSet as a list of strings.
     * This method moves the cursor to the specified row in the ResultSet, retrieves the data for each column in that row,
     * and adds it to the list. Finally, it resets the cursor to its initial position.
     * If an exception occurs during the process, it will be printed to the standard output stream.
     *
     * @param rowNum The index of the row to retrieve data from.
     * @return A list containing the data of the specified row in the ResultSet.
     */
    public static List<String> getRowDataAsList(int rowNum) {
        List<String> rowDataList = new ArrayList<>();
        int colCount = getColumnCount();
        try {
            // Move the cursor to the specified row in the ResultSet
            resultSet.absolute(rowNum);
            // Iterate through each column in the row and add its data to the list
            for (int colIndex = 1; colIndex <= colCount; colIndex++) {
                String cellValue = resultSet.getString(colIndex);
                rowDataList.add(cellValue);
            }
        } catch (SQLException e) {
            // Print the error message if an exception occurs
            System.out.println("ERROR OCCURRED WHILE getRowDataAsList: " + e.getMessage());
        } finally {
            // Reset the cursor to its initial position
            resetCursor();
        }
        return rowDataList;
    }

    /**
     * Retrieves the value of a specific cell from the ResultSet.
     * This method moves the cursor to the specified row in the ResultSet,
     * retrieves the value of the cell at the specified column index, and returns it as a string.
     * If an exception occurs during the process, it will be printed to the standard output stream.
     *
     * @param rowNum      The index of the row containing the cell.
     * @param columnIndex The index of the column containing the cell.
     * @return The value of the cell at the specified row and column indexes as a string.
     */
    public static String getCellValue(int rowNum, int columnIndex) {
        String cellValue = "";
        try {
            // Move the cursor to the specified row in the ResultSet
            resultSet.absolute(rowNum);
            // Retrieve the value of the cell at the specified column index
            cellValue = resultSet.getString(columnIndex);
        } catch (SQLException e) {
            // Print the error message if an exception occurs
            System.out.println("ERROR OCCURRED WHILE getCellValue: " + e.getMessage());
        } finally {
            // Reset the cursor to its initial position
            resetCursor();
        }
        return cellValue;
    }

    /**
     * Retrieves the value of the cell located at the first row and first column of the ResultSet.
     * This method internally calls the getCellValue() method with row index 1 and column index 1,
     * then returns the value of the cell as a string.
     *
     * @return The value of the cell at the first row and first column of the ResultSet as a string.
     */
    public static String getFirstRowFirstColumn() {
        return getCellValue(1, 1);
    }

    /**
     * Retrieves the data of a specified column from all rows in the ResultSet.
     * This method iterates through all rows of the ResultSet, retrieves the value of the specified column,
     * and adds it to a list. The list containing column data from all rows is returned.
     *
     * @param columnNum The index of the column to retrieve data from.
     * @return A list containing the data of the specified column from all rows of the ResultSet.
     */
    public static List<String> getColumnDataAsList(int columnNum) {
        List<String> columnDataLst = new ArrayList<>();
        try {
            // Iterates through all rows of the ResultSet
            while (resultSet.next()) {
                // Retrieves the value of the specified column from the current row
                String cellValue = resultSet.getString(columnNum);
                // Adds the retrieved value to the list
                columnDataLst.add(cellValue);
            }
        } catch (Exception e) {
            // Handles any exceptions that might occur during the process
            System.out.println("ERROR OCCURRED WHILE getColumnDataAsList " + e.getMessage());
        } finally {
            // Resets the cursor position to before the first row to prepare for future iterations
            resetCursor();
        }
        return columnDataLst; // Returns the list containing column data from all rows
    }

    /**
     * Displays all data from the ResultSet.
     * This method iterates through all rows of the ResultSet and displays the data for each row.
     */
    public static void displayAllData() {
        int columnCount = getColumnCount(); // Retrieves the total number of columns in the ResultSet
        resetCursor(); // Resets the cursor position to before the first row
        try {
            while (resultSet.next()) { // Iterates through all rows of the ResultSet
                for (int colIndex = 1; colIndex <= columnCount; colIndex++) {
                    // Displays the data of each column for the current row
                    System.out.printf("%-25s", resultSet.getString(colIndex)); // Adjusts the width of the column
                }
                System.out.println(); // Moves to the next line after displaying data for all columns of the row
            }
        } catch (Exception e) {
            // Handles any exceptions that might occur during the process
            System.out.println("ERROR OCCURRED WHILE displayAllData " + e.getMessage());
        } finally {
            resetCursor(); // Resets the cursor position to before the first row to prepare for future iterations
        }
    }

    /**
     * Retrieves data for a specific row from the ResultSet and stores it in a LinkedHashMap.
     * This method returns a map where each entry represents a column name-value pair for the specified row.
     *
     * @param rowNum the row number for which data needs to be retrieved
     * @return a LinkedHashMap containing column name-value pairs for the specified row
     */
    public static Map<String, String> getRowMap(int rowNum) {
        Map<String, String> rowMap = new LinkedHashMap<>(); // LinkedHashMap preserves the order of insertion
        int columnCount = getColumnCount(); // Retrieves the total number of columns in the ResultSet

        try {
            resultSet.absolute(rowNum); // Moves the cursor to the specified row

            for (int colIndex = 1; colIndex <= columnCount; colIndex++) {
                String columnName = rsMetaData.getColumnName(colIndex); // Retrieves the column name
                String cellValue = resultSet.getString(colIndex); // Retrieves the value of the current cell
                rowMap.put(columnName, cellValue); // Adds the column name-value pair to the map
            }

        } catch (Exception e) {
            // Handles any exceptions that might occur during the process
            System.out.println("ERROR OCCURRED WHILE getRowMap " + e.getMessage());
        } finally {
            resetCursor(); // Resets the cursor position to before the first row
        }

        return rowMap; // Returns the map containing column name-value pairs for the specified row
    }

    /**
     * Retrieves all rows from the ResultSet and stores each row as a map in a list.
     * This method returns a list where each element represents a row, and each row is represented
     * as a LinkedHashMap containing column name-value pairs.
     *
     * @return a list of maps, where each map represents a row from the ResultSet
     */
    public static List<Map<String, String>> getAllRowAsListOfMap() {
        List<Map<String, String>> allRowLstOfMap = new ArrayList<>(); // List to store all rows as maps
        int rowCount = getRowCount(); // Retrieves the total number of rows in the ResultSet

        // Iterates through each row in the ResultSet
        for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
            Map<String, String> rowMap = getRowMap(rowIndex); // Retrieves column name-value pairs for the current row
            allRowLstOfMap.add(rowMap); // Adds the row map to the list
        }

        resetCursor(); // Resets the cursor position to before the first row
        return allRowLstOfMap; // Returns the list containing all rows as maps
    }

}