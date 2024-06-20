
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Revision {
    
    public static ArrayList<FlashCard> readCards( String filename ){

        String line;
        String[] data;
        FlashCard f1;
        
        //creates an empty list to store FlashCards
        ArrayList<FlashCard> cardList = new ArrayList<FlashCard>();

        //create a File object representing file to read
        File inFile = new File( filename );

        //try the following
        try {
            //create Scanner that reads from file with given name
            Scanner file = new Scanner( inFile );

            //while file contains more data
            while( file.hasNext() ) {
                //read the next line from the file
                line = file.nextLine();

                //split the line into tokens (hint: String split() method )
                data = line.split("\t", 3);
                //System.out.println(Arrays.toString(data));
                
                //create a FlashCard object using the line tokens - don't forget convert difficulty to int
                f1 = new FlashCard(data[0], data[1], Integer.parseInt(data[2]));
                
                //add the card to the list
                cardList.add(f1);
                
            }
            //close the file
            file.close();
        }catch( FileNotFoundException f ){
            System.out.println("file cannot be opened");
        }
        //return the ArrayList containing FlashCards from the file
        return cardList;
    }

	public static void bubbleSort (ArrayList<FlashCard> cards){
		boolean sorted = false;
        FlashCard temp;
		for (int j = 0; j < cards.size() - 1 && !sorted; j++){
			sorted = true;
			for (int k = 0; k < cards.size() - j - 1; k++){
				if (cards.get(k).getQuestion().compareTo(cards.get(k+1).getQuestion()) > 0){
					sorted = false;
					// Swap the current and next elements.
					temp = cards.get(k);
					cards.set(k, cards.get(k+1));
					cards.set(k+1, temp);
				}
			}
		}
	} // end bubbleSort

    public static void searchByQuestion(ArrayList<FlashCard> flashCards) {
        String tryAgain;
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to repeat a particular flaschcard (enter the question or enter no to exit):");
        tryAgain = input.next();
        while (!tryAgain.equalsIgnoreCase("no")){
            for (int i = 0; i < flashCards.size(); i++) {
                if (flashCards.get(i).getQuestion().equalsIgnoreCase(tryAgain)) {
                    flashCards.get(i).showFlashCardAnswer();
                }
                else if (flashCards.get(i).getAnswer().equalsIgnoreCase(tryAgain)){
                    flashCards.get(i).showFlashCardQuestion();
                }
                else {
                    System.out.printf("This cardlist does not have %s%n",tryAgain);
                }
                System.out.println("Would you like to repeat a particular flaschcard (enter the question or enter no to exit):");
                tryAgain = input.next();
            }
        }
    }

    
        
    public static void main(String[] args) {
        int numOfCards, randomNum, rightQ;
        String userAnswer, tryAgain;
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        ArrayList<FlashCard> flashCards = new ArrayList<FlashCard>();


        flashCards = readCards("turkish_english_words.txt");
        
        searchByQuestion(flashCards);
 
        in.close();

    }
}