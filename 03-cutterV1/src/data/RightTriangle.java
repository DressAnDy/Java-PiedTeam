package data;
//RightTriangle: là cái khuôn chuyên dùng để đúc ra hình tam giác vuông
//bọn nó giống nhau , có thể nói là chúng có mối quan hệ
//cha con là mối quan hệ "is a"
//Triangle is a RightTriangle(sai)
//RightTriangle is a Triangle(đúng)
//con                   cha
//xác định cha con thông qua is - a
//Tại sao t phải nhận cha : bản chất RightTrangle không nhận cha
//có bình thường không ? bình thường nhưng mà mệt lắm 
// 1.Những gì cha làm tốt rồi thì mình lấy xài , k viết lại
// extends: mở rộng
public class RightTriangle extends Triangle{

   //nêu ra các prop mà cha ko có
   //k có gì khác so với cha cả
    
    //constructor
    public RightTriangle(double edgeA, double edgeB) {
        super(edgeA, edgeB, Math.sqrt(edgeA*edgeA + edgeB*edgeB));
    }
    //super: bề trên : new Triangle
    //khỏi getter và showInfo thì t kế thừa ba t
    @Override
        public void showInfor(){
        String str = String.format("RightTriangle     |%5.2f|%5.2f|%5.2f|%5.2f|%5.2f", 
                                                   edgeA , edgeB , edgeC , getPerimeter(),
                                                   getArea());
        System.out.println(str);
    }
}
//ta có 2 class cha và con , class con kế thừa class cha 
//thì có nghĩa là con sẽ kế thừa hết tất cả những gì cha có
//class con > < == class cha
//trong constructor của con thì nó gọi constructor của cha
//bằng từ khóa super
//mún tạo con thì phải tạo cha khác
//trong con có cha 
// => con > cha

//Override: là hiện tượng chỉa xuất hiện trong mối quan hệ cha con is a
//hiện tượng diễn ra khi thằng con muốn độ lại method của thằng cha
//nó tạo ra 1 method có thể giống với method của cha ( or khác paremeter và body)

//Overload: hiện tượng diễn ra không cần mối qua hệ 
//khi mà methoad này trùng tên method kia và khác paremeter