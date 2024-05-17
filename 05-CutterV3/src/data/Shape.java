package data;
/*
    Shape là cha của tất cả các loại hình học và nếu là cha
thì nó chỉ nên chứa những điểm chung của các con mà thôi , nếu nó chứa
1 prop của riêng thằng con nào ( radius) thì các thằng con còn lại sau khi kế
thừa sẽ phải sở hữu radius đó 
*/
public abstract class Shape { //1 abstract class không cần abstract methods
    //nếu có abstract methods thì class đó gọi là abstract class
    protected  String owner;
    protected String Color;
    
    //tạo cái phễu

    public Shape(String owner, String Color) {
        this.owner = owner;
        this.Color = Color;
    }

    public String getOwner() {
        return owner;
    }

    public String getColor() {
        return Color;
    }
    
    public abstract double getPerimeter();
    public abstract double getArea();
    public abstract void paint();
}

//tại sao ko viết công thức cho chu vi , vì shape là cha của tất cả hình học
//nên mọi thứ shape có đều sẽ cho đám con , nếu shape có 1 công thức tính chu vi
//thì các con sẽ dùng công thức đó hết ( quy tắc bất hiếu)
//nhưng ta không tìm được công thức nào cho tất cả các hình
//phải cụ thể là hình nào thì mới có công thức
//nên shape chọn không định nghĩa công thức 

//Tại sao shape lại là abstract class
//vì nó chứa abs methods

//abs methods là gì ?
//là methods không có định nghĩa , hoang mang ko rõ nghĩa
//giống như 1 lỗ thủng của 1 cái khuôn

//abs giống cái khuôn mà có lỗ thủng gì đó
//thì nó không thể đúc được bức tượng
//vì bức tượng ( đối tượng) tạo ra sẽ có một hành động bất thường
//vậy từ abstract class mà muốn đúc thì sao ?
// thì abstract class cần tìm 1 class con , và nhờ thằng con vá lỗ
//thủng cho mình , vá dc thì thằng con đúc dc object

//nếu thằng con vá k dc thì thằng con là abs class và chờ đới cháu vá

/*
abs class Shape
    abs getPerimeter()
    abs getArea()
    abs paint()

abs class Rectangle extends Shape
    abs getPerimeter()
    abs getArea()
    abs paint()

class Square extends Shape
    abs getArea()
    abs paint()

*/