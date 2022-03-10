package web_ui_test.pages;

import org.openqa.selenium.By;
import web_ui_test.control.Button;

public class LeftMenu {
    public Button recyclerBinOptions = new Button(By.xpath("//div[@itemid=\"-3\"]//img"));
    public Button emptyRecycleBinButton = new Button(By.xpath("//a[@href='#emptyRecycle']"));
}
