
package runtime;

import data.Pet;
import data.petManagement;
import java.util.Scanner;
import ui.Menu;
import utils.Inputter;

/*
Viết 1 chương trình quản lý thú cưng (DOG | CAT)
    1. Thêm mới 1 con cún
    2. Thêm mới 1 con mèo
    3. in ra danh sách thú cưng 
    4. tìm kiếm thú cưng theo tên
    5. update thú cưng theo id
    6. remove thú cưng theo id
    7. sắp xếp thú cưng theo trọng lượng
    8. save file and quit

    khi thêm mới id của pet k được trùng với id ở trong danh sách
    id của pet phải thỏa theo format "D001| C001"
    một con Pet có nhửng thuộc tính owner , color, weight
    
    Dog: necklace
    Cat: ribbon

    yêu cầu chung: nhập chuẩn | nhập bậy bạ là chữi
*/
public class Program {

    public static void main(String[] args) {
        petManagement pm = new petManagement();
        pm.initData();
        Menu menu = new Menu("Pet Care System Menu");
        menu.addNewOption("Add new Dog");
        menu.addNewOption("Add new Cat");
        menu.addNewOption("Print Pet List");
        menu.addNewOption("Search Pet By Id");
        menu.addNewOption("Update Pet By Id");
        menu.addNewOption("Remove Pet By Id");
        menu.addNewOption("Sort Pet Order By Weight");
        menu.addNewOption("Save file and Quit");
        
        int choice;
        while(true){
            menu.print();
            choice = menu.getChoice();
            switch(choice){
                case 1:{
                   pm.addNewDog();
                   break;
                }
                case 2:{
                    pm.addNewCat();
                    break;
                }
                case 3:{
                    pm.showPetList();
                    break;
                }
                case 4:{
                    pm.searchPetById();
                    break;
                }
                case 5:{
                    pm.updatePetById();
                    break;
                }
                case 6:{
                    pm.removePetById();
                    break;
                }
                case 7:{
                    pm.sortPetListByWeight();
                    break;
                }
                case 8:{
                    System.out.println("See you again");
                    return;
                }
            }
        }
    }
}
