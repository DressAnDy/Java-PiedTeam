/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runtime;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Program {
    public static void main(String[] args) {
        //I - REGEX
        //Regex | regular experssion | Pattern | biểu thức chính quy
        String str = "SE1234567";
        
        checkString("SE1234567", "^[Ss][Ee]\\d{7}");
        
        //học viết
        //1.regex kiểm tra có pb hoa thường
        checkString("nAme", "name"); //false
        //2. có thể bật chế bộ ko quan tâm hoa thường
        checkString("nAme", "(?i)name"); //true
        //3. 1 ký tự bất kì thì minh có dấu .
        checkString("mey", "m.y");
        //mey|may|m,y|m.y|m~y|m8y true
        //my |maay| false
        //4. lập lại ký tự trước đó , từ không đến nhiều lần: "*"
        checkString("my", "m*y");
        //y|my|mmy|mmmmmmmmy : true
        //m|mey|myy : false
        
        //5.group: ()
        checkString("mery", "m(er)*y");
        //mererererery| my | mery :true
        //mey | mry | mmy | myy :false

        //6. phần tử bất kì trong set [...]
        //m[aer]y : may | mry | mey : true
        // còn lại false hết
        //m[^aer]y : may | mry | mey : false
        // còn lại true hết
        
        //7.tập hợp chữ
        //[a - z]:  1 kí tự từ a - z
        //[A-Za-z]: lấy từ đoán a - z ko quan tâm tới viết thường hay hoa
        
        //8 tập hợp số
        //[0-9]: 1 kí tự từ 0 - 9
        
        //9. giới hạn ký tự: {}
        //{3}: lập lại 3 lần
        //{2}: lập lại từ 2 đến trở lên
        //{2,4}: lập lại từ 2 đến 4 lần
        //{0 , } : *
        //{1, }: +
        //{0,1}: ?
        
        //10. hoặc | kết hợp với ()
        
        //11. Shorthand: viết tắt
            //1 \w: [a-zA-z0-9] \W ( phủ định)
            //2 \d: [0-9]       \D (phủ định)
            //3 \s: space       \S (phủ định)
        //Try hard
            // Regex về tiền tệ: 100 000 000
            // Regex về email
            // Regex về mã số sinh viên
            // Regex tìm khoản cách thừa
        //^([A-Z][a-z]*)( [A-Z][a-z]*)*$
        //------------------------------
        //Try catch
        //error compilation: lỗi trong quá trình biên dịch code 
        //error runtime: lỗi trong quá trình người dùng sử dụng
        //Scanner: đảm nhiệm trách nhiệm cho các hàm nhập giá trị 
        Scanner sc = new Scanner(System.in);
        int age;
        try{
            System.out.println("Nhập tuổi đi: ");
            age = sc.nextInt();
            if(age < 10 || age > 30){
                throw new Exception();
            }
        }catch(Exception e){
            System.out.println("Ngu");
        }
        System.out.println("Ahihi làm tốt lắm");
        
    }
    
    public static void checkString(String str , String regex){
        System.out.println(str.matches(regex));
    }
    
}
