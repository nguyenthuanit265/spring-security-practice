# Spring Security Practice

This repository contains a practice project for understanding and implementing Spring Security. The aim is to explore various security features provided by Spring, such as authentication, authorization, and CSRF protection.

## Features

- Basic Authentication
- Role-based Access Control
- Custom Login Page
- CSRF Protection
- In-memory User Details Service

## Getting Started

### Prerequisites

- Java 11 or later
- Maven 3.6+
- IDE with Spring support (e.g., IntelliJ IDEA, Eclipse)

### Running the Application

1. Clone the repository:
    ```bash
    git clone https://github.com/nguyenthuanit265/spring-security-practice.git
    cd spring-security-practice
    ```

2. Build the project using Maven:
    ```bash
    mvn clean install
    ```

3. Run the application:
    ```bash
    mvn spring-boot:run
    ```

4. Access the application at `http://localhost:8080`.

### Usage

- Default credentials:
    - Username: `user`
    - Password: `password`

- Access the `/admin` endpoint to test role-based access.

## Contributing

If you'd like to contribute to this project, feel free to fork the repository and submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

