import java.util.Scanner;
public class Lab04_Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String reviewLine, bar, inputString;
        int reviewNum, input,inputForDigit, inputForStars, inputForAverage, total ,average, addedNum;
        reviewNum = 0;
        reviewLine = "     ";
        System.out.print("Enter chard data: ");
        if (!in.hasNextInt()) {
            System.out.println("Invalid chard data!");
        } 
        else {
            inputString = in.next();
            in.close(); 
            input = Integer.parseInt(inputString);
            //calculates how many reviews
            inputForDigit = input;
            do {
                inputForDigit /= 10;
                reviewNum++;
            } while (inputForDigit > 0);
            
            //display review line
            for (int i = 1; i <= reviewNum; i++) {
                reviewLine += "review " + i + "     ";
            }
            System.out.println(reviewLine);

            //display stars
            for (int i = 9; i > 0 ; i--) {
                inputForStars = input;
                bar= "";
                for (int r = reviewNum - 1; r >= 0; r--) {
                    if (inputForStars / Math.pow(10,r) >= i) {
                        bar += "          ***";
                    }
                    else {
                        bar += "             ";
                    }
                    inputForStars %= Math.pow(10,r);
                }
                System.out.println(bar);
            }

            //calculate average
            total = 0;
            inputForAverage = input;
            for (int r = reviewNum - 1; r >= 0; r--) {
                addedNum =(int) (inputForAverage / (Math.pow(10, r)));
                total += addedNum;
                addedNum = 0;
                inputForAverage %= Math.pow(10,r);
            }
            System.out.printf("Average review: %.1f: ", total/(reviewNum*1.0));
        }
    }
}