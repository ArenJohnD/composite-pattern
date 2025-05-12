import java.util.List;
import java.util.ArrayList;

class College implements UniversityComponent {
    private String name;
    private List<UniversityComponent> components = new ArrayList<>();
    
    public College(String name) {
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
        if (components.isEmpty()) {
            return 0;
        }
        
        double totalBudget = 0;
        for (UniversityComponent component : components) {
            totalBudget += component.getBudget();
        }
        return totalBudget;
    }
    
    @Override
    public int getNumberOfStudents() {
        if (components.isEmpty()) {
            return 0;
        }
        
        int totalStudents = 0;
        for (UniversityComponent component : components) {
            totalStudents += component.getNumberOfStudents();
        }
        return totalStudents;
    }
    
    @Override
    public void displayComponentsFormatted() {
        for (UniversityComponent component : components) {
            component.displayComponentsFormatted();
        }
    }
}