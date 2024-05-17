package runtime;

import data.Herbivore;
import data.Horse;
import data.Hunter;
import data.Monkey;
import data.StudyEnthusiasts;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        Monkey m1 = new Monkey("Rafiki", 1998 , 210); //the lion king
        Monkey m2 = new Monkey("Abu", 1994 , 30); 
        Horse h1 = new Horse("Rarity", 2015, 9, "none");
        Herbivore h2 = new Horse("Roach", 2019, 170, "Grey");
        Hunter hun1 = new Hunter("Thợ săn vượn", 1999 , 63 , "Nỏ");
        
        ArrayList<StudyEnthusiasts> stuList = new ArrayList<>();
        stuList.add(h1);
        stuList.add((Horse)h2); //ép kiểu
        stuList.add(hun1);
        
        //hôm này mọi người đều học chăm chỉ , thì có 1 con lười(Sloth)
        //đến học , tưởng là 1 học sinh mới , nhưng hóa ra chính là cái con
        //đã chùm kín mít
        //lúc này muốn lưu con lười 
        //1. tạo con lười bằng class Herbivore như lần trước 
        // thì ko nhét vào stuList dc vì stuList là hội ham học
        
        //2. tạo class Sloth và cho Sloth implements với StudyEnthusiasts
        // đâu phải con lười nào cũng ham học đâu mình code như này 
        // là mình ép tất cả lười trên thế giới đều ham học
        // con lười của mình là một con lười rất đặc biệt so với giống loài
        // của nó. nên mình ko nên xem nó là mốt con lười bth mà nên xem nó là
        //một loài ham học mà thôi
        //3. tạo con lười bằng anonymours thông qua StudyEnthusiasts
        StudyEnthusiasts xxx = new StudyEnthusiasts() {
            @Override
            public double studyHard() {
                return 80 * 1.5;
            }

            @Override
            public void showProfile() {
                String str = String.format("%-20s|%-20s|%4d|%6.2f|%6.2f", 
                                           "Sloth", "Flash", 2019 , 120F , studyHard());
                System.out.println(str);
            }
        };
        stuList.add(xxx);      
    }
    
}
