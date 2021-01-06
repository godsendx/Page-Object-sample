package com.formy.sample.pages;

import com.formy.sample.exceptions.ValidationExceptions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DatepickerPage extends HomePage {

    public DatepickerPage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    @FindBy(id = "datepicker")
    private WebElement datePicker;

    @Override
    public DatepickerPage open() {
        super.open();
        return this;
    }

    @Override
    public String getUrl() {
        return "https://formy-project.herokuapp.com/datepicker";
    }

    public DatepickerPage selectDateInDatepicker(String date) {
        datePicker.sendKeys(date);
        datePicker.sendKeys(Keys.RETURN);
        return this;
    }

    public DatepickerPage isRightDateSelected(String expectedDate) throws ValidationExceptions.WrongElementStateException {
        String text = datePicker.getText();

        if (!expectedDate.equals(text)) {
            throw new ValidationExceptions.WrongElementStateException("Wrong date selected!");
        }

        return this;
    }
}
