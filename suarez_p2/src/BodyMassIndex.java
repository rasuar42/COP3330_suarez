import  java.lang.Math;

public class BodyMassIndex {
    private final double height;
    private final double weight;

    //Constructor
    public BodyMassIndex(double h, double w)
    {
        height = h;
        weight = w;
    }

    public String categorize()
    {
        double BMI = calcBMI();

        if(BMI > 29.9) {
            return "Obesity";
        }else if(BMI > 24.9) {
            return "Overweight";
        }else if(BMI > 18.4) {
            return "Normal Weight";
        }else{
            return "Underweight";
        }
    }

    public double calcBMI()
    {
        double temp = (703 * weight) / (height * height);
        return (double)Math.round(temp * 10) / 10;  //rounded one number after decimal
    }
}
