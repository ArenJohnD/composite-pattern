# University Organizational Hierarchy System

<p>New Era University is composed of various organizational units. These units can be either individual entities or compositions of other entities. The system should be able to represent the following:</p>

### Organizational Units:

- **Colleges**: A college is a high-level organizational unit (e.g., "College of Engineering", "College of Business"). A college can contain departments, teachers, and students. It can also contain other colleges (e.g., a university is composed of several colleges).

- **Departments**: A department is a subdivision within a college, focusing on a specific subject (e.g., "Department of Computer Science", "Department of Information Technology"). A department can contain teachers and students.

- **Teachers**: A teacher is an individual entity responsible for instructing students. Each teacher has a name, a subject they teach, and a salary.

- **Students**: A student is an individual entity enrolled in a college or department. Each student has a name, a unique student ID, and pays a tuition fee.

### Requirements:

1. **Model the hierarchical structure**:  
   The system must accurately represent the "part-whole" relationship between the different entities (e.g., a college *has-a* department, a department *has-a* teacher).

2. **Calculate the number of students**:  
   The system should be able to calculate the total number of students within any given college, including students in its departments and sub-colleges.

3. **Display details**:  
   The system should be able to display the details of any educational unit (college, department, teacher, or student) in a clear and organized manner.

4. **Calculate the budget**:  
   The system should be able to calculate the total budget for a college.  
   - The budget for a college is the sum of the budgets of its departments and teachers, and the negative sum of the tuition fees of the students.  
   - The budget of a department is the sum of the budgets of its teachers and the negative sum of the tuition fees of the students in that department.  
   - A teacher's budget is their salary.  
   - A student's budget is the negative value of their tuition fee.

### Tasks:

1. **Design a UML class diagram**:  
   Create a UML class diagram that illustrates the classes, interfaces, and relationships involved in the system.

2. **Implement the system in Java**:  
   Write Java code that implements the design, adhering to the Composite Design Pattern.

3. **Create a client program**:  
   Write a client program that demonstrates the functionality of the system by:
   - Creating instances of colleges, departments, teachers, and students.
   - Organizing these instances into a hierarchical structure.
   - Displaying the details of a college.
   - Calculating and displaying the total number of students in a college.
   - Calculating and displaying the total budget of a college.

### UML Class Diagram:

![Composite Design Pattern](https://github.com/user-attachments/assets/c2c79ee6-52d9-44e4-aa6e-2621afde16d5)
