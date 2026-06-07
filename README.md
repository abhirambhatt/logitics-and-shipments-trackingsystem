# Logistics & Shipment Tracking System

## Overview

The Logistics Shipment Tracking System is a Spring Boot REST API application developed for managing logistics operations including customer management, driver management, warehouse management, shipment management, authentication, and shipment tracking.

The application follows a layered architecture consisting of Controller, Service, Repository, DTO, Entity, Security, and Exception layers.

It implements JWT Authentication and Role-Based Authorization using Spring Security.

---

# Features

## Authentication

- User Registration
- User Login
- JWT Token Generation
- BCrypt Password Encryption
- Role-Based Access Control

---

## Customer Management

- Create Customer
- Get Customer By Id
- Get All Customers
- Update Customer
- Delete Customer

---

## Driver Management

- Create Driver
- Get Driver By Id
- Get All Drivers
- Update Driver
- Delete Driver

---

## Warehouse Management

- Create Warehouse
- Get Warehouse By Id
- Get All Warehouses
- Update Warehouse
- Delete Warehouse

---

## Shipment Management

- Create Shipment
- Get Shipment By Id
- Get All Shipments
- Update Shipment Status
- Delete Shipment

---

## Shipment Tracking

Customers can track their shipment using a Tracking Number (AWB).

Tracking Response contains

- Tracking Number
- Shipment Status
- Source Address
- Destination Address
- Created Date
- Tracking History

Each Tracking History contains

- Location
- Status
- Remarks
- Created Date

---

# Technology Stack

- Java 21
- Spring Boot
- Spring MVC
- Spring Data JPA
- Spring Security
- JWT Authentication
- Hibernate
- MySQL
- Maven
- Lombok
- Swagger OpenAPI

---

# Project Structure

```
Logistics.ShipmentsTrackingSystem.Logistics.LSTS
│
├── config
│   ├── OpenApiConfig
│   ├── PasswordConfig
│   ├── SecurityConfig
│   └── SwaggerSecurityConfig
│
├── controller
│   ├── AuthController
│   ├── CustomerController
│   ├── DriverController
│   ├── ShipmentController
│   ├── TrackingController
│   ├── UserController
│   └── WarehouseController
│
├── dto
│   │
│   ├── Request
│   │   ├── CreateCustomerRequest
│   │   ├── CreateDriverRequest
│   │   ├── CreateShipmentRequest
│   │   ├── CreateWarehouseRequest
│   │   ├── LoginRequest
│   │   ├── RegisterRequest
│   │   └── UpdateShipmentStatusRequest
│   │
│   └── Response
│       ├── AuthResponse
│       ├── TrackingHistoryResponse
│       └── TrackingResponse
│
├── entity
│   ├── Customer
│   ├── Driver
│   ├── Shipment
│   ├── TrackingHistory
│   ├── Users
│   └── Warehouse
│
├── enums
│   ├── Role
│   └── ShipmentStatus
│
├── exception
│   ├── ErrorResponse
│   ├── GlobalExceptionHandler
│   └── NotFoundException
│
├── repository
│   ├── CustomerRepository
│   ├── DriverRepository
│   ├── ShipmentRepository
│   ├── TrackingHistoryRepository
│   ├── UserRepository
│   └── WarehouseRepository
│
├── security
│   ├── JwtFilter
│   ├── JwtUtil
│   └── UserCustomDetailsService
│
├── service
│   ├── AuthService
│   ├── CustomerService
│   ├── DriverService
│   ├── ShipmentService
│   ├── TrackingService
│   ├── UserService
│   └── WarehouseService
│
├── ServiceImpl
│   ├── AuthServiceImpl
│   ├── CustomerServiceImpl
│   ├── DriverServiceImpl
│   ├── ShipmentServiceImpl
│   ├── TrackingServiceImpl
│   ├── UserServiceImpl
│   └── WarehouseServiceImpl
│
├── Application.java
│
└── resources
```

---

