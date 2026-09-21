# Notification Service

Microservice responsible for centralizing and processing notifications from the helpdesk system, enabling alerts and communications related to tickets, status updates, assignments, and other operational events.

This project is currently in its initial stage and is structured as a Spring Boot application written in Java. It is ready to evolve with integrations for communication channels such as email, WhatsApp, Slack, SMS, or other notification providers.

## Overview

The goal of `notification-service` is to provide a foundation for:

- registering helpdesk events;
- sending notifications to users, support agents, and managers;
- standardizing communication messages;
- enabling integration with other microservices in the ecosystem.

## Technology Stack

- Java 25
- Spring Boot 4.1.1
- Maven
- Spring Web MVC
- Spring Validation

## Project Structure

```text
notificacao-service/
├── .mvn/
│   └── wrapper/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── corecode/
│   │   │           └── notificacao_service/
│   │   │               └── NotificacaoServiceApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── corecode/
│                   └── notificacao_service/
│                       └── NotificacaoServiceApplicationTests.java
├── .gitattributes
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Requirements

Before running the project, make sure you have installed:

- Java 25
- Maven
- Git

## Configuration

The main service configuration is located at:

```text
src/main/resources/application.properties
```

Current configuration:

```properties
server.port=8081
spring.application.name=notificacao-service
```

## Running the Project

### 1. Clone the repository

```bash
git clone https://github.com/LuanDevReis/notificacao-service.git
cd notificacao-service
```

### 2. Run with Maven

On Linux or macOS:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

### 3. Access the application

The application will be available at:

```text
http://localhost:8081
```

## Planned Features

This microservice may evolve to support:

- email notifications;
- WhatsApp messages;
- Slack or Microsoft Teams alerts;
- SMS notifications;
- helpdesk ticket event tracking;
- reminders and expiration alerts;
- integration with other helpdesk services.

> Note: the initial project structure has been created, but the business rules and endpoints may still be implemented according to the helpdesk system requirements.

## Endpoints

The API is currently in its initial definition stage. Endpoints may be added as the helpdesk requirements are defined, such as:

- `POST /notifications`
- `GET /notifications/{id}`
- `GET /notifications`
- `POST /notifications/test`

## Development Guidelines

- follow REST conventions for endpoints;
- use DTOs for request and response data;
- keep notification delivery logic isolated in service classes;
- centralize external configurations in Spring properties;
- write tests for business rules and integration scenarios.

## Best Practices

- use standardized logs for delivery events;
- handle communication failures with retries and queues when necessary;
- keep notification messages configurable;
- validate the delivery channel according to the notification type;
- monitor delivery time and success rate.

## Contributing

Contributions are welcome. To contribute:

1. Fork the project.
2. Create a feature branch:
   ```bash
   git checkout -b feature/my-feature
   ```
3. Make your changes.
4. Commit and push them:
   ```bash
   git commit -m "Add my feature"
   git push origin feature/my-feature
   ```
5. Open a pull request.

## License

This project does not have a license defined yet. If necessary, add a license before using or distributing it in production.

## Author

- LuanDevReis

## Repository

- https://github.com/LuanDevReis/notificacao-service
