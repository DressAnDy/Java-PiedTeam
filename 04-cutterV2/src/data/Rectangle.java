
package data;

public class Rectangle {
    protected String color;
    protected double Width;
    protected double Height;
    public Rectangle(String color, double Width, double Height) {
        this.color = color;
        this.Width = Width;
        this.Height = Height;
    }

    public String getColor() {
        return color;
    }

    public double getWidth() {
        return Width;
    }

    public double getHeight() {
        return Height;
    }
    
    public double getPerimeter(){
        return (Height + Width) * 2;
    }
    
    public double getArea(){
        return Height * Width;
    }
    
    public void paint(){
        String str = String.format("Rectangle     |%10s|%5.2f|%5.2f|%5.2f|%5.2f", 
                                                   color , Height , Width , getPerimeter(),
                                                   getArea());
        System.out.println(str);
    }
 }

 //disk: hình tròn
  
