package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends TestBase {

    @Test
    public void loginSuccess(){
        //open login form
        WebElement loginItem = wd.findElement(By.cssSelector("[href='/login']"));
        loginItem.click();
        //fill email
        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("sveta.mail.il@gmail.com");

        //fill password
        WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("Sveta2022$");
        //click button Login
        wd.findElement(By.xpath("//*[text()=' Login']")).click();

        Assert.assertTrue(wd.findElements(By.xpath("//*[text()='Sign Out']")).size()>0);
        //Assert.assertTrue(sing_out_present?);
    }
    @Test
    public void loginSuccessNew(){
        //open login form
        click(By.cssSelector("[href='/login']"));
        //fill email
        type(By.xpath("//input[1]"),"sveta.mail.il@gmail.com");
        //fill password
        type(By.xpath("//input[2]"),"Sveta2022$");
        //click button login
        click(By.xpath("//*[text()=' Login']"));

        Assert.assertTrue(isElementPresent(By.xpath("//*[text()='Sign Out']")));

    }


}
