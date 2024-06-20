package Lab07;

import java.util.Scanner;

public class Lab07_Q2 {
    public static void main(String[] args) {
        String personAvoided;
        int coming, going, bestHour, personsIndex, comingOfAvoided, goingOfAvoided, maxPpl;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter friend you wish to avoid: ");
        personAvoided = in.next();
        System.out.println();
        System.err.print("Enter time interval you are available: ");
        coming = in.nextInt();
        going = in.nextInt();
        bestHour = -1;
        personsIndex = -1;
        maxPpl = -1;

        // find personsIndex
        for(int i = 0; i < Lab07_Q1.names.length; i++){
            if (Lab07_Q1.names[i].equalsIgnoreCase(personAvoided)) {
                personsIndex = i;
            }
        }
        // find hours of avoided person
        comingOfAvoided = Lab07_Q1.arrivingTime[personsIndex];
        goingOfAvoided = Lab07_Q1.leavingTime[personsIndex];
        // check best time 
        for (int hour = coming; hour < going; hour++) {
            if((Lab07_Q1.friendsAttending(coming, going)[hour-coming] > maxPpl) && (hour < comingOfAvoided || hour >= goingOfAvoided)){
                maxPpl = Lab07_Q1.friendsAttending(coming, going)[hour-coming];
                bestHour = hour;
            }
        }
        System.out.printf("Best time to attend to avoid %s and to see the most friends is %d",personAvoided, bestHour);
        in.close();
    }
}
