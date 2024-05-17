
package data;

public class Disk extends Shape{
    private double radius;
    public final static double PI = 3.14;

    public Disk(String owner, String Color , double radius) {
        super(owner, Color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    
    @Override
    public double getPerimeter() {
       return 2 * radius*PI;
    }

    @Override
    public double getArea() {
        return PI * Math.pow(radius,2);
    }

    @Override
    public void paint() {
                String str = String.format("Disk     |%10s|%5.2f|%5.2f|%5.2f|", 
                                                   Color , radius , getPerimeter(),
                                                   getArea());
        System.out.println(str);
    }
    
    
}
