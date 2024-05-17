/*
  Person class
     bao gồm name , gender , yob
     có phễu có đối số, và ko có đối số
     có getter và k dc có setter
     method showInfor
     method nhập thông tin người dùng
*/
package data;

import java.util.Scanner;

public class Person {
    //props
    private String name;
    private String gender;
    private int yob;
    
    //constructor - có đủ thông tin ( có đối số)
    public Person(String name, String gender, int yob) {
        this.name = name;
        this.gender = gender;
        this.yob = yob;
    }
    //constructor rỗng ( không có đối số)
    public Person(){
        
    }

    //getter
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getYob() {
        return yob;
    }
    
    
    //hàm giúp bổ sung thông tin ( thu thập thông tin từ người dùng)
    public void inputInfor(){ //hàm nhập full thông tin người dùng
        Scanner sc = new Scanner(System.in); //máy nhập
        
        System.out.println("Nhập tên đi: ");
        this.name = sc.nextLine(); //nhập chuỗi
        
        System.out.println("Nhập gender đi: ");
        this.gender = sc.nextLine();
        
        System.out.println("Nhập năm sinh: ");
        this.yob = sc.nextInt(); //nhập số
    }
    
    public void showInfor(){
        String str = String.format("|%s|%s|%d", name , gender , yob);
        System.out.printf(str);
    }
}
