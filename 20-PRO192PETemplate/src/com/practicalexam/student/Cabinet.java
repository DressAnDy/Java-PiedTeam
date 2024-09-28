package com.practicalexam.student;

import com.practicalexam.student.data.Student;
import utils.Inputter;

/**
 *
 * @author FPT University - HCMC
 * Java OOP Practical Exam Template
 */




public class Cabinet {

    //StartList - do not remove this comment!!!
	int count = 0;
	Student ds[] = new Student[10];
    

    // Declare ArrayList or Array here
    
    //EndList - do not remove this comment!!!
    
    public void add() {
        // Print the object details after adding
    	//thu thập
        boolean isDup;
        String id;
        do{
            isDup = false; //reset niềm tin , chưa trùng
            id = Inputter.getString("Nhap ma sinh vien: ", "Ma sinh vien cam de trong");
            isDup = checkDuplicatedId(id); //kiểm tra có trùng ko
            if(isDup){
                System.err.println("Ma sinh vien bi trung roi");
            }
        }while(isDup);
    	String name = Inputter.getString("Nhap ten sinh vien", "Ten sinh vien cam de trong");
        int point = Inputter.getAnInteger("Nhap diem so cua sinh vien", "Diem so phai tu 0 den 10", 0 , 10);
        
        //tạo
        Student nStudent = new Student(id, name, point);
        //nhét
        ds[count] = nStudent;
        
        count++;
    	System.out.println("Danh sach sinh vien");
    	for(int i = 0 ; i <= count - 1 ; i++){
            ds[i].Show();
        }
    }

    public boolean checkDuplicatedId(String id) {
        // Your code here
        for(int i = 0 ; i <= count - 1 ; i++){
            if(ds[i].getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    public void update() {
        // Print the object details after updating name/model and price
        String keyId = Inputter.getString("Nhap ma sinh vien can cap nhat", "Ma sinh vien ko duoc de trong");
        //tìm pos
        int pos = -1;
        for(int i = 0 ; i <= count - 1; i++){
            if(ds[i].getId().equals(keyId)){
                pos = i;
            }
        }
        if(pos == -1){
            System.err.println("Khong co sinh vien can tim");
        }else{
            System.out.println("Thong tin sinh vien truoc khi cap nhat");
            ds[pos].Show();
            System.err.println("Dang cap nhat");
            String name = Inputter.getString("Nhap ten moi", "Ten ko duoc de trong");
            int point = Inputter.getAnInteger("Nhap diem moi", "Diem khong duoc de trong", 0 , 10);
        //set
            ds[pos].setName(name);
            ds[pos].setPoint(point);
            
            //thông báo kết quả
            System.err.println("Cap nhat sinh vien thanh cong");
        System.out.println("Danh sach sinh vien");
            for(int i = 0 ; i <= count - 1 ; i++){
                ds[i].Show();
            }
        }
    }

    public void search() {
        // Print the object details after searching
        String keyId = Inputter.getString("Nhap ma sinh vien can cap nhat", "Ma sinh vien ko duoc de trong");
        //tìm pos
        int pos = -1;
        for(int i = 0 ; i <= count - 1; i++){
            if(ds[i].getId().equals(keyId)){
                pos = i;
            }
        }
        if(pos == -1){
            System.err.println("Khong co sinh vien can tim");
        }else{
            //thông báo kết quả
            System.out.println("Thong tin sinh vien");
            ds[pos].Show();
        }
    }
    public void remove() {
        // Print the list after removing
        String keyId = Inputter.getString("Nhap ma sinh vien can xoa", "Ma sinh vien ko duoc de trong");
        //tìm pos
        int pos = -1;
        for(int i = 0 ; i <= count - 1; i++){
            if(ds[i].getId().equals(keyId)){
                pos = i;
            }
        }
        
        if(pos == - 1){
            System.out.println("Khong co sinh vien de xoa");
        }else
            for(int i = pos ; i <= count - 1 ; i++){
                ds[i] = ds[i + 1];
            }
            count--;
            System.out.println("Xoa sinh vien thanh cong");
            
                    //in ra
            System.out.println("Danh sach sinh vien");
            for(int i = 0 ; i <= count - 1 ; i++){
            ds[i].Show();
        }
    }
    public void sort() {
        // Print the object details after sorting
    	for(int i = 0 ; i <= count - 2 ; i++){
            for(int j = i + 1 ; j <= count - 1 ; j++){
                if(ds[i].getPoint() > ds[j].getPoint()){
                    //swap
                    Student tmp = ds[i];
                    ds[i] = ds[j];
                    ds[j] = tmp;
                }
            }
        }
        //in ra
        System.out.println("Danh sach sinh vien");
    	for(int i = 0 ; i <= count - 1 ; i++){
            ds[i].Show();
        }
    }
    
}
