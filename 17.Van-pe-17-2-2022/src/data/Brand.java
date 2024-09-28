
package data;

public class Brand {
    private String brandId;
    private String brandName;
    private String soundBrand;
    private double price;

    public Brand(String brandId, String brandName, String soundBrand, double price) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.soundBrand = soundBrand;
        this.price = price;
    }

    public Brand() {
    }

    public String getBrandId() {
        return brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getSoundBrand() {
        return soundBrand;
    }

    public double getPrice() {
        return price;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setSoundBrand(String soundBrand) {
        this.soundBrand = soundBrand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String str = String.format("%s, %s, %s: %.3f", brandId, brandName
                                , soundBrand , price);
        return str;
    }
       
}
 