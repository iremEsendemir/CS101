import java.util.Scanner;
public class Lab04_Q4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input, converted;
        char checkedChar, mostUsedChar, addedChar;
        int length, usageNum,mostUsedNum;
        boolean isLowerCase;
        System.out.print("Enter word to convert: ");
        input = in.next();
        in.close();
        isLowerCase = true;
        length = input.length();

        //check it's lowercase
        for (int i = 0; i < length && isLowerCase ; i++) {
            checkedChar = input.charAt(i);
            if (!Character.isLowerCase(checkedChar)) {
                isLowerCase = false;
            }
        }
        if (!isLowerCase) {
            System.out.println("Invalid iput! Only enter lowercase letters.");
        } 
        else {
            System.out.println("Length: " + length);
            mostUsedChar = input.charAt(0);
            mostUsedNum = 1;

            //determine most used char
            for (int i = 0; i < length; i++) {
                checkedChar = input.charAt(i);
                for (int r = 0; r < length; r++) {
                    usageNum = 1;
                    if (!(i == r) && checkedChar == input.charAt(r)) {
                        usageNum++;
                    }
                    if (usageNum > mostUsedNum) {
                        mostUsedNum = usageNum;
                        mostUsedChar = input.charAt(i);
                    }
                }
            }

            //makes convert
            converted = "";
            for (int i = 0; i < length; i++) {
                checkedChar = input.charAt(i);
                addedChar = checkedChar;
                addedChar += length;
                if (checkedChar == mostUsedChar) {
                    converted += "(";
                } 
                else if (addedChar > 'z' ){
                    addedChar -= 26;
                    converted += addedChar;
                }
                else {
                    converted += addedChar;
                }
            }
            System.out.println("Converted Word: " + converted);
        }
    }
}
