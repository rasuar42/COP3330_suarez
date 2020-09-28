import  java.lang.Math;

public class BodyMassIndex {
    private final double height;
    private final double weight;
    private final double BMI;


    //Constructor
    public BodyMassIndex(double h, double w)
    {
        height = h;
        weight = w;
        BMI = calcBMI(h, w);
    }

    //Helper Functions

    /* Unneeded Functions
    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }
    */

    public double getBMI() {
        return BMI;
    }

    private static double calcBMI(double h, double w)
    {
        double temp = (703 * w) / (h * h);
        return (double)Math.round(temp * 10) / 10;  //rounded one number after decimal
    }
}
