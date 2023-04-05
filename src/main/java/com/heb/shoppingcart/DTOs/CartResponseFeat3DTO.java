package com.heb.shoppingcart.DTOs;

public class CartResponseFeat3DTO extends CartResponseFeat2DTO {
  private double taxableSubTotal;

  public CartResponseFeat3DTO() {

  }

  public CartResponseFeat3DTO(double grandTotal, double subTotal, double taxTotal, double taxableSubTotal) {
    super(grandTotal, subTotal, taxTotal);
    setTaxableSubTotal(taxableSubTotal);
  }

  public double getTaxableSubTotal() {
    return taxableSubTotal;
  }

  public void setTaxableSubTotal(double taxableSubTotal) {
    this.taxableSubTotal = taxableSubTotal;
  }
}
