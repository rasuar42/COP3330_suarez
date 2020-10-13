public class Triangle extends Shape2D{
    private final double length;
    private final double height;


    public Triangle(double length, double height)
    {
        this.length = length;
        this.height = height;
    }

    public String getName() {
        return "triangle";
    }

    public double getArea() {
        return length*height;
    }
}
