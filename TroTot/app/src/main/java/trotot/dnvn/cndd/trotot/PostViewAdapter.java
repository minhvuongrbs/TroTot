package trotot.dnvn.cndd.trotot;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
        public RecyclerViewHolder(View itemView){
            super(itemView);
            username= itemView.findViewById(R.id.user_name);
            address=itemView.findViewById(R.id.address);
            image_room=itemView.findViewById(R.id.image_room);
        }

    }
}

 class Data {
    String username;
    String address;
    int image_room_id;

    Data(String username,String address,int image_room_id){
        this.username=username;
        this.address=address;
        this.image_room_id=image_room_id;
    }
}
