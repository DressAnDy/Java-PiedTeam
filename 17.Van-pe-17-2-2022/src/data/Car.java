
package data;
/*
Khuôn đúc các chiếc xe
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Car implements Comparable<Car>{
    private String carId;
    private Brand brand;
    private String color;
    private String frameId;
    private String engineId;

    public Car(String carId, Brand brand, String color, String frameId, String engineId) {
        this.carId = carId;
        this.brand = brand;
        this.color = color;
        this.frameId = frameId;
        this.engineId = engineId;
    }
    
    public Car(){
    }

    public String getCarId() {
        return carId;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getFrameId() {
        return frameId;
    }

    public String getEngineId() {
        return engineId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFrameId(String frameId) {
        this.frameId = frameId;
    }

    public void setEngineId(String engineId) {
        this.engineId = engineId;
    }

    @Override
    public String toString() {
        String str = String.format("%s, %s, %s, %s, %s", carId , brand.getBrandId(),  color ,
                                    frameId , engineId);
        return str;
    }
    
    public String screenString(){
                String str = String.format("%s,\n %s, %s, %s, %s", brand, carId ,  color ,
                                    frameId , engineId);
        return str;
    }
    @Override
    public int compareTo(Car that) {
        String thisBrandName = this.brand.getBrandName();
        String thatBrandName = that.brand.getBrandName();
        if(thisBrandName.compareTo(thatBrandName) > 0){
            return 1;
        }else if(thisBrandName.compareTo(thatBrandName) == 0){
            //so qua carID
            return this.getCarId().compareTo(that.getCarId());
        }
        return -1;
    }
}
