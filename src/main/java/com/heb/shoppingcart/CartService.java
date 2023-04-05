package com.heb.shoppingcart;

import com.heb.shoppingcart.Componets.Coupon;
import com.heb.shoppingcart.Componets.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class CartService {

  private final double taxRate = .0825;

  /**
   * Sums the price of all <code>Item</code> in the list
   * @param items list of <code>Item</code>
   * @return total price of all items
   */
  double calcTotalPrice(List<Item> items) {
    return items.stream().mapToDouble(Item::getPrice).sum();
  }

  /**
   * Calculates the amount of tax for all <code>Item</code> in the list
   * @param items list of <code>Item</code>
   * @return total amount of tax for all items
   */
  double calcTaxTotal(List<Item> items) {
    return items.stream().mapToDouble(i -> i.getPrice()*taxRate).sum();
  }

  /**
   * Calculates the grand total of all taxable <code>Item</code> in the list. An <code>Item</code>
   * is taxable if the isTaxable flag = true
   * @param items list of <code>Item</code>
   * @return total amount of all taxable items
   */
  double calcTaxableSubTotal(List<Item> items) {
    return calcTotalPrice(filterTaxableItems(items));
  }

  /**
   * Filters out non taxable items
   * @param items list of <code>Item</code>
   * @return a list of all taxable items
   */
  List<Item> filterTaxableItems(List<Item> items) {
    return items.stream().filter(Item::isTaxable).collect(Collectors.toList());
  }

  /**
   * Applies the discounted price to all <code>Item</code> in the list.
   * The final price of an item cannot be negative.
   * Treat the "discountPrice" as a subtraction.
   * A discount of $0.75 applied to an item with price $1.00 will have a final price of ($1.00 - $0.75) = $0.25
   * @param items list of <code>Item</code>
   * @param coupons list of <code>Coupon</code>
   * @return new <code>Item</code> list with adjusted discounted prices
   */
  List<Item> applyDiscountPrices(List<Item> items, List<Coupon> coupons) {
    return items.stream().map(i -> {
      for(Coupon c : coupons) {
        if(isDiscountItem(i, c)) {
          i.setPrice(i.getPrice()-c.getDiscountPrice());
        }
      }
      return i;
    }).collect(Collectors.toList());
  }

  /**
   * Check if <code>coupon</code> applies to a given <code>Item</code>
   * @param i item
   * @param coupon discount
   * @return if <code>coupon</code> applies to item
   */
  private boolean isDiscountItem(Item i, Coupon coupon) {
    String iName = i.getItemName().toLowerCase();
    String cName = coupon.getCouponName().toLowerCase().replace("discount", "").trim();

    return iName.contains(cName);
  }
}
