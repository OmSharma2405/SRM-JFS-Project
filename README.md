# SRM-JFS-Project: Java Full Stack Calculator Utility

A customized Maven-based Java Swing Calculator desktop application built for SRM-IST Java Full Stack practicals.

## 📌 Overview
This project provides a clean, responsive desktop arithmetic calculator implementing core operations with customized UI/UX styling, improved button designs, real-time input focus effects, and dynamic feedback indicators.

## 🚀 Features & Customizations
- **Arithmetic Operations**: Addition, Subtraction, Multiplication, Division.
- **Improved UI & Typography**: Custom rounded borders, styled buttons with hover effects, and Slate-inspired modern palette.
- **Enhanced Labels**: Intuitive button and field labels (`Add (+)`, `Subtract (−)`, `Multiply (×)`, `Divide (÷)`, `Exit`).
- **Focus Effects**: Highlighted borders on active input fields for improved user experience.
- **Error Handling & Feedback**:
  - Division by zero protection (`Error: Divide by 0`).
  - Input validation for non-numeric entries (`Invalid Input`).
  - Color-coded bottom status banner.

## 🛠️ Tech Stack
- **Language**: Java 8+ / Java 17
- **Framework**: Java Swing / AWT
- **Build Tool**: Apache Maven
- **Packaging**: Executable JAR (`maven-jar-plugin`)

## 📋 Prerequisites
- Java Development Kit (JDK 8 or higher)
- Apache Maven (3.6+)

## 💻 How to Build and Run

### 1. Build the Project
```bash
mvn clean package
```

### 2. Run the Application
```bash
java -jar target/calculator-executable-jar-1.0-SNAPSHOT.jar
```

Alternatively, use the convenience runner script:
```bash
./run.sh
```

## 📂 Project Structure
```text
├── pom.xml
├── README.md
├── run.sh
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── example
    │               └── myapp
    │                   └── App.java
    └── test
        └── java
            └── com
                └── example
                    └── myapp
                        └── AppTest.java
```
