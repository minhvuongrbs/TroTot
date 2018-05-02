package trotot.dnvn.cndd.trotot.Navi.menu1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import trotot.dnvn.cndd.trotot.R;

/**
 * Created by minhv on 3/3/2018.
 */

public class PostViewAdapter extends RecyclerView.Adapter<PostViewAdapter.RecyclerViewHolder>{
    private List<Data> data=new ArrayList<>();


    public PostViewAdapter(List<Data> data) {
        this.data=data;
    }

    @NonNull
    @Override
    public PostViewAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.post,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewAdapter.RecyclerViewHolder holder, int position) {
//        holder.username.setText(data.get(position).getUsername());
//        holder.address.setText(data.get(position).getAddress());
//        holder.time_post.setText(data.get(position).getTimeUp());

        holder.username.setText(data.get(position).getUsername());
        holder.address.setText(data.get(position).getAddress());
        holder.time_post.setText(data.get(position).getTimeUp());
        holder.describe.setText(data.get(position).getDescribe());
        holder.area.setText(data.get(position).getArea());
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView username;
        TextView address;
        ImageView image_room;
        ImageView image_profile;
        TextView time_post;
        TextView describe;
        TextView area;

        public RecyclerViewHolder(View itemView){
            super(itemView);
            username= itemView.findViewById(R.id.user_name);
            address=itemView.findViewById(R.id.address);
            image_room=itemView.findViewById(R.id.image_room);
            image_profile=itemView.findViewById(R.id.image_profile);
            time_post=itemView.findViewById(R.id.time_post);
            describe=itemView.findViewById(R.id.txtViewDescribe);
            area=itemView.findViewById(R.id.txtViewArea);

        }

    }
}

 class Data {
    private String timeUp;
     private String username;
     private int imageId;
     private String address;
     private String area;
     private String describe;

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
     }

     public Data(String timeUp, String username, int imageId, String address, String area, String describe) {
         this.timeUp = timeUp;
         this.username = username;
         this.imageId = imageId;
         this.address = address;
         this.area = area;
         this.describe = describe;
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
