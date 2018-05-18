package trotot.dnvn.cndd.trotot.Model;

import java.util.ArrayList;
import java.util.List;

public class FileTransfer {
    private List<Data> data;

    public FileTransfer(List<Data> data){
        this.data=data;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }
}
