package Lab07;
import java.util.Scanner;

public class Lab07_Q1 {

    public static String[] names = {"Ela","Eren","Alona","Jen","Mark","Mel","Ender"};
    public static int [] arrivingTime = {9,5,8,7,9,7,8};
    public static int [] leavingTime = {12,7,11,12,10,9,10};

    public static int [] friendsAttending(int coming, int going) {
        int count;
        int [] availablePplNum = new int[going-coming];
        for (int hour = coming; hour < going; hour++) {
            count = 0;
            for (int j = 0; j < names.length; j++) {
                if ( (arrivingTime[j] <= hour) && (leavingTime[j] > hour)) {
                    count++;
                }
            }
            availablePplNum[hour-coming] = count;
        }
        return availablePplNum;
    }

    public static int bestTimeToAttend(int coming, int going, ){

    }
    public static void main(String[] args) {
        int coming, going, bestTime, maxPpl;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter time interval you are available: ");
        coming = in.nextInt();
        going = in.nextInt();
        maxPpl = 0;
        bestTime = -1;
        for (int hour = coming; hour < going; hour++){
            System.out.printf("At %d, %d friends will be at the party %n",hour, friendsAttending(coming, going)[hour-coming] );
            if(friendsAttending(coming, going)[hour-coming] > maxPpl){
                maxPpl = friendsAttending(coming, going)[hour-coming];
                bestTime = hour;
            }
        }
        System.out.println("Best time to attend is " + bestTime);
        in.close();


    }
}