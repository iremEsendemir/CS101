import java.util.Scanner;
import java.util.Random;
public class Lab03_Q2 {
    public static void main(String[] args) {
        String enteredStr, strBeforeInt, strAfterInt,strWithInt, strBeforeSpace, strAfterSpace,encodedString, decodedString, enteredStr2, encodedString2, decodedString2;
        int choice, addedInt, addedNumOfInt,placeOfInt,placeOfSpace, checkedCharNum, letterFromLast, checkedCharNum2;
        char checkedChar,addedChar, checkedChar2;

        Scanner in = new Scanner(System.in);
        java.util.Random random = new Random(); 

        System.out.printf("1) Encode Message %n2) Decode Message %n3)Encode2 Message %n4)Decode2 Messaage %n5)Quit %nEnter choice: ");
        choice = in.nextInt();
        encodedString = "";
        encodedString2 = "";


        while (choice != 5) {

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
                    System.out.printf("1) Encode Message %n2) Decode Message %n3)Encode2 Message %n4)Decode2 Messaage %n5)Quit %nEnter choice: ");
                    choice = in.nextInt();
                }
            }

            else if (choice == 2) {
                if (encodedString.equals("")) {
                    System.out.println("no message to decode");
                    System.out.printf("1) Encode Message %n2) Decode Message %n3)Encode2 Message %n4)Decode2 Messaage %n5)Quit %nEnter choice: ");
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
                    System.out.printf("1) Encode Message %n2) Decode Message %n3) Encode2 Message %n4) Decode2 Message %n5)Quit %nEnter choice: ");
                    choice = in.nextInt();
                } 
            }
            else if (choice == 3) {
                encodedString2 = "";
                System.out.print("Enter word to encode: ");
                in.nextLine();
                enteredStr2 = in.nextLine();
    
                if (enteredStr2.length() < 2) {
                    System.out.println("Invalid length word - try again");
                    System.out.print("Enter word to encode: ");
                    enteredStr2 = in.nextLine();
                } 
                else {
                    letterFromLast = enteredStr2.length() - 1;
                    while (letterFromLast >= 0) {
                        addedChar = enteredStr2.charAt(letterFromLast);
                        if (Character.isLetter(addedChar)) {
                            if (letterFromLast > 0 && enteredStr2.charAt(letterFromLast - 1) != ' ') {
                                encodedString2 += addedChar + "*";
                            }
                            else {
                                encodedString2 += addedChar ;  
                            }
                        }
                        else{
                            encodedString2 += addedChar ;
                        }
                        letterFromLast--;
                    }
                    System.out.printf("Encoded message: %s%n",encodedString2);
                    System.out.printf("1) Encode Message %n2) Decode Message %n3) Encode2 Message %n4) Decode2 Message %n5)Quit %nEnter choice: ");
                    choice = in.nextInt();
                }
            }
            else if (choice ==4) {
                if (encodedString2.equals("")) {
                    System.out.println("no message to decode");
                    System.out.printf("1) Encode Message %n2) Decode Message %n3)Encode2 Message %n4)Decode2 Messaage %n5)Quit %nEnter choice: ");
                    choice = in.nextInt();
                } 
                else {
                    checkedCharNum2 = encodedString2.length() - 1;
                    decodedString2 = "";
                    while (checkedCharNum2 >= 0) {
                        checkedChar2 = encodedString2.charAt(checkedCharNum2);
                        if (checkedChar2 != '*') {
                            decodedString2 += checkedChar2;
                        }  
                    checkedCharNum2--; 
                    }
                    System.out.println(decodedString2);
                    System.out.printf("1) Encode Message %n2) Decode Message %n3) Encode2 Message %n4) Decode2 Message %n5)Quit %nEnter choice: ");
                    choice = in.nextInt();
                }
                
            }
            else if (choice < 1 || choice > 3) {
                System.out.println("Invalid choice - try again...");
                System.out.printf("1) Encode Message %n2) Decode Message %n3) Encode2 Message %n4) Decode2 Message %n5)Quit %nEnter choice: ");                choice = in.nextInt();
            }
        }
        System.out.println("Thank you, goodbye!");
        in.close();
    }
}
