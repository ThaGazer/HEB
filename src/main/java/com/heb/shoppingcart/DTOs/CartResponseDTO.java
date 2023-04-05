package com.heb.shoppingcart.DTOs;

public class CartResponseDTO {
  private double grandTotal;

  public CartResponseDTO() {

  }

  public CartResponseDTO(double grandTotal) {
    setGrandTotal(grandTotal);
  }

  public double getGrandTotal() {
    return grandTotal;
  }

  public void setGrandTotal(double grandTotal) {
    this.grandTotal = grandTotal;
  }
}
