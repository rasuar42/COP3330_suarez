public class Cube extends Shape3D{

    private final double edge;


    public Cube(double edge)
    {
        this.edge = edge;
    }


    public String getName() {
        return "cube";
    }

    public double getArea() {
        return edge*edge;
    }

    public double getVolume() {
        return 6*getArea();
    }
}
