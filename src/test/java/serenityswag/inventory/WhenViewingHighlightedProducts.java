package serenityswag.inventory;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.User;
import serenityswag.authentication.actions.LoginActions;


@ExtendWith(SerenityJUnit5Extension.class)
public class WhenViewingHighlightedProducts {

  @Managed(driver = "chrome")
  WebDriver driver;

  @Steps
  LoginActions login;

  ProductListPageObject productList;

  ProductDetailsPageObject productDetails;

  @Test
  public void shouldDisplayHighlightedProductsOnWelcomePage() {
    login.as(User.STANDARD_USER);

    List<String> productsOnDisplay = productList.titles();

    assertThat(productsOnDisplay).hasSize(6)
        .contains("Sauce Labs Backpack");
  }

  @Test
  public void highlightedProductShouldDisplayTheCorrespondingImages() {
    login.as(User.STANDARD_USER);
    List<String> productsOnDisplay = productList.titles();

    SoftAssertions softly = new SoftAssertions();
    productsOnDisplay.forEach(
        productName ->
            softly.assertThat(productList.imageTextForProduct(productName)).isEqualTo(productName));
    softly.assertAll();
  }

  @Test
  public void shouldDisplayCorrectDisplayPage() {
    login.as(User.STANDARD_USER);

    String firstItemName = productList.titles().get(0);
    productList.openProductDetailsFor(firstItemName);

    assertThat(productDetails.productName()).isEqualTo(firstItemName);
    productDetails.productImageWIthAltValueOf(firstItemName).shouldBeCurrentlyVisible();
  }

}
