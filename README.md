# Online Tourism Management System

This is a web-based application developed for tour operating companies to manage customers, hotels, vehicles, packages, orders, foods, and transports.

## Features

### Admin Features:
- Manage Rooms (implicitly handled via Hotels and Packages)
- Manage Hotels: Add, View, Update, Delete hotel listings.
- Manage Packages: Add, View, Update, Delete tourism packages, including associating them with hotels.
- Manage Users: Register, View, Update, Delete user accounts with roles (USER/ADMIN).
- Manage Orders: View and manage customer bookings.
- Manage Vehicles: Add, View, Update, Delete vehicle details.
- Manage Foods: Add, View, Update, Delete food items.
- Manage Transports: Add, View, Update, Delete transport details, including associating them with vehicles.

### User / Customer Features:
- View available tourism packages.
- Purchase/Book packages.
- View their past orders/bookings.

## Technologies Used
- **Backend:** Spring Boot (Java)
- **Database:** MySQL
- **Templating Engine:** Thymeleaf (HTML)
- **Build Tool:** Maven

## Setup Instructions

1.  **Java Development Kit (JDK):** Ensure you have JDK 8 or higher installed.

2.  **Maven:** Ensure Maven is installed and configured in your system's PATH.

3.  **MySQL Database Setup:**
    *   Install MySQL Server.
    *   Create a database named `tourism_db`.

    ```sql
    CREATE DATABASE tourism_db;
    ```

    *   The application will automatically create and update tables in `tourism_db` based on the JPA entities (defined in `src/main/java/com/tourism/model/`) when it runs for the first time, due to `spring.jpa.hibernate.ddl-auto=update` in `application.properties`.

4.  **Application Properties:**
    *   Open `tourism/src/main/resources/application.properties`.
    *   Update the database connection details if your MySQL setup differs from the default (username `root`, no password, `localhost:3306`).

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/tourism_db
    spring.datasource.username=root
    spring.datasource.password=
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.mvc.view.suffix=.html
    spring.mvc.view.prefix=/WEB-INF/jsp/
    ```

## How to Run the Application

1.  **Navigate to the project root:**
    Open your terminal or command prompt and navigate to the `tourism/` directory (the one containing `pom.xml`).

    ```bash
    cd tourism
    ```

2.  **Build the project (optional, but good practice):**
    ```bash
    mvn clean install
    ```

3.  **Run the Spring Boot application:**
    ```bash
    mvn spring-boot:run
    ```

    The application will start on `http://localhost:8080` by default.

## Important URLs

*   **Home Page:** `http://localhost:8080/`
*   **View Packages (Public):** `http://localhost:8080/packages`
*   **View Hotels (Public):** `http://localhost:8080/hotels`
*   **Login / Register:** `http://localhost:8080/login`
*   **Admin Dashboard:** `http://localhost:8080/admin/dashboard`
*   **User Dashboard:** `http://localhost:8080/user/dashboard` 