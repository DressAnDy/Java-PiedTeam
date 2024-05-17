
package data;

public class Square extends Rectangle{
    //liệt kê các điểm riêng của con
    //k có gì riêng
    //Constructor
    public Square(String color, double edge) {
        super(color, edge, edge);
    }
    @Override
    public void paint(){
        String str = String.format("Square   |%10s|%5.2f|%5.2f|%5.2f|%5.2f", 
                                                   color , Height , Width , getPerimeter(),
                                                   getArea());
        System.out.println(str);
    }
}
