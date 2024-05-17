//Bé na muốn quản lý tiếp
package runtime;
//muốn lưu hình vuông và hình chữ nhật
//hình chữ nhật (color, các cạnh)

import data.Disk;
import data.Rectangle;
import data.Square;
//chữ nhật là cha
public class Program {
    public static void main(String[] args) {
        Rectangle re1 = new Rectangle("Tím" , 2, 5);
        Square sq1 = new Square("Đỏ", 3);
        Rectangle re2 = new Square("Vàng", 2);
        //Square sq2 = new Rectangle(color , 3 , 9);
        //khai báo cha xong new con thì bình thường
        //khai con mà new cha thì ko dc
        
        Rectangle ds[] = new Rectangle[3];
        ds[0] = sq1;
        ds[1] = re1;
        ds[2] = re2;
        
        //in ra màn hình
        for(int i = 0 ; i <= ds.length - 1 ; i++){
            ds[i].paint();
        }
        
    }
    /*
    for(Rectangle item : ds){
        item.paint();
    } //iterable: tính khả duyệt
    */
    
    Disk d1 = new Disk("Tím" , 2); //biệt kiểu nhưng ko có giá trị = null
    //new Disk: gọi cái phễu của class Disk
    //cái phễu nhận dữ liệu(Nguyên Liệu) truyền vào
            //các ngăn(prop) của khuôn (java)
            //và tạo ra object và đưa cho con trỏ d1
    Square list[] = new Square[1];
}
