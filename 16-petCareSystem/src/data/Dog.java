
package data;

public class Dog extends Pet{
    private String necklace;

    public Dog(String id , String owner, String color, double weight, String necklace) {
        super(owner, color, weight);
        this.necklace = necklace;
    }

    public String getNecklace() {
        return necklace;
    }

    @Override
    public void showInfor() { //chỉ in ra chứ không đưa sử dụng
        String str = String.format("%4s|%-12s|%-12s|%6.2f|%s",
                id , owner , color , weight , necklace); //tạo ra chuỗi đẹp
        System.out.println(str); //in ra cái chuỗi vừa tạo
    }

    @Override
    public String toString(){  //toString: là tạo ra chuỗi đẹp và ném ra bên ngoài
        String str = String.format("%4s|%-12s|%-12s|%6.2f|%s",
                id , owner , color , weight , necklace);
        return str; //ném chuỗi đẹp ra ngoài , mún xài sao xài
    }
       
}
