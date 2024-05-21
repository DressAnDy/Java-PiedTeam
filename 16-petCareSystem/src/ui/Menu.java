    
package ui;

import java.util.ArrayList;
import utils.Inputter;

/*
Menu là 1 cái khuôn chuyên tạo ra các anh quản lý menu
có: danh sách các lựa chọn "optionList"
có: tên của menu (title) 
có: những hàm thao tác với optionList
//thêm một option vào optionList
// hiển thị danh sách optionList
// hàm thu thập lựa chọn của người dùng
*/
public class Menu {
    public ArrayList<String> optionList = new ArrayList<>();
    public String title; //tên của menu

    public Menu(String title) {
        this.title = title;
    }
    
    //hàm addNewOption: thêm 1 chức năng cho danh sách options
    public void addNewOption(String newOption){
        optionList.add(newOption);
    }
    //hàm hiển thị danh sách options kèm số phía trước
    public void print(){
        int count = 1;
        System.out.println("___________ "+title+"___________");
        for (String op : optionList) {
            System.out.println(count + "." + op);
            count++;
        } 
    }
    //hàm getChoice: thu thập lựa chọn ng dùng
    public int getChoice(){
        int choice = Inputter.getAnInteger("Input your choice: ",
                                           "Your choice must between 1 and " + optionList.size());
        
        return choice;
    }
}
