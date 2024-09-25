# <div align="center">  Online Order Management System </div>
   ##   Description
  *-> A robust Online Order Management System built with Spring Boot and Java, designed to streamline eCommerce operations. This application efficiently manages users, carts, products, and orders, offering seamless product browsing, automated cart creation, dynamic pricing calculations, and order tracking. It leverages JPA/Hibernate for data persistence, ensuring secure and scalable database management with MySQL. Featuring a flexible review system, comprehensive order processing, and automated tracking number generation, this solution provides a complete, efficient, and scalable approach to handling online orders.*
  
  ## Features
  - ## Features
- **User Authentication & Management:** Secure user registration and login, with automatic cart creation for new users.
- **Cart Management:** Real-time cart management, including adding/removing products, automatic total price calculation, and stock validation before saving or updating the cart.
- **Product Management:** Manage products with detailed information like price, discount, stock availability, brand, and category. Support for dynamic stock updates and product filtering.
- **Order Processing & Tracking:** Seamless order creation with automatic total price calculation, support for multiple payment methods, and automated generation of tracking numbers. Orders are linked with detailed shipping methods, status updates, and delivery tracking.
- **Bidirectional Entity Relationships:** Efficiently manage complex entity relationships, including many-to-many associations between products, carts, and orders, and one-to-one relationships for user details and addresses.
- **Review and Rating System:** Users can rate and review products, with real-time average rating updates and total reviews for each product.
- **Dynamic Pricing & Discounts:** Support for dynamic pricing adjustments based on discounts and promotions, reflected in both product listings and cart totals.
- **Order History & Status:** Track past orders with detailed status updates, including pending, shipped, and delivered states, as well as additional notes and expected delivery dates.
- **Stock Management:** Automated stock quantity validation during the order process to prevent over-selling, ensuring inventory accuracy.
- **API Documentation with Swagger UI:** Integrated Swagger UI for easy API documentation and testing.

  
## Tech Stack
- **Language:** Java
- **Framework:** Spring Boot
- **Database:** MySQL
- **Build Tool:** Maven
- **ORM:** Hibernate (JPA)
- **Dependency Management:** Lombok
- **Testing:** JUnit 5, Spring Boot Test
- **API Documentation:** Swagger UI (for interactive API documentation and testing)
- **Version Control:** Git

