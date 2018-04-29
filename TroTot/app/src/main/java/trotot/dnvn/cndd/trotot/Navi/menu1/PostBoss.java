package trotot.dnvn.cndd.trotot.Navi.menu1;

import java.io.Serializable;

public class PostBoss implements Serializable {
    private String username;
    private String image;
    private String address;
    private String area;
    private String electricRate;
    private String waterRate;
    private String describe;
    private String phone;

    public PostBoss() {
        this.username = null;
        this.image = null;
        this.address = null;
        this.area = null;
        this.electricRate = null;
        this.waterRate = null;
        this.describe = null;
        this.phone = null;
    }

    public PostBoss(String username, String image, String address, String area, String electricRate, String waterRate, String describe, String phone) {
        this.username = username;
        this.image = image;
        this.address = address;
        this.area = area;
        this.electricRate = electricRate;
        this.waterRate = waterRate;
        this.describe = describe;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getElectricRate() {
        return electricRate;
    }

    public void setElectricRate(String electricRate) {
        this.electricRate = electricRate;
    }

    public String getWaterRate() {
        return waterRate;
    }

    public void setWaterRate(String waterRate) {
        this.waterRate = waterRate;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribec(String describe) {
        this.describe = describe;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
