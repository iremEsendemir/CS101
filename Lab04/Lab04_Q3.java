import java.util.Scanner;
public class Lab04_Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input, convertedWord;
        char checkedChar;
        int length;
        boolean same;
        System.out.print("Enter word to convert: ");
        input = in.next();
        while (!input.equalsIgnoreCase("exit")) {
            convertedWord = "";
            same = false;
            length = input.length();
            System.out.print("Original word: " + input + "    ");
            for (int i = 0; i < length; i++) {
                checkedChar = input.charAt(i);
                for (int r = 0; r < length && !same ; r++) {
                    if (!(i == r) && checkedChar == input.charAt(r)) {
                        same = true;
                    }
                }
                if (!Character.isLetter(input.charAt(i))) {
                    convertedWord += "*";
                }
                else if (same) {
                    convertedWord += ")";
                } 
                else {
                    convertedWord += "(";
                }
                same = false;
            }
            System.out.println("Converted word: " + convertedWord);
            System.out.print("Enter word to convert: ");
            input = in.next();
        }
        in.close();
    }
}