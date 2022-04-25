package tests;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isSignOutPresent()){
            app.getHelperUser().signOut();
        }
    }

    @Test(dataProvider = "validLoginData",dataProviderClass = MyDataProvider.class)
    public void loginSuccessNew(String email, String password){
        logger.info("Test start with email : " +email+ " and password : "+password+"");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email,password);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());
        logger.info("test passed");
    }
    @Test
    public void loginSuccessModel(){
        User user = new User().withEmail("sveta.mail.il@gmail.com").withPassword("Sveta2022$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());
    }
    @Test
    public void LoginNegativeTestWrongPassword() {
        User user = new User().withEmail("sveta.mail.il@gmail.com").withPassword("Sveta");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLoginRegistrationSuccess());
        Assert.assertTrue(app.getHelperUser().isAlertDisplayed());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());

    }
}
