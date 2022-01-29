import java.util.*;

public class Student {

    private String name;
    private String firstName;
    private String lastName;
    private String department;
    private int age;
    private String username;
    private int studentNumber;
    private boolean fullTime;

    public ArrayList<Grade> grades = new ArrayList<Grade>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = firstName + lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public boolean isFullTime() {
        return fullTime;
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }

    public Student(String name, String firstName, String lastName, String department, int age, int studentNumber, boolean fullTime) {
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.age = age;
        this.studentNumber = studentNumber;
        this.fullTime = fullTime;
        this.username = createUserName(firstName,lastName,studentNumber);
    }

    @Override
    public String toString() {
        return "Student full name= " + name + '\'' +
                ", firstName= " + firstName + '\'' +
                ", lastName= " + lastName + '\'' +
                ", department= " + department + '\'' +
                ", age= " + age +
                ", username= " + username + '\'' +
                ", studentNumber= " + studentNumber +
                ", fullTime= " + fullTime +
                ", grades= " + grades;
    }

    static String createUserName(String firstName, String lastName, int studentNumber) {
        //this will select first letter of first name and the first 4 letters of the last name
        char [] userNameList = new char[5];
        userNameList[0] = firstName.charAt(0);
        userNameList[1] = lastName.charAt(0);
        userNameList[2] = lastName.charAt(1);
        userNameList[3] = lastName.charAt(2);
        userNameList[4] = lastName.charAt(3);
        String usernameFinal = String.valueOf(userNameList);
        //this adds the first 3 digits of the student number and finalise the username
        usernameFinal = usernameFinal + Integer.parseInt(Integer.toString(studentNumber).substring(0, 3));

        return usernameFinal.toLowerCase() ;
    }

    public void addGrades(String subject, Double score){
        Grade grade = new Grade(subject, score);
        this.grades.add(grade);
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }
}
