package com.library.pages;

import com.library.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class BorrowingBooksPage extends BasePage{

    public BorrowingBooksPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
