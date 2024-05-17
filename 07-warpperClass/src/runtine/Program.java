package runtine;

public class Program {
    public static void main(String[] args) {
        int a = 10; //primitive datatype: kiểu dữ liệu nguyên thủy
        //a là một đơn vị siêu nhỏ , nhỏ đến mức không thể tách nhỏ được nữa
        //a. cái đầu này
        //WarpperClass
        Integer b = new Integer(10);
        //lấy một cái class tên là Integer(core = 10)
        //new Integer(10) tạo ra 1 vùng nhớ lưu trữ ở Heap
        //và vùng nhớ này rất lớn
        //b là một biến con trỏ nằm ở stack , đang trỏ vào vùng nhớ
        //có core là 10
        //so về kích thước thì a < b nên anh không khuyến kích
        //lưu số nguyên bằng warpper class
        //boxing : gói 1 con số int bằng 10 vào 1 cái object
        //boxing xảy ra khi Warpper = primitive
        //=> gán primitive vào warpper class
        System.out.println("a nè: " + a);
        System.out.println("b nè: " + b);
        System.out.println("b nè: " + b.toString()); //toString: lôi hết tất cả
        //thuộc tính để in 
        //auto unboxing
        
        int c = b;
        //auto unboxing, mở object b ra , lấy cái core 10 
        //sau đó gán 10 đó cho c
        System.out.println("c nè: " + c);
       //c. cái đầu m
       
       //ngoài ra ta có thể tạp object từ wapper class như sau
       Integer d = 2000;
       //Wapper = primitive boxing
       //gói 2000 vào 1 object Integer
       //xài bth
        System.out.println("d nè: " + d);
        System.out.println("sum nè: " + (a + d)); //2010
        //vào cái d ( object) lấy 2000 ra + a (10) = 2010
        
        
        //comparision
        d = 2000;
        b = 2000;
        a = 2000;
        
        if(d.equals(b) == 0){
            System.out.println("Bằng nhau");
        }else{
            System.out.println("Khác nhau");
        }
        
        //số nguyên so với số nguyên là rất bth '=='
        //số nguyên so với warpper thì dùng '==' vì auto uboxing
        //Warpper và warpper không so sánh dc
        //chúng nó đang so địa chỉ với nhau
        //2 con trỏ chơi với nhau thì ko bật dc auto unboxing
        //và sẽ so sánh 2 địa chỉ
        // .equals() hoắc compareTo(b)
        //warpper class bự hơn
    }
}
