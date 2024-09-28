
package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import ui.Menu;
import utils.Inputter;

/*
tư duy 1: BrandList: là anh quản lý danh sách các brand
tư duy 2: BrandList: là danh sách các brand 
*/
public class BrandList {
    //danh sách các brand
    ArrayList<Brand> brandList = new ArrayList<>();
    //những method để xử lý danh sách
    public boolean loadFromFile(String url){
        File f = new File(url);
        try {
            //xử lý file
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = reader.readLine();
            while(line != null){
                //xử lý dòng , nếu còn thì xử lý
                StringTokenizer st = new StringTokenizer(line , ",");
                String id = st.nextToken().trim();
                String name = st.nextToken().trim();
                String str = st.nextToken().trim();
                //stage 2
                st = new StringTokenizer(str , ":");
                String sound = st.nextToken().trim();
                double price = Double.parseDouble(st.nextToken().trim());
                //dùng các nguyên liệu thu được để tạo brand và lưu vào danh sách
                Brand nBrand = new Brand(id, name, sound, price);
                brandList.add(nBrand);
                line = reader.readLine(); //đọc dòng tiếp theo
            }
            
            //true nếu xong
            return true;
        } catch (Exception e) {
            System.err.println("File brand error: " + e);
            return false;
        }
    }
    
    //hàm in
    public void listBrand(){
        if(brandList.isEmpty()){
            System.err.println("Brand List Nothing To Print");
            return;
        }
        System.out.println("_____BrandList_____");
        for (Brand brand : brandList) {
            System.out.println(brand);
        }
    }
    
    //hàm tìm
    public int searchId(String keyId){
        for(int i = 0 ; i <= brandList.size() - 1 ; i++){
            if(brandList.get(i).getBrandId().equals(keyId)){
                return i;
            }
        }
        return -1;
    }
    //hàm thêm 1 brand
    public void addBrand(){
        //thu thập dữ liệu
        //id cấm trùng
        boolean isDup;
        String id;
        do{
            isDup = false;
            id = Inputter.getString("Input brand id: ", "That field is required!!!");
            //dùng id mà hò muốn tạo để tìm xem có brand nào trùng k
            int pos = searchId(id);
            //dc vị trí hoặc -1 nếu ko tìm dc 
            if(pos != -1){
                //tìm dc , bị trùng
                isDup = true;
                System.err.println("This brand id has been used");
            }
        }while(isDup);
        //name , sound , price
        String name = Inputter.getString("Input brand name", "That field is required!!!");
        String sound = Inputter.getString("Input sound name", "That field is required!!!");
        double price = Inputter.getADouble("Input price", "Price must to positive real number",
                                            1 , Math.pow(2,53) - 1);
        //lấy thông tin thu dc để tạo brand mới
        Brand nBrand = new Brand(id, name, sound, price);
        brandList.add(nBrand);
        System.out.println("Brand adding is successful");
        
        }
        //hàm update
    public void updateBrand(){
            //xin brand id của banrd muốn update
        String keyId = Inputter.getString("Input brand id you wanna update: ", 
                                            "That field is required!!!");
        int pos = searchId(keyId);
        Brand brand = pos == -1 ? null : brandList.get(pos);
        //nếu có thì update ko thì báo k có
        if(brand == null){
            System.out.println("Not Found");
        }else{
            System.out.println("Brand information before updating");
            System.out.println(brand);
            System.out.println("Updating...");
            //thu nhập thông tin mới cho name , sound , price
            
          
             //name , sound , price
            String name = Inputter.getString("Input new brand name", "That field is required!!!");
            String sound = Inputter.getString("Input new sound name", "That field is required!!!");
            double price = Inputter.getADouble("Input new price", "Price must to positive real number",
                                            1 , Math.pow(2,53) - 1);
            //set
            brand.setBrandId(name);
            brand.setSoundBrand(sound);
            brand.setPrice(price);
            System.out.println("Brand updating is successful");
        }
    }
    //Hiện thị danh sách BrandList có đánh số
    //gọi ref_getChoice để xin người dùng chọn và trả ra kết quả
    
    public Brand getUserChoice(){
        //hiển thị brandList như menu có số
        int count = 1;
        System.out.println("_____BrandList_____");
        for (Brand brand : brandList) {
            System.out.println(count + ". " + brand);
            count++;
        }
        Menu<Brand> brandMenu = new Menu("brandListMenu");
        return brandMenu.ref_getChoice(brandList);
        //thu thập lựa chọn và trả ra brand tương ứng
    }
    
    public void searchBrand(){
            //xin brand id của banrd muốn update
        String keyId = Inputter.getString("Input brand id you wanna find: ", 
                                            "That field is required!!!");
        int pos = searchId(keyId);
        Brand brand = pos == -1 ? null : brandList.get(pos);
        //nếu có thì update ko thì báo k có
        if(brand == null){
            System.out.println("Not Found");
        }else{
            System.out.println("Brand information");
            System.out.println(brand);
        }
    }
    
    public boolean saveToFile(String url){
        File f = new File(url);
        try{
            //xử lý file
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(f));
            for (Brand brand : brandList) {
                writer.write(brand.toString());
                writer.write("\n");
                
            }
            writer.flush();
            //xong thì
            return true;
        }catch(Exception e){
            System.err.println("Brand file error: " + e); //omit stacks
            return true;
        }
    }
    
    
}
