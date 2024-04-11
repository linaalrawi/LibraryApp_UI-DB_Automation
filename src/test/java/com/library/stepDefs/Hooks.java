package com.library.stepDefs;

import com.library.utilities.BrowserUtils;
import com.library.utilities.ConfigurationReader;
import com.library.utilities.DataBaseUtils;
import com.library.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * This class contains Cucumber hooks for setup and teardown operations.
 */
public class Hooks {

    /**
     * Method to execute before scenarios tagged with "ui".
     */
    @Before("@ui")
    public void setupMethod() {
        // Open the browser and navigate to the specified URL before each scenario
        Driver.getDriver().get(ConfigurationReader.getProperty("library_url"));
    }

    /**
     * Method to execute after scenarios tagged with "@ui".
     *
     * @param scenario The scenario object representing the current scenario.
     */
    @After("@ui")
    public void tearDown(Scenario scenario) {
        // Check if the scenario has failed
        if (scenario.isFailed()) {
            // Take a screenshot of the current state of the browser
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            // Attach the screenshot to the scenario report
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        // Close the browser after each scenario
        Driver.closeDriver();
    }

    /**
     * Method to execute before scenarios tagged with "@db".
     */
    @Before("@db")
    public void setupDB() {
        // Establish a connection to the database before scenarios tagged with "@db"
        DataBaseUtils.createConnection();

    }

    /**
     * Method to execute after scenarios tagged with "@db".
     */
    @After("@db")
    public void closeDB() {
        // Close the database connection after scenarios tagged with "@db"
        DataBaseUtils.destroy();
    }
}
