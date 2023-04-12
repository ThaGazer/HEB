### To Run
Navigate to project directory

    cd <my_rpoject>

Build project. Maven must be pre-installed

    mvn package

Run the generated jar file

    java -jar target/shoppingcart-0.0.1-SNAPSHOT.jar
    
Site should be running on `localhost:8080` and you can hit the endpoints with `curl`
or `postman`.

#### Endpoint Format
- http://localhost:8080/cart
- http://localhost:8080/cart/feat1
- http://localhost:8080/cart/feat2
- http://localhost:8080/cart/feat3
- http://localhost:8080/cart/feat4

All endpoints require a `JSON` body payload in the form of

```
{
  "items": [
    {
      "itemName": "H-E-B Two Bite Brownies",
      "sku": 85294241,
      "isTaxable": false,
      "ownBrand": true,
      "price": 3.61
    },
  ],
  "coupons": [
    {
      "couponName": "Brownie Discount",
      "appliedSku": 85294241,
      "discountPrice": 0.79
    },
  ]
}
```

Coupons are optional