package com.library.utilities;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A utility class for browser-related operations.
 */
public class BrowserUtils {

    /**
     * Switches to the window with the expected URL and verifies the expected title.
     *
     * @param expectedURL   Expected URL to be found in the window.
     * @param expectedTitle Expected title of the window.
     * @return true if the title contains the expectedTitle, false otherwise.
     */
    public static boolean switchWindowAndVerify(String expectedURL, String expectedTitle) {

        // Get all window handles
        Set<String> allHandles = Driver.getDriver().getWindowHandles();

        // Iterate through each handle
        for (String eachHandle : allHandles) {

            // Switch to the window
            Driver.getDriver().switchTo().window(eachHandle);

            // Check if the current URL contains the expectedURL
            if (Driver.getDriver().getCurrentUrl().contains(expectedURL)) {

                // If found, break the loop
                break;
            }
        }

        // Return whether the title contains the expectedTitle
        return Driver.getDriver().getTitle().contains(expectedTitle);
    }

    /**
     * Switches to a browser window with a specific title.
     * If the window with the specified title is not found, it switches back to the original window.
     *
     * @param targetTitle The title of the window to switch to.
     */
    public static void switchToWindow(String targetTitle) {
        // Store the handle of the original window
        String origin = Driver.getDriver().getWindowHandle();

        // Iterate through all window handles
        for (String handle : Driver.getDriver().getWindowHandles()) {
            // Switch to the window with the current handle
            Driver.getDriver().switchTo().window(handle);

            // If the title matches the target title, exit the method
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }

        // If the target window is not found, switch back to the original window
        Driver.getDriver().switchTo().window(origin);
    }

    /**
     * Utility method to perform a hover action on a WebElement.
     * @param element The WebElement to hover over.
     */
    public static void hover(WebElement element) {
        // Create an Actions object with the WebDriver instance
        Actions actions = new Actions(Driver.getDriver());

        // Perform the hover action on the specified element
        actions.moveToElement(element).perform();
    }

    /**
     * Utility method to retrieve the text of each WebElement in a list.
     * @param elementsList The list of WebElements from which to retrieve text.
     * @return A list containing the text of each WebElement.
     */
    public static List<String> getElementsText(List<WebElement> elementsList) {
        List<String> elementsTexts = new ArrayList<>();

        // Iterate through each WebElement in the list
        for (WebElement element : elementsList) {
            // Retrieve the text of the WebElement and add it to the list
            elementsTexts.add(element.getText());
        }
        return elementsTexts;
    }

    /**
     * Utility method to retrieve the text of WebElements identified by a locator.
     *
     * @param locator The locator used to identify the WebElements.
     * @return A list containing the text of each WebElement found by the locator.
     */
    public static List<String> getElementsText(By locator) {
        // Find all WebElements matching the provided locator
        List<WebElement> elements = Driver.getDriver().findElements(locator);
        // List to store the text of each WebElement
        List<String> elementsTexts = new ArrayList<>();

        // Iterate through each WebElement in the list
        for (WebElement element : elements) {
            // Get the text of the current WebElement and add it to the list
            elementsTexts.add(element.getText());
        }
        return elementsTexts; // Return the list containing text of each WebElement
    }

    /**
     * Utility method to pause the execution for a specified number of seconds.
     *
     * @param seconds The number of seconds to sleep.
     */
    public static void waitFor(int seconds) {

        // Convert seconds to milliseconds
        seconds *= 1000;

        try {
            // Sleep for the specified number of milliseconds
            Thread.sleep(seconds);

        } catch (InterruptedException e) {

            // If interrupted while sleeping, catch and ignore the exception
        }
    }

