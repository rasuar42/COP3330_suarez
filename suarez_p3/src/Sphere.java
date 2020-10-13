public class Sphere extends Shape3D {
   private final double radius;

   public Sphere(double radius)
   {
       this.radius = radius;
   }


    public String getName() {
        return "sphere";
    }

    public double getArea() {
        return 4*Math.PI*radius*radius;
    }

    public double getVolume() {
        return (4/3.0) * Math.PI * radius*radius*radius;
    }
}
