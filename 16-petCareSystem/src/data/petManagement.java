
package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;
import utils.Inputter;

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
        + nhận vào id tìm vị trí 
        + nhận vào id tìm pet ( tìm cái id đó , tìm vị trí đó r lấy ra đưa ng dùng
            ( ko có gì thì trả ra null )
        +   xin id và thông báo tình trạng
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
        petList.add(new Dog("D003", "Nhật", "Đen", 3.2, "Test"));
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
    
    //method sortPetListByWeight: hàm sắp xếp thú cưng theo trọng lượng
    //tạo ra anh trọng tài
    public void sortPetListByWeight(){
        Comparator orderByWeight = new Comparator<Pet>() {
            @Override
            public int compare(Pet t1, Pet t2) {
                return t1.getWeight() > t2.getWeight() ? 1 : -1;
            }
        };
        //2. sau khi có anh trọng tài thì mình nạo vài danh sách thông qua
        Collections.sort(petList , orderByWeight);
        
     }
    //nhập vào id tìm vị trí
    public int searhPetIndexById(String keyId){
        for(int i = 0 ; i <= petList.size() - 1 ; i++){
            if(petList.get(i).getId().equals(keyId)){
                return i;
            }
        }
        return -1;
    }
    public Pet searchPetById(String keyId){
        //1. tìm vị trí]
        int pos = searhPetIndexById(keyId); //tìm vị trí
        return pos == -1 ? null : petList.get(pos);
        //nếu pos == -1 thì null
    }
    
    public void searchPetById(){
        //xin ketId cần tìm 
       String keyId = Inputter.getString("Input petId you wanna find", 
                                         "That field is required!!!");
       
        Pet pet = searchPetById(keyId);
        if(pet == null){
            System.out.println("The pet not exist");
        }else{
            System.out.println("The pet information");
            pet.showInfor();      
        }
    }
    
    //update thú cưng theo id
    //hàm removePetById(): hàm xin id tìm pet và xóa
    public void removePetById(){
        //xin ketId cần tìm 
       String keyId = Inputter.getString("Input petId you wanna remove", 
                                         "That field is required!!!");
       //đựa vào keyId tìm con pet
        Pet pet = searchPetById(keyId);
        if(pet == null){
            System.out.println("The pet not exist");
        }else{
            System.out.println("The pet information");
            pet.showInfor();
            petList.remove(pet);
            System.err.println("Removing is successful");
        }
    }
    
    //hàm updatePetById()
    public void updatePetById(){
        //xin ketId cần tìm 
       String keyId = Inputter.getString("Input petId you wanna update", 
                                         "That field is required!!!");
       //đựa vào keyId tìm con pet
        Pet pet = searchPetById(keyId);
        if(pet == null){
            System.out.println("The pet not exist");
        }else{
            System.out.println("The pet information before updating");
            pet.showInfor();
            //cần cập nhật owner , color , weight ,
            //dog thì có necklace
            //mèo thì có rebbon
            System.err.println("Updating....");
            String newOwner = Inputter.getString("Input onwer: ",
                                                "that field is required");
            String newColor = Inputter.getString("Input color: ",
                                                "that field is required");
            double newWeight = Inputter.getADouble("Input weight", "weight must between 1 and 100",
                                                    1 , 100);
            
            pet.setOwner(newOwner);
            pet.setColor(newColor);
            pet.setWeight(newWeight);
           //không thể dùng pet.set... vì chưa có làm trong object pet ( hàm dùng để
           //tùy chỉnh thuộc tính con pet
           
           if(pet instanceof Dog){
               String newNecklace = Inputter.getString("Input necklace", 
                                                       "that field is requierd");
               ((Dog)pet).setNecklace(newNecklace);
           }else{
               String newRibbon = Inputter.getString("Input ribbon", 
                                                    "that field is requierd");
               ((Cat)pet).setRibbon(newRibbon);
           }
            System.out.println("Updating is successful");
        }
    }
    
    //Hàm thêm con Dog or Cat
    //method addNewDog(): thêm một con chó
    public void addNewDog(){
        //thu thập thông tin để đúc con chó
        boolean isDup;
        String id;
        do{
            isDup = false; //ban đầu tin là ko trùng
            id = Inputter.getString("Input your Dog's id: ", 
                                    "Your Id isn't matched DXXX!!!",
                                    "[dD]\\d{3}").toUpperCase();
            Pet pet = searchPetById(id);
            if(pet != null){
                isDup = true;
                System.err.println("Id has been used");
                
            }
        }while(isDup);
        //nhập thông tin còn lại
        String owner = Inputter.getString("Input onwer: ",
                                                "that field is required");
        String color = Inputter.getString("Input color: ",
                                                "that field is required");
        double weight = Inputter.getADouble("Input weight", "weight must between 1 and 100",
                                                    1 , 100);
        String necklace = Inputter.getString("Input necklace", 
                                                "that field is requierd");
        
        //tạo
        Dog nDog = new Dog(id, owner, color, weight, necklace);
        petList.add(nDog);
        System.out.println("Adding is successful");
    }
    //thu thập thông tin đúc con mèo
    public void addNewCat(){
        //thu thập thông tin để đúc con mèo
        boolean isDup;
        String id;
        do{
            isDup = false; //ban đầu tin là ko trùng
            id = Inputter.getString("Input your Cat's id: ", 
                                    "Your Id isn't matched CXXX!!!",
                                    "[cC]\\d{3}").toUpperCase();
            Pet pet = searchPetById(id);
            if(pet != null){
                isDup = true;
                System.err.println("Id has been used");
                
            }
        }while(isDup);
        //nhập thông tin còn lại
        String owner = Inputter.getString("Input onwer: ",
                                                "that field is required");
        String color = Inputter.getString("Input color: ",
                                                "that field is required");
        double weight = Inputter.getADouble("Input weight", "weight must between 1 and 100",
                                                    1 , 100);
        String ribbon = Inputter.getString("Input ribbon", 
                                                "that field is requierd");
        
        //tạo
        Cat nCat = new Cat(id, owner, color, weight, ribbon);
        petList.add(nCat);
        System.out.println("Adding is successful");
    }
    
    //method đọc file
    //method nhận vào url và đọc file từ url và nạp giá trị vào danh sách
    public boolean loadFromFile(String url){
        petList.clear();
        //xóa hết trước khi nạp giá trị (option)
        File f = new File(url); //từ url tạo object xứ lý file
        try {
            //xử lý
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = reader.readLine(); //ra lệnh nó đọc 1 dòng và lưu lại
            while(line != null){ //còn dòng thì còn làm
                //xử lý dòng
                StringTokenizer st = new StringTokenizer(line, "|");
                String id = st.nextToken().trim();
                String owner = st.nextToken().trim();
                String color = st.nextToken().trim();
                double weight = Double.parseDouble(st.nextToken().trim());
                String special = st.nextToken().trim(); 
                Pet pet;
                if(id.matches("[dD]\\d{3}")){
                    pet = new Dog(id, owner, color, weight, special);
                }else{
                    pet = new Cat(id, owner, color, weight, special);
                }
                petList.add(pet);
                line = reader.readLine();
            }
            //return true báo đọc thành công
            return true;
        }catch(Exception e){
            System.err.println("File lỗi rồi: " + e);
            return false;
        }
    }
    //method lưu file
    public boolean saveToFile(String url){
        File f = new File(url);
        try {
            OutputStreamWriter writter = new OutputStreamWriter(new FileOutputStream(f));
            for (Pet pet : petList) {
                writter.write(pet.toString());
                writter.write("\n");
            }
            writter.flush(); //save xong moi dc dừng
            return true;
        } catch (Exception e) {
            System.out.println("Lỗi đọc file " + e);
            return false; 
        }
    }
}
