
package data;

import java.util.ArrayList;

/*
PetManagement
hỗ trợ lưu dững danh sách
là 1 cái khuôn dùng để đút ra 1 anh quản lý danh sách các thú cưng
vậy thì anh này phải sở hữu một danh sách các con thú: (petList)
và kèm theo đó là các hàm xử lý danh sách đó: thêm , xóa tìm , update , in
    1. Thêm mới 1 con cún
    2. Thêm mới 1 con mèo
    3. in ra danh sách thú cưng 
    4. tìm kiếm thú cưng theo tên
    5. update thú cưng theo id
    6. remove thú cưng theo id
    7. sắp xếp thú cưng theo trọng lượng
    8. save file and quit

*/
public class petManagement {
    //petManagement là anh quản lý phải sở hưu danh sách thú cưng trc
    ArrayList<Pet> petList = new ArrayList<>();
    //petManagement sẽ sở hữu rất nhìu method giúp xử lý petList
    //method initData: hàm giúp nhét 1 vài thú cưng vào petList giúp test code
    public void initData(){
        //thêm 2 con chó và 2 con mèo
        petList.add(new Dog("D001", "Tuấn", "Red", 6.5, "I <3 U"));
        petList.add(new Dog("D002", "Toàn", "Ye Lầu", 2.6, "Yellow"));
        petList.add(new Cat("C001", "Tùng", "Nâu", 4.2, "Mỹ Diệu"));
        petList.add(new Cat("C002", "Thông", "Tím", 5.2, "Thông Tìm"));
    }
    
    //method showPetList: hàm giúp mình in ra danh sách các con thú cưng
    public void showPetList(){
        if(petList.isEmpty()){
            System.out.println("Nothing to print");
            return; //nếu không có gì trong danh sách thì in thông báo và kết thúc
        }
        //nếu có
        System.out.println("_____PETLIST_____");
        for (Pet item : petList) {
            item.showInfor();
        }
    }
}
