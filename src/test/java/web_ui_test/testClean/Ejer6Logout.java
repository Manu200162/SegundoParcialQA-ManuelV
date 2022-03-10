package web_ui_test.testClean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import web_ui_test.pagesTodoist.LoginPage;
import web_ui_test.pagesTodoist.MainPage;
import web_ui_test.pagesTodoist.TopBarTools;

public class Ejer6Logout extends BaseTodoist{
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    TopBarTools topBarTools = new TopBarTools();
    String email="manli2001@hotmail.es";
    String password="PruebaWeb123";

    @Test
    public void verifyLogOut() throws InterruptedException {
        //Log in
        Thread.sleep(2000);
        mainPage.loginButton.click();
        loginPage.emailTxtBox.setText(email);
        loginPage.passwordTxtBox.setText(password);
        loginPage.loginButton.click();
        topBarTools.avatarMenuButton.click();
        Thread.sleep(2000);
        Assertions.assertTrue(topBarTools.logoutButton.isControlDisplayed(),"ERROR, no se hizo log in");

        //Log out
        topBarTools.logoutButton.click();
        Thread.sleep(3000);
        Assertions.assertTrue(mainPage.loginButton.isControlDisplayed());

    }
}
