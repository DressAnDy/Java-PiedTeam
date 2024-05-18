    
package runtime;
//1 file java có thể chưa dc nhiều class
// class A là outter class của class Program
// class B là inner class của class Program

//tuy có nhìu class nhưng chỉ có 1 class dc public
//và class dc public phải có tên giống như file



public class Program {

    public static void main(String[] args) {
        Human diep = () ->{
            System.out.println("Ahihihih"); //lambda
        };
    Math xxx = (int a , int b) -> (a + b);
    xxx.add(2,5); 
    }
}

class A{
    
}

interface Human{
    public void show();
}

interface Math{
    public int add(int a , int b);
}

//lambda chỉ xuất hiện ở sau phiên bản SE8
//nhiệm vụ lớn nhất của lambda là viết code tạo ra object từ anonymours
//gọn hơn

//tại sao interface thì chỉ nên có một method mà thôi ?
// vì lambda chỉ bổ sung code cho 1 method mà thôi , nếu có 2 method thì k bik
// bổ sung cho method này

//vậy nên SE9 , người ta thêm vào @FunctionalInterface để ràng buộc interface
//chỉ có 1 method 