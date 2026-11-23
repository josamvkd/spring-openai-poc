# Spring OpenAI POC

A Proof of Concept (POC) demonstrating the integration of **Spring Boot with OpenAI APIs** to build AI-powered Java applications using RESTful APIs, prompt handling, and AI-generated responses.

This project explores how to integrate Large Language Models (LLMs) into Spring Boot applications using **Spring AI**, enabling developers to build intelligent, scalable, and maintainable backend services.

## 🚀 Features

The POC is designed to explore the following capabilities:

- **OpenAI Integration:** Connect Spring Boot applications with OpenAI models.
- **Spring AI Framework:** Simplify AI model integration using Spring AI abstractions.
- **RESTful APIs:** Expose AI capabilities through REST endpoints.
- **Prompt Handling:** Accept user prompts and generate contextual AI responses.
- **AI-Powered Responses:** Generate natural-language responses using LLMs.
- **Configuration Management:** Manage API keys and model configurations externally.
- **Extensible Architecture:** Provide a foundation for future AI-powered microservices.

## 🛠️ Technology Stack

| Technology | Purpose |
|---|---|
| Java 17+ | Backend development |
| Spring Boot | Application framework |
| Spring AI | AI integration framework |
| OpenAI API | Large Language Model integration |
| Maven | Build and dependency management |
| REST APIs | Client-server communication |
| Postman | API testing |

## 📋 Prerequisites

Before running the application, ensure the following are installed or available:

- JDK 17 or higher (compatible with your Spring Boot version)
- Maven
- An IDE such as IntelliJ IDEA or Spring Tool Suite
- An OpenAI API key
- Internet connectivity to access OpenAI APIs

## ⚙️ Installation and Setup

### 1. Clone the Repository

```bash
git clone https://github.com/<your-username>/spring-openai-poc.git
cd spring-openai-poc
```

Replace `<your-username>` with your GitHub username.

### 2. Configure the OpenAI API Key

Create an API key from the [OpenAI Platform](https://platform.openai.com/api-keys).

Set the key as an environment variable.

**macOS / Linux**

```bash
export OPENAI_API_KEY="your-openai-api-key"
```

**Windows PowerShell**

```powershell
$env:OPENAI_API_KEY="your-openai-api-key"
```

**Important:** Never commit your actual API key to GitHub.

### 3. Configure application.properties

Example configuration for a Spring AI application using OpenAI:

```properties
spring.application.name=spring-openai-poc

spring.ai.openai.api-key=${OPENAI_API_KEY}
spring.ai.openai.chat.options.model=gpt-4o-mini

server.port=8080
```

The model name is an example and can be changed to another supported model.

### 4. Add Spring AI Dependency

For a Maven-based project using a compatible Spring AI version, include the OpenAI model starter:

```xml
<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-starter-model-openai</artifactId>
</dependency>
```

Configure the compatible Spring AI BOM or dependency version in your `pom.xml`.

### 5. Build the Application

```bash
mvn clean install
```

### 6. Run the Application

```bash
mvn spring-boot:run
```

By default, the example application runs at:

```text
http://localhost:8080
```

## 🔌 REST API Example

The following demonstrates a possible REST API design for the POC. The endpoint and implementation must exist in your project before these requests will work.

### Generate an AI Response

**Endpoint**

```http
GET /api/ai/chat
```

**Request**

```bash
curl -G "http://localhost:8080/api/ai/chat" \
  --data-urlencode "message=Explain Spring Boot in simple terms"
```

**Example Response**

```text
Spring Boot is a Java framework that simplifies
application development by providing automatic
configuration, embedded servers, and production-ready
features.
```

## 💻 Sample Implementation

The following example illustrates how a Spring Boot REST controller can interact with OpenAI using Spring AI's `ChatClient`.

```java
package com.example.springopenaipoc.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai")
public class OpenAIController {

    private final ChatClient chatClient;

    public OpenAIController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}
```

This example demonstrates:

1. Accepting user prompts through REST APIs.
2. Using Spring AI's `ChatClient` abstraction.
3. Sending requests to the configured OpenAI model.
4. Returning AI-generated responses to clients.

## 📁 Example Project Structure

```text
spring-openai-poc/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/springopenaipoc/
│   │   │       ├── controller/
│   │   │       │   └── OpenAIController.java
│   │   │       └── SpringOpenAiPocApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       └── java/
│
├── .gitignore
├── pom.xml
└── README.md
```

This structure is illustrative and should be updated to reflect the actual repository.

## 🔐 Security Best Practices

- Store OpenAI API keys in environment variables or a secrets manager.
- Never hardcode credentials in Java source files.
- Exclude sensitive configuration files from version control.
- Validate incoming user requests.
- Configure API timeouts and error handling.
- Apply authentication, authorization, and rate limiting before exposing endpoints publicly.
- Monitor API usage and associated costs.

## 🔮 Future Enhancements

Potential areas for further exploration include:

- Conversational AI with chat history.
- Streaming AI responses.
- Retrieval-Augmented Generation (RAG).
- Vector database integration.
- Function calling and tool integration.
- Structured AI responses.
- AI-powered document processing.
- Docker containerization.
- Observability and API usage monitoring.
- Integration with enterprise microservices.

## 🎯 Learning Objectives

The primary objectives of this POC are to:

- Understand OpenAI integration with Java and Spring Boot.
- Explore Spring AI's model abstractions.
- Build RESTful services powered by LLMs.
- Learn prompt engineering fundamentals.
- Understand API configuration and credential management.
- Establish a foundation for enterprise AI applications.

## 📚 References

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/)
- [Spring AI Documentation](https://docs.spring.io/spring-ai/reference/)
- [OpenAI API Documentation](https://platform.openai.com/docs/)
- [OpenAI API Keys](https://platform.openai.com/api-keys)

## 📄 License

This project is intended for educational, experimental, and proof-of-concept purposes. No open-source license is implied unless a LICENSE file is added.

---

**Spring OpenAI POC** — Exploring Generative AI integration with Java, Spring Boot, and OpenAI APIs.
