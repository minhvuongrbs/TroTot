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
    private int postId;
    private double longitude;
    private double latitude;
    private String name;

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
        this.imageId = R.drawable.room1;
        this.address = null;
        this.area = null;
        this.describe = null;
        this.rate=null;
        this.postId=0;
        this.longitude=0;
        this.latitude=0;
        this.name=null;
    }

    public Data(String timeUp, String username, int imageId, String address, String area, String describe,String rate,int postId,double longitude,double latitude,String name) {
        this.timeUp = timeUp;
        this.username = username;
        this.imageId = imageId;
        this.address = address;
        this.area = area;
        this.describe = describe;
        this.rate=rate;
        this.postId=postId;
        this.longitude=longitude;
        this.latitude=latitude;
        this.name=name;
    }

    public static class Builder {

        private String timeUp;
        private String username;
        private int imageId;
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
