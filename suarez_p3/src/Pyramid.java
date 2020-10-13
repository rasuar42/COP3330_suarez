public class Pyramid extends Shape3D{
    private final double length;
    private final double width;
    private final double height;

   public Pyramid(double length, double width, double height)
   {
        this.length = length;
        this.width = width;
        this.height = height;
   }

    public String getName() {
        return "pyramid";
    }

    public double getArea() {
       double a = length*width;
       double b = length*Math.sqrt(Math.pow(width/2, 2) + Math.pow(height, 2));
       double c = width*Math.sqrt(Math.pow(length/2, 2) + Math.pow(height, 2));
        return a+b+c;
    }

    public double getVolume() {
        return (length*width*height)/3;
    }
}
