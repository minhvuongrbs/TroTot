package trotot.dnvn.cndd.trotot.Model;

import trotot.dnvn.cndd.trotot.R;

public class Data {
    //data for post boss
    private String timeUp;
    private String username;
    private String image;
    private String address;
    private String area;
    private String describe;
    private String rate;
    private int postId;
    private double longitude;
    private double latitude;
    private String name;
    private String electric_bill;
    private String water_bill;
    private String phone;
    private String image_user;

    public String getImage_user() {
        return image_user;
    }

    public void setImage_user(String image_user) {
        this.image_user = image_user;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getElectric_bill() {
        return electric_bill;
    }

    public void setElectric_bill(String electric_bill) {
        this.electric_bill = electric_bill;
    }

    public String getWater_bill() {
        return water_bill;
    }

    public void setWater_bill(String water_bill) {
        this.water_bill = water_bill;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Data(Builder builder) {

    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

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
        this.image = null;
        this.address = null;
        this.area = null;
        this.describe = null;
        this.rate=null;
        this.postId=0;
        this.longitude=0;
        this.latitude=0;
        this.name=null;
        this.phone=null;
        this.electric_bill=null;
        this.water_bill=null;
        this.image_user=null;
    }

    public Data(String timeUp, String username, String image, String address, String area, String describe,String rate,int postId,double longitude,double latitude,String name,String phone,String water_bill,String electric_bill,String image_user) {
        this.timeUp = timeUp;
        this.username = username;
        this.image = image;
        this.address = address;
        this.area = area;
        this.describe = describe;
        this.rate=rate;
        this.postId=postId;
        this.longitude=longitude;
        this.latitude=latitude;
        this.name=name;
        this.phone=phone;
        this.water_bill=water_bill;
        this.electric_bill=electric_bill;
        this.image_user=image_user;
    }

    public static class Builder {

        private String timeUp;
        private String username;
        private String image;
        private String address;
        private String area;
        private String describe;
        private String rate;
        private int postId;
        private double longitude;
        private double latitude;
        private String name;
        public Builder() {

        }

        public Data build() {
            return new Data(this);
        }
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

    public String getImage() {
        return image;
    }

    public void setImage(int imageId) {
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

}
