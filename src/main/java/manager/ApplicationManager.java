package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

   // WebDriver wd;

    EventFiringWebDriver wd;
    HelperUser helperUser;
    HelperContact contact;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public void init() {
        wd = new EventFiringWebDriver(new ChromeDriver());
        logger.info("All test start in ChromeDriver");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
        logger.info("The link is --> "+wd.getCurrentUrl());
        helperUser = new HelperUser(wd);
        contact = new HelperContact(wd);

        wd.register(new MyListener());
    }
    public void stop() {
      //  wd.quit();
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperContact contact() {
        return contact;
    }
}
