package runtime;

import data.Herbivore;
import data.Horse;
import data.Hunter;
import data.Monkey;
import java.util.ArrayList;

/*
Viet 1 boi canh
Mình có 1 nhiệm vụ là phổ cập kiến thức cho muôn loài
Mình không dạy cho con chó con mèo bình thường
Mình dạy cho những con hoang dã: 
Ngày đầu tiên anh đến lớp anh đã gặp được 2 con vật rất dễ thương
đó là ngựa và khỉ
*/
public class Progarm {

    public static void main(String[] args) {
        Monkey m1 = new Monkey("Rafiki", 1998 , 210); //the lion king
        Monkey m2 = new Monkey("Abu", 1994 , 30); 
        Horse h1 = new Horse("Rarity", 2015, 9, "none");
        Herbivore h2 = new Horse("Roach", 2019, 170, "Grey");
        
        //tạo mảng kiểu premitive
        //Herbivore stuList[] = {m1,m2,h1,h2};
        
        ArrayList<Herbivore> stulist = new ArrayList<>();
        stulist.add(m1);
        stulist.add(m2);
        stulist.add(h1);
        stulist.add(h2);
        
        for (Herbivore student : stulist) {
            student.showLearningOutcomes();
        }
        
        
        //bối cánh: lớp học của anh rớt vào một mùa đông giá ret 
        //mọi con vật đều co ro học tập trong cái lạnh
        //thì bỗng nhiên có một con vật nhỏ bé đi vào
        /*
            trùm kính mít , và vì quá kín nên mình không đoán dc nó là con gì
            thấy nó ăn cỏ , cũng hiền nên mình tin nó là động vật ăn cỏ
            nó muốn xin học , mình cần lưu nó vào danh sách thì làm sao
        */
        
        Herbivore xxx = new Herbivore("Con chậm chạp", 2024, 4) {
            @Override
            public double study() {
                return 80; //chậm chạp, ko ai chơi chung , rất tập trung
            }
            
            @Override
            public void showLearningOutcomes() {
                String str = String.format("%-20s|%-10s|%4d|%6.2f|%6.2f",
                                    "XXX", name , yob , weight , study());
                System.out.println(str);
            }
        };
        stulist.add(xxx);
        
        //Lớp học đang yên ắng , thì lại có thêm 1 bạn mới vào , bạn này
        /*
            bạn này làm cả lớp học sôi động , đó là bác thợ săn
            bác đến vì bác tham học , mún tham gia vào lớp học
            hãy lưu trữ bác thợ săn nhé
        */
        
        Hunter hun1 = new Hunter("Thợ săn vượn", 1999 , 0 , "Nỏ");
        Hunter hun2 = new Hunter("Mắt diều hâu", 1999 , 0 , "Cung");
        hun1.showLearningOutcomes();
        hun2.showLearningOutcomes();
    }
    
}

//muốn lưu khỉ và ngựa về cùng 1 nhà thì là dễ thông qua thằng Herbivore
//anh muốn thêm Hunter vào cùng 1 nhà thì phải có cha là ai ? k có
//trong câu chuyện này sự khác nhau về mặt sinh học là quá lớn
//mình ko thể ghép 2 kẻ thù về 1 nhà như thế
// chúng ta chỉ có một điểm chung duy nhất đó là con nào cũng ham học cả