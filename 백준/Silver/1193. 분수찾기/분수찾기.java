import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        scanner.close();
        
        int grade = 1;
        int maxInGrade = 1;
        
        while (X > maxInGrade) {
            grade++;
            maxInGrade += grade;
        }
        
        int positionInGrade = X - (maxInGrade - grade);
        int numerator, denominator;
        
        if (grade % 2 == 0) {
            numerator = positionInGrade;
            denominator = grade - positionInGrade + 1;
        } else {
            numerator = grade - positionInGrade + 1;
            denominator = positionInGrade;
        }
        
        System.out.println(numerator + "/" + denominator);
    }
}
