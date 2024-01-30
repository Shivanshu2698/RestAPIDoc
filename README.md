Description: This project specify the creation of REST API documentation for a Spring Boot project using Swagger and OpenAPI specification.

Swagger:
Swagger is a set of open-source tools that use the OpenAPI Specification to create, design, build, and document RESTful APIs. The Swagger toolset includes:
Swagger Editor: A web-based editor for designing OpenAPI specifications.
Swagger UI: A web-based interface for visualizing and interacting with OpenAPI specifications.

OpenAPI:
OpenAPI is the modern name for what was originally the Swagger Specification. The OpenAPI Specification is a standard, machine-readable format for describing, producing, consuming, and visualizing RESTful web services. It allows developers to define APIs in a language-agnostic way.

Key features of the OpenAPI Specification include:
Human-Readable: It is designed to be easy to read and write for both humans and machines.
Standardized Documentation: It provides a standardized way to document RESTful APIs.
Code Generation: Tools like Swagger Codegen use the OpenAPI Specification to generate client libraries, server stubs, and API documentation.

Library: 
For the integration between spring-boot and swagger-ui, add this library to pom.xml of your project
   <dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
      <version>2.3.0</version>
   </dependency>

By adding this library in pom.xml, this Automatically generates documentation in JSON/YAML and HTML format APIs. This documentation can be completed by comments using swagger-api annotations.
   
This will automatically deploy swagger-ui to a spring-boot application:
* Documentation will be available in HTML format, using the official swagger-ui jars

The Swagger UI page will then be available at http://localhost:8082/swagger-ui.html in a ui interface
and the OpenAPI description will be available at the following url for json format: http://localhost:8082/v3/api-docs

