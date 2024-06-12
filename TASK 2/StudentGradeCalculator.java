import java.util.Scanner;

public class StudentGradeCalculator{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int totalMarks = 0;
        System.out.println("Enter Marks obtained (out of 100) for each subjects: ");
        for(int i=1; i <= numSubjects; i++){
            System.out.print("Subject " + i + ": ");
            int marks = scanner.nextInt();
            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / numSubjects;
        
        //Multiple if-else statements , we can also use switch statement instead of this.
        char grade;
        if(averagePercentage >= 90){
            grade = 'A';
        }else if(averagePercentage >= 80){
            grade = 'B';
        }else if(averagePercentage >= 70){
            grade = 'C';
        }else if(averagePercentage >= 60){
            grade = 'D';
        }else if(averagePercentage >= 50){
            grade = 'E';
        }else {
            grade = 'F';
        }

        System.out.println("Total Marks : " + totalMarks);
        System.out.println("Average Percentage : " + averagePercentage + " %");
        System.out.println("Grade : " + grade);

        scanner.close();
    }
}
//Code by Vivek Auti