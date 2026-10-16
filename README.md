# Envios de Paqueteria LogiExpress

Sistema de una empresa de paqueteria con envios nacionales, de documentos e internacionales.

## Detalle

| | |
|---|---|
| Tipo | Consola (MVC) |
| Archivos Java | 8 |
| Version de Java | 23 |
| Patron | Arquitectura MVC con jerarquia de clases de registro de envio |

## Funcionalidades

- Calculo de peso volumetrico
- Envios de usuario, documentos e internacionales
- Calculo de impuestos por pais
- Listado de envios mayores a 500 USD
- Generacion de identificadores UUID

## Estructura del proyecto

```
logiExpress/
|-- pom.xml       configuracion de Maven, importable desde cualquier IDE
|-- src/          codigo fuente
`-- README.md
```

## Como ejecutarlo

### Con Maven

```bash
mvn clean compile
mvn exec:java
```

### Con javac directamente

```bash
# Linux / macOS
javac -d bin $(find src -name "*.java")

# Windows (PowerShell)
javac -d bin (Get-ChildItem -Recurse -Filter *.java src).FullName
```

```bash
java -cp bin co.edu.unbosque.controller.AplMain
```

### Desde un IDE

Cualquier IDE con soporte de Java (Eclipse, IntelliJ IDEA, VS Code o NetBeans)
puede importar el proyecto directamente como **proyecto Maven**. Basta con abrir
o importar la carpeta: el IDE detecta el `pom.xml`, resuelve las dependencias y
compila sin configuracion adicional.

## Autor

Desarrollado por [Sergio Parra](https://github.com/P2X4A) como parte de su
formacion en Java.

## Licencia

Ver el archivo [LICENSE](LICENSE).