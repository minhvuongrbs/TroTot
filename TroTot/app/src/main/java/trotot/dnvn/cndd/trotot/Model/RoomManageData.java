package trotot.dnvn.cndd.trotot.Model;

public class RoomManageData {
    String username;
    String tinhTrang;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public RoomManageData(String username, String tinhTrang){
        this.username=username;
        this.tinhTrang=tinhTrang;
    }
    public RoomManageData(){
        this.username=null;
        this.tinhTrang=null;
    }
}