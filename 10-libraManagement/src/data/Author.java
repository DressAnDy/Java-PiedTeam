
package data;

import java.util.ArrayList;
import java.util.Scanner;

public class Author {
    private String name;
    private String nickname;
    private int yob;
    //constructor
    
    //phễu rỗng
    public Author(){
    
    }
    
    //phễu đầy đủ
    public Author(String name, String nickName, int yob) {
        this.name = name;
        this.nickname = nickName;
        this.yob = yob;
    }
    //phễu chỉ có nick name
    public Author(String nickname) {
        this.nickname = nickname;
    }
    
    //getter

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickname;
    }

    public int getYob() {
        return yob;
    }
    
    //hàm inputInfor() k nhận gì cả chỉ nhập name và yob 
    public void inputInfor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên tác giả: ");
        this.name = sc.nextLine();
        
        System.out.println("Nhập tuổi tác giả đi");
        this.yob = Integer.parseInt(sc.nextLine());
    }
    
    //Overload: inputInfor(auList) : hàm nhập nhưng nhận vào thêm vào danh sách
    //tác giả để cho việc kiểm tra nickname có ai dùng chưa , hàm nhập nickname
    //name , yob
    public void inputInfor(ArrayList<Author> auList){ //hàm dùng nhập 3 thông tin
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập bút danh tác giả (nickname) nha: ");
        while(true){
            String inputNickName = sc.nextLine(); //nhập nick name mún thêm
            boolean isDupe = false;
            //dùng biến giả định
            for (Author author : auList) {
                if(author.getNickName().equals(inputNickName)) isDupe = true;
                //dùng để kiểm tra
            }
            if(!isDupe){
                this.nickname = inputNickName;
                break;
            }
        }
        this.inputInfor(); //nhập tiếp name và yob bth
    }
    public void showInfor(){
        System.out.printf("%-30s|%-30s|%4d\n",name , nickname , yob);
    }
    
}

/*
Author
    name nickname yob;
    tạo phểu hàm không đối số
    tạo phểu có đối số 
    tạo phểu có đối số là nickname
    tạo getter không tạo setter
    tạo hàm nhập thông tin tác giả 
    nhưng nếu tác giả đã tồn tại trong danh sách thì k cho
    ép nhập lại
    tạo hàm showInfor
*/