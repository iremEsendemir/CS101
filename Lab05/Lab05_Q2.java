import java.util.Scanner;
public class Lab05_Q2 {
    static final String KEY = "a@bpdqi!l1mwnuo0s5t+z2A4B8E3G6WM";
    public static char convertChar(char ch)  {
        int index;
        char returnCh;
        index = KEY.indexOf(ch);
        returnCh = KEY.charAt(index+1);
        return returnCh;
    }
    public static String convertText(String str) {
        char checkedChar;
        for (int i = 0; i < str.length(); i++) {
            checkedChar = str.charAt(i);
            for (int j = 0; j < KEY.length(); j+=2) {
                if (KEY.charAt(j) == checkedChar) {
                    str = str.replace(str.charAt(i), convertChar(checkedChar));
                }  
            }
        }
        return str;
    }
    public static int countNumbers (String str){
        int count;
        count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input, output;
        System.out.print("Enter a phrase for conversion: ");
        input = in.nextLine();
        in.close();
        if (input.equals("")) {
            System.out.println("No phrase entered.");
        } else {
            System.out.printf("Text you entered: '%s'%n",input);
            output = convertText(input);
            System.out.printf("After conversion: '%s'%n",output);
            if (countNumbers(input) == 0 && countNumbers(output) == 0) {
                System.out.println("!! Attention !! There is no number in this text");
            }
            if (input.equals(output)) {
                System.out.println("No conversion happened.");
            }
        }
    }
}