package com.heb.shoppingcart.DTOs;

public class CartResponseFeat4DTO extends CartResponseFeat3DTO {
  private double subTotalPostDiscounts;
  private double discountTotal;

  public CartResponseFeat4DTO() {

  }

  public CartResponseFeat4DTO(double grandTotal, double taxTotal, double taxableSubTotal, double discountTotal,
                              double subTotalPreDiscounts, double subTotalPostDiscounts) {
    super(grandTotal, subTotalPreDiscounts, taxTotal, taxableSubTotal);
    setDiscountTotal(discountTotal);
    setSubTotalPostDiscounts(subTotalPostDiscounts);
  }

  public double getSubTotalPostDiscounts() {
    return subTotalPostDiscounts;
  }

  public void setSubTotalPostDiscounts(double subTotalPostDiscounts) {
    this.subTotalPostDiscounts = subTotalPostDiscounts;
  }

  public double getDiscountTotal() {
    return discountTotal;
  }

  public void setDiscountTotal(double discountTotal) {
    this.discountTotal = discountTotal;
  }
}
