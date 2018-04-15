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
        holder.username.setText(data.get(position).username);
        holder.address.setText(data.get(position).address);
        holder.image_room.setImageResource(data.get(position).image_room_id);
        holder.image_profile.setImageResource(data.get(position).image_profile_id);
        holder.time_post.setText(data.get(position).time_post);
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
        public RecyclerViewHolder(View itemView){
            super(itemView);
            username= itemView.findViewById(R.id.user_name);
            address=itemView.findViewById(R.id.address);
            image_room=itemView.findViewById(R.id.image_room);
            image_profile=itemView.findViewById(R.id.image_profile);
            time_post=itemView.findViewById(R.id.time_post);

        }

    }
}

 class Data {
    String username;
    String address;
    int image_profile_id;
    int image_room_id;
    String time_post;

    Data(String username,String address,int image_room_id,int image_profile_id,String time_post){
        this.username=username;
        this.address=address;
        this.image_room_id=image_room_id;
        this.image_profile_id=image_profile_id;
        this.time_post=time_post;
    }
}