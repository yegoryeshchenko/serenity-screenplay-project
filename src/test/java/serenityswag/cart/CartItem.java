package serenityswag.cart;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartItem {
  String title;
  String description;
  Double price;

}
