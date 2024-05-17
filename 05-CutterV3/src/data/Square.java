
package data;

public class Square extends Rectangle {

    public Square(String owner, String Color, double edge) {
        super(owner, Color, edge, edge);
    }
        @Override
    public void paint() {
        String str = String.format("%15s|%10s|%10s|%5.2f|%5.2f|%5.2f|%5.2f|",
                        "Square", owner , Color , width , height , getPerimeter() , getArea());
        System.out.println(str);
    }
    public void drawInfor(){
        System.out.println("Ahihi"); //hàm của riêng thằng con 
    }
}
