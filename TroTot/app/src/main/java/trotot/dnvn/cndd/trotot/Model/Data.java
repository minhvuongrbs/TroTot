package trotot.dnvn.cndd.trotot.Model;

import trotot.dnvn.cndd.trotot.R;

public class Data {
    //data for post boss
    private String timeUp;
    private String username;
    private int imageId;
    private String address;
    private String area;
    private String describe;
    private String rate;

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Data() {
        this.timeUp = null;
        this.username = null;
        this.imageId = R.drawable.room1;
        this.address = null;
        this.area = null;
        this.describe = null;
        this.rate=null;
    }

    public Data(String timeUp, String username, int imageId, String address, String area, String describe,String rate) {
        this.timeUp = timeUp;
        this.username = username;
        this.imageId = imageId;
        this.address = address;
        this.area = area;
        this.describe = describe;
        this.rate=rate;
    }

    public String getTimeUp() {
        return timeUp;
    }

    public void setTimeUp(String timeUp) {
        this.timeUp = timeUp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
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

}
