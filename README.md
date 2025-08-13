# University Structure Manager

A Java implementation of the Composite Design Pattern to model a university’s organizational hierarchy (university → colleges → departments → teachers and students). It demonstrates uniform treatment of individual and composite objects and recursive aggregation of data.

## 📋 Overview

The University Structure Manager lets you compose a hierarchy of colleges and departments containing teachers and students. Using the Composite pattern, the application can:

- Compute total student counts at any level
- Compute aggregate budgets by summing salaries and subtracting tuitions
- Display formatted details for any composite

## 🏗️ Architecture

This project implements the Composite Design Pattern with the following components:

- **UniversityComponent (interface)**: Defines the contract for all units (budget, student count, display)
- **Composite classes**: `College`, `Department`
- **Leaf classes**: `Teacher`, `Student`
- **Main application**: `Client` builds a sample hierarchy and prints summaries

### Design Pattern Benefits

- **Uniformity**: Treat groups and single objects through a common interface
- **Extensibility**: Add new units (leaves or composites) without changing existing client code
- **Recursive aggregation**: Totals are computed by delegating to child components

## 📊 UML Class Diagram

![UML Class Diagram](UML%20Class%20Diagram.png)

The diagram shows the `UniversityComponent` interface, composite implementations (`College`, `Department`), leaf implementations (`Teacher`, `Student`), and the `Client` that composes them.

## 🚀 Features

- **Multi-level hierarchy**: University → Colleges → Departments → Teachers/Students
- **Recursive metrics**: Student counts and budgets roll up automatically
- **Formatted console output**: Clear summaries and component listings
- **Easy to extend**: Implement `UniversityComponent` for new unit types

## 📁 Project Structure

```
university-structure-composite/
├── src/
│   ├── UniversityComponent.java      # Component interface
│   ├── College.java                  # Composite: contains components
│   ├── Department.java               # Composite: contains components
│   ├── Teacher.java                  # Leaf: salary contributes to budget
│   ├── Student.java                  # Leaf: tuition (negative) contributes to budget
│   └── Client.java                   # Main application demo
└── README.md                         # Project documentation
```

## 🛠️ Installation & Setup

### Prerequisites

- Java Development Kit (JDK) 8 or higher

### Getting Started

1. Navigate to the project directory
2. Compile the Java files

   Windows PowerShell:
   ```powershell
   javac src\*.java
   ```

   macOS/Linux (bash/zsh):
   ```bash
   javac src/*.java
   ```

3. Run the application

   Windows PowerShell and macOS/Linux:
   ```bash
   java -cp src Client
   ```

## 📖 Usage

The main application (`Client.java`) builds a sample structure. To create your own programmatic structure:

```java
College university = new College("New Era University");

College arts = new College("College of Arts and Sciences");
Department biology = new Department("Bachelor of Science in Biology");
biology.add(new Teacher("Dr. Maria Santos", "Molecular Biology", 95_000));
biology.add(new Student("Angela Reyes", "BIO001", 85_000));
arts.add(biology);

university.add(arts);

System.out.println("Students: " + university.getNumberOfStudents());
System.out.printf("Budget: %s₱%,.2f\n",
        university.getBudget() >= 0 ? "" : "-", Math.abs(university.getBudget()));
```

## ✅ Expected Output (abridged)

```text
==============================================================
                     UNIVERSITY STRUCTURE
==============================================================

• University: New Era University
• Number of Students: 12
• Budget: -₱225,000.00

==============================================================
             COLLEGE OF ARTS AND SCIENCES
==============================================================

• Number of Students: 6
• Budget: -₱105,000.00

==============================================================
• Department: Bachelor of Science in Biology
• Number of Students: 3
• Budget: -₱55,000.00

• Components:
  • Teacher: Dr. Maria Santos
    - Subject: Molecular Biology
    - Salary: ₱95,000.00
  ...
```

Totals correspond to values constructed in `Client.java` and are computed recursively via the Composite pattern.

## 🔧 Extending the Project

Add a new unit (e.g., `Staff`) by implementing `UniversityComponent`:

```java
class Staff implements UniversityComponent {
    private final String name;
    private final double salary;

    Staff(String name, double salary) { this.name = name; this.salary = salary; }
    public double getBudget() { return salary; }
    public int getNumberOfStudents() { return 0; }
    public void displayComponentsFormatted() { /* print details if needed */ }
}
```

Then add instances of `Staff` to a `Department` or `College` using their `add(...)` method.

## 🎯 Design Patterns Used

### Composite Pattern
- **Purpose**: Treat individual and composite objects uniformly
- **Benefits**: Simplifies client code, supports recursive aggregation, and eases extension
- **Implementation**: `UniversityComponent` as the component interface; `College`/`Department` as composites; `Teacher`/`Student` as leaves

## 🤝 Contributing

Contributions are welcome:
- Improve documentation and examples
- Add new composite/leaf types
- Enhance formatting or add tests

## 📄 License

Educational project; add a LICENSE file to specify reuse terms if you plan to distribute.

**Note**: This implementation demonstrates clean code principles and design patterns best practices. The Composite pattern is particularly useful when representing part–whole hierarchies, when you need to perform recursive operations over tree structures, or when clients should treat individual objects and compositions uniformly.
