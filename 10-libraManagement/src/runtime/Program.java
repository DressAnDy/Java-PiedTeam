package runtime;

import data.Author;
import data.Book;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ArrayList<Author> auList = new ArrayList<>();
        ArrayList<Book> boList = new ArrayList<>();
        initData(auList,boList);
        int choice;
        Scanner sc = new Scanner(System.in);
        
        do{
            showMenu();
            System.out.println("Vui lòng nhập lựa chọn: ");
            choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:{
                    System.out.println("Thêm 1 cuốn sách");
                    Book newBook = new Book();
                    newBook.inputInfor(); //bookName , createAt , nickname
                    //kiểm tra xem tác giả của cuốn sách này đã lưu chưa
                    boolean isFind = false;
                    for (Author author : auList) {
                        if(author.getNickName().equals(newBook.getNickname())){
                            isFind = true;
                        }
                    }
                    //nếu chưa lưu thì tạo mới trên cái nick name đó lun
                    if(!isFind){
                        Author newAuthor = new Author(newBook.getNickname());
                        newAuthor.inputInfor(); //nhập name , yob
                        auList.add(newAuthor);
                    }
                    boList.add(newBook);
                    break;
                }
                case 2:{
                    System.out.println("In ra danh sách các cuốn sách");
                    boolean isFind = false;
                    for (Book book : boList) {
                        book.showInfor();
                        isFind = true;
                    }
                    if(!isFind) System.out.println("Éo có cuốn nào cả");
                    break;
                }
                case 3:{
                    System.out.println("Thêm mới 1 tác giả");
                    Author newAuthor = new Author();
                    newAuthor.inputInfor(auList); // nickname cấm trùng , name , yob
                    auList.add(newAuthor);
                    break;
                }
                case 4:{
                    System.out.println("Tìm sách theo bút danh(nickname)");
                    System.out.println("Nhập bút danh của tác giả cần tìm sách: ");
                    String keyId = sc.nextLine(); //nick name cần tìm
                    //duyệt danh sách các cuốn sách
                    boolean isFind = false;
                    for (Book book : boList) {
                        if(book.getNickname().equals(keyId));
                        book.showInfor();
                        isFind = true;
                    }
                    if(!isFind) System.out.println("Éo có tìm dc cuốn nào");
                    break;
                }
                case 5:{
                    System.out.println("Hẹn gặp lại");
                    break;
                }
                default:{
                    System.out.println("Phải nhập từ 1 đến 5");
                    break;
                }
            }
        }while(choice != 5);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    //hàm nạp sẵn giá trị cho auList và boList
    public static void initData(ArrayList<Author> auList,
                                ArrayList<Book> boList){ //nạp data
        //nạp giá trị cho auList
        auList.add(new Author("Ngô Kiến Huy", "Huy Quần Hoa", 1999));
        auList.add(new Author("Nguyen Thuy Chi", "ChiPu", 1994));
        auList.add(new Author("Le Muoi Diep", "UncleTen", 1999));
        
        //thêm mấy cuốn sách vào
        boList.add(new Book("Mãi mãi là hết tiền", "16-4-2024", "Huy Quần Hoa"));
        boList.add(new Book("Đừng làm mọi thứ phức tạp", "16-4-2024", "ChiPu"));
        boList.add(new Book("Dạy người giàu giả nghèo", "16-4-2024", "UncleTen"));
    }
    
    public static void showMenu(){
        System.out.println("========Menu========");
        System.out.println("1.Nhập thông tin sách in ra màn hình");
        System.out.println("2.Hiển thị thông tin sách ra màn hình");
        System.out.println("3.Nhập thông tin tác giả");
        System.out.println("4.Tìm kiếm sách theo bút danh");
        System.out.println("5.Thoát");
    }
}

/*
tạo chương trình quản lý thư viện
gồm 2 class sau
Author
    name nickname old birthday;
    tạo phểu hàm không đối số
    tạo phểu có đối số 
    tạo phểu có đối số là nickname
    tạo getter không tạo setter
    tạo hàm nhập thông tin tác giả
    nhưng nếu tác giả đã tồn tại trong danh sách thì k cho
    ép nhập lại
    tạo hàm showInfor
Book
    bookName createAt nickName
    tạo có đối số và k có đồi số
    tạo getter anh setter
    tạo hàm input//nếu mà sách này có tác giả mà 
    có tên trong danh sách tác giả thì bỏ qua
    nếu tác giả của cuốn sách mà chưa có tồn tại trong ds
    thì thêm mới
program:
    menu
    1.Nhập thông tin sách in ra màn hình
    2.Hiển thị thông tin sách ra màn hình
    3.Nhập thông tin tác giả
    4.Tìm kiếm sách theo bút danh
    5.Thoát
*/


