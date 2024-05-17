
package data;

import java.util.Random;

/*
Hunter: thợ săn
Tao muốn hunter tham gia vào hội ham học , ban đầu bác thợ săn vừa học
vừa ngắm phò mã , chỉ cần bác tham gia hội này thì ko cần quan tâm tới 
bữa tối của mình 

Nếu hunter tham gia vào clb thì nó sẽ dc làm gì
Hunter sẽ k dc thừa kề bất cứ thuộc tính nào , nhưng dc xài chung cái FAN
Hunter sẽ nhận dc 2 cái lỗ ( 2 abs method)
extends: mở rộng (bao gồm props riêng , override method (implement), method riêng)
implement: chỉ override abs method
*/
public class Hunter implements StudyEnthusiasts{
    //props
    private String name;
    private int yob;
    private double weight;
    private String gear;
   
    //bác vì mãi mê nhìn phò mã nên bác học rất mất tập trung nên là public
    public static final double RECEPTIVE = 50;

    public Hunter(String name, int yob, double weight, String gear) {
        this.name = name;
        this.yob = yob;
        this.weight = weight;
        this.gear = gear;
    }
    
    //method
    public double study() {
        return new Random().nextDouble() * RECEPTIVE;
    }

    public void showLearningOutcomes() {
        String str = String.format("%-20s|%-10s|%4d|%6.2f|%6.2f|%s",
                                    "Hunter", name , yob , weight , study() , gear);
        System.out.println(str);
    }

    @Override
    public double studyHard() {
        return study() * 1.5; //học chăm hơn 1 nửa so với bh
    }

    @Override
    public void showProfile() {
         String str = String.format("%-20s|%-10s|%4d|%6.2f|%6.2f|%s",
                                    "Hunter", name , yob , weight , studyHard() , gear);
        System.out.println(str);
    }
    
}
