package data;

import java.util.Random;

/*
Khi mà horse kế thừa herbivore là nó muốn gì ?
    + Kế thừa còn là khôi phục lại trạng thái trước khi có cha
    + Thừa hưởng những gì cha có
    + Không cần làm lại những gì tiền bối đã làm tốt rồi
*/
public class Horse extends Herbivore implements StudyEnthusiasts{
    //prop
    private String colorSaddle;
    //con ngựa vừa học vừa hú hí , nên khả năng tiếp thu của nó rất kém
    //mà con ngựa nào cũng như vậy nên minh sẽ lưu thêm khả năng tiếp thu cho tất
    //cả con ngựa
    public static final double RECEPTIVE = 30; //khả năng tiếp thu kiến thức
    //khả năng tiếp thu tối đa của ngựa

    public Horse(String name, int yob, double weight, String colorSaddle) {
        super(name, yob, weight);
        this.colorSaddle = colorSaddle;
    }//super : new Cha => new Herbivore(name , yob , weight)

    public String getColorSaddle() {
        return colorSaddle;
    }
    //mỗi con ngựa tuy học khác nhau nhưng khả năng tiếp thu đối đa là 30
    //nhưng không phải con ngựa nào cũng 30 điểm , random lắm
    @Override
    public double study() {
        return new Random().nextDouble() * RECEPTIVE;
    }

    @Override
    public void showLearningOutcomes(){
        String str = String.format("%-20s|%-10s|%4d|%6.2f|%6.2f|%s",
                                    "Horse", name , yob , weight , study() , colorSaddle);
        System.out.println(str);
    }

    @Override
    public double studyHard() {
        return study() * 2.5;
    }

    @Override
    public void showProfile() {
        String str = String.format("%-20s|%-10s|%4d|%6.2f|%6.2f|%s",
                                    "Horse", name , yob , weight , studyHard() , colorSaddle);
        System.out.println(str);    
    }
 
}
