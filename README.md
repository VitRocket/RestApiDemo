# RestApiDemo
Demo REST API Service

### Create order by POST
example
```
curl --location --request POST 'http://localhost:8080/order' \
--header 'Content-Type: application/json' \
--data-raw '{
    "productId":100,
    "client":{
        "name":"Hryhorii Skovoroda",
        "email":"hs@example.com"
    },
    "clientComment":"You can be careful, please."
}'
```
response http status: 201 with Location header for example
```
http://localhost:8080/order/c54827ca-b429-4f1a-97f7-200523002209
```

### Getting a data 
example
```
curl --location --request GET 'http://localhost:8080/order/c54827ca-b429-4f1a-97f7-200523002209'
```
