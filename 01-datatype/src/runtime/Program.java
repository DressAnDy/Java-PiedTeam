
package runtime;

public class Program {
    public static void main(String[] args) { //access modifer , psvm
        //comment: ghi chú
        //trong java có 2 dạng datatype
        //1.primitive datatype: kiểu dữ liệu nguyên thủy
        //lấy 1 vùng nhớ nhỏ để lưu trữ dữ liệu
        //vùng nhớ này nhỏ đến mức không thể tách nhỏ được nữa
        //1 - byte       1 byte (8bit) số nguyên rất rất nhỏ
        //1 con byte có giới hạn [-128, 128] vì không tính số 0
        //2 - short      2 byte             số nguyên rất nhỏ
        //3 - int        4 byte             số nguyên nhỏ
        //4 - long       8 byte             số nguyên lớn
        //5 - float      4 byte             số thực nhỏ
        //6 - double     8 byte             số thực lớn
        //7 - char       2 byte(khổng phải 1 byte vì còn có dấu)    ký tự: Unicode
        //8 - boolean    1 bit              True/False
        
        byte numByte = -128;
        
        int numInt = 257;
        float numFloat = 1234.5f;
        //số thực trong java dc hiểu mặc định là double
        
        double numDouble = 123.5;
        
        numInt = numByte;
        //numByte = numInt;
        //đừng nhét cái gì đó quá bự vào cái gì đó quả nhỏ
        
        //2.Object datatype | references datatype : kiểu dữ liệu đối tượng
        //kiểu dữ liệu tham chiếu
        //là kiểu dữ liệu do người dùng tự định nghĩa ra dựa vào
        //các primitive datatype
        //Student(name - char - string , yob - int , gpa - float) 
        
        long money = 10_000_000_000L;
        //số nguyên lưu dc java hiểu là int
        int num1 = 0xFA; //0x; prefix: tiền tố
        //0x: hexa: hệ 16
        num1 = 076; //0: prefix của octal: hệ 8
        System.out.printf("%d\n", num1);
        System.out.println("num1 nè: " + num1); //ln: line new
        
        //Operator:
        //trong java có ít nhất 10 loại toán tử
        //Athrimetic: toán tử , toán hạng (+ , - , * , / , % , -- , ++)
        //-= += /= *= %=
        
        int a = 10;
        int b = a++ + ++a - --a - a--;
        System.out.println(b);
        
        //comparision: toán tử so sánh
        //> < >= <= == !=
        
        //logical: toán tử logic
        //And (&&) OR(||)
        // & và | : toán tử ngu
        
        //&& tìm false : gặp false sẽ ngừng
        //||: tìm true : có true là ngừng
        
        //String
        //Unary: toán tử 1 ngôi
        //comma: phẩy
        
        //shift bit: toán tử dịch bit
        //>> <<
        
        int num2 = 8;
        num2 = num2 >> 2;
        System.out.println(num2);
        //n >> x : n / 2^x
        //n << x: n * 2^x
        
        //bitwise: toán tử bit (| & ^ ~) 
        //| : tìm 1
        //& : nếu có 2 số 1 thì 1 , còn lại thì 0 hết , tìm 0
        //^ : giống nhau là 0 , khác là 1
        //~ : phủ định
    }
}