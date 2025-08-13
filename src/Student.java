class Student implements UniversityComponent {
    private String name;
    private String id;
    private double tuitionFee;
    
    public Student(String name, String id, double tuitionFee) {
        this.name = name;
        this.id = id;
        this.tuitionFee = tuitionFee;
    }
    
    public String getName() {
        return name;
    }
    
    public String getId() {
        return id;
    }
    
    public double getTuitionFee() {
        return tuitionFee;
    }
    
    @Override
    public double getBudget() {
        return -tuitionFee;
    }
    
    @Override
    public int getNumberOfStudents() {
        return 1;
    }
    
    @Override
    public void displayComponentsFormatted() {

    }
}
