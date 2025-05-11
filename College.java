class College implements UniversityComponent {
    private String name;
    private java.util.List<UniversityComponent> components = new java.util.ArrayList<>();
    
    public College(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void add(UniversityComponent component) {
        components.add(component);
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