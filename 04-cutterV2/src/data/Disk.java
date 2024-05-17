    
package data;

//Disk là cái khuôn hình tròn , chuyên đúc ra các hình tròn

public class Disk {
    private String color;
    private double radius;
    public final static double PI = 3.14; //thuộc về cái khuôn hình tròn
    
    //Cái phễu
    public Disk(String color, double radius) {
        this.color = color;
        this.radius = radius;
    }
    
    //gettter
    public String getColor() {
        return color;
    }

    public double getRadius() {
        return radius;
    }
    public double getPerimeter(){
        return 2 * radius*PI;
    }
    
    public double getArea(){
        return PI * Math.pow(radius,2);
    }
    
    
    public void paint(){
        String str = String.format("Disk     |%10s|%5.2f|%5.2f|%5.2f|", 
                                                   color , radius , getPerimeter(),
                                                   getArea());
        System.out.println(str);
    }

    
    
    
}



//từ cái khuôn class Disk tạo ra 8 hình tròn ( Object)
/*
    
*/