import java.util.Scanner;
public class Lab02_Q1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String ifStringIsEntered;
        double inputNumber;
        double outputNumber;

        System.out.print("Enter a real number: ");

        if (!in.hasNextDouble()){ 
            ifStringIsEntered = in.nextLine();
            System.out.println("Invalid input - value must be numeric....");
            System.out.printf("You entered: %s",ifStringIsEntered);
        }

        else {
            inputNumber = in.nextDouble(); 
            in.close();

            if ( inputNumber > 15 ) { 
                outputNumber = Math.sqrt(Math.pow(inputNumber, 5) + 1);
            }   

            else if ( inputNumber <= 15 && inputNumber >= 0 ) {
                outputNumber = Math.exp(inputNumber) - 15;  
            }  

            else{
                outputNumber = inputNumber / (inputNumber + 10) ;
            }

            System.out.println("-----------------------------");
            System.out.printf("f(x) = %.2f",outputNumber);
        }               
    }
} 