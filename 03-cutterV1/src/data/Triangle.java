package data;
//Triangle là cái khuôn(class) chuyên dùng để đúc ra các 
//bức tượng(Object) tam giác
//có thẻ nói rằng , tất cả các hình tam giác đều tạo ra từ cái khuôn này
public class Triangle {

    //prop:
    protected double edgeA;
    protected double edgeB;
    protected double edgeC;
    //double perimeter = edgeA + edgeB + edgeC; //sai
    //không nên tạo thuộc tính chu vi và diện tích
    //nếu mình tạo ra nó thì người dùng có thể set giá trị lên nó
    // và tất nhiên có thể set sai giá trị so với 3 cạnh
    // cái gì có thể tự tính được bằng những cái trước nó thì k nên lưu
    // => tạo 1 hàm tính chu vi , ai gọi thì mình lấy 3 cạnh ra tính tổng 
    
    public Triangle(double edgeA, double edgeB, double edgeC) {
        this.edgeA = edgeA;
        this.edgeB = edgeB;
        this.edgeC = edgeC;
    }


    public double getEdgeA() {
        return edgeA;
    }

    public double getEdgeB() {
        return edgeB;
    }

    public double getEdgeC() {
        return edgeC;
    }
    
    public double getPerimeter(){
        return edgeA + edgeB + edgeC;
    }
    
    public double getArea(){
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - edgeA) * (p - edgeB) * (p - edgeC));
    }
    
    //method
    //show
    public void showInfor(){
        String str = String.format("Triangle     |%5.2f|%5.2f|%5.2f|%5.2f|%5.2f", 
                                                   edgeA , edgeB , edgeC , getPerimeter(),
                                                   getArea());
        System.out.println(str);
    }
    
}