## Getting Started
### 1) Prerequisites
1. **Java:**  Ensure that JDK 11 or later is installed. You can download it from the Oracle website or use OpenJDK.
2. **Maven:** Ensure Maven is installed to build the project. You can download it from the [Apache Maven website](https://maven.apache.org/download.cgi).
3. **MySQL:** Install MySQL for managing the database. You can download it from the [MySQL website](https://dev.mysql.com/downloads/installer/). Create a database for the application.
4. **IDE:** A Java Integrated Development Environment (IDE) like Eclipse, IntelliJ IDEA, or VSCode can help you manage and run the project efficiently.
5. **Swagger UI:** Ensure that Swagger UI is integrated with your Spring Boot application for interactive API documentation. You can access it via the URL provided when the application is running.
### 2) Setup
1. **Clone the Repository:**
   
    ```bash
       https://github.com/RudraPrasad07/OnlineOrderManagement.git
    ```
2. **Navigate to the Project Directory:**
   
    ```bash
     cd Online-Order-Management
    ```
3. **Configure Database:**
   
   Update `src/main/resources/application.properties` with your MySQL database details:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```
4. **Build the Project:**
   
    ```bash
    mvn clean install
    ```
5. **Run the Application:**
   
    ```bash
    mvn spring-boot:run
    ```
6. **Access Swagger UI:**  Once the application is running, you can access the Swagger UI documentation on your browser with the URL: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
   
### 3) Running the Application
Once the application is up and running, you can access the REST API through the following endpoints:

#### AddressController
- **PUT /address/updateaddress/{id}:** Update the address information for the given ID. Requires the ID as a path variable and the updated details in the request body.
- **GET /address/fetch/{id}:** Retrieve the address information for the given ID. Requires the ID as a path variable.
  
#### CartController
- **GET /Cart/fetchCartById/{id}:** Retrieves cart details by the specified cart ID. Returns the cart details if found.
- **POST /Cart/{cartId}/product/{productId}/stockQuantity/{stockQuantity}:** Adds a specified quantity of a product to the cart. Requires the cart ID, product ID, and stock quantity as path variables.
- **DELETE /Cart/{cId}/product/{pId}:** Removes a product from the cart by the specified product ID. Requires the cart ID and product ID as path variables.
- **GET /Cart/fetchAllcart:** Retrieves all carts from the database.
- **GET /Cart/productexistsinCart/{cartId}/{productId}/stockQuanty/{stockQuanty}:** Verifies if a product exists in the specified cart with the given quantity. Requires the cart ID, product ID, and stock quantity as path variables.
- **PUT /Cart/{cartId}/product/{productId}/stockQuanty/{stockQuanty}:** Updates the quantity of a specified product in the cart. Requires the cart ID, product ID, and updated stock quantity as path variables.
 - **GET /Cart/fetchCountByCartId/{cartId}:** Fetches the total product count in the cart by the specified cart ID. Returns the cart details including the total count.
   
#### CartController
- **GET /Cart/fetchCartById/{id}:** Retrieves cart details by the specified cart ID. Returns the cart details if found.
- **POST /Cart/{cartId}/product/{productId}/stockQuantity/{stockQuantity}:** Adds a specified quantity of a product to the cart. Requires the cart ID, product ID, and stock quantity as path variables.
- **DELETE /Cart/{cId}/product/{pId}:** Removes a product from the cart by the specified product ID. Requires the cart ID and product ID as path variables.
- **GET /Cart/fetchAllcart:** Retrieves all carts from the database.
- **GET /Cart/productexistsinCart/{cartId}/{productId}/stockQuanty/{stockQuanty}:** Verifies if a product exists in the specified cart with the given quantity. Requires the cart ID, product ID, and stock quantity as path variables.
- **PUT /Cart/{cartId}/product/{productId}/stockQuanty/{stockQuanty}:** Updates the quantity of a specified product in the cart. Requires the cart ID, product ID, and updated stock quantity as path variables.
 - **GET /Cart/fetchCountByCartId/{cartId}:** Fetches the total product count in the cart by the specified cart ID. Returns the cart details including the total count.

### MyorderDetailsController
- **POST /Myorder/createOrder/{userID}:** Creates a new order associated with a specific user. Accepts order details and the user ID, returning the newly created order.
- **GET /Myorder/getAllOrder:** Fetches all the orders from the database.
- **GET /Myorder/getOrderById/{Id}:** Fetches a specific order by its unique ID.
- **PUT /Myorder/UpdateOrder/{id}:** Updates the details of an existing order by providing the order ID and new order data.
- **DELETE /Myorder/DeleteOrderById/{id}:** Deletes an order from the database by its ID.
- **GET /Myorder/getOrderByshippingMethod/{shippingMethod}:** Fetches all orders that use a specific shipping method.
- **GET /Myorder/getOrderBypaymentMethod/{paymentMethod}:** Fetches all orders that use a specific payment method.
- **GET /Myorder/getOrderByTrackingNumber/{TrackingNumber}:** Fetches a specific order by its tracking number.
- **GET /Myorder/getOrderByDeliveryDate/{DeliveryDate}:** Fetches all orders that are expected to be delivered on a specific date.

### ProductController
- **POST /Product/saveProduct:** Creates and saves a new product. Accepts product details in the request body and returns the created product.
- **PUT /Product/updateProduct/{id}:** Updates an existing product identified by its ID. Accepts the new product details in the request body and returns the updated product.
- **GET /Product/fetchByid/{id}:** Retrieves product details based on the product ID.
- **GET /Product/fetchByName/{name}:** Retrieves a list of products matching the specified name.
- **GET /Product/fetchByPrice/{Price}:** Retrieves a list of products priced at the specified amount.
- **GET /Product/fetchBystockQuanty/{stockQuanty}:** Retrieves a list of products based on the specified stock quantity.
- **GET /Product/fetchBycategory/{category}:** Retrieves a list of products belonging to the specified category.
- **GET /Product/fetchAll:** Retrieves all products in the database.
- **DELETE /Product/deleteByid/{id}:** Deletes a product identified by its ID.

### ReviewController
- **POST /Review/saveReview:** Creates and saves a new review. It accepts a ReviewDTO object in the request body and returns the created review.
- **PUT /Review/update/{id}:** Updates an existing review identified by its ID. It accepts the updated ReviewDTO object in the request body and returns the updated review.
- **GET /Review/fetchByid/{id}:** Retrieves a review based on the specified ID.
- **GET /Review/fetchByRating/{rating}:** Retrieves a list of reviews that match the specified rating.
- **GET /Review/fetchByReviewDate/{reviewDate}:** Retrieves a list of reviews that match the specified review date. Note that the date format should match your application requirements.
- **GET /Review/fetchByphoneNumber/{phoneNo}:** Retrieves a list of reviews associated with a specified user phone number.
- **DELETE /Review/DeleteById/{id}:** Deletes a review identified by its ID.

### UserController
- **POST /user/save:** Creates and saves a new user. It takes a UserDTO object in the request body and returns the saved user with a 201 Created status.
- **PUT /user/update/{id}:** Updates an existing user identified by their ID. It accepts the updated UserDTO in the request body and returns the updated user.
- **GET /user/fetchByID/{id}:** Retrieves a user by their unique ID.
- **GET /user/fetchByEmail/{email}:** Retrieves a user by their email address.
- **GET /user/fetchByNumber/{phoneNo}:** Retrieves a user by their phone number.
- **GET /user/fetchByName/{name}:** Retrieves a list of users that match the specified name.
- **GET /user/fetchAllUser:** Retrieves a list of all users.
- **GET /user/existsByEmail/{email}:** Checks if a user exists based on their email and returns a boolean response.
- **GET /user/existsByNumber/{phoneNo}:** Checks if a user exists based on their phone number and returns a boolean response.
- **DELETE /user/deleteByID/{id}:** Deletes a user identified by their ID and returns the deleted user.
- **DELETE /user/deleteByNumber/{phoneNo}:** Deletes a user identified by their phone number and returns the deleted user.
  
### WishListController
- **PUT /WishList/update/{id}:** Updates a wish list identified by its ID using the provided WishListDTO. Returns the updated wish list with a 200 OK status.
- **GET /WishList/findWishListById/{id}:** Retrieves a wish list by its unique ID.
- **GET /WishList/findWishListByUser/{userEmail}:** Retrieves the wish list associated with a particular user identified by their email.
- **POST /WishList/{wishListId}/product/{productId}:**Adds a product to a wish list identified by wishListId using the specified productId. Returns the updated wish list with a 201 Created status.
- **DELETE /WishList/{lsitId}/Product/{pId}:** Removes a product from a wish list using the specified wishListId and productId. Returns the updated wish list.
- **GET /WishList/fetchAll:** Fetches all wish lists available in the database.

### 4) API Documentation
You can explore and test the APIs using Swagger (if integrated) or tools like Postman. Below is an example of a sample API request in Postman:
### Sample API Request
- **Method**: POST
- **URL**: `http://localhost:8080/user/save`

- **Body**:
```json
{
    "name": "Name",
    "dob": "DOB",
    "gender": "Gender",
    "email": "Email",
    "password": "Password",
    "phoneno": "PhoneNumber",
    "dob":"dob",
    "gender":"gender",
    "addresses":"Address details"
}
```
### 5) Database Configuration
### Switching to MySQL

To use MySQL, update the `application.properties` file with the following configuration:

```properties
# MySQL Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
### 6) Testing
 - **Run tests using the following Maven command:**
    ```bash
    mvn test
    ```
    
###  ***Contributing***
   *Feel free to contribute or provide feedback. Your support is greatly appreciated!*

</br>
  <div align="center">

 ***Thank You! For checking out my project! 🙏***



</div>
