import java.util.Scanner;

public class Lab05_Q3 {
    public static void displayMenu(){
        System.out.printf("1 - Find Probability of Same Birthday %n2 - Draw Chart %n3 - Convert Word %n4 - QUIT %nEnter choice: ");
    }
    public static int getChoice() {
        int choice;
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();
        return choice;
    }
    public static double sameBirthday(int groupSize){
        final double DAYS_IN_YEAR = 365.0;
        double probability;
        probability = 1;
        for ( int j = 1; j < groupSize; j++ ){
            probability = probability * ((DAYS_IN_YEAR - j)/DAYS_IN_YEAR);
        }
        probability = 1 - probability;
        return probability;
    }
    public static int findMax(int integer){
        int digit, maxDigit;
        maxDigit  = 0;
        while (integer > 0) {
            digit = integer % 10;
            if (digit > maxDigit) {
                maxDigit = digit;
            }
            integer /= 10;
        }
        return maxDigit;
    }
    public static void displayChart(String chartData){
        //validate that string only contains digits
        int pos = -1;
        do {
            pos++;
        }while( pos < chartData.length() && Character.isDigit(chartData.charAt(pos)));
        
        //if the string does not contain only digits 
        if ( pos != chartData.length() ){
            System.out.println("Invalid chart data!");
        }
        
        else {
        //display chart headings
        for (int i = 1; i <= chartData.length(); i++){
            System.out.printf("%10s","review"+" "+i);
            }
            System.out.println();
            int num = Integer.valueOf(chartData);
            int maxDigit = findMax(num);

            //for each line
            for ( int line = maxDigit; line > 0; line-- ){
                    
                //for each digit in the string
                for( int ch = 0; ch < chartData.length(); ch++ ){

                    //if the value of the current digit is greater than or equal to the current line 
                    int current = Character.getNumericValue( chartData.charAt( ch ) );
                    if ( current >= line ){
                        //print 3 stars
                        System.out.printf("%10s","***");
                    }
                    else {
                        //print empty space
                        System.out.printf("%10s","");
                    }
                }
                //go to the next line
                System.out.println();
            }
        }   
    }
    public static boolean isValidNumeric(String str){
        boolean isValidNumeric;
        isValidNumeric = true;
        for (int i = 0; i < str.length() && isValidNumeric; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                isValidNumeric = false;
            }
        }
        return isValidNumeric;
    }
    public static int countLetter(String str, int index){
        int count;
        char ch;
        count = 1;
        ch = str.charAt(index);
        for (int r = 0; r < str.length(); r++) {
            if (r != index && ch == str.charAt(r)) {
               count++;
            }
        }
        return count;
    }

    public static String convertWord(String word){
        String newWord;
        int count;
        newWord = "";
        for( int i = 0; i < word.length(); i++){
            if ( !Character.isLetter(word.charAt(i)) ){
                newWord += '*';
            }
            else { 
                count = countLetter(word, i);
                if( count != 1 ){
                    newWord += ")";
                }
                else {
                    newWord += "(";
                }
            }
        }
        return newWord;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice, groupSize;
        String chartData, word;
        displayMenu();
        choice = getChoice();
        while (choice != 4) {
            if (choice < 1 || choice > 3) {
                System.out.println("Invalid choice");
            }
            else if (choice == 1){
                System.out.print("Enter the group size: ");
                groupSize = in.nextInt();
                System.out.printf("The probability of two people in a group of %d having the same birthday is %.2f%n", groupSize, sameBirthday(groupSize));
            }
            else if (choice == 2) {
                System.out.print("Enter chart data: ");
                chartData = in.next();
                displayChart(chartData);
            }
            else if (choice == 3) {
                System.out.print("Enter word to convert: ");
                word = in.nextLine();
                System.out.printf("Original word: %s Converted word: %s%n", word, convertWord(word));
            }
            displayMenu();
            choice = getChoice();
        }
        System.out.println("GOODBYE!");
        in.close();
    }
}