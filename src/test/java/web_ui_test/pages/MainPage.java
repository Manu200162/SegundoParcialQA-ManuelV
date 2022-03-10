package web_ui_test.pages;

import io.cucumber.java.bs.I;
import org.openqa.selenium.By;
import web_ui_test.control.Image;

public class MainPage {
    public Image loginImage= new Image(By.xpath("//img[@src='/Images/design/pagelogin.png']"));
}
