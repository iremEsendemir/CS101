import java.util.Scanner;
public class Lab02_Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int volumeOfSmallJar;
        int volumeOfLargeJar;
        int numOfSmallJar;
        int numOfLargeJar;
        int sizeOfOrder;
        int neededNumOfSmallJar;

        volumeOfSmallJar = 1;
        volumeOfLargeJar = 5;

        System.out.print("Input the number of small and large jars available and the order size: ");
        
        numOfSmallJar = in.nextInt();
        numOfLargeJar = in.nextInt();
        sizeOfOrder = in.nextInt();
        in.close();

        
        if (sizeOfOrder < 5) {
            System.out.println("Order must be larger than 5 litres");
        } 

        else if (sizeOfOrder > ((volumeOfSmallJar * numOfSmallJar) + (volumeOfLargeJar * numOfLargeJar))) {
            System.out.println("You do not have enough jars to complete the order");   
        } 

        else {
            if (sizeOfOrder > numOfLargeJar*volumeOfLargeJar) {
                neededNumOfSmallJar = sizeOfOrder - (numOfLargeJar*volumeOfLargeJar);
            } 
            else {
                neededNumOfSmallJar = sizeOfOrder % volumeOfLargeJar;
            }

            if (neededNumOfSmallJar > numOfSmallJar) {
                System.out.println("You do not have enough jars to complete the order");
            } 
            else {
                System.out.printf("Order of %d litres will contain %d small(%d litre)jars",sizeOfOrder,neededNumOfSmallJar,volumeOfSmallJar);
            }
        }        
    }  
}