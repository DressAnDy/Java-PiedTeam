
package data;

public abstract class Pet {
    protected String id;
    protected String owner; //chủ sở hữu
    protected String color;
    protected double weight;
    
    //constructor
    public Pet(String owner, String color, double weight) {
        this.owner = owner;
        this.color = color;
        this.weight = weight;
    }

    //getter
    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }
    
    //method show
    //chó thì có necklace nhưng mèo thì có ribbon => 2 con in khác nhau
    public abstract void showInfor();
}
