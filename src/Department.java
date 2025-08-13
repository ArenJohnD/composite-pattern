import java.util.List;
import java.util.ArrayList;

class Department implements UniversityComponent {
    private String name;
    private List<UniversityComponent> components = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(UniversityComponent component) {
        components.add(component);
    }

    public void remove(UniversityComponent component) {
        components.remove(component);
    }

    @Override
    public double getBudget() {
        double teachersSalaries = 0;
        double studentsTuition = 0;
        
        for (UniversityComponent component : components) {
            if (component instanceof Teacher) {
                teachersSalaries += component.getBudget();
            } else if (component instanceof Student) {
                studentsTuition += Math.abs(component.getBudget());
            }
        }
        
        return teachersSalaries - studentsTuition;
    }

    @Override
    public int getNumberOfStudents() {
        int count = 0;
        for (UniversityComponent component : components) {
            if (component instanceof Student) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void displayComponentsFormatted() {
        for (UniversityComponent component : components) {
            if (component instanceof Teacher) {
                Teacher teacher = (Teacher) component;
                System.out.println("  • Teacher: " + teacher.getName());
                System.out.println("    - Subject: " + teacher.getSubject());
                System.out.printf("    - Salary: ₱%,.2f\n", teacher.getSalary());
                System.out.println();
            }
        }

        for (UniversityComponent component : components) {
            if (component instanceof Student) {
                Student student = (Student) component;
                System.out.println("  • Student: " + student.getName());
                System.out.println("    - ID: " + student.getId());
                System.out.printf("    - Tuition Fee: ₱%,.2f\n", student.getTuitionFee());
                System.out.println();
            }
        }
    }
}