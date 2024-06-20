import java.util.Scanner;
public class Lab01_Q2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String dateAndTime;
        String clock;
        String minute;
        String month;
        String year;
        String day;
        String dayNumber;
        int indexOfSlash;
        int indexOfFirstMinus;
        int indexOfSecondMinus;
        int indexOfComma;


        System.out.print("Enter a date and time: ");
        dateAndTime = in.next();

        indexOfSlash = dateAndTime.indexOf("/");
        indexOfFirstMinus = dateAndTime.indexOf("-");
        indexOfSecondMinus = dateAndTime.indexOf("-", indexOfFirstMinus + 1);
        indexOfComma = dateAndTime.indexOf(",");

        clock = dateAndTime.substring(0,2);
        minute = dateAndTime.substring(3,5);
        day = dateAndTime.substring(indexOfSlash + 1,indexOfFirstMinus);
        month = dateAndTime.substring(indexOfFirstMinus + 1, indexOfSecondMinus);
        dayNumber = dateAndTime.substring(indexOfSecondMinus + 1, indexOfComma);
        year = dateAndTime.substring(indexOfComma + 1);

        
        System.out.printf("%s minutes past %s on %s %s %s (%s)",minute,clock,dayNumber,month,year,day);
    
        in.close();
    }

}