
package data;

import java.util.Random;

/*
Hunter: thợ săn
*/
public class Hunter {
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
    
}
