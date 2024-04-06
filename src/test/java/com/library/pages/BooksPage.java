package com.library.pages;

import com.library.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class BooksPage extends BasePage{

    public BooksPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
