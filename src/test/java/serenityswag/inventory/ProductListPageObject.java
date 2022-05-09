package serenityswag.inventory;

import java.util.List;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ProductListPageObject extends PageObject {

  public List<String> titles() {
    return $$(".inventory_item_name").textContents();
  }

  public void openProductDetailsFor(String itemName) {
    find(By.linkText(itemName)).click();
  }

  public String imageTextForProduct(String productName) {
    return $("xpath://div[@class='inventory_item'][contains(., '" + productName + "')]//img")
        .getAttribute("alt");
  }
}
