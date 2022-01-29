public class Grade {

     String subject;
     double score;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Grade(String subject, double score) {
        this.subject = subject;
        this.score = score;
    }
        //GRADE SYSTEM
        public static char getLetterGrade(double score){
            char grade = 'O';
            if(score >= 70){
                grade = 'A';
            }else if(score >= 60){
                grade = 'B';
            }else if(score >= 50){
                grade = 'C';
            }else if(score >= 40){
                grade = 'D';
            }else if(score < 40){
                grade = 'F';
            }else if(score < 0 || score > 100) {
                grade = 'E';
            }
        return grade;
        }

    @Override
    public String toString() {
        return "subject= " + subject + '\'' +
                ", score= " + score +
                ", grade= " + getLetterGrade(score) + "; ";
    }
}