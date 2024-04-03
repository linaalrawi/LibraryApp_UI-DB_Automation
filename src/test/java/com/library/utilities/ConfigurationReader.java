package com.library.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigurationReader is a utility class to read configuration properties from a file.
 */
public class ConfigurationReader {

    // Using private static fields to hold properties to ensure they are accessible only within this class
    private static Properties properties = new Properties();

    // Static initializer block to load properties from the file when the class is loaded
    static {

        try {

            // Loading properties from a file named "configuration.properties"
            FileInputStream fis = new FileInputStream("configuration.properties");

            // Loading properties from the file
            properties.load(fis);

            // Closing the FileInputStream
            fis.close();

        } catch (IOException e) {

            // Handling file not found exception
            System.out.println("FILE NOT FOUND WITH GIVEN PATH!!!");

            // Printing stack trace for debugging purposes
            e.printStackTrace();

        }
    }

    /**
     * Get the value of a property by its keyword.
     *
     * @param keyword The keyword of the property whose value is to be retrieved.
     * @return The value of the property corresponding to the given keyword.
     */
    public static String getProperty(String keyword) {

        // Returning the value of the property associated with the given keyword
        return properties.getProperty(keyword);

    }
}