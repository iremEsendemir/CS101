import java.util.Scanner;
public class Lab01_Q4 {
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);

        double kgToLose;
        double daysToLose;

        double recommendedDailyCalMin;
        double recommendedDailyCalMax;

        double dailyDeficitCal;


        double wantedDailyCalMin;
        double wantedDailyCalMax;

        final double CAL_TO_LOSE_1_KG;
        //final double NORMAL_DAILY_CAL;
        final double RECOMMENDED_CARB_RATIO;
        final double RECOMMENDED_FAT_RATIO;
        final double RECOMMENDED_PROTEIN_RATIO;
        final double CARB_CAL_PER_G;
        final double FAT_CAL_PER_G;
        final double PROTEIN_CAL_PER_G;

        double recommendedCarbCalMin;
        double recommendedCarbCalMax;

        double recommendedFatCalMin;
        double recommendedFatCalMax;

        double recommendedProteinCalMin;
        double recommendedProteinCalMax;

        double carbGMin;
        double carbGMax;

        double fatGMin;
        double fatGMax;

        double proteinGMin;
        double proteinGMax;

        System.out.print("Enter kilograms to lose: ");
        kgToLose = in.nextDouble();

        System.out.printf("Enter days to lose %.0f kilograms: ",kgToLose);
        daysToLose = in.nextDouble();

        System.out.print("Enter minimum calories you take: ");
        wantedDailyCalMin = in.nextDouble();

        System.out.print("Enter maximum calories you take: ");
        wantedDailyCalMax = in.nextDouble();


        RECOMMENDED_CARB_RATIO = 0.50;
        RECOMMENDED_FAT_RATIO = 0.30;
        RECOMMENDED_PROTEIN_RATIO = 0.20;
        CARB_CAL_PER_G = 4;
        FAT_CAL_PER_G = 9;
        PROTEIN_CAL_PER_G = 4;
        CAL_TO_LOSE_1_KG = 7700;

        // NORMAL_DAILY_CAL = 2000;

        dailyDeficitCal = (CAL_TO_LOSE_1_KG * kgToLose) / daysToLose;

        recommendedDailyCalMin = wantedDailyCalMin - dailyDeficitCal;
        recommendedDailyCalMax = wantedDailyCalMax  - dailyDeficitCal;

        recommendedCarbCalMin = recommendedDailyCalMin * RECOMMENDED_CARB_RATIO;
        recommendedFatCalMin = recommendedDailyCalMin * RECOMMENDED_FAT_RATIO ;
        recommendedProteinCalMin = recommendedDailyCalMin * RECOMMENDED_PROTEIN_RATIO;
        carbGMin = recommendedCarbCalMin / CARB_CAL_PER_G; 
        fatGMin = recommendedFatCalMin / FAT_CAL_PER_G;
        proteinGMin = recommendedProteinCalMin / PROTEIN_CAL_PER_G;

        recommendedCarbCalMax = recommendedDailyCalMax * RECOMMENDED_CARB_RATIO;
        recommendedFatCalMax = recommendedDailyCalMax * RECOMMENDED_FAT_RATIO;
        recommendedProteinCalMax = recommendedDailyCalMax * RECOMMENDED_PROTEIN_RATIO;
        carbGMax = recommendedCarbCalMax / CARB_CAL_PER_G; 
        fatGMax = recommendedFatCalMax / FAT_CAL_PER_G;
        proteinGMax = recommendedProteinCalMax / PROTEIN_CAL_PER_G;

        System.out.println("********************************************************************************************************************");
        System.out.printf("To lose %.0f kilograms in %.0f days you will need a daily deficit of %.0f calories \n",kgToLose,daysToLose,dailyDeficitCal);
        System.out.println("********************************************************************************************************************");
        System.out.printf("RECOMMENDED DAILY CALORIES TO LOSE %.0f KILOS IN %.0f DAYS: minimum %.0f calories and maximum %.0f\n",kgToLose,daysToLose,recommendedDailyCalMin,recommendedDailyCalMax);
        System.out.println("********************************************************************************************************************");
        System.out.println("MACRO          RECOMMENDED PERCENT     CALORİES PER GRAM     RECOMMENDED CALORIES(min-max)           GRAMS(min-max)");
        System.out.printf("CARBOHYDRATE%21.0f%s%22.0f%28.0f - %.0f %16.1f - %.1f\n",RECOMMENDED_CARB_RATIO*100,"%",CARB_CAL_PER_G,recommendedCarbCalMin,recommendedCarbCalMax,carbGMin,carbGMax);
        System.out.printf("FAT%30.0f%s%22.0f%28.0f - %.0f %16.1f - %.1f\n",RECOMMENDED_FAT_RATIO*100,"%",FAT_CAL_PER_G,recommendedFatCalMin,recommendedFatCalMax,fatGMin,fatGMax);
        System.out.printf("PROTEIN%26.0f%s%22.0f%28.0f - %.0f %16.1f - %.1f\n",RECOMMENDED_PROTEIN_RATIO*100,"%",PROTEIN_CAL_PER_G,recommendedProteinCalMin,recommendedProteinCalMax,proteinGMin,proteinGMax);
        System.out.println("*******************************************************************************************************************");

        in.close();   
    }
}