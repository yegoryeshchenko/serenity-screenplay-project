package serenityswag.cart;

import java.util.ArrayList;
import java.util.List;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.saucedemo.com/cart.html")
public class CartPageObject extends PageObject {

  @FindBy(id = "checkout")
  WebElementFacade checkoutButton;

  private static By CHECKOUT_BUTTON = By.id("checkout");
  private static By TITLE = By.cssSelector(".title");
  private static By CART_ITEMS = By.cssSelector(".cart_item");

  @FindBy(css = ".title")
  WebElementFacade title;

  @FindBy(className = "cart_item")
  List<WebElementFacade> cartItemElements;

  public void checkout() {
    $(CHECKOUT_BUTTON).click();
    checkoutButton.click();
  }

  public String getTitleText() {
    return $(TITLE).getText();
  }

  public List<CartItem> items() {
    return findAll(CART_ITEMS).map(
        item -> new CartItem(
            item.findBy(".inventory_item_name").getText(),
            item.findBy(".inventory_item_desc").getText(),
            priceFrom(item.findBy(".inventory_item_price").getText())
        )
    );
  }

  private Double priceFrom(String textValue) {
    return Double.parseDouble(textValue.replace("$", ""));
  }

}
