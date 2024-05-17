
package data;

import java.util.Scanner;

public class Book {
    private String bookName;
    private String createAt;
    private String nickname;
    
    
    public Book(){
        
    }
    
    public Book(String bookName, String createAt, String nickname) {
        this.bookName = bookName;
        this.createAt = createAt;
        this.nickname = nickname;
    }

    public String getBookName() {
        return bookName;
    }

    public String getCreateAt() {
        return createAt;
    }

    public String getNickname() {
        return nickname;
    }
     
   //hàm nhập đẩy đủ thông tin
    public void inputInfor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên sách: ");
        this.bookName = sc.nextLine();
        
        System.out.println("Nhập ngày tạo đi: ");
        this.createAt = sc.nextLine();
        
        System.out.println("Tác giả của cuốn sách");
        this.nickname = sc.nextLine();
    }
    
    //hàm in thông tin
    public void showInfor(){
        System.out.printf("%-40s|%-15s|%s\n", bookName , createAt , nickname);
    }
}
/*
Book
    bookName createAt nickName
    tạo có đối số và k có đồi số
    tạo getter anh setter
    tạo hàm input//nếu mà sách này có tác giả mà 
    có tên trong danh sách tác giả thì bỏ qua
    nếu tác giả của cuốn sách mà chưa có tồn tại trong ds
    thì thêm mới
*/