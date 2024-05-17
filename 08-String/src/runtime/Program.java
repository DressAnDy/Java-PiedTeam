
package runtime;

import java.util.StringTokenizer;

public class Program {
    public static void main(String[] args) {
        //cho mình một class tên là String
        String lastName = new String("Điệp");
        String tmp = lastName; // tmp tham chiếu lastName
        String firstName = "Lê"; //String có phân vùng riêng để lưu (pool)
        
        //String là một object immutable: bất biến - mọi thao tác , mọi hành 
        //động tương tác với String sẽ không làm String biến dạng , thay đổi
        //mà chỉ tạo ra String mới
        lastName = lastName.concat(firstName);
        
        System.out.println("LastName nè: " + lastName);
        System.out.println("tmp nè : "  + tmp);
        
        //StringBuffer , StringBuilder
        //2 thằng này là chuỗi nhưng lại mutable
        //mutableL là object có thể chỉnh sửa
        
        StringBuilder lastName2 = new StringBuilder("Điệp");
        StringBuilder tmp2 = lastName2;
        StringBuilder firstName2 = new StringBuilder("Lê");
        
        lastName2.append(firstName2); //nối
        System.out.println("lastName2: " + lastName2); //ĐiệpLê
        System.out.println("tmp2: " + tmp);
        
        //StringTokenizer: làm split
        String information  = "SE123|Điệp Đẹp Trai|2004|9.9";
        StringTokenizer st = new StringTokenizer(information , "|");
        System.out.println(st.countTokens()); //đếm được chuỗi có bao nhiêu khúc
        System.out.println(st.hasMoreTokens()); //còn chặt dc k true | false
        
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
        
        System.out.println(st.countTokens());
        System.out.println(st.hasMoreTokens());
        System.out.println(information);
        
        checkStringMethod(); //Hàm 
        playWithStringComparision();
    }
    
    public static void checkStringMethod(){
        //khi dùng method với String thì phải để ý return
        //vì String là inmmutable nên method của nó thường return về
        //1 string kết quả
        String str1 = "Điệp";
        String str2 = "Đẹp Trai";
        //str1.concat(str2); //tạo ra 1 cái string khác //vô nghĩa
        str1 = str1.concat(str2);
        System.out.println("str1 nè " + str1);
        
        //tìm chuỗi trong chuỗi
        str1 = "Điệp đẹp trai";
        str2 = "đẹp";
        System.out.println(str1.indexOf(str2)); //5
        //tìm ký tự ở vị trí cho trước
        System.out.println(str1.charAt(9)); //t
        System.out.println(str1.contains(str2)); //true
    }
    public static void playWithStringComparision(){
        String s0 = new String("BÉ HỨA HỌC HANH CHĂM NGOAN");
        String s1 = "BÉ HỨA HỌC HÀNH CHĂM NGOAN"; //pool
        String s2 = "BÉ HỨA HỌC HÀNH CHĂM NGOAN"; //pool
        String s3 = "bé hứa học hành chăm ngoan"; //pool
        String s4 = new String("BÉ HỨA HỌC HANH CHĂM NGOAN");
        String s5 = new String("BÉ HỨA HỌC HANH CHĂM NGOAN");
        
        //nghiên cứu s0 == s1; F
        //nghiên cứu s1 == s2; T
        //nghiên cứu s2 == s3; F
        //nghiên cứu s3 == s4; F
        //nghiên cứu s4 == s5; F
    }
}
