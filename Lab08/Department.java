public class Department {
    private String deptName;
    private String deptCode;

    //Constructor
    public Department(String deptName, String deptCode){
        this.deptName = deptName;
        this.deptCode = deptCode;
    }

    // accessor
    public String getDeptName(){
        return deptName;
    }

    public String getDeptCode(){
        return deptCode;
    }

    //other methods
    public boolean equals(Object obj){
        if ( obj instanceof Department ){
            Department otherDep =(Department)obj;
            if (otherDep.getDeptCode.equals(this.deptCode) && otherDep.deptName.equals(this.deptName)) {
                return true;
            }
        }
        return false;
    }

    public String toString(){
        String output = "DeptName: "+deptName+" Dept Code: "+ deptCode;
        return output;
    }
    
}
