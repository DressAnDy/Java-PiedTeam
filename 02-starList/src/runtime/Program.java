
package runtime;

import data.Star;

public class Program {
    public static void main(String[] args) {
        Star mtp = new Star("Thanh Tung", 1994, "Nam", "Cơn Mưa Ngang Qua");
        //new Star: là gọi cái phễu star
        mtp.showInfor();
        Star chipu = new Star("Huyền Chi", 1993, "Nữ", "Chiếc Ố");
        chipu.showInfor();
            System.out.println("Tung sinh nam: " + mtp.yob);
            mtp.yob = 1999;
            System.out.println("Tung sinh nam: " + mtp.yob);
            
            System.out.println("Ten cua Tung ne " + mtp.getName()); //get
            mtp.setName("Tung iu Diep", 22032024);
            System.out.println("Ten cua Tung ne " + mtp.getName());
            

            //di ho boi
            Star ngocTrinh = new Star("Trần Thị Ngọc Trinh", 1989 , "Nữ", "Eo56");
            ngocTrinh.showInfor();
            
            Star diep = new Star("Lê Mười Điệp", 1999 , "Nam", "Thích gõ code");
            diep.showInfor();
            ngocTrinh.showInfor();
            //khi đặt 1 thằng là static , thì tất cả sẽ xài chung
    }
}

/*
Modifier: bộ nghĩa
1 - access modifier
    + public: phạm vi truy cập rộng nhất, gọi ở đâu cũng dc
              ai cũng nhìn thấy

    + private: riêng tư , phạm vị truy cập thấp nhất , không ai truy cập được
               chỉ có mình nó xài thôi
    + default: trong cùng package ai cũng có thể truy cập được nó
    
    + protected: giống public nhưng chỉ truy cập được bởi các con (extends
                 quy tắc bất hiếu
2 - non-access modifier
    + final: áp dụng cho class , prop , method
        - class không nhận con , vẫn tạo object
        - properties: hằng số
        - method:cho kế thừa mà không được Override - là phiên bản cuối 
    + static: tĩnh lặng
        đứng yên, k xê dịch
        prop , method mà có static thì nghĩa là object k dc nhân bản
        mà phải xài chung với nhau
        lúc này prop và method đó là của class
    + abstract: trù tượng:
        1 class có những abstact method nó class đó là abstract class
        nhưng 1 abstract class thì k nhất thiết phải có abstract method
        
*/

/*
Program: thấy: Student  | ai thấy nó: k ai hết
Student: thấy: Bike  | ai thấy nó: ai cũng thấy
Car: thấy: Student , Bike  | ai thấy nó: không ai thấy nó
Bike: thấy: Student  | ai thấy nó: Student , Car

vd: protected 
class có khả năng kế thừa , nhận CHA CON

class Hai{
    protected People Bà_Nội
}

class Tuan{
    protected int money = 1000
}

class Hung extends Tuan{
    private People Người_Yêu;
}

Tuan la CHA của thằng Hung
Quy tắc: quy tắc bất hiếu: cha cho con hết những gì cha có
         còn con thì không cho gì cả
Hải có Bà_Nội;
Tuấn thừa thưởng Bà_Nội từ Hải và tạo ra tiền
Hùng thừa hưởng Bà_Nội và Tiền , tạo ra Ny

P/S: chỉ thừa hưởng mà ko trả lại
vd: Tuấn tạo ra tiền nhưng Hải ko thể sử dụng được
    Hùng tạo ra người yêu nhưng Hải và Tuấn không thể sử dụng được
*/

/*
   class là gì ?
*/



/*
    Nguyên tắc Class
- Nguyên tắc quản lý : tao phải đưa mọi thứ về cùng mảng thì mới quản lý được
- Nhưng mảng chỉ chơi với những thằng cùng kiểu
- Vậy nên ta bốc ra 2 đối tượng (Object) bất kỳ và tìm điểm chung của nó
- Từ điểm chung này , ta suy luận ra bộ khuông (Class)
- Và dự trên class , ta có thể tạo ra nhiều (Object) như vậy nên chúng là 1 nhà
,cùng 1 loại , cùng 1 khuôn tạo ra , về cùng 1 mảng
*/

/*
vd:final: cuối cùng
    class
        1 - nhận 1 class khác làm con của nó
        2 - tạo ra object

        1 - class mà bị final thì sao ?
            + thì nó vẫn tạo ra object nhưng nó sẽ không nhận class
              khác làm con được.
    final properties:
    properties: thuộc tính, bản chất cũng chỉ là những cái biến
        bình thường mà thôi
        yob int yob
        yob k được chỉnh giá trị nữa: hằng số
    final method
        //ví dụ về việc bán trà sữa
        class Cha{
            protected method: nấu trà sữa{
                bỏ đường , sữa , than tre
            }
        }
        
        class Con{
            @Override
            protected method: nấu trà sữa{
                bỏ đường , sữa , than tre
                đường hóa học , ma tóe
            }
        }
        //Thằng con dựa vào hàm nấu trà sữa của CHA mà độ lại
            chế ra hàm nấu trà sữa của riêng nó
        Vậy thì thằng cha có: 1 cách nấu trà sữa và k nấu được giống con
            vì quy tắc bất hiểu
        Vậy thì thằng con có : 2 cách nấu trà sữa và cách nó độ 
    Cha.nấu trà sữa()
    Con.nấu trà sữa()
    @Override : ghi đè xong rồi xóa thằng trước đó. (Vượt mặt) 
        nó vừa có phương thức của CHA và có cả phương thức của chính nó tạo ra


    cha mà final thì con vẫn được kế thừa nhưng ko được Override(vượt mặt và độ)

vd: abtract: trừu tượng
    class Cha{
       abstract method: thành công()
       abstract method: ăn trứng()
       abstract method: yêu();
    }
thành công là một định nghĩa rất khó để viết ra , mỗi người mỗi nghĩ khác nhau 
1 class có những hành động không định nghĩa được , ko giải thích dc (abstract)
1 class có những abstact method nó class đó là abstract class
nhưng 1 abstract class thì k nhất thiết phải có abstract method
*/