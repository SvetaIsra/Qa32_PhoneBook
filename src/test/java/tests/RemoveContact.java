package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContact extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (!app.getHelperUser().isSignOutPresent()) {
            app.getHelperUser().login(new User().withEmail("sveta.mail.il@gmail.com").withPassword("Sveta2022$"));
        }
    }

    @Test(enabled = false)
    public void removeOneContact() {
        app.contact().openAllContactsForm();
        app.contact().removeContact("1234567640");

        Assert.assertTrue(app.contact().isRemovedOneContactSuccess("1234567640"));
        logger.info("test passed");
    }

    @Test(groups = {"web"}, priority = 1)
    public void removeOneContact2() {
        Assert.assertEquals(app.contact().removeOneContact(), 1);
    }

    @Test(enabled = false)
    public void removeAllContacts() {
        app.contact().openAllContactsForm();
        app.contact().removeAllContacts();

        Assert.assertTrue(app.contact().isRemovedAllContactsSuccess());
        logger.info("test passed");
    }

    //  @Test (dependsOnMethods = "removeOneContact2")
    @Test(priority = 2)
    public void removeAllContacts2() {
        app.contact().removeAllContacts2();

        Assert.assertTrue(app.contact().isRemovedAllContactsSuccess());
        logger.info("test passed");

    }
}
