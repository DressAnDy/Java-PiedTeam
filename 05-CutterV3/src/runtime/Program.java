
package runtime;

import data.Disk;
import data.Rectangle;
import data.Shape;
import data.Square;

/*
    bây giờ tui ko chỉ quản lý Rectangle và Square mà tui còn mún quàn lý thêm
Disk , và sau này còn Triangle thì bạn có cách nào để bỏ tất cả những loại này
vào cùng 1 mảng không ? cũng có thể | hoặc không
tùy vào việc tôi có tìm dc cha của tất cả bọn này ko ?   
*/
public class Program {
    public static void main(String[] args) {
        //muốn quản lý hết bọn vuông , tròn chữ nhật , tam giác
        //thì phải bỏ vào mảng
        Shape ds[] = new Shape[5];
        ds[0] = new Disk("Tía", "Purple", 2.0);
        ds[1] = new Rectangle("Hường", "Pink", 2 ,3);
        ds[2] = new Square("Lục", "Greenn", 4);
        //bỏ vào gián tiếp
        
        Disk d = new Disk("Lam" , "Blue" , 5);
        ds[3] = d;
        
        //muốn tạo ra 1 object thì cần những thứ gì
        //cái khuôn - class
        //cái phễu
        //biến con trỏ = new ???
        //Dog chiquaqua = new Dog();
        //new Dog() nhận dữ liệu , gán vào các ngăn của khuôn
        //  tạo ra object và đưa ra biến con trỏ "chiquaqua"
        
        //Vậy nếu tạo object từ class con thì sao ? cũng vậy
        //Square sq1 = new Square();
        
        //nếu nhìn sâu vào vùng nhớ của con thì có gì đặc biệt
        //khi ta new Con sẽ phải new Cha(super)
        //ý nghĩa: giúp cho thằng con có tất cả những gì thằng cha có
        // bản thân trước đó thằng con và cha sống độc lập
        //nhưng nếu để nhận cha con thì con cho cha những điểm chung
        // => vì vậy kế thừa là cách mà nó khôi phục lại trạng thái ban đầu
        // => không làm lại những gì người khác làm tốt rồi
        
        //object con nếu ta nhìn vào sâu bên trong sẽ là
        //Square s1 = new Square()
        //   new Rectangle() + code của riêng con (override)
        // => con = cha + code của riêng con
        //          super
        //          di chuyền   extends(vùng biến dị)
        //          inherit
        
        //nếu object của abs class?
        //sẽ là con = new cha + code của riêng con +
        
        //Shape là abstract class và không có khả năng tạo object
        //nên nó phải thông qua 1 class khác(class trung gian)
        //giúp nó vá lỗi (rectangle , square , Disk)
        //nhưng nếu như class con của em là một class khó nói tên thì sao
        //hoặc em k bik tên thì sao ? thì em có thể dùng kỹ thuật anonymous
        //Mượn gió bẻ măng
        
        //khi nào thì dùng anonymous:
            //muốn tạo object từ 1 cái khuôn bị thủng(abs class)
            //mà không muốn tạo class trung gian
            //lười nghĩ tên , lười viết
            //vừa rót giá trị , vừa vá lỗ, nhào nặng bằng tay
            
            //ưu điểm, khỏi đặt tên , nhanh gọn lẹ , cần là code
            //nhược điểm: hardcore , ko tái sử dụng được , phải copy
        Shape xxx = new Shape("Bé Na", "7Color") {
            @Override
            public double getPerimeter() {
                return 50;
            }
            
            @Override
            public double getArea() {
                return 15;
            }
            
            @Override
            public void paint() {
            String str = String.format("%15s|%10s|%10s|%5.2f|%5.2f|", 
                                                   "XXX", owner ,Color , getPerimeter(),
                                                   getArea());
                System.out.println(str);
            }
        };
        
        ds[4] = xxx;
        for (Shape item : ds) {
            item.paint();
        }
        Rectangle r1 = new Rectangle("r1", "Pink", 10, 23);
        Square s1 = new Square("s1", "Tím" , 5);
        //gọi cái phễu hình vuông và đổ vào cái phểu này , bản chất s1 là con 
        //trỏ và trỏ vào dùng nhớ
        r1.paint();
        s1.drawInfor();
        //trong thực tế , hình vuôn cũng dc xem là hình chữ nhật
        //ta có thể tạo hình chữ nhật bằng khuôn hình vuông không
        Rectangle r2 = new Square("r2", "Vàng", 20);
        //nó sẽ sở hữu body của thằng Square nhưng không thể chạm hết những gì
        //của riêng thằng square
        r2.paint(); //Square vì paint bị override rồi
        //r2.drawInfor(); //k dc vì em đang là rectangle
        //dù em có drawInfo bên trong (do tạo bằng square) nhưng con trỏ
        //rectangle thì k dc truy cập vào
        
        Square tmp = (Square)r2; //ép kiểu , lúc đầu nó là rectangle nhưng mình
        //sẽ để nó hiểu ý là Square
        tmp.drawInfor();
        
        ((Square)r2).drawInfor();
        
        //khai cha new con
        //không dc khai con new cha
    }
}

//chỉ lưu những cái chung , lưu cái riêng thì những thằng kế thừa sẽ có thuộc
//tính đó.

