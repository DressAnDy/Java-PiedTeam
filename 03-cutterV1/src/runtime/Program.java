package runtime;
import data.RightTriangle;
import data.Triangle;
//Bé Na học lớp 5 
//Bé Na cần lưu rất nhiều hình tam giác có đủ loại
public class Program {
    public static void main(String[] args) {
        Triangle tr1 = new Triangle(4 , 7.5 , 10);
        tr1.showInfor();
       
        RightTriangle rit = new RightTriangle(3 , 4);
        rit.showInfor();
    }
    //tui độ lại hàm của bố tôi để hợp với tôi
    
}
