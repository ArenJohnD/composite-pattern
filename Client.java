import java.util.List;
import java.util.ArrayList;

public class Client {

    public static void main(String[] args) {
        College university = new College("New Era University");

        College artsSciences = new College("College of Arts and Sciences");
        College computing = new College("College of Informatics and Computing Studies");

        university.add(artsSciences);
        university.add(computing);

        Department biology = new Department("Bachelor of Science in Biology");
        Department psychology = new Department("Bachelor of Science in Psychology");
        artsSciences.add(biology);
        artsSciences.add(psychology);

        Department computerScience = new Department("Bachelor of Science in Computer Science");
        Department informationTech = new Department("Bachelor of Science in Information Technology");
        computing.add(computerScience);
        computing.add(informationTech);

        Teacher bioTeacher1 = new Teacher("Dr. Maria Santos", "Molecular Biology", 95000);
        Teacher bioTeacher2 = new Teacher("Prof. Juan Dela Cruz", "Genetics", 90000);
        biology.add(bioTeacher1);
        biology.add(bioTeacher2);
        Student bioStudent1 = new Student("Angela Reyes", "BIO001", 85000);
        Student bioStudent2 = new Student("Bryan Cruz", "BIO002", 80000);
        Student bioStudent3 = new Student("Carla Gomez", "BIO003", 75000);
        biology.add(bioStudent1);
        biology.add(bioStudent2);
        biology.add(bioStudent3);

        Teacher psyTeacher1 = new Teacher("Dr. Liza Villanueva", "Cognitive Psychology", 100000);
        Teacher psyTeacher2 = new Teacher("Prof. Mark Navarro", "Behavioral Psychology", 90000);
        psychology.add(psyTeacher1);
        psychology.add(psyTeacher2);
        Student psyStudent1 = new Student("Daniel Bautista", "PSY001", 85000);
        Student psyStudent2 = new Student("Erika Mendoza", "PSY002", 80000);
        Student psyStudent3 = new Student("Francis Lim", "PSY003", 75000);
        psychology.add(psyStudent1);
        psychology.add(psyStudent2);
        psychology.add(psyStudent3);

        Teacher csTeacher1 = new Teacher("Dr. Kevin Tan", "Data Structures and Algorithms", 98000);
        Teacher csTeacher2 = new Teacher("Prof. Sheila Ramos", "Artificial Intelligence", 92000);
        computerScience.add(csTeacher1);
        computerScience.add(csTeacher2);
        Student csStudent1 = new Student("Gerald Aquino", "CS001", 90000);
        Student csStudent2 = new Student("Hazel Uy", "CS002", 85000);
        Student csStudent3 = new Student("Ivan Morales", "CS003", 80000);
        computerScience.add(csStudent1);
        computerScience.add(csStudent2);
        computerScience.add(csStudent3);

        Teacher itTeacher1 = new Teacher("Dr. Robert Chua", "Network Security", 95000);
        Teacher itTeacher2 = new Teacher("Prof. Camille Soriano", "Web Development", 90000);
        informationTech.add(itTeacher1);
        informationTech.add(itTeacher2);
        Student itStudent1 = new Student("Jasmine Lee", "IT001", 85000);
        Student itStudent2 = new Student("Kenneth Sy", "IT002", 80000);
        Student itStudent3 = new Student("Liza Fernandez", "IT003", 75000);
        informationTech.add(itStudent1);
        informationTech.add(itStudent2);
        informationTech.add(itStudent3);


        displayTitle("UNIVERSITY STRUCTURE");
        System.out.println();
        System.out.println("• University: " + university.getName());
        System.out.println("• Number of Students: " + university.getNumberOfStudents());
        System.out.printf("• Budget: %s₱%,.2f\n", university.getBudget() >= 0 ? "" : "-", Math.abs(university.getBudget()));
        System.out.println();

        List<CollegeStructure> collegesToDisplay = new ArrayList<>();
        collegesToDisplay.add(new CollegeStructure("COLLEGE OF ARTS AND SCIENCES", artsSciences, List.of(biology, psychology)));
        collegesToDisplay.add(new CollegeStructure("COLLEGE OF INFORMATICS AND COMPUTING STUDIES", computing, List.of(computerScience, informationTech)));

        for (int i = 0; i < collegesToDisplay.size(); i++) {
            CollegeStructure currentCollegeInfo = collegesToDisplay.get(i);
            displayTitle(currentCollegeInfo.title);
            System.out.println();
            
            College currentCollege = currentCollegeInfo.collegeObject;
            System.out.println("• Number of Students: " + currentCollege.getNumberOfStudents());
            System.out.printf("• Budget: %s₱%,.2f\n", currentCollege.getBudget() >= 0 ? "" : "-", Math.abs(currentCollege.getBudget()));
            System.out.println();
            displaySeparator();
            System.out.println();

            List<Department> departmentsInCollege = currentCollegeInfo.departments;
            for (int j = 0; j < departmentsInCollege.size(); j++) {
                Department currentDepartment = departmentsInCollege.get(j);
                displaySingleDepartmentContents(currentDepartment); 

                boolean isLastDepartmentInThisCollege = (j == departmentsInCollege.size() - 1);
                boolean isAnotherCollegeFollowing = (i < collegesToDisplay.size() - 1);

                if (isLastDepartmentInThisCollege && isAnotherCollegeFollowing) {
                } else {
                    displaySeparator();
                }

                if (!isLastDepartmentInThisCollege) {
                    System.out.println();
                }
            }
        }
    }

    static class CollegeStructure {
        String title;
        College collegeObject; 
        List<Department> departments;

        CollegeStructure(String title, College collegeObject, List<Department> departments) {
            this.title = title;
            this.collegeObject = collegeObject;
            this.departments = departments;
        }
    }

    private static void displayTitle(String title) {
        String separatorLine = "==============================================================";
        System.out.println(separatorLine);
        if (title != null && !title.isEmpty()) {
            int paddingLength = (60 - title.length()) / 2; 
            paddingLength = Math.max(0, paddingLength);
            for (int k = 0; k < paddingLength; k++) {
                System.out.print(" ");
            }
            System.out.println(title);
        }
        System.out.println(separatorLine);
    }

    private static void displaySeparator() {
        System.out.println("==============================================================");
    }

    private static void displaySingleDepartmentContents(Department department) {
        System.out.println("• Department: " + department.getName());
        System.out.println("• Number of Students: " + department.getNumberOfStudents());
        System.out.printf("• Budget: %s₱%,.2f\n", department.getBudget() >= 0 ? "" : "-", Math.abs(department.getBudget()));
        
        System.out.println();
        displaySeparator(); 
        System.out.println();
        
        System.out.println("• Components:");
        department.displayComponentsFormatted();
    }
}