import java.util.Scanner;
import java.util.Random;
public class Lab03_Q1 {
    public static void main(String[] args) {
        String enteredStr, strBeforeInt, strAfterInt,strWithInt, strBeforeSpace, strAfterSpace,encodedString, decodedString;
        int choice, addedInt, addedNumOfInt,placeOfInt,placeOfSpace, checkedCharNum;
        char checkedChar;

        Scanner in = new Scanner(System.in);
        java.util.Random random = new Random(); 

        System.out.printf("1) Encode Message %n2) Decode Message %n3) Quit %nEnter choice: ");
        choice = in.nextInt();
        encodedString = "";

        while (choice != 3) {
            if (choice == 1) {
                System.out.print("Enter word to encode: ");
                enteredStr = in.next();
    
                if (enteredStr.length() < 2) {
                    System.out.println("Invalid length word - try again");
                } 
    
                else {
                    strWithInt = enteredStr;
                    addedNumOfInt = 0;
    
                    while (enteredStr.length() > addedNumOfInt) {
                        addedInt = random.nextInt(10);
                        placeOfInt = random.nextInt(enteredStr.length());
                        strBeforeInt = strWithInt.substring(0, placeOfInt+1);
                        strAfterInt = strWithInt.substring(placeOfInt+1);
                        strWithInt = strBeforeInt + addedInt + strAfterInt;
                        addedNumOfInt++;
                    }

                    placeOfSpace = random.nextInt(strWithInt.length());
                    strBeforeSpace = strWithInt.substring(0, placeOfSpace+1);
                    strAfterSpace = strWithInt.substring(placeOfSpace+1);
                    encodedString = strBeforeSpace + " " + strAfterSpace;
                    System.out.printf("Encoded message: %s%n",encodedString);

                    System.out.printf("1) Encode Message %n2) Decode Message %n3) Quit %nEnter choice: ");
                    choice = in.nextInt();
                }
            }

            else if (choice == 2) {
                if (encodedString.equals("")) {
                    System.out.println("no message to decode");
                    System.out.printf("1) Encode Message %n2) Decode Message %n3) Quit %nEnter choice: ");
                    choice = in.nextInt();
                } 
                else {
                    //System.out.println("should work if you put 1 first");
                    checkedCharNum = 0;
                    decodedString = "";
                    while (encodedString.length() > checkedCharNum) {
                        checkedChar = encodedString.charAt(checkedCharNum);
                        if (Character.isLetter(checkedChar)) {
                            decodedString += checkedChar;
                        }  
                        checkedCharNum++;
                    }
                    System.out.println(decodedString);
                    System.out.printf("1) Encode Message %n2) Decode Message %n3) Quit %nEnter choice: ");
                    choice = in.nextInt();
                } 
            }
            else if (choice < 1 || choice > 3) {
                System.out.println("Invalid choice - try again...");
                System.out.printf("1) Encode Message %n2) Decode Message %n3) Quit %nEnter choice: ");
                choice = in.nextInt();
            }
        }
        System.out.println("Thank you, goodbye!");
        in.close();
    }
}