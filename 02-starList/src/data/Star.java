
package data;
//đây là cái khuôn (class) chuyên đúc ra các ngôi sao, ca sĩ nổi tiếng (object)
public class Star {
    //properties - props - field - attribute: thuộc tính
    private String name;
    public int yob;
    public String gender;
    public String hotSong;
    //static là không phân tán mà chỉ có duy nhất thằng này
    //ảm chỉ việc prop hay method này thuộc class(khuôn) ko thuộc object
    // các object phải xài chung cái prop , method đó
    //method: phương thức || hành động
    //constructor: cái phễu 
    //phải public mới lấy xài và đúc dc chứ
    // phài cùng tên với class
    // không dc quy định đầu ra 
    //this: this là đại diện cho class chứa nó
    public Star(String name , int yob , 
            String gender , String hotSong){
        this.name = name;
        this.yob = yob;
        this.gender = gender;
        this.hotSong = hotSong;
    }   
    public void showInfor(){
        System.out.println("Tôi tên là " + name + 
                           ", Tôi là " + gender +
                           ", Sinh Năm " + yob + 
                           ", hotSong nè: " + hotSong);
    }     
    
    //get
    public String getName(){
        return name;
    }

    public void setName(String newName , int pwd ) {
        name = pwd == 5071994 ? newName : name;
    }
}
