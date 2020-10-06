package SchoolManagementSystem;

public class Student{

    private int id;
    private String name;
    private int grade;
    private int feesPaid;
    private int feesTotal;

    Student(int id, String name, int grade){
        this.id=id;
        this.name=name;
        this.grade=grade;
        feesPaid=0;
        feesTotal=30000;
    }
    public void setGrade(int grade){
        this.grade=grade;
    }
    public void setFeesPaid(int fees){
        this.feesPaid+=fees;
        School.setTotalMoneyEarned(feesPaid);
    }
    public int getRemainingFees(){
        return feesTotal-feesPaid;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getGrade(){
        return grade;
    }
    public int getFeesPaid(){
        return feesPaid;
    }
    public int getFeesTotal(){
        return feesTotal;
    }
}