package com.heb.shoppingcart.Componets;

public class Item {
  private String itemName;
  private long sku;
  private boolean isTaxable;
  private boolean ownBrand;
  private double price;

  public Item() {

  }

  public Item(String name, long sku, boolean isTaxable, boolean ownBrand, double price) {
    setItemName(name);
    setSku(sku);
    setIsTaxable(isTaxable);
    setOwnBrand(ownBrand);
    setPrice(price);
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public long getSku() {
    return sku;
  }

  public void setSku(long sku) {
    this.sku = sku;
  }

  public boolean isTaxable() {
    return isTaxable;
  }

  public void setIsTaxable(boolean taxable) {
    this.isTaxable = taxable;
  }

  public boolean isOwnBrand() {
    return ownBrand;
  }

  public void setOwnBrand(boolean ownBrand) {
    this.ownBrand = ownBrand;
  }

  public double getPrice() {
    return price;
  }

  /**
   * Sets price of an item. Price can not be below 0.0. If so it is set to 0.0
   * @param price new price
   */
  public void setPrice(double price) {
    if(price < 0) {
      this.price = 0.0;
    }
    this.price = price;
  }

  public String toString() {
    return "Name:"+getItemName() + " SKU:"+getSku() + " taxable:"+isTaxable() + " brand:"+isOwnBrand() + " price:"+getPrice();
  }
}
