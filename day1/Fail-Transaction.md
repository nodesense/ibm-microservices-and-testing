# Success Test


```
http://localhost:8181/orders
```

```json
{
  "customerId": "d215b5f8-0249-4dc5-89a3-51fd148cfb41",
  "restaurantId": "d215b5f8-0249-4dc5-89a3-51fd148cfb45",
  "address": {
    "street": "street_1",
    "postalCode": "1000AB",
    "city": "Amsterdam"
  },
  "price": 50.00,
  "items": [
    {
      "productId": "d215b5f8-0249-4dc5-89a3-51fd148cfb48",
      "quantity": 1,
      "price": 50.00,
      "subTotal": 50.00
    }
  ]
}
```


use PostMAN GET to validate order completion or rejection

```
http://localhost:8181/orders/0d823a1a-1804-4700-99a9-1e433a03885c
```


# Failure Part 1

Payment, Restarent not able to deliver product, the payment returned to customer..


end point, POST method, Body , Raw, JSON for Content Type

```
http://localhost:8181/orders
```

```json
{
  "customerId": "d215b5f8-0249-4dc5-89a3-51fd148cfb41",
  "restaurantId": "d215b5f8-0249-4dc5-89a3-51fd148cfb45",
  "address": {
    "street": "street_1",
    "postalCode": "1000AB",
    "city": "Amsterdam"
  },
  "price": 25.00,
  "items": [
    {
      "productId": "d215b5f8-0249-4dc5-89a3-51fd148cfb47",
      "quantity": 1,
      "price": 25.00,
      "subTotal": 25.00
    }
  ]
}
```

After getting order tracking id, use tracking to get status in postman


end point , order id will be different for you

```
http://localhost:8181/orders/95f64949-e2df-44d1-bdbb-12f1a59c103b
```
