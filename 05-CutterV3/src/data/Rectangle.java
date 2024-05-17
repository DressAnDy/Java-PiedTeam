package data;
/*
Rectangle là con của Shape , nếu kế thừa thì nó sẽ thừa hưởng tất cả những gì
shape có
=> ý nghĩa của kế thừa: khôi phục lại trạng thái trước khi nhận cha

quy trình nhận Shape là cha
0.tạo class con
1.khai báo đặc tính của riêng con
2. cho con nhận cha
3. tạo phễu
4. làm phần việc mà cha giao cho em nếu có
    - bổ sung code cho abs methods của ổng ( vá lỗ)
        + nếu mà mày vá thiếu lỗ nào thì m là abs class , con m phải vá
    - nếu ko có abs methods nào thì xem thử có gì độ thì độ (override)
    - có hàm nào của riêng m thì m thêm đi (extends) 
*/


public class Rectangle extends Shape{
    protected double width;
    protected double height;

    public Rectangle(String owner, String Color, double width, double height) {
        super(owner, Color);
        this.width = width;
        this.height = height;
    }
    //super : new Cha => new Shape: gọi phễu Shape
    //super phải là câu lệnh đầu tiên trong phễu , cha trước con sau

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
    
    
    
    
    
    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public void paint() {
        String str = String.format("%15s|%10s|%10s|%5.2f|%5.2f|%5.2f|%5.2f|",
                        "RECTANGLE", owner , Color , width , height , getPerimeter() , getArea());
        System.out.println(str);
    }
    
}
