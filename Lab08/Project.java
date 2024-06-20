/**
 * Project
 */
import java.time.LocalDate;
public class Project {

    //Constant Data Members
    public static final double TAX = 0.13;
    public static final int OVERHEAD = 50000;
    public static final int EMP_HOURS_WEEK = 45;

    //Static data members:
    private static int projectCounter = 5000;

    //Instance Data Members
    private String projectId;
    private String projectName;
    private char projectType;
    private int personHours;
    private double ratePerHour;
    private int projectWeeks;

    public Project(String projectName, int personHours, double ratePerHour, int projectWeeks) {
        //Counts the project.
        projectCounter++;
        //Initializes the projectName to the value passed as a parameter. 
    	this.projectName = projectName;
        //set method to initialize
        setProjectId();
        setProjectType();
        setPersonHours(personHours);
        setRatePerHour(ratePerHour);
        setProjectWeeks(projectWeeks);
    }

    // accessor methods
    public String getProjectName(){
    	return this.projectName;
    }

    public String getProjectId(){
    	return this.projectId;
    }

    public char getProjectType(){
    	return this.projectType;
    }

    public int getPersonHours(){
    	return this.personHours;
    }

    public double getRatePerHour(){
    	return this.ratePerHour;
    }

    public int getProjectWeeks(){
    	return this.projectWeeks;
    }


    //mutator methods
    public void setProjectName(String projectName){
        this.projectName = projectName;
    }
    
    public void setPersonHours(int personHours){
        if(personHours > 0){
            this.personHours = personHours;
        }
    }

    public void setRatePerHour(double ratePerHour){
        if (ratePerHour > 0) {
            this.ratePerHour = ratePerHour;

        }
    }

    public void setProjectWeeks(int projectWeeks){
        if (projectWeeks > 0) {
            this.projectWeeks = projectWeeks;

        }
    }

    private void setProjectId() {
        LocalDate today = LocalDate.now();
    	int year = today.getYear();
        projectId= year + "-" + projectCounter;
    }

    public void setProjectType() {
        double cost = calculateProjectCost();
        if (cost > 1000000) {
            projectType = 'm';
        }

        else if (cost > 500000) {
            projectType = 'l';
        }

        else if (cost > 0) {
            projectType = 's';
        }

        else if (cost == 0) {
            projectType = 'i';
        }
    }


    // Service Methods
    public void deactivateProject() {
        projectType = 'i';
        personHours = 0;
        ratePerHour = 0;
    }

    public void activateProject(int personHours, double ratePerHour) {
        setPersonHours(personHours);
        setRatePerHour(ratePerHour);
        setProjectType();
    }

    public double calculateProjectCost(){
        double cost = personHours*ratePerHour;
        if (cost<20000) {
            cost = (cost+OVERHEAD)*(1+TAX);
        } 
        else {
            cost = cost*(1+TAX);
        }
        return cost;
    }

    public int calculatePersonResources(){
        int personResources = (int) 1.0 * personHours / (projectWeeks*EMP_HOURS_WEEK);
        return personResources;
    }

    public String toString(){
    	String output;
        if (projectType == 'i') {
            output = "-------INACTIVE PROJECT------" + "\n" +
            "Project Name: " + projectName + "\n" +
            "Project ID: " + projectId + "\n";
        } 
        else {
            output = "Project Name: " + projectName + "\n" +
            "Project ID: " + projectId + "\n" +
            "Project Type: " + projectType + "\n" +
            "Team Size: " + calculatePersonResources() + "\n" +
            "Estimated Project Cost: " + calculateProjectCost() + "\n";
        }
    	return output;
    }








}