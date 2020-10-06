package SchoolManagementSystem;

public class Teacher{

    private int id;
    private String name;
    private int salary;
    private int salaryEarned;

    public Teacher(int id, String name, int salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
        this.salaryEarned = 0;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getSalary(){
        return salary;
    }
    public int getSalaryEarned(){
        return salaryEarned;
    }

    public void receiveSalary(int salary){
        this.salaryEarned += salary;
        School.setTotalMoneySpent(salary);
    }
}