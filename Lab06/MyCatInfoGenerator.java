import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class MyCatInfoGenerator {
    private static final int CAMPUS_RADIUS = 250;
    private static final int MAX_MONTHS = 60;
    private static String[] arrayOfNames = {"Gollum","Spiderman","Mocha","Gora","Zeytin","Spot","Pamuk","Duman","Pasha","Tickles","Kahve","Tekir","Benek","Checkers", "Karamel","Tik Tak", "Havuç", "Blizzard", "Splatter", "Sprite","Hamur","Pofuduk","Popsicle","Ash","Gofret","Latte","Aslan","Patches","Lucky","Fluffy"};
    private static ArrayList<String> catNames = new ArrayList<String>( Arrays.asList( arrayOfNames ));

    public static ArrayList<String> getRandomNameList( int num ){
        /*Implement the method here.....
	    * The method should add num random names from the global static catNames list to a new ArrayList and 
		* return the random list of names. There should be no duplicates, and you should make sure that num is 
		* less than the number of names in the catNames list, if not, num should be set to the size of the 
		* catNames list.*/
        Random rand = new Random();
        int addingIndex;
        String addingName;
        addingIndex = rand.nextInt(catNames.size());
        ArrayList<String> names = new ArrayList<String>();
        if (num < catNames.size()) {
            while (names.size() < num) {
                addingIndex = rand.nextInt(catNames.size());
                addingName = catNames.get(addingIndex);
                if (!names.contains(addingName)) {
                    names.add(addingName);
                } 
            } 
        }
        else{
            names = catNames;
        }
        return names;
    }

    public static ArrayList<String> getRandomLocationList( int num ){
        ArrayList<String> randomLocations = new ArrayList<String>();
        int randX;
        int randY;

        Random rand = new Random();
        int locCount = 0; //name counter

        while (  locCount < num ){    
            randX = rand.nextInt( CAMPUS_RADIUS * 2 );
            randY = rand.nextInt( CAMPUS_RADIUS * 2 );
            //if name not already added to list
            if( Math.sqrt( Math.pow(randX,2) + Math.pow(randY,2)) <= CAMPUS_RADIUS * 2 ){
                randomLocations.add( randX + "," + randY );
                locCount++;
            }
        }
        return randomLocations;
    }

    public static ArrayList<Integer> getRandomMonthList( int num ){
        ArrayList<Integer> randomMonths = new ArrayList<Integer>();
        int month;
    
        Random rand = new Random();

        for ( int i = 0; i < num; i++ ){    
            month = rand.nextInt( MAX_MONTHS );
            randomMonths.add( month );
        }
        return randomMonths;
    }

    public static double calculateDistance(String location1, String location2){
        int x1, x2, y1, y2;
        double distance;
        x1 = Integer.valueOf(location1.substring(0, location1.indexOf(',')));
        y1 = Integer.valueOf(location1.substring(location1.indexOf(',')+1));
        x2 = Integer.valueOf(location2.substring(0, location2.indexOf(',')));
        y2 = Integer.valueOf(location2.substring(location2.indexOf(',')+1));
        distance = Math.sqrt(Math.pow(x2 - x1,2) + Math.pow(y2-y1,2));
        return distance;
    }

    public static boolean doesIntersect(String location1, String location2){
        int radius;
        double distance;
        boolean isIntersect;
        radius = 50;
        distance = calculateDistance(location1, location2);
        isIntersect = false;
        if (distance <= 2 * radius) {
            isIntersect =true;
        } 
        return isIntersect;
    }

    public static int countIntersecting(String location, ArrayList<String> locations){
        int count, indexOfLocation;
        count = 1;
        indexOfLocation = locations.indexOf(location);
        for (int i = 0; i < locations.size(); i++) {
            if ( i != indexOfLocation && doesIntersect(location, locations.get(i))){
                count++;
            }
        }
        return count;
    }

    public static void displayIntersections(ArrayList<String> cats, ArrayList<String> locations, ArrayList<Integer> months){
        for (int i = 0; i < cats.size(); i++) {
            System.out.printf("%n %s at location %s for %s months intersects with: ", cats.get(i),  locations.get(i), months.get(i));
            if (countIntersecting(locations.get(i), locations) == 1) {
                System.out.printf("NO CATS%n");
            }
            else{
                for (int j = 0; j < cats.size(); j++) {
                    if ( i != j && doesIntersect(locations.get(i), locations.get(j))) {
                        System.out.printf("%n   %s, at location %s for %s months ", cats.get(j),  locations.get(j), months.get(j)); 
                    }
                }
            }
        }
        System.out.printf("%n");
    }

  public static int findMinMonthsAtLocation(String location, ArrayList<String> locations, ArrayList<Integer> months){
    int minMonth, indexOfMin;
    indexOfMin = -1; 
    minMonth = Integer.MAX_VALUE;
    for (int i = 0; i < locations.size(); i++) {
        if (doesIntersect(location, locations.get(i)) && months.get(i) < minMonth) {
            minMonth = months.get(i);
            indexOfMin = i;
        }
    }
    return indexOfMin;
   }

    public static String findRandomLocation(){
        Random rand = new Random();
        String location;
        int randX;
        int randY;
        randX = rand.nextInt( CAMPUS_RADIUS * 2 );
        randY = rand.nextInt( CAMPUS_RADIUS * 2 );
        while ( Math.sqrt( Math.pow(randX,2) + Math.pow(randY,2)) > CAMPUS_RADIUS * 2 ){
            randX = rand.nextInt( CAMPUS_RADIUS * 2 );
            randY = rand.nextInt( CAMPUS_RADIUS * 2 );
        }
        location = randX + "," + randY;
        return location;
    }

    public static void moveCats(ArrayList<String> locations, ArrayList<Integer> months){
        int indexOfMinMonth;
        boolean isPerfect;
        do {
            for (int i = 0; i < locations.size(); i++) {
                if (countIntersecting(locations.get(i), locations)> 2) {
                    indexOfMinMonth = findMinMonthsAtLocation(locations.get(i), locations, months);
                    locations.set(indexOfMinMonth, findRandomLocation());
                    months.set(indexOfMinMonth, 0);
                }
            }
            //control whether it is perfect
            isPerfect = true;
            for (int i = 0; i < locations.size() && isPerfect; i++) {
                if (countIntersecting(locations.get(i), locations) > 2) {
                    isPerfect = false;
                }
            } 
        } while (!isPerfect);


    }

    public static void main(String[] args) {
        ArrayList<String> cats = getRandomNameList(20);
        ArrayList<String> locations = getRandomLocationList(20);
        ArrayList<Integer> months = getRandomMonthList(20);

        System.out.println("");
        System.out.println(" Before moving the cats:");
        displayIntersections(cats, locations, months);
        System.out.println("");
        System.out.println(" After moving the cats:");
        moveCats(locations, months);
        displayIntersections(cats, locations, months);
    }
}
