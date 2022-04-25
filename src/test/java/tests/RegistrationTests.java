package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if(app.getHelperUser().isSignOutPresent()) {
            app.getHelperUser().signOut();
        }
    }

    @Test
    public void registrationSuccess() {
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        logger.info("sonya"+index+"@gmail.com");
        logger.info("The index is -->" +index);

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("sonya"+index+"@gmail.com","Sonya2022$");
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());
    }
}
