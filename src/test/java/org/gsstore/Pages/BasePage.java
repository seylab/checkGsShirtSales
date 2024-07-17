package org.gsstore.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.gsstore.utilities.Driver;

public abstract class BasePage {


    @FindBy(css = ".js-shirt-counter.tick[data-quantity]")
    public WebElement counter;


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
}
