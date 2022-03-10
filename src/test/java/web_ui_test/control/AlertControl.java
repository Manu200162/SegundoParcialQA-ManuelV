package web_ui_test.control;

import org.openqa.selenium.Alert;
import web_ui_test.singleton.Session;

public class AlertControl {

    public void alertAccept(){
        Alert alert = Session.getInstance().getDriver().switchTo().alert();
        alert.accept();
    }

    public void alertDismiss(){
        Alert alert = Session.getInstance().getDriver().switchTo().alert();
        alert.dismiss();
    }

}