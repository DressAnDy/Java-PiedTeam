
package data;
/*
CarList là anh quản lý danh sách các chiếc xe carList
    thì ảnh có: danh sách các chiếc xe  carList
                có 1 anh quản lý danh sách các "dòng xe" BrarndList
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import utils.Inputter;

public class CarList {
    ArrayList<Car> carList = new ArrayList<>();
    BrandList brandList;; //anh quản lý danh sách brandList tên là brandList
    
    //constructor


    public CarList(BrandList brandList){
        this.brandList = brandList;
    }

    //hàm đọc file
    public boolean loadFromFile(String url) {
        File f = new File(url);
        try{
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = reader.readLine();
            while(line != null){
                //xử lý file
                StringTokenizer st = new StringTokenizer(line , ",");
                String cid = st.nextToken().trim();
                String bid = st.nextToken().trim();
                String color = st.nextToken().trim();
                String fId = st.nextToken().trim();
                String eId = st.nextToken().trim();
                //dùng bid tìm brand tương ứng
                int pos = brandList.searchId(bid);
                Brand brand = brandList.brandList.get(pos);
                Car nCar = new Car(cid, brand, color, fId, eId);
                carList.add(nCar);
                line = reader.readLine(); //đọc dòng tiếp theo
            }
            
            return true;
        }catch(Exception e){
            System.err.println("File car error" + e);
            return false;
        }
    }
    
    //hàm in
    public void listCars(){
        if(carList.isEmpty()){
            System.err.println("CarList has nothing to print");
            return; //ngừng
        }
        System.out.println("_____CarList_____");
        for (Car car : carList) {
            System.out.println(car.screenString());
        }
    }
    //hàm tim vị trí theo carID
    public int searchID(String carID){
        for (int i = 0; i <= carList.size() - 1; i++) {
            if(carList.get(i).getCarId().equals(carID)){
                return i;
            }
        }
        return -1;
    }
    
    //hàm tìm vị trí theo frameID
    public int searchFrame(String frameID){
        for (int i = 0; i <= carList.size() - 1; i++) {
            if(carList.get(i).getFrameId().equals(frameID)){
                return i;
            }
        }
        return -1;
    }
    
    //tìm vị trí theo egnineID
    public int searchEngine(String engineID){
        for (int i = 0; i <= carList.size() - 1; i++) {
            if(carList.get(i).getEngineId().equals(engineID)){
                return i;
            }
        }
        return -1;
    }
    
    //hàm thêm 1 chiếc xe
    public void addCar(){
        //thu thập 
        //id cấm trùng
        boolean isDup;
        String carID;
        do{
            isDup = false; //reset // tìn là ko bị trùng 
            carID = Inputter.getString("Input carId: ", 
                                        "That field is required");
            int pos = searchID(carID); //nếu khác -1 thì là tìm dc
            if(pos != -1){
                //tìm dc nghĩa là bị trùng
                System.err.println("CarId is has been used");
                isDup = true;
            }
        }while(isDup); // còn trùng thì còn nhập lại
        //nhập brand bằng menu
        Brand brand = brandList.getUserChoice();
        String color = Inputter.getString("Input color: ", 
                                         "That field is required");
        

        //nhập framdID theo format và cấm trùng    
        String framdID;
        do{
            isDup = false; //reset // tìn là ko bị trùng 
            framdID = Inputter.getString("Input frame: ", 
                    "framdId must be match F00000: ", "F\\d{5}");
            int pos = searchFrame(framdID); //nếu khác -1 thì là tìm dc
            if(pos != -1){
                //tìm dc nghĩa là bị trùng
                System.err.println("frameID is has been used");
                isDup = true;
            }
        }while(isDup);
        
        
        String engineID;
        do{
            isDup = false; //reset // tìn là ko bị trùng 
            engineID = Inputter.getString("Input frame: ", 
                    "framdId must be match F00000: ", "F\\d{5}");
            int pos = searchEngine(engineID); //nếu khác -1 thì là tìm dc
            if(pos != -1){
                //tìm dc nghĩa là bị trùng
                System.err.println("engineID is has been used");
                isDup = true;
            }
        }while(isDup);
        
        Car nCar = new Car(carID, brand, color, framdID, engineID);
        carList.add(nCar);
        System.out.println("Car adding is successful");
    }
    public void printBaseBrandName(){
        //nhập một phần brand name cần tìm
        String key = Inputter.getString("Input a part of BrandName", 
                                        "That field is required!!!");
        //duyệt qua các chiếc xe, xe nào mà brandName có chứa key thì in ra
        int count = 0;
        for (Car car : carList) {
            if(car.getBrand().getBrandName().contains(key)){
                System.out.println(car.screenString());
                count++;
            }
        }
        if(count == 0){
            System.err.println("No car is detected");
        }
    }
    public boolean removeCar(){
        String keyId = Inputter.getString("Intput CarId you wanna remove",
                                         "That field is required!!");
        //Từ keyId tìm Car cần xóa
        int pos = searchID(keyId);
        Car car = pos == -1 ? null : carList.get(pos);
        if(car == null){
            System.err.println("Not found");
            return false;
        }else{
            System.out.println("Car Infomation: ");
            System.out.println(car.screenString());
            carList.remove(pos);
            System.out.println("Car removing is successful");
            return true;
        }
    }
    
        public boolean updateCar(){
        String keyId = Inputter.getString("Intput CarId you wanna remove",
                                         "That field is required!!");
        //Từ keyId tìm Car cần xóa
        int pos = searchID(keyId);
        Car car = pos == -1 ? null : carList.get(pos);
        if(car == null){
            System.err.println("Not found");
            return false;
        }else{
            System.out.println("Car Infomation before updating: ");
            System.out.println(car.screenString());
            //thu thập thông tin mới
             //nhập brand bằng menu
            Brand brand = brandList.getUserChoice();
            String color = Inputter.getString("Input color: ", 
                                             "That field is required");


            //nhập framdID theo format và cấm trùng    
            boolean isDup;
            String framdID;
            do{
                isDup = false; //reset // tìn là ko bị trùng 
                framdID = Inputter.getString("Input frame: ", 
                        "framdId must be match F00000: ", "F\\d{5}");
                pos = searchFrame(framdID); //nếu khác -1 thì là tìm dc
                if(pos != -1){
                    //tìm dc nghĩa là bị trùng
                    System.err.println("frameID is has been used");
                    isDup = true;
                }
            }while(isDup);


            String engineID;
            do{
                isDup = false; //reset // tìn là ko bị trùng 
                engineID = Inputter.getString("Input engine: ", 
                        "engineId must be match F00000: ", "E\\d{5}");
                pos = searchEngine(engineID); //nếu khác -1 thì là tìm dc
                if(pos != -1){
                    //tìm dc nghĩa là bị trùng
                    System.err.println("engineID is has been used");
                    isDup = true;
                }
            }while(isDup);
            car.setBrand(brand);
            car.setColor(color);
            car.setFrameId(framdID);
            car.setEngineId(engineID);
            System.out.println("Car updating is sucessful");
            return true;
        }
    }
        public boolean saveToFile(String url){
        File f = new File(url);
        try{
            //xử lý file
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(f));
            for (Car car : carList) {
                writer.write(car.toString());
                writer.write("\n");
                
            }
            writer.flush();
            //xong thì
            return true;
        }catch(Exception e){
            System.err.println("Car file error: " + e); //omit stacks
            return true;
        }
    }
}
