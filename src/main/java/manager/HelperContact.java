package manager;

import models.Contact;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HelperContact extends HelperBase{
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        click(By.cssSelector("[href='/add']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("[placeholder='Name']"),contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"),contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"),contact.getPhone());
        type(By.cssSelector("[placeholder='email']"),contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"),contact.getAddress());
        type(By.cssSelector("[placeholder='description']"),contact.getDescription());

    }

    public void saveContact() {
        click(By.cssSelector("b"));
        //click(By.cssSelector(".add_form__2rsm2"));
    }

    public boolean isContactByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el:list) {
            if(el.getText().equals(name))
                return true;
        }
        return false;
    }

    public boolean isContactByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el:list) {
            if(el.getText().equals(phone))
                return true;
        }
        return false;
    }
    public  void scroll(int x, int y){
        JavascriptExecutor js  =(JavascriptExecutor) wd;
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public void fillTab() {
        WebElement el = wd.findElement(By.cssSelector("[placeholder='description']"));
        el.sendKeys(Keys.TAB);
    }

    public void openAllContactsForm() {
        click(By.cssSelector("[href='/contacts']"));
    }

    public void removeContact(String phoneNumber) {
        List<WebElement> list = wd.findElements(By.cssSelector(".contact-item_card__2SOIM h3"));
        for (WebElement el:list) {
            if(el.getText().equals(phoneNumber)){
                el.click();
                click(By.xpath("//button[text()='Remove']"));
            }
        }
    }

    public void removeAllContacts() {
        new WebDriverWait(wd,5)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".contact-item_card__2SOIM h3"))));
        List<WebElement> list = wd.findElements(By.cssSelector(".contact-item_card__2SOIM h3"));
        for (WebElement el:list) {
            el.click();
            click(By.xpath("//button[text()='Remove']"));
        }
    }

    public boolean isRemovedAllContactsSuccess() {
        String message = wd.findElement(By.cssSelector(".contact-page_message__2qafk h1")).getText();
        return message.equals("No Contacts here!");
    }

    public boolean isRemovedOneContactSuccess(String phoneNumber) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el:list) {
            if(el.getText().equals(phoneNumber))
                return true;
        }
        return false;
    }

    public int removeOneContact() {
        int countBefore = countOfContacts();
        if(!isCountListEmpty()) {
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[text()='Remove']"));
            pause(500);
        }
        int countAfter = countOfContacts();
        return countBefore-countAfter;
    }

    private boolean isCountListEmpty() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }

    private int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }

    public void removeAllContacts2() {
        while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() != 0) {
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[text()='Remove']"));
            pause(500);
        }
    }

    public void provideContactData() {
        //add.contacts 3/4
    }
}
