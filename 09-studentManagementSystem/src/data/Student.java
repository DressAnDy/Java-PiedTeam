
package data;

import java.util.Scanner;

public class Student extends Person {
    //props
    private String id;
    private float gpa;
    private String email;
    //constructor

    public Student(String name, String gender, int yob,
            String id, float gpa, String email) {
        super(name, gender, yob);
        this.id = id;
        this.gpa = gpa;
        this.email = email;
    }//super : new Cha => new Person(name , gender , yob)

    //constructor rỗng
    public Student() {
    
    }
    
    //getter
    public String getId() {
        return id;
    }

    public float getGpa() {
        return gpa;
    }

    public String getEmail() {
        return email;
    }
    
    //setter (thông minh): thay vì nhận được giá trị r bỏ vào lun thì mình
    //thì mình sẽ kiểm tra giá trị đó , nếu value is vaild thì mình
    //gán giá trị về return true
    //còn nếu value is not vaild thì mình chửi và return false
    public boolean setId(String id) {
        if(id.length() <= 0){
            System.err.println("Không được để trống!!!");
            return false;
        }
        if(!id.matches("^SE\\d{7}$")){
            System.err.println("Id phải có dạng SEDDDDDD với D là số");
            return false;
        }
        //nếu k vào if nào ở trên - vượt qua các tầng validate(xác thực)
        //thì mình sẽ gán giá trị vào object và return true
        this.id = id;
        return true;
    }

    public boolean setGpa(float gpa) {
        if(gpa < 0 || gpa > 10){
            System.err.println("GPA không hợp lệ");
            return false;
        }
        this.gpa = gpa;
        return true;
    }

    public boolean setEmail(String email) {
        if(email.length() == 0){
            System.err.println("Email không được bỏ trống");
            return false;
        
        }
        
        if(!email.contains("@")){
            System.err.println("Email không hợp lệ");
            return false;
        }
        this.email = email;
        return true;
    }
    
    @Override
    public void inputInfor(){ //hàm nhập full thông tin người dùng
        Scanner sc = new Scanner(System.in); //máy nhập
        super.inputInfor(); //cha: nhập cho con name , gender , yob;
        
        System.out.println("Nhập StudentId: ");
        /*
        while(true){
            String inpId = sc.nextLine();
            boolean isValid = this.setId(inpId);
            if(isValid) break;
        } */
        
        //id
        while(!setId(sc.nextLine()));
        //gpa
        System.out.println("Nhập điểm: ");
        while(!setGpa(Float.parseFloat(sc.nextLine()))); //ép kiểu từ chuỗi sang
        //sang float để xó buffer vd: "12.5\n"
        //email
        System.out.println("Nhập email: ");
        while(!setEmail(sc.nextLine()));
    }
    @Override
    public void showInfor(){
        super.showInfor(); //in ra name , gender , yob
        String str = String.format("|%s|%f|%s\n", id , gpa , email);
        System.out.printf(str);
    }
    
    public boolean isScholarship(){
    /*
        if(this.gpa > 8){
            return true;
        }else{
            return false;
        }
        */
        return this.gpa > 8;
    } 
}
/*
  Student class
     sử dụng kế thừa để có name , gender , yob của person
     riêng student thì muốn có thêm id , gpa , email
     phễu có đối số và ko có đối số
     getter và có setter nhưng thông minh
     showInfor
*/