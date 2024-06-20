
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FlashCardApp {
    
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
        int numOfStr;
        boolean dne = true;
        Scanner input = new Scanner(System.in);
        System.out.print("Would you like to repeat a particular flaschcard (enter the question or enter no to exit): ");
        tryAgain = input.nextLine();
        System.out.println(tryAgain);
        while (!tryAgain.equalsIgnoreCase("no")){
            for (int i = 0; i < flashCards.size() && dne; i++) {
                if (flashCards.get(i).getQuestion().equalsIgnoreCase(tryAgain)) {
                    flashCards.get(i).showFlashCardAnswer();
                }
                else if (flashCards.get(i).getAnswer().equalsIgnoreCase(tryAgain)){
                    flashCards.get(i).showFlashCardQuestion();
                }
            }
             System.out.print("Would you like to repeat a particular flaschcard (enter the question or enter no to exit): ");
             tryAgain = input.nextLine();
        }
    }
        
    public static void main(String[] args) {
        int numOfCards, randomNum, rightQ;
        String userAnswer;
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        ArrayList<FlashCard> flashCards = new ArrayList<FlashCard>();
        ArrayList<FlashCard> cardsToPlay = new ArrayList<FlashCard>();
        ArrayList<FlashCard> wrongAnswers = new ArrayList<FlashCard>();


        flashCards = readCards("turkish_english_words.txt");
        System.out.print("Enter the number of flash cards to generate: ");
        numOfCards = in.nextInt();
        while (cardsToPlay.size()<numOfCards) {
            randomNum = rand.nextInt(flashCards.size());
            if (!cardsToPlay.contains(flashCards.get(randomNum))) {
                cardsToPlay.add(flashCards.get(randomNum));
            }
        }
        bubbleSort(cardsToPlay);
        System.out.println("Let's play!");
        rightQ = 0;
        for (int i = 0; i < cardsToPlay.size(); i++) {
            cardsToPlay.get(i).showFlashCardQuestion();
            System.out.print("Enter your guess: ");
            userAnswer = in.next();
            if (userAnswer.equalsIgnoreCase(cardsToPlay.get(i).getAnswer())) {
                System.out.println("Correct!");
                rightQ++;
            } 
            else {
                System.out.println("Wrong answer!");
                System.out.println("Lets see the correct answer:");
                cardsToPlay.get(i).showFlashCardAnswer();
                wrongAnswers.add(cardsToPlay.get(i));
            }
        }
        System.out.println("Your score: " + rightQ + " / " + numOfCards);
        if (rightQ != numOfCards) {
            System.out.println("Words you need to review:");
            for (int i = 0; i < wrongAnswers.size() ; i++) {
                System.out.print(wrongAnswers.get(i).toString());
            }
        }


        searchByQuestion(flashCards);
        in.close();

    }
}