# PRICE-MANAGER

Devuelve el precio aplicable a un producto según su product_id, brand_id y date de la venta.

## Ejecución de aplicación

```
$ mvn spring-boot:run
```

Corre por defecto en el puerto 8080.

## Ejecución de tests

```
$ mvn test
```

## API

#### Get active price

    GET http://localhost:8080/product/{product_id}?brand_id={brand_id}&date={date}

- product_id (numérico - requerido)
- brand_id (numérico - requerido)
- date (en formato yyyy-MM-ddTHH:mm:ss - requerido)

##### Curl example

``` curl
curl --location 'http://localhost:8080/product/35455?brand_id=1&date=2020-06-14T10%3A00%3A00'
```

##### Ejemplo de respuesta OK (200)

``` json
{
    "price_list": 1,
    "product_id": 35455,
    "brand_id": 1,
    "start_date": "2020-06-14 00:00:00",
    "end_date": "2020-12-31 23:59:59",
    "price": 35.5
}
```


