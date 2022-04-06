package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @Test
    public void registrationSuccess() {
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        System.out.println(index);

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("sonya"+index+"@gmail.com","Sonya2022$");
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isLoginRegistrationSuccess());
    }
}
