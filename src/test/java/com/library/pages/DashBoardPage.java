package com.library.pages;

import com.library.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * This class represents the Dashboard page of the application.
 * It provides methods to interact with elements on the Dashboard page.
 */
public class DashBoardPage extends BasePage{

    /**
     * Initializes the elements of the DashBoardPage class using PageFactory.
     */
    public DashBoardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    /**
     * Retrieves the count from the specified field on the Dashboard page.
     *
     * @param fieldName The name of the field to retrieve the count from.
     * @return The count displayed in the specified field.
     */
    public String getFieldCount(String fieldName){
        WebElement countField = Driver.getDriver().findElement(
                By.xpath("//h6[.='"+fieldName+"']/..//h2"));
        return countField.getText();
    }

    /**
     * Retrieves the text from the specified field on the Dashboard page.
     *
     * @param fieldName The name of the field to retrieve the text from.
     * @return The text displayed in the specified field.
     */
    public String getFieldText(String fieldName){
        WebElement textField = Driver.getDriver().findElement(
                By.xpath("//h6[.='"+fieldName+"']"));
        return textField.getText();
    }
}
