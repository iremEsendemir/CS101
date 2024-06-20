import java.util.Scanner;
public class Lab01_Q3 {
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);

        double kgToLose;
        double daysToLose;
        double dailyDeficitCal;
        double recommendedDailyCal;
        final double CAL_TO_LOSE_1_KG;
        final double NORMAL_DAILY_CAL;
        final double RECOMMENDED_CARB_RATIO;
        final double RECOMMENDED_FAT_RATIO;
        final double RECOMMENDED_PROTEIN_RATIO;
        final double CARB_CAL_PER_G;
        final double FAT_CAL_PER_G;
        final double PROTEIN_CAL_PER_G;
        double recommendedCarbCal;
        double recommendedFatCal;
        double recommendedProteinCal;
        double carbG;
        double fatG;
        double proteinG;

        System.out.print("Enter kilograms to lose: ");
        kgToLose = in.nextDouble();

        System.out.printf("Enter days to lose %.0f kilograms: ",kgToLose);
        daysToLose = in.nextDouble();


        RECOMMENDED_CARB_RATIO = 0.50;
        RECOMMENDED_FAT_RATIO = 0.30;
        RECOMMENDED_PROTEIN_RATIO = 0.20;
        CARB_CAL_PER_G = 4;
        FAT_CAL_PER_G = 9;
        PROTEIN_CAL_PER_G = 4;
        CAL_TO_LOSE_1_KG = 7700;
        NORMAL_DAILY_CAL = 2000;
        dailyDeficitCal = (CAL_TO_LOSE_1_KG * kgToLose) / daysToLose;
        recommendedDailyCal = NORMAL_DAILY_CAL - dailyDeficitCal;
        recommendedCarbCal = recommendedDailyCal * RECOMMENDED_CARB_RATIO;
        recommendedFatCal = recommendedDailyCal * RECOMMENDED_FAT_RATIO;
        recommendedProteinCal = recommendedDailyCal * RECOMMENDED_PROTEIN_RATIO;
        carbG = recommendedCarbCal / CARB_CAL_PER_G; 
        fatG = recommendedFatCal / FAT_CAL_PER_G;
        proteinG = recommendedProteinCal / PROTEIN_CAL_PER_G;

        System.out.println("**************************************************************************************************");
        System.out.printf("To lose %.0f kilograms in %.0f days you will need a daily deficit of %.0f calories \n",kgToLose,daysToLose,dailyDeficitCal);
        System.out.println("**************************************************************************************************");
        System.out.printf("RECOMMENDED DAILY CALORIES TO LOSE %.0f KILOS IN %.0f DAYS: %.0f\n",kgToLose,daysToLose,recommendedDailyCal);
        System.out.println("**************************************************************************************************");
        System.out.println("MACRO          RECOMMENDED PERCENT     CALORİES PER GRAM     RECOMMENDED CALORIES           GRAMS");
        System.out.printf("CARBOHYDRATE%21.0f%s%22.0f%25.0f%16.1f\n",RECOMMENDED_CARB_RATIO*100,"%",CARB_CAL_PER_G,recommendedCarbCal,carbG);
        System.out.printf("FAT%30.0f%s%22.0f%25.0f%16.1f\n",RECOMMENDED_FAT_RATIO*100,"%",FAT_CAL_PER_G,recommendedFatCal,fatG);
        System.out.printf("PROTEIN%26.0f%s%22.0f%25.0f%16.1f\n",RECOMMENDED_PROTEIN_RATIO*100,"%",PROTEIN_CAL_PER_G,recommendedProteinCal,proteinG);
        System.out.println("**************************************************************************************************");

        in.close();   
    }
}
