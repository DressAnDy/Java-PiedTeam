
package data;

public class Cat extends Pet{
    private String ribbon;
    //constructor

    public Cat(String id ,String owner, String color, double weight, String ribbon) {
        super(owner, color, weight);
        this.ribbon = ribbon;
    }

    public String getRibbon() {
        return ribbon;
    }

    @Override
    public void showInfor() { //chỉ in ra chứ không đưa sử dụng
        String str = String.format("%4s|%-12s|%-12s|%6.2f|%s",
                id , owner , color , weight , ribbon); //tạo ra chuỗi đẹp
        System.out.println(str); //in ra cái chuỗi vừa tạo
    }

    @Override
    public String toString(){  //toString: là tạo ra chuỗi đẹp và ném ra bên ngoài
        String str = String.format("%4s|%-12s|%-12s|%6.2f|%s",
                id , owner , color , weight , ribbon);
        return str; //ném chuỗi đẹp ra ngoài , mún xài sao xài
    }
       
}
