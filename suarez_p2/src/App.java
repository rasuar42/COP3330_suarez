import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }


    //Methods
    public static double getUserHeight()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Height (inches): ");

        double height = sc.nextDouble();
        String buff = sc.nextLine();    //Input Buffer

        while(height < 0)
        {
            System.out.println("Please enter a positive number: ");
            height = sc.nextDouble();
            buff = sc.nextLine();   //Input Buffer
        }

        return height;
    }

    public static double getUserWeight()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Weight (pounds):");

        double weight = sc.nextDouble();
        String buff = sc.nextLine();   //Input Buffer

        while(weight < 0)
        {
            System.out.println("Please enter a positive number: ");
            weight = sc.nextDouble();
            buff = sc.nextLine();   //Input Buffer
        }

        return weight;
    }

    public static boolean moreInput()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("More Input? (Y/N): ");
        String in = sc.nextLine();
        String buff = sc.nextLine();   //Input Buffer

        //Checks if other letters are pressed
        while(in.equalsIgnoreCase("y") && in.equalsIgnoreCase("n"))
        {
            System.out.println("More Input? (Y/N): ");
            in = sc.nextLine();
            buff = sc.nextLine();   //Input Buffer
        }

        return in.equalsIgnoreCase("y"); //if 'y' return true else false
    }

    public static void displayBmiInfo(BodyMassIndex obj)
    {
        double temp = obj.calcBMI();
        System.out.println("Your BMI: " + temp);
        System.out.print("Category: ");
        System.out.print(obj.categorize());
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiList)
    {
        int len = bmiList.size();
        double bmiSum = 0;
        double bmiAvg = 0;

        for(BodyMassIndex obj : bmiList) {
            bmiSum += obj.calcBMI();
        }
        bmiAvg = bmiSum/len;

        System.out.println("Average BMI: " + bmiAvg);
    }

}
