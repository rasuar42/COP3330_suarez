public class Circle extends Shape2D {
    private final double radius;

    public Circle(double radius)
    {
        this.radius = radius;
    }

    public String getName() {
        return "circle";
    }

    public double getArea() {
        return Math.PI * radius*radius;
    }
}
