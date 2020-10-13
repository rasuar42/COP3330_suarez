public class Square extends Shape2D {

    private final double edge;


    public Square(double edge) {
        this.edge=edge;
    }

    public String getName() {
        return "square";
    }

    public double getArea() {
        return edge*edge;
    }


}
