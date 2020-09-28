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
        double temp = obj.getBMI();
        System.out.println("Your BMI: " + temp);
        System.out.print("Category: ");

        //Set Category
        if(temp > 29.9) {
            System.out.println("Obese");
        }else if(temp > 24.9) {
            System.out.println("Overweight");
        }else if(temp > 18.4) {
            System.out.println("Normal Weight");
        }else{
            System.out.println("Underweight");
        }
        System.out.print("Category: ");
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiArr)
    {
        int arrLen = bmiArr.size();
        int bmiSum = 0;
        int bmiAvg = 0;

        for(BodyMassIndex obj : bmiArr) {
            bmiSum += obj.getBMI();
        }
        bmiAvg = bmiSum/arrLen;

        System.out.println("Average BMI: " + bmiAvg);
    }

}
