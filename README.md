# Notification Service

Microservice responsible for centralizing and processing notifications from the helpdesk system, enabling alerts and communications related to tickets, status updates, assignments, and other operational events.

This project is currently in its initial stage and is structured as a Spring Boot application written in Java. It is ready to evolve with integrations for communication channels such as email, WhatsApp, Slack, Teams, and SMS through RabbitMQ message queuing.

## Overview

The goal of `notification-service` is to provide a foundation for:

- registering helpdesk events;
- sending notifications to users, support agents, and managers;
- standardizing communication messages;
- enabling integration with other microservices in the ecosystem;
- asynchronous message processing via RabbitMQ.

## Technology Stack

- Java 25
- Spring Boot 4.1.1
- Maven
- Spring Web MVC
- Spring Validation
- Spring AMQP (RabbitMQ)
- Docker

## Project Structure

```text
notificacao-service/
├── .github/
│   └── workflows/
│       └── ci.yml
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
├── Dockerfile
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
- Docker (for containerized deployment)
- RabbitMQ (for message queue processing)

## Configuration

### Application Configuration

The main service configuration is located at:

```text
src/main/resources/application.properties
```

Current configuration:

```properties
server.port=8081
spring.application.name=notificacao-service
```

### RabbitMQ Configuration

The service uses RabbitMQ for asynchronous message processing. Configure the following properties in `application.properties`:

```properties
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
```

## Running the Project

### 1. Clone the repository

```bash
git clone https://github.com/LuanDevReis/notificacao-service.git
cd notificacao-service
```

### 2. Start RabbitMQ (Optional - for local development)

Using Docker:

```bash
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management
```

Or using docker-compose if available in the project.

### 3. Run with Maven

On Linux or macOS:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

### 4. Access the application

The application will be available at:

```text
http://localhost:8081
```

RabbitMQ Management Console (if running locally):

```text
http://localhost:15672
```

## CI/CD Pipeline

The project includes an automated CI/CD pipeline configured with GitHub Actions (`.github/workflows/ci.yml`).

### Pipeline Steps:

1. **Checkout**: Clones the repository code
2. **Java Setup**: Configures Java 25 with Maven caching
3. **Tests**: Runs all unit and integration tests
4. **Build**: Generates the application package
5. **Docker Build & Push**: Builds and pushes Docker images to Docker Hub
   - `main` branch → `lreis393/notificacao-service:latest`
   - `develop` branch → `lreis393/notificacao-service:dev`
   - All pushes → tagged with commit SHA

### Trigger Events:

- Push to `main` or `develop` branches
- Pull requests to `main` or `develop` branches

## Planned Features

This microservice may evolve to support:

- email notifications;
- WhatsApp messages;
- Slack or Microsoft Teams alerts;
- SMS notifications;
- helpdesk ticket event tracking;
- reminders and expiration alerts;
- integration with other helpdesk services;
- asynchronous processing with RabbitMQ queues;
- retry mechanisms and dead letter queues.

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
- write tests for business rules and integration scenarios;
- use RabbitMQ for asynchronous message processing;
- implement proper error handling and retry strategies.

## Best Practices

- use standardized logs for delivery events;
- handle communication failures with retries and queues when necessary;
- keep notification messages configurable;
- validate the delivery channel according to the notification type;
- monitor delivery time and success rate;
- use RabbitMQ message queues for decoupling services;
- implement Dead Letter Queues (DLQ) for failed messages.

## Docker

The application can be containerized using the included Dockerfile. To build and run:

```bash
docker build -t notificacao-service:latest .
docker run -p 8081:8081 -e SPRING_RABBITMQ_HOST=host.docker.internal notificacao-service:latest
```

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
