package web_ui_test.pages;

import web_ui_test.control.Label;
import org.openqa.selenium.By;

public class CentralSection {
    public Label actualProjectLabel = new Label(By.xpath("//div[@class=\"view_header__content\"]//span[@class]"));
}
