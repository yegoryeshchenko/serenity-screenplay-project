package serenityswag.cart;

import java.util.List;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import serenityswag.inventory.ProductList;

public class CartActions extends UIInteractionSteps {

  @Step("Add {0} to the cart")
  public void addItem(String itemName) {
    $(ProductList.addToCartButtonFor(itemName)).click();
  }

  @Step("Add {0} items to the cart")
  public void addItems(List<String> items) {
    items.forEach(this::addItem);
  }

  @Step("open the shopping cart")
  public void openCart() {
    $(ShoppingCartIcon.link()).click();
  }

  public List<String> displayedItems() {
    return findAll(".inventory_item_name").texts();
  }
}
