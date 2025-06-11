Class Employee{
  private int empId;
  private String empName;
  private double empSalary;

  public void setEmpId(int id){
    empId = id;
  }

  public int getEmpId(){
    return empId;
  }

public void setEmpName(String name){
    empName = name;
  }

  public String getEmpName(){
    return empName;
  }

public void setEmpSalary(double salary){
    empSalary = salary;
  }

  public double getEmpSalary(){
    return empSalary;
  }

  private Employee(){
    System.out.println("Employee Object is constructed");
  }

  public static Employee getEmployee(){ // static Factory Method
    return new Employee();
  }
}

public class Demo{
  public static void main(String[] args){
    Employee emp = Employee.getEmployee();
    emp.setEmpId(101);
    emp.setEmpName("Your Name");
    emp.setEmpSalary(1000000.99);

    System.out.println("Employee Id is: " + emp.getEmpId());
    System.out.println("Employee Name is: " + emp.getEmpName());
    System.out.println("Employee Salary is: " + emp.getEmpSalary());
  }
}
