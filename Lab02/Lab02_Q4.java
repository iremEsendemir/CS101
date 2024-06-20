import java.util.Scanner;
public class Lab02_Q4 {
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
        char inputChar;
        int valueOfFirstLetter;
        int valueOfMiddleLetter;
        int valueOfLastLetter;
        int lenghtOfInput;
        int valueOfInputChar;
        boolean superSpecial;
        boolean specialCondition1;
        boolean specialCondition2;
        boolean specialCondition3;

        System.out.print("Enter string: ");
        input = in.nextLine();
        System.out.print("Enter the character: ");
        inputChar = in.next().charAt(0);
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
            valueOfInputChar = inputChar;

            if ((valueOfFirstLetter < 97) || (valueOfMiddleLetter < 97) || (valueOfLastLetter < 97) || (valueOfFirstLetter > 122) || (valueOfMiddleLetter > 122) || (valueOfLastLetter > 122)) {
                System.out.println("Characters not lowercase letters..."); 
            }

            else {
                specialCondition1 = (Math.abs(valueOfInputChar - valueOfFirstLetter)<= 1)&&(Math.abs(valueOfInputChar - valueOfMiddleLetter) >=2)&&(Math.abs(valueOfInputChar - valueOfLastLetter) >=2);
                specialCondition2 = (Math.abs(valueOfInputChar - valueOfMiddleLetter)<= 1)&&(Math.abs(valueOfInputChar - valueOfFirstLetter) >=2)&&(Math.abs(valueOfInputChar - valueOfLastLetter) >=2);
                specialCondition3 = (Math.abs(valueOfInputChar - valueOfLastLetter)<= 1)&&(Math.abs(valueOfInputChar - valueOfFirstLetter) >=2)&&(Math.abs(valueOfInputChar - valueOfMiddleLetter) >=2);
                superSpecial = specialCondition1 || specialCondition2 || specialCondition3;
                inputWithoutSpace = input.replaceAll("\\s", "");
                
                if (inputWithoutSpace.length() == 3) {
                    System.out.printf("String is special = %b",superSpecial); 
                } 
                else {
                    System.out.printf("first=%c middle=%c last=%c%n",firstLetter,middleLetter,lastLetter);
                    System.out.printf("String is super special = %b",superSpecial);

                }
            }   
        }   
    }
}