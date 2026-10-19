# Courier Management System - logiExpress

## Description

Management system for a courier company that handles national package shipments, document shipments and international shipments, with registered users. Console application built with **MVC** separation and one model class per shipment type.

Academic project developed for the **Java programming** courses - Systems Engineering, Universidad El Bosque.

## Author

- Sergio Alejandro Parra Rivera

## Technologies

- Java 21 (compiled with `maven-compiler-plugin`)
- Maven 3.8+ with `exec-maven-plugin` to run the application
- **MVC** architecture (`controller`, `model`, `view`)
- Model classes per shipment type (`RegistroPaquete`, `RegistroDocumento`, `EnvioInternacional`)

## Requirements

| Requirement | Version | How to check |
| --- | --- | --- |
| JDK | 21 or higher | `javac -version` |
| Maven | 3.8 or higher | `mvn -v` |
| Git | Any recent version | `git --version` |

## Installation

Follow these steps exactly so the application runs on the first try.

### 1. Clone the repository

```bash
git clone https://github.com/P2X4A/logiExpress.git
```

### 2. Enter the project folder

```bash
cd logiExpress
```

> On Windows, if your path contains spaces, always quote it, for example: `cd "C:\Users\Example\Documents\logiExpress"`.

### 3. Verify your environment

```bash
javac -version
mvn -v
```

Expected: JDK 21 (or higher) and Maven 3.8 (or higher). If any command fails, install or update that tool before continuing.

### 4. Compile the project

```bash
mvn clean compile
```

What success looks like:

- The console ends with `BUILD SUCCESS`.
- A `target/classes/` folder is created with the compiled classes.

## Running the application

```bash
mvn exec:java
```

The menu is displayed in the terminal: register users and shipments by type (national packages, documents or international).

Troubleshooting:

- `ClassNotFoundException` or missing main class: compile first with `mvn clean compile`.
- `UnsupportedClassVersionError`: your JDK is older than 21; install JDK 21 or higher and check it with `javac -version`.

## Main features

- **Users:** register the users who ship and receive (`RegistroUsuario`).
- **Shipment types:** national packages (`RegistroPaquete`), documents (`RegistroDocumento`) and international shipments (`EnvioInternacional`), each with its own model class.
- **Company model:** `LogiExpress` holds the shipments registry and the rules of the company.
- **Console MVC:** `Controlador` coordinates, the `model` package holds the domain and `Consola` renders the menu.

## Project structure

```text
logiExpress/
├── pom.xml
├── README.md
├── LICENSE
└── src/
    └── co/edu/unbosque/
        ├── controller/
        │   ├── AplMain.java               # Entry point (main class)
        │   └── Controlador.java           # Application controller (MVC)
        ├── model/
        │   ├── LogiExpress.java           # Company model
        │   ├── RegistroUsuario.java       # Registered user
        │   ├── RegistroPaquete.java       # National package shipment
        │   ├── RegistroDocumento.java     # Document shipment
        │   └── EnvioInternacional.java    # International shipment
        └── view/
            └── Consola.java               # Console interface
```
