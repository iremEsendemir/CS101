import java.util.ArrayList;
public class EmployeeApp {
    public static void main(String[] args) {
        Project p1 = new Project("SunMarkets POS", 15000, 50, 8);
        Employee e1 = new Employee("Karakus, Zana", 10, p1, "Information Technology", "IT");
        Employee e2 = new Employee("Rocca, Denis", 100,  p1, "Human Resources", "HR");
        Employee e3 = new Employee("Anders, Jamie", 70, p1, "Human Resources", "HR");
        Employee copied = new Employee(e1);

        String s1 = e1.toString();
        String s2 = e2.toString();
        String s3 = e3.toString();
        String s4 = copied.toString();

        System.out.println(s1 + s2 + s3 +s4);
        System.out.println("--------- end employee list ----------");
        
        Employee[] employeeList = {e1, e2, e3, copied};
        ArrayList<String> deptList = new ArrayList<String>();
        for (int i = 0; i < employeeList.length; i++) {
            if (!deptList.contains(employeeList[i].getDepartment().getDeptCode())) {
                deptList.add(employeeList[i].getDepartment().getDeptCode());
            }
        }
        for (int i = 0; deptList.size()>1 && i < deptList.size(); i++) {
            System.out.println("_____________________");
            System.out.printf("Employees with Matching Departments (%d)%n", i+1);
            for (int j = 0; j < employeeList.length; j++) {
                if (employeeList[j].getDepartment().getDeptCode().equals(deptList.get(i))) {
                    System.out.println(employeeList[j].toString()); 
                }
            }
        }
    }
}
