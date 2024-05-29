import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] gradeArr = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
        double[] numArr = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};
        double sum = 0.0;
        double totalNum = 0.0;


        for(int i = 0; i < 20; i++) {
            String str = scan.next();
            double num = scan.nextDouble();
            String grade = scan.next();

            if(grade != "P") {
                for(int j = 0; j < gradeArr.length; j++) {
                    if(gradeArr[j].equals(grade)) {
                        sum += num * numArr[j];
                        totalNum += num;
                        break;
                    }
                }
            }
        }
        
        if(totalNum > 0) {
            double gpa = sum / totalNum;
            System.out.printf("%.6f\n", gpa);
        } else {
            System.out.println("0.000000");
        }
    }
}
