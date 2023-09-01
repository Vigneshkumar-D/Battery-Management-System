# Battery Management System

The Battery Management System is a robust web application backend designed to serve as a centralized platform for efficiently managing and analyzing battery data originating from electric vehicles. This project is built using Spring Boot and leverages various technologies and dependencies to provide seamless data acquisition, storage, retrieval, and analysis capabilities through user-friendly web APIs.

## Table of Contents
- [Description](#description)
- [Key Features](#key-features)
- [Dependencies](#dependencies)
- [Technologies Used](#technologies-used)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Description

The Battery Management System acts as a central hub for battery data management, offering real-time updates, secure storage, and efficient retrieval. It enables users to access battery-related information using various querying options, including fetching specific data attributes and calculating average measurements. The system also allows batteries to contribute data every minute, ensuring comprehensive historical data storage.

## Key Features

- **Data Ingestion:** Seamless integration with batteries enables the transmission of essential battery data, including Battery-Id, Current, Voltage, Temperature, and Timestamp.
- **Real-time Updates:** Batteries transmit data to the backend every minute, ensuring the system remains up-to-date with the latest battery information.
- **Robust Database Storage:** All incoming battery data is securely stored in a structured database table for efficient data management and retrieval.
- **Data Retrieval Options:** Users can retrieve data for a specific battery, access specific data attributes, and analyze data within specified timeframes. Average measurements can also be calculated.
- **Continuous Data Addition:** The backend offers a seamless mechanism for batteries to contribute data every minute, ensuring a comprehensive data history.
- **Effortless API Communication:** RESTful APIs facilitate seamless communication between clients and the server using conventional HTTP methods.
- **Predictive Analytics:** Leveraging accumulated battery data, the backend supports predictive analytics, offering insights into battery behavior, patterns, and potential maintenance requirements.

## Dependencies

- **Spring Boot Starter Data JDBC:** Simplifies the development of data access layers.
- **Spring Boot Starter Data JPA:** Provides JPA support for data access and storage.
- **Spring Boot Starter Web:** Facilitates building web applications.
- **H2 Database (runtime):** An in-memory database for development and testing.
- **Spring Boot Starter Test (test):** Provides testing support.
- **SQLite JDBC (version 3.36.0.1):** JDBC driver for connecting to SQLite databases.

## Technologies Used

- **Spring Boot:** Framework for building production-ready applications quickly and with minimal configuration.
- **Spring Data JPA:** Simplifies the development of data access layers by leveraging JPA (Java Persistence API) annotations.
- **H2 Database:** Embedded in-memory database for development and testing purposes.
- **SQLite JDBC:** JDBC driver for connecting to SQLite databases.
- **RESTful APIs:** Facilitates communication between clients and the server using industry-standard HTTP methods.

## Usage

1. Clone the repository to your local machine.
2. Build and run the application using Spring Boot's Maven plugin.
3. Access the provided APIs for data retrieval, addition, and analysis.

## Contributing

Contributions are welcome! Feel free to open issues and pull requests to improve the project.

## License

This project is licensed under the [MIT License](LICENSE).
