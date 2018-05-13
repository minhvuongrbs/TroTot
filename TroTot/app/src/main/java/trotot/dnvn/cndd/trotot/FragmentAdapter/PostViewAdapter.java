package trotot.dnvn.cndd.trotot.FragmentAdapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import trotot.dnvn.cndd.trotot.Model.Data;
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

