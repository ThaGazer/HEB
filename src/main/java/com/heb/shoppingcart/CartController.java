package com.heb.shoppingcart;

import com.heb.shoppingcart.Componets.Item;
import com.heb.shoppingcart.DTOs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

  @Autowired
  private CartService cartService;

  /**
   * Simple echo endpoint to make sure items get passed correctly
   *
   * @param cart data transfer object containing both items and coupons for the cart
   * @return items in the cart
   */
  @GetMapping()
  @ResponseBody
  public List<Item> echo(@RequestBody CartDTO cart) {
    return cart.getItems();
  }

  /**
   * Calculates the grand total of a given shopping cart
   *
   * @param cart data transfer object containing both items and coupons for the cart
   * @return dto containing the grand total of a shopping cart in the json form of
   * {
   *   "grandTotal"=<double>,
   * }
   */
  @GetMapping("/feat1")
  public CartResponseDTO feature1(@RequestBody CartDTO cart) {
    return new CartResponseDTO(cartService.calcTotalPrice(cart.getItems()));
  }

  /**
   * Calculates the subtotal and tax total of a given shopping cart
   *
   * @param cart data transfer object containing both items and coupons for the cart
   * @return dto containing the grand total, subtotal, and tax total of a shopping cart in the json form of
   * {
   *   "grandTotal"=<double>,
   *   "subTotal"=<double>,
   *   "taxTotal"=<double>,
   * }
   */
  @GetMapping("/feat2")
  public CartResponseFeat2DTO feature2(@RequestBody CartDTO cart) {
    double taxTotal = cartService.calcTaxTotal(cart.getItems());
    double priceTotal = cartService.calcTotalPrice(cart.getItems());

    return new CartResponseFeat2DTO(priceTotal + taxTotal, priceTotal, taxTotal);
  }

  /**
   * Calculates the subtotal and tax total of all taxable items in a given shopping cart
   *
   * @param cart data transfer object containing both items and coupons for the cart
   * @return dto containing the grand total, subtotal, and tax total of a shopping cart in the json form of
   * {
   *   "grandTotal"=<double>,
   *   "subTotal"=<double>,
   *   "taxTotal"=<double>,
   * }
   */
  @GetMapping("/feat3")
  public CartResponseFeat3DTO feature3(@RequestBody CartDTO cart) {
    double priceTotal = cartService.calcTotalPrice(cart.getItems());
    double taxTotal = cartService.calcTaxTotal(cartService.filterTaxableItems(cart.getItems()));
    //no need to filter on the pass because calcTaxableSubtotal filters taxable items in the call
    double taxableSubtotal = cartService.calcTaxableSubTotal(cart.getItems());

    return new CartResponseFeat3DTO(priceTotal + taxTotal, priceTotal, taxTotal, taxableSubtotal);
  }

  /**
   * Calculates the grand total of all taxable items in a shopping cart after discounts have been applied
   *
   * @param cart data transfer object containing both items and coupons for the cart
   * @return dto containing the grand total, subtotal, subtotal post discounts, tax total,
   * and taxable subtotal post discounts of a shopping cart in the json form of
   * {
   *   "grandTotal"=<double>,
   *   "subTotal"=<double>,
   *   "taxTotal"=<double>,
   *   "taxableSubTotal": <double>,
   *   "subTotalPostDiscounts": <double>,
   *   "discountTotal": <double>
   * }
   */
  @GetMapping("/feat4")
  public CartResponseFeat4DTO feature4(@RequestBody CartDTO cart) {
    double subTotalPreDiscounts = cartService.calcTotalPrice(cart.getItems());

    //apply cart discounts to item prices
    cart.setItems(cartService.applyDiscountPrices(cart.getItems(), cart.getCoupons()));

    double subTotalPostDiscounts = cartService.calcTotalPrice(cart.getItems());
    double taxTotal = cartService.calcTaxTotal(cartService.filterTaxableItems(cart.getItems()));
    double taxableSubPostDiscounts = cartService.calcTaxableSubTotal(cart.getItems());

    return new CartResponseFeat4DTO(
        subTotalPostDiscounts + taxTotal,
        taxTotal,
        taxableSubPostDiscounts,
        (subTotalPreDiscounts - subTotalPostDiscounts),
        subTotalPreDiscounts,
        subTotalPostDiscounts);
  }
}