# Database Entities

## Users

```
id
username
password
role
```

---

## Customer

```
id
customerName
email
phoneNumber
address
```

---

## Driver

```
id
driverName
phoneNumber
licenseNumber
vehicleNumber
```

---

## Warehouse

```
id
warehouseName
location
capacity
```

---

## Shipment

```
id
trackingNumber
weight
description
shipmentStatus
sourceAddress
destinationAddress
createdDate
customer
driver
warehouse
trackingHistory
```

---

## TrackingHistory

```
id
location
status
remarks
createdDate
shipment
```

---

# Roles

## ADMIN

- Create Users
- Manage Customers
- Manage Drivers
- Manage Warehouses
- Manage Shipments

---

## MANAGER

- Manage Customers
- Manage Shipments
- View Warehouses

---

## EMPLOYEE

- View Warehouses
- Update Shipment Status

---

## USER

- Login
- Track Shipment Using Tracking Number

---

# Authentication APIs

## Register

```
POST /api/auth/register
```

Request

```json
{
    "username": "username001",
    "password": "password123"
}
```

---

## Login

```
POST /api/auth/login
```

Request

```json
{
    "username": "username001",
    "password": "password123"
}
```

Response

```json
{
    "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

---

# Customer APIs

```
POST    /api/customer
GET     /api/customer
GET     /api/customer/{id}
PUT     /api/customer/{id}
DELETE  /api/customer/{id}
```

---

# Driver APIs

```
POST    /api/driver
GET     /api/driver
GET     /api/driver/{id}
PUT     /api/driver/{id}
DELETE  /api/driver/{id}
```

---

# Warehouse APIs

```
POST    /api/warehouse
GET     /api/warehouse
GET     /api/warehouse/{id}
PUT     /api/warehouse/{id}
DELETE  /api/warehouse/{id}
```

---

# Shipment APIs

```
POST    /api/shipment
GET     /api/shipment
GET     /api/shipment/{id}
PUT     /api/shipment/status/{id}
DELETE  /api/shipment/{id}
```

---

# Tracking API

Track shipment using AWB / Tracking Number.

```
GET /api/tracking/{trackingNumber}
```

Example

```
GET /api/tracking/TRK-1780762068938
```

Sample Response

```json
{
    "trackingNumber": "TRK-1780762068938",
    "shipmentStatus": "IN_TRANSIT",
    "sourceAddress": "Bangalore",
    "destinationAddress": "Mysore",
    "createdDate": "2026-06-07T10:30:00",
    "trackingHistory": [
        {
            "location": "Bangalore Warehouse",
            "status": "Shipment Picked",
            "remarks": "Package received",
            "createdDate": "2026-06-07T11:00:00"
        },
        {
            "location": "Mandya Hub",
            "status": "In Transit",
            "remarks": "Shipment moving",
            "createdDate": "2026-06-08T09:15:00"
        }
    ]
}
```

---

# Security

JWT Authentication is implemented using

```
JwtFilter
JwtUtil
UserCustomDetailsService
SecurityConfig
```

Protected APIs require

```
Authorization

Bearer <JWT_TOKEN>
```

---

# Public APIs

```
POST /api/auth/register

POST /api/auth/login

GET /api/tracking/{trackingNumber}
```

---

# Exception Handling

Global exception handling is implemented using

```
GlobalExceptionHandler
```

Custom exceptions

```
NotFoundException

ErrorResponse
```

---

# Run the Project

Clone Repository

```
git clone https://github.com/yourusername/logistics-shipment-tracking-system.git
```

Go to project directory

```
cd logistics-shipment-tracking-system
```

Configure MySQL

```
application.properties
```

Build

```
mvn clean install
```

Run

```
mvn spring-boot:run
```

---

# Swagger

```
http://localhost:8080/swagger-ui/index.html
```

# Author

Abhiram

Java Backend Developer

Spring Boot | Spring Security | JWT | REST APIs | Hibernate | MySQL
