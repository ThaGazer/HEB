package com.heb.shoppingcart.DTOs;

public class CartResponseFeat2DTO extends CartResponseDTO {
  private double subTotal;
  private double taxTotal;

  public CartResponseFeat2DTO() {

  }

  public CartResponseFeat2DTO(double grandTotal, double subTotal, double taxTotal) {
    super(grandTotal);

    setSubTotal(subTotal);
    setTaxTotal(taxTotal);
  }

  public double getSubTotal() {
    return subTotal;
  }

  public void setSubTotal(double subTotal) {
    this.subTotal = subTotal;
  }

  public double getTaxTotal() {
    return taxTotal;
  }

  public void setTaxTotal(double taxTotal) {
    this.taxTotal = taxTotal;
  }
}
