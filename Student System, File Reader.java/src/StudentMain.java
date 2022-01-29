import java.util.*;

public class StudentMain {

    private static ArrayList<Student> studentList = new ArrayList<Student>();

    public static void main(String[] args) {

        //adding students info
        studentList.add(new Student("Berth Smith", "Berth", "Smith", "Computing", 21, 12345, true));
        studentList.add(new Student("Olivia Green", "Olivia", "Green", "Computing", 19, 23464, true));
        studentList.add(new Student("Eloise Jones", "Eloise", "Jones", "Computing", 18, 34744, true));
        studentList.add(new Student("Ben Bird", "Ben", "Bird", "Computing", 42, 34834, false));
        studentList.add(new Student("Ken Brown", "Ken", "Brown", "Computing", 25, 45632, false));

        //adding grades to the student info
        studentList.get(0).grades.add(new Grade("programming", 52));
        studentList.get(0).grades.add(new Grade("web dev", 63));
        studentList.get(0).grades.add(new Grade("math", 76));
        studentList.get(0).grades.add(new Grade("algorithms", 68));

        studentList.get(1).grades.add(new Grade("programming", 73));
        studentList.get(1).grades.add(new Grade("web dev", 82));
        studentList.get(1).grades.add(new Grade("math", 72));
        studentList.get(1).grades.add(new Grade("algorithms", 66));

        studentList.get(2).grades.add(new Grade("programming", 65));
        studentList.get(2).grades.add(new Grade("web dev", 63));
        studentList.get(2).grades.add(new Grade("math", 37));
        studentList.get(2).grades.add(new Grade("algorithms", 40));

        studentList.get(3).grades.add(new Grade("programming", 55));
        studentList.get(3).grades.add(new Grade("web dev", 29));
        studentList.get(3).grades.add(new Grade("math", 56));
        studentList.get(3).grades.add(new Grade("algorithms", 38));

        studentList.get(4).grades.add(new Grade("programming", 62));
        studentList.get(4).grades.add(new Grade("web dev", 51));
        studentList.get(4).grades.add(new Grade("math", 43));
        studentList.get(4).grades.add(new Grade("algorithms", 43));

        menuSystem();
        System.out.println(studentList.toString());
    }

    public static void toResit() {
        for(int i = 0; i < studentList.size(); i++){
            for(int x = 0; x < studentList.get(i).grades.size(); x++){
                if(Grade.getLetterGrade(studentList.get(i).grades.get(x).score) == 'F'){
                    System.out.println("The student " + studentList.get(i).getName() + " has failed the module: " + studentList.get(i).grades.get(x).subject);
                }
            }
        }
    }

    public static void averageGrades(){

        for(int i = 0; i < studentList.size(); i++){
            double avg = 0;
            for(int x = 0; x < studentList.get(i).grades.size(); x++){

                avg = avg + studentList.get(i).grades.get(x).score;
            }
            System.out.println("The student " + studentList.get(i).getName() + " has an average score of: " + avg / studentList.get(i).grades.size());
        }
    }

    //In case I needed to store the actual data this code would need to be changed as the new student would be added to the next index of student array only.
    public static void createStudent(){

        Scanner userInput = new Scanner(System.in);

        System.out.println("To add a new student to the student list, type in the student first name");
        String firstName = "";
        firstName += userInput.nextLine();
        System.out.println("To add a new student to the student list, type in the student last name");
        String lastname = "";
        lastname += userInput.nextLine();
        String name = firstName + lastname;


        System.out.println("Now add what department the student is studying in");
        String department = userInput.next();

        System.out.println("Perfect, we are almost there, now add the student's age");
        int age = userInput.nextInt();

        System.out.println("Thank you! Now enter the student number");
        int studentNumber = userInput.nextInt();

        System.out.println("Is the student studying fulltime? Enter yes or no");
        String fullTime = userInput.next();
        fullTime.toLowerCase(Locale.ROOT);
        //not sure about here
        boolean partTime = false;
        if(fullTime == "no"){
            partTime = true;
        }

        System.out.println("Perfect thank you! The student has been added");
        System.out.println("Now in order to have all the information add the student's grades");
        System.out.println("Enter the grade for the module: Intro to Programming");
        double introToGrade = 0;
        introToGrade = userInput.nextDouble();

        System.out.println("Enter the grade for the module: Web Development");
        double webDevGrade = 0;
        webDevGrade = userInput.nextDouble();

        System.out.println("Enter the grade for the module: Math");
        double mathGrade = 0;
        mathGrade = userInput.nextDouble();

        System.out.println("Enter the grade for the module: Algorithms");
        double algoGrade = 0;
        algoGrade = userInput.nextDouble();

        System.out.println("Thank you! The student and the grades have been added");

        studentList.add(new Student(name, firstName, lastname, department, age, studentNumber, partTime));
        studentList.get(5).grades.add(new Grade("programming", introToGrade));
        studentList.get(5).grades.add(new Grade("web dev", webDevGrade));
        studentList.get(5).grades.add(new Grade("math", mathGrade));
        studentList.get(5).grades.add(new Grade("algorithms", algoGrade));

        menuSystem();
    }

    public static void menuSystem() {
        System.out.println("~-~-~-~-~-~-~-~-~-~-~-");
        System.out.println("Welcome to the student menu system!");
        System.out.println("Here are some options of what you can do here:");
        System.out.println("Press 1 for all the students info");
        System.out.println("Press 2 for all the students with a failed module");
        System.out.println("Press 3 for the average grade of the students");
        System.out.println("Press 4 to add a new student to the database");
        System.out.println("Press 5 to quit the student menu system");

        Scanner menuScanner = new Scanner(System.in);
        int userInput = menuScanner.nextInt();

        switch (userInput){
            case 1:
                for (int i = 0; i < studentList.size(); i++) {
                    System.out.println(studentList.get(i));
                }
                menuSystem();
                break;
            case 2:
                toResit();
                menuSystem();;
                break;
            case 3:
                averageGrades();
                menuSystem();
                break;
            case 4:
                createStudent();
                menuSystem();
                break;
            case 5:
                System.out.println("We are sorry to see you go, have a great day!");
                System.exit(1);
            default:
                System.out.println("Ops, you opted for an invalid input, tray again following the instructions below:");
                menuSystem();
                break;
        }
    }
}