    /**
     * Utility method to verify the exact title of the current page.
     * @param expectedTitle The expected title of the page.
     */
    public static void verifyTitle(String expectedTitle) {

        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());
    }

    /**
     * Utility method to verify that the title of the current page contains a specific substring.
     * @param expectedInTitle The substring expected to be contained within the title of the page.
     */
    public static void verifyTitleContains(String expectedInTitle) {

        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));
    }

    /**
     * Utility method to wait for the invisibility of a specific WebElement.
     * @param target The WebElement to wait for invisibility.
     */
    public static void waitForInvisibilityOf(WebElement target) {

        // Create the object of 'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        // Use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    /**
     * Utility method to wait until the title of the current page contains a specific substring.
     * @param title The substring expected to be contained within the title of the page.
     */
    public static void waitForTitleContains(String title) {

        // Create the object of 'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        // Use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.titleContains(title));
    }

    /**
     * Utility method to verify that the current URL contains a specific substring.
     * @param expectedInURL The substring expected to be contained within the current URL.
     */
    public static void verifyURLContains(String expectedInURL) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));
    }



    /**
     * Method to retrieve the options of a dropdown element as strings.
     *
     * @param dropdownElement The dropdown element.
     * @return The list of dropdown options as strings.
     */
    public static List<String> dropdownOptions_as_String(WebElement dropdownElement) {

        // Creating a Select object for the dropdown element
        Select dropdown = new Select(dropdownElement);

        // Getting the list of actual options as WebElements
        List<WebElement> actualOptions_as_WebElement = dropdown.getOptions();

        // Converting the list of actual options from WebElements to strings
        List<String> actualOptions_as_String = new ArrayList<>();

        for (WebElement option : actualOptions_as_WebElement) {
            actualOptions_as_String.add(option.getText());
        }

        return actualOptions_as_String;
    }

    /**
     * Clicks the radio button with the specified attribute value.
     *
     * @param radioButtons   The list of radio buttons.
     * @param attributeValue The attribute value of the radio button to be clicked.
     */
    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue) {

        // Iterate through each radio button in the list
        for (WebElement radioButton : radioButtons) {

            // Check if the current radio button's value matches the specified attribute value
            if (radioButton.getAttribute("value").equals(attributeValue)) {

                // If a match is found, click on the radio button
                radioButton.click();
            }
        }
    }

    /**
     * Utility method to wait for the visibility of a WebElement.
     * @param element The WebElement to wait for visibility.
     * @param time The maximum time to wait for visibility, in seconds.
     * @return The WebElement once it is visible.
     */
    public static WebElement waitForVisibility(WebElement element, int time) {
        // Create WebDriverWait with the provided maximum wait time
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        // Wait until the element becomes visible and return it
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Utility method to wait for a WebElement to be clickable.
     * @param element The WebElement to wait for clickability.
     * @param time The maximum time to wait for the element to be clickable, in seconds.
     * @return The WebElement once it is clickable.
     */
    public static WebElement waitForClickable(WebElement element, int time) {
        // Create WebDriverWait with the provided maximum wait time
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        // Wait until the element becomes clickable and return it
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Utility method to wait for the page to load completely.
     * @param time The maximum time to wait for the page to load, in seconds.
     */
    public static void waitForPageToLoad(long time) {
        // Create an ExpectedCondition to check if the page state is complete
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                // Check if the document state is complete
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };

        try {
            // Create WebDriverWait with the provided maximum wait time
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
            // Wait until the page state becomes complete
            wait.until(expectation);
        } catch (Throwable error) {
            // Print stack trace if any error occurs during waiting
            error.printStackTrace();
        }
    }

    /**
     * Utility method to verify if a WebElement is displayed.
     * @param element The WebElement to verify.
     */
    public static void verifyElementDisplayed(WebElement element) {
        try {
            // Check if the element is displayed
            Assert.assertTrue("Element not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            // If element not found, print stack trace and fail the test
            e.printStackTrace();
            Assert.fail("Element not found: " + element);
        }
    }

    /**
     * Utility method to verify if a WebElement is not displayed.
     * @param element The WebElement to verify.
     */
    public static void verifyElementNotDisplayed(WebElement element) {
        try {
            // Check if the element is not displayed
            Assert.assertFalse("Element should not be visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            // If element not found, print stack trace
            e.printStackTrace();
        }
    }

    /**
     * Utility method to wait for a WebElement to become stale.
     * @param element The WebElement to wait for staleness.
     */
    public static void waitForStaleElement(WebElement element) {
        int y = 0;
        // Retry loop for a maximum of 15 attempts
        while (y <= 15) {
            if (y == 1) {
                try {
                    // Attempt to check if the element is still displayed
                    element.isDisplayed();
                    break; // If the element is still displayed, exit the loop
                } catch (WebDriverException e) {
                    // If StaleElementReferenceException or WebDriverException occurs, retry after a delay
                    y++;
                    try {
                        Thread.sleep(300); // Wait for 300 milliseconds before retrying
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * Utility method to click on a WebElement using JavaScript.
     * @param element The WebElement to click.
     */
    public static void clickWithJS(WebElement element) {
        // Scroll the element into view
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        // Click on the element using JavaScript
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Utility method to scroll to a WebElement using JavaScript.
     * @param element The WebElement to scroll to.
     */
    public static void scrollToElement(WebElement element) {
        // Scroll the element into view
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Utility method to perform a double-click action on a WebElement.
     * @param element The WebElement to double-click.
     */
    public static void doubleClick(WebElement element) {
        // Create an Actions object with the WebDriver instance
        Actions actions = new Actions(Driver.getDriver());

        // Double-click on the provided WebElement
        actions.doubleClick(element).build().perform();
    }

    /**
     * Utility method to set a specific attribute with a given value for a WebElement using JavaScript.
     * @param element The WebElement for which to set the attribute.
     * @param attributeName The name of the attribute to set.
     * @param attributeValue The value to set for the attribute.
     */
    public static void setAttribute(WebElement element, String attributeName, String attributeValue) {
        // Execute JavaScript to set the attribute with the given value for the WebElement
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, attributeValue);
    }

    /**
     * Utility method to highlight a WebElement on a web page by changing its background color and adding a border.
     * @param element The WebElement to highlight.
     */
    public static void highlight(WebElement element) {
        // Execute JavaScript to set the highlight style for the WebElement
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

        // Wait for a short duration to allow the highlight effect to be visible
        waitFor(1);

        // Execute JavaScript to remove the highlight style for the WebElement
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].removeAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    /**
     * Utility method to select or deselect a checkbox WebElement based on a boolean value.
     * @param element The checkbox WebElement to interact with.
     * @param check A boolean indicating whether to select (true) or deselect (false) the checkbox.
     */
    public static void selectCheckBox(WebElement element, boolean check) {
        // If check is true and the checkbox is not selected, click to select it
        if (check && !element.isSelected()) {
            element.click();
        }
        // If check is false and the checkbox is selected, click to deselect it
        else if (!check && element.isSelected()) {
            element.click();
        }
    }

    /**
     * Utility method to click on a WebElement within a specified timeout period.
     * @param element The WebElement to click.
     * @param timeout The maximum number of attempts to click on the element before timing out, in seconds.
     */
    public static void clickWithTimeOut(WebElement element, int timeout) {
        // Attempt to click on the element within the specified timeout period
        for (int i = 0; i < timeout; i++) {
            try {
                // Try to click on the element
                element.click();
                return; // If successful, exit the loop
            } catch (WebDriverException e) {
                // If a WebDriverException occurs (e.g., element not clickable), wait for a short duration before retrying
                waitFor(1); // Assuming waitFor method is implemented elsewhere to wait for a specified duration
            }
        }
    }

    /**
     * Utility method to execute JavaScript commands on a WebElement.
     * @param element The WebElement on which to execute the JavaScript command.
     * @param command The JavaScript command to execute.
     */
    public static void executeJsCommand(WebElement element, String command) {
        // Cast the WebDriver instance to JavascriptExecutor
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        // Execute the JavaScript command on the WebElement
        jse.executeScript(command, element);
    }

    /**
     * Utility method to click on an element specified by a locator with a specified number of attempts.
     * @param by The locator of the element to click.
     * @param attempts The maximum number of attempts to click on the element.
     */
    public static void clickWithWait(By by, int attempts) {
        int counter = 0;

        // Click on the element as many times as specified in the attempts parameter
        while (counter < attempts) {
            try {
                // Find the element again before clicking (refreshing the reference)
                clickWithJS(Driver.getDriver().findElement(by));
                // If the click is successful, exit the loop
                break;
            } catch (WebDriverException e) {
                // If the click fails, print the exception and the attempt number
                e.printStackTrace();
                ++counter;
                // Wait for 1 second before attempting to click again
                waitFor(1);
            }
        }
    }

    /**
     * Utility method to wait until an element specified by a locator is present in the DOM.
     * @param by The locator used to identify the element.
     * @param time The maximum time to wait for the element to be present, in seconds.
     */
    public static void waitForPresenceOfElement(By by, long time) {
        // Create a WebDriverWait instance with the specified maximum wait time
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        // Wait until the element specified by the locator is present in the DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

}