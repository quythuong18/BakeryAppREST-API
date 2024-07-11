# Bakery REST-API
This application provide an API to save data and manage a typical bakery system

### Technologies
Spring Boot 3, Spring Data JPA, Spring Security 6, OpenAPI 3.0 Spring doc(Swagger UI), JWT, PostgreSQL

### Explore the REST API
API was built with OpenAPI 3.0, so you can use Swagger UI to see full information, structures of the REST API at `/swagger-ui/index.html`
Then type "/api-docs" in the Explore input
### Let's get a quick overview
#### Authentication/Authorization
| Method | Url            | Request body | Decription |
| ------ |----------------|--------------|------------|
| POST   | /auth/register | JSON         | Register   |
| POST   | /auth/login    | JSON         | Log in     |
#### Category
| Method | Url                                    | Decription                     | Request body |
|--------|----------------------------------------|--------------------------------|--------------|
| GET    | /api/v1/category                       | Get all categories             |              |
| GET    | /api/v1/category/{categoryId}/products | Get all products of a category |              |
| POST   | /api/v1/category                       | Create a new category          | JSON         |
| DELETE | /api/v1/category/{categoryId}          | Delete a category              |              |
| PATCH  | /api/v1/category/{categoryId}          | Update a category              | JSON         |

#### Products
| Method | Url                                   | Decription           | Request body |
|--------|---------------------------------------|----------------------|--------------|
| GET    | /api/v1/product                       | Get all products     |              |
| POST   | /api/v1/product                       | Create a new product | JSON         |
| DELETE | /api/v1/product/{productId}           | Delete a product     |              |
| PATCH  | /api/v1/product/{productId}           | Update a product     | JSON         |
#### AppUser
| Method | Url                    | Decription        | Request body |
|--------|------------------------|-------------------|--------------|
| GET    | /api/v1/user/customers | Get all customers |              |
| GET    | /api/v1/user/{userId}  | Get a user by Id  |              |
#### SaleOrder
| Method | Url             | Decription     | Request body |
|--------|-----------------|----------------|--------------|
| POST   | /api/v1/order   | Place an order | JSON         |
#### Cart
| Method | Url                   | Decription    | Request body |
|--------|-----------------------|---------------|--------------|
| PATCH  | /api/v1/cart/{cartId} | Update a cart | JSON         |
### How to run and install project
