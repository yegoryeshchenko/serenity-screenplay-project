package serenityswag.inventory;

import java.util.List;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ProductList extends PageObject {

  public static By addToCartButtonFor(String itemName) {
    return By.xpath("//div[@class='inventory_item'][contains(., '" + itemName + "')]//button");
  }


  public List<String> titles() {
    return $$(".inventory_item_name").textContents();
  }

  public static By productDetailsLinkFor(String itemName) {
    return By.linkText(itemName);
  }

  public String imageTextForProduct(String productName) {
    return $("xpath://div[@class='inventory_item'][contains(., '" + productName + "')]//img")
        .getAttribute("alt");
  }

}
