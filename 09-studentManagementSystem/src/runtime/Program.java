//menu
/*
  Quản lý danh sách sinh viên
  menu bao gồm các chức năng cơ bản:
    1. nhập vào 1 sinh viên
    2. hiển thị thông tin sinh viên
    3. hiển thị max min theo điểm trung bình
    4. tìm kiếm theo mã sinh viên
    5. sắp xếp sinh viên theo tên acs và hiện thị
    6. in ra sinh viên có học bổng và hiển thị desc
    7. thoát

  Trong chương trình này tôi muốn có
  Person class
     bao gồm name , gender , yob
     có phễu có đối số, và ko có đối số
     có getter và k dc có setter
     method showInfor
     method nhập thông tin người dùng

  Student class
     sử dụng kế thừa để có name , gender , yob của person
     riêng student thì muốn có thêm id , gpa , email
     phễu có đối số và ko có đối số
     getter và ko có setter
     showInfor

*/
package runtime;

import data.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        //muốn quản lý sinh viên thì luôn cần mảng chứa sinh viên
        //mảng arrayList là mảng đặc biệt , có khả năng co giãn
        ArrayList<Student> studentList = new ArrayList<>(); //<> bổ nghĩa
        
        int choice;
        Scanner sc = new Scanner(System.in);
        do{
            showMenu();
            System.out.println("Vui lòng nhập lựa chọn: ");
            choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:{
                    System.out.println("Thêm sinh viên");
                    Student newStudent = new Student(); //tạo sinh viên mới
                    newStudent.inputInfor(); //xin thông tin
                    studentList.add(newStudent); //nhét sinh viên mới vào ds
                    break;
                }
                case 2:{
                    System.out.println("Hiển thị danh sách sinh viên");
                    if(studentList.isEmpty()){
                        System.out.println("Không có sinh viên");
                        break;
                    }
                    //nếu có thì in
                    for (Student student : studentList) {
                        student.showInfor();
                    }
                    break;
                }
                case 3:{
                    System.out.println("Tìm sinh viên Giỏi và Gà nhất");
                    float maxPoint = studentList.get(0).getGpa();
                    float minPoint = studentList.get(0).getGpa();
                    
                    //tìm điểm bé nhất và điểm lớn nhất
                    for (Student student : studentList) {
                        if(student.getGpa() > maxPoint) maxPoint = student.getGpa();
                        if(student.getGpa() < minPoint) minPoint = student.getGpa();
                    }
                    
                    //tìm trong danh sách và in ra những thằng có điểm = max
                    System.out.println("Những thằng giỏi nhất nè");
                    for (Student student : studentList) {
                        if(student.getGpa() == maxPoint) student.showInfor();
                    }
                    
                    System.out.println("Những thằng gà nhất nè");
                    for (Student student : studentList) {
                        if(student.getGpa() == minPoint) student.showInfor();
                    } 
                    break;
                }
                case 4:{
                    System.out.println("Tìm kiếm theo mã sinh viên");
                    System.out.println("Nhập mã sinh viên cần tìm nhé");
                    String keyId = sc.nextLine();
                    
                    boolean isFind = false;
                    for (Student student : studentList) {
                        if(student.getId().equals(keyId)){
                            student.showInfor();
                            isFind = true;
                        }
                    }
                    if(!isFind){
                        System.out.println("Không có sinh viên cần tìm");
                    }
                    break;
                }
                case 5:{
                    System.out.println("Sắp xếp theo tên");
                    //studentList là 1 cái mảng rất xịn của java
                    //mảng này đi kèm một bộ công cụ giúp thao tác với chiếc 
                    //mảng: Collections
                    Collections.sort(studentList, new Comparator<Student>() {
                        @Override
                        public int compare(Student t1, Student t2) {
                            if(t1.getName().compareTo(t2.getName()) > 0){
                                return 1; //swap
                            }else{
                                return -1;
                            }
                            //return t1.getName().compareTo(t2.getName());
                        }
                    });
                    //hiển thị
                    for (Student student : studentList) {
                        student.showInfor();
                    }
                    break;
                }
                case 6:{
                    System.out.println("Những thằng có học bổng desc");
                    Collections.sort(studentList , new Comparator<Student>() {
                        @Override
                        public int compare(Student t1, Student t2) {
                            if(t1.getGpa() > t2.getGpa()){
                                return 1;
                            }else{
                                return -1;
                            }
                        }
                    });
                    
                    Collections.reverse(studentList);
                    //hiển thị sinh viên nào có điểm > 8 là xong
                    for (Student student : studentList) {
                        if(student.isScholarship()) student.showInfor();
                    }
                    break;
                }
                case 7:{
                    System.out.println("Exit");
                    break;
                }
                default:{
                    System.err.println("Nhập từ 1 đến 7 nhé");
                    break;
                }
            }
        }while(choice != 7);
    }
    public static void showMenu(){
            System.out.println("Student Management Application");
            System.out.println("1. nhập vào 1 sinh viên");
            System.out.println("2. hiển thị thông tin sinh viên");
            System.out.println("3. hiển thị max min theo điểm trung bình");
            System.out.println("4. tìm kiếm theo mã sinh viên");
            System.out.println("5. sắp xếp sinh viên theo tên acs và hiện thị");  
            System.out.println("6. in ra sinh viên có học bổng và hiển thị desc");
            System.out.println("7. thoát");
        }
    }
