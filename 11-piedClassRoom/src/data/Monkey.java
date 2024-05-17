
package data;

import java.util.Random;

/*
 Con khỉ thì ko có gì khác với Herbivore
trừ việc có RECEPTIVE là 70
*/
public class Monkey extends Herbivore {
    public static final double RECEPTIVE = 70;
    
    public Monkey(String name, int yob, double weight) {
        super(name, yob, weight);
    }

    @Override
    public double study() {
        return new Random().nextDouble() * RECEPTIVE;
    }

    @Override
    public void showLearningOutcomes() {
        String str = String.format("%-20s|%-10s|%4d|%6.2f|%6.2f",
                                    "Monkey", name , yob , weight , study());
        System.out.println(str);
    }
    
}
