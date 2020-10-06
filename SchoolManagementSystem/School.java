package SchoolManagementSystem;

import java.util.List;

public class School {
    
    private List<Teacher> teachers;
    private List<Student> students;
    private static int totalMoneyEarned;
    private static int totalMoneySpent;

    public School(List<Teacher> teachers, List<Student> students){
        this.teachers = teachers;
        this.students = students;
        totalMoneyEarned=0;
        totalMoneySpent=0;
    }

    public List<Teacher> getTeachers(){
        return teachers;
    }

    public void setTeachers(Teacher teacher){
        teachers.add(teacher);
    }

    public List<Student> getStudents(){
        return students;
    }

    public void setStudents(Student student){
        students.add(student);
    }
    
    public int getTotalMoneyEarned(){
        return totalMoneyEarned;
    }

    public static void setTotalMoneyEarned(int MoneyEarned){
        totalMoneyEarned += MoneyEarned;
    }

    public int getTotalMoneySpent(){
        return totalMoneySpent;
    }

    public static void setTotalMoneySpent(int MoneySpent){
        totalMoneyEarned -= MoneySpent;
        totalMoneySpent += MoneySpent;
        
    }
}
