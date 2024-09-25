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
    git clone https://github.com/RudraPrasad07/School-Data-Management-System.git
    ```
