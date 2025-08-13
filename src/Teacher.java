class Teacher implements UniversityComponent {
    private String name;
    private String subject;
    private double salary;
    
    public Teacher(String name, String subject, double salary) {
        this.name = name;
        this.subject = subject;
        this.salary = salary;
    }
    
    public String getName() {
        return name;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public double getSalary() {
        return salary;
    }
    
    @Override
    public double getBudget() {
        return salary;
    }
    
    @Override
    public int getNumberOfStudents() {
        return 0;
    }
    
    @Override
    public void displayComponentsFormatted() {

    }
}
