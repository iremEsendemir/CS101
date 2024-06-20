import java.util.Scanner;
public class Lab01_Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       
        double x;
        double y;
        int roundY;
        int floorY;
        int ceilY;

        System.out.print("Enter x: ");
        x = in.nextDouble();
        y = (Math.pow(x, 3) + 3 * Math.abs(x) + 9) / Math.pow(x, 2);
        roundY = (int)Math.round(y);
        floorY = (int)Math.floor(y);
        ceilY = (int)Math.ceil(y);

        System.out.printf("y = %d\n",roundY);
        System.out.printf("%.2f is between %d and %d",y,floorY,ceilY);

        in.close();
    }
}