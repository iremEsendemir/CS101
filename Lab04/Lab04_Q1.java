import java.util.Scanner;
public class Lab04_Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final double day = 365;
        int min, max;
        double probability, sameBirthday ;
        sameBirthday = 0;
        do {
            System.out.print("Enter the minimum and maximum number of people: ");
            min = in.nextInt();
            max = in.nextInt();
            if (min >= max) {
                System.out.println("Invalid input - minimum must be less than maximum...");
            }
        } while (min >= max);
        in.close();
        System.out.println("NUMBER OF PEOPLE    PROBABİLİTY");
        for (int r = min ; r <= max; r++) {
            probability = 1;
            for (int i = 1; i < r ; i++) {
                probability *= (day - i)/day;
            }
            sameBirthday = 1 - probability;
            System.out.printf("%d %22.3f%n",r, sameBirthday);
        }
    }
}