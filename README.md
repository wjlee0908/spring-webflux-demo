# Spring WebFlux Demo

This is a simple demo of a product API built using Spring WebFlux, which provides reactive programming support, and MongoDB for data storage. The API allows you to perform CRUD (Create, Read, Update, Delete) operations on product data.

## Technologies Used

- Java
- Spring WebFlux
- MongoDB

## Installation

1. Clone the repository:
```
git clone <repository_url>
```

2. Navigate to the project directory:
```
cd webflux-demo
```

3. Build the project:
```
./mvnw clean package
```

4. Run the application:
```
./mvnw spring-boot:run
```

## API Endpoints

- **GET /v1/products**: Retrieve multiple products with pagination support.
- **GET /v1/products/{id}**: Retrieve a single product by its ID.
- **POST /v1/products**: Create a new product.
- **PUT /v1/products/{id}**: Update an existing product.
- **DELETE /v1/products/{id}**: Delete a product by its ID.

## Request and Response Examples

### GET /v1/products

Request:
```
GET /v1/products?page=0&limit=10
```

Response:
```json
{
  "code": 200,
  "page": 0,
  "limit": 10,
  "data": [
    {
      "id": "1",
      "name": "Product 1",
      "price": 19.99
    },
    {
      "id": "2",
      "name": "Product 2",
      "price": 29.99
    },
    ...
  ]
}
```

### POST /v1/products

Request:
```json
{
  "name": "New Product",
  "price": 39.99
}
```

Response:
```json
{
  "code": 201,
  "data": {
    "id": "3",
    "name": "New Product",
    "price": 39.99
  }
}
```

### DELETE /v1/products/{id}

Request:
```
DELETE /v1/products/3
```

Response:
```json
{
  "code": 200,
  "message": "Product with id 3 has been deleted."
}
```

