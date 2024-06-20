import java.util.Scanner;
public class Lab02_Q3 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input;
        String inputWithoutSpace;
        char firstLetter;
        char middleLetter;
        char lastLetter;
        int valueOfFirstLetter;
        int valueOfMiddleLetter;
        int valueOfLastLetter;
        int lenghtOfInput;
        boolean specialString;
        boolean specialCondition1;
        boolean specialCondition2;

        System.out.print("Enter string: ");
        input = in.nextLine();
        in.close();

        if (input.length() < 3) {
            System.out.println("Length of string not sufficient"); 
        }
 
        else  {
            lenghtOfInput = input.length();
            firstLetter = input.charAt(0);
            lastLetter = input.charAt(lenghtOfInput - 1);
            middleLetter = input.charAt(lenghtOfInput/2);
            valueOfFirstLetter = firstLetter;
            valueOfMiddleLetter = middleLetter;
            valueOfLastLetter = lastLetter;
            

            if ((valueOfFirstLetter < 97) || (valueOfMiddleLetter < 97) || (valueOfLastLetter < 97) || (valueOfFirstLetter > 122) || (valueOfMiddleLetter > 122) || (valueOfLastLetter > 122)) {
                System.out.println("Characters not lowercase letters..."); 
            }

            else {
                specialCondition1 = (Math.abs(valueOfMiddleLetter - valueOfFirstLetter)<= 1)&&(Math.abs(valueOfLastLetter - valueOfFirstLetter) >=2)&&(Math.abs(valueOfLastLetter - valueOfMiddleLetter) >=2);
                specialCondition2 = (Math.abs(valueOfLastLetter - valueOfFirstLetter)<= 1)&&(Math.abs(valueOfMiddleLetter - valueOfFirstLetter) >=2)&&(Math.abs(valueOfMiddleLetter - valueOfLastLetter) >=2);
                specialString = specialCondition1 || specialCondition2; 
                inputWithoutSpace = input.replaceAll("\\s", "");
                
                if (inputWithoutSpace.length() == 3) {
                    System.out.printf("String is special = %b",specialString); 
                } 

                else {
                    System.out.printf("first=%c middle=%c last=%c%n",firstLetter,middleLetter,lastLetter);
                    System.out.printf("String is special = %b",specialString);

                }
            }   
        }   
    }
}