package trotot.dnvn.cndd.trotot.Dung;

import java.io.Serializable;

public class Account implements Serializable {

    private String userName;
    private String email;
    private String phone;
    private String address;
    private String image;

    public Account(){
        this.userName = null;
        this.email = null;
        this.address = null;
        this.phone = null;
        this.image=null;
    }
    public Account(String userName, String email, String address, String phone,String image) {
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.image=image;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}