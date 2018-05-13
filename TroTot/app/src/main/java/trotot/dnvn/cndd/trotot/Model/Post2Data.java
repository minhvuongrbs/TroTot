package trotot.dnvn.cndd.trotot.Model;

public class Post2Data {
    int imageId;
    String location;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    String describe;


    public Post2Data(int imageId, String location, String describe){
        this.imageId=imageId;
        this.location=location;
        this.describe=describe;
    }
    Post2Data(){
        this.imageId=0;
        this.location=null;
        this.describe=null;
    }
}