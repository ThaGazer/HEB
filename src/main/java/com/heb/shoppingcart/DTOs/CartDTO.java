package com.heb.shoppingcart.DTOs;

import com.heb.shoppingcart.Componets.Coupon;
import com.heb.shoppingcart.Componets.Item;

import java.util.List;

public class CartDTO {

  private List<Item> items;
  private List<Coupon> coupons;

  public CartDTO() {

  }

  public CartDTO(List<Item> items, List<Coupon> coupons) {
    setItems(items);
    setCoupons(coupons);
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public List<Coupon> getCoupons() {
    return coupons;
  }

  public void setCoupons(List<Coupon> coupons) {
    this.coupons = coupons;
  }

  public String toString() {
    return items.toString() + coupons.toString();
  }
}
