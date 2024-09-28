
package utils;

import java.util.Scanner;

/*
Inputter: là một cái khuôn nhưng anh không dùng để đúc ra object
Mà dùng class này để lưu những hàm hỗ trợ cho việc nhập
*/
public class Inputter {
    //phải để nó ở dạng static để tránh phân nhánh , cũng như dễ truy cập hơn
    //khi sử dụng. Tránh lặp đi nhìu phiên bản
    //props
    public static Scanner sc = new Scanner(System.in);
    //methods hỗ trợ cho việc nhập
    //method ép người dùng nhập số nguyên chuẩn
    public static int getAnInteger(String inpMsg , String errMsg){
        System.out.println(inpMsg);//hiện thị câu mời nhập
        while(true){
            try{
                int number = Integer.parseInt(sc.nextLine());
                return number;
            }catch(Exception e){
                System.err.println(errMsg); //hiện thị câu chửi
            }
        }
    }
    //Overload
    //method ép nhập số nguyên chuẩn nhưng phải nằm ở khoảng yêu cầu
        public static int getAnInteger(String inpMsg , String errMsg,
                                        int lowerBound , int upperBound){
        if(lowerBound > upperBound){ //swap nếu người dùng bị khờ
            int tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;               
        }
             
        System.out.println(inpMsg);//hiện thị câu mời nhập
        while(true){
            try{
                int number = Integer.parseInt(sc.nextLine());
                if(number < lowerBound || number > upperBound){
                    throw new Exception();
                }
                return number;
            }catch(Exception e){
                System.err.println(errMsg); //hiện thị câu chửi
            }
        }
    }
    
    //ép người dùng nhập số thực
         public static double getADouble(String inpMsg , String errMsg){
        System.out.println(inpMsg);//hiện thị câu mời nhập
        while(true){
            try{
                double number = Double.parseDouble(sc.nextLine());
                return number;
            }catch(Exception e){
                System.err.println(errMsg); //hiện thị câu chửi
            }
        }
    }
         
    //Overload
    //method ép nhập số thực chuẩn nhưng phải nằm ở khoảng yêu cầu
        public static double getADouble(String inpMsg , String errMsg,
                                        double lowerBound , double upperBound){
        if(lowerBound > upperBound){ //swap nếu người dùng bị khờ
            double tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;               
        }
             
        System.out.println(inpMsg);//hiện thị câu mời nhập
        while(true){
            try{
                double number = Double.parseDouble(sc.nextLine());
                if(number < lowerBound || number > upperBound){
                    throw new Exception();
                }
                return number;
            }catch(Exception e){
                System.err.println(errMsg); //hiện thị câu chửi
            }
        }
    }
    //Nhập chuỗi ko được để trống
     public static String getString(String inpMsg , String errMsg){
         System.out.println(inpMsg);
         while(true){
             try{
                 String str = sc.nextLine();
                 if(str.isEmpty()){
                     throw new Exception();
                 }
                 return str;
             }catch(Exception e){
                 System.err.println(errMsg);
             }
         }
     }
     
    //Nhập chuỗi ko được để trống và phải đúng format (regex)
     public static String getString(String inpMsg , String errMsg ,
                                    String regex){
         System.out.println(inpMsg);
         while(true){
             try{
                 String str = sc.nextLine();
                 if(str.isEmpty() || !str.matches(regex)){
                     throw new Exception();
                 }
                 return str;
             }catch(Exception e){
                 System.err.println(errMsg);
             }
         }
     }
     
     //hàm nhập ngày tháng năm theo format
}
