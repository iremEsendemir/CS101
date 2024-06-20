public class Employee {
    public static final int WORKING_DAYS = 261;

    private String employeeName;
    private double dailyRate;
    private Department department;
    private Project project;

    //constructor
    public Employee(String employeeName, double dailyRate, Project project, String deptName, String deptCode){
        this.employeeName = employeeName;
        this.dailyRate = dailyRate;
        this.project = project;
        Department d1 = new Department(deptName, deptCode);
        department = d1;
    }

    //copy constructor
	public Employee( Employee toCopy ){
		this.employeeName = toCopy.employeeName;
		this.dailyRate = toCopy.dailyRate;
		this.department = toCopy.department;
		this.project = toCopy.project;
	}

    // accessor methods
    public String getEmployeeName() {
        return this.employeeName;
    }

    public double getDailyRate() {
        return this.dailyRate;
    }

    public Department getDepartment() {
        return this.department;
    }

    public Project getProject(){
        return this.project;
    }


    // mutator methods
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public double calculateYearlySalary(){
        double salary = dailyRate * WORKING_DAYS;
        return salary;
    }

    public String toString(){
        String deptString = department.toString();
        String output = "Employee Name: " + employeeName + " Yearly Salary:  " + calculateYearlySalary() + "\n"+
        deptString + "Project Name: " + project.getProjectName() + "\n"+
        "Implementation " + "\n"+
        "Project ID: " + project.getProjectId() + "\n"+
        "Project Type: " + project.getProjectType() + "\n"+
        "Team Size: " + project.calculatePersonResources() + "\n"+
        "Estimated Project Cost: " + this.project.calculateProjectCost() + "\n" + "\n"; 
        return output; 
    }



}
