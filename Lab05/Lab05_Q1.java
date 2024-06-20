import java.util.Scanner;
public class Lab05_Q1 {
    public static  int persistance(int num) {
        int multiplication, digit, multiplicationNum;
        multiplicationNum = 0;
        while (num > 10) {
            multiplication = 1;
            while (num > 0) {
                digit = num % 10;;
                multiplication *= digit;
                num /= 10;
            }
            num = multiplication;
            multiplicationNum++;
        }
        return multiplicationNum;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean isInt, isPositive;
        int num, output;
        isInt = false;
        isPositive = false;
        num = -9;
        do {
            System.out.print("Enter a positive integer: ");
            if (in.hasNextInt()) {
                isInt = true;
                num = in.nextInt();
                if (num > 0) {
                    isPositive = true;
                }
                else {
                    in.nextLine();
                }
            }
            else {
                in.nextLine();
            }
        } while (!(isInt && isPositive));
        output =persistance(num);
        System.out.printf("multiplicative persistence of  %d is %d",num,output);
    }
}