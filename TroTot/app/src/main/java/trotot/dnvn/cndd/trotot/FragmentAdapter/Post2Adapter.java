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

import trotot.dnvn.cndd.trotot.Model.Post2Data;
import trotot.dnvn.cndd.trotot.R;

public class Post2Adapter extends RecyclerView.Adapter<Post2Adapter.RecyclerViewHolder>{
    private List<Post2Data> post2Data=new ArrayList<>();

    public Post2Adapter(List<Post2Data> roomManageData) {
        this.post2Data=roomManageData;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.post2,parent,false);


        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.image.setImageResource(post2Data.get(position).getImageId());
        holder.location.setText(post2Data.get(position).getLocation());
        holder.describe.setText(post2Data.get(position).getDescribe());
    }


    @Override
    public int getItemCount()
    {
        return post2Data.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView location;
        TextView describe;

        public RecyclerViewHolder(View itemView){
            super(itemView);
            image=itemView.findViewById(R.id.image_post2);
            location=itemView.findViewById(R.id.location_post2);
            describe=itemView.findViewById(R.id.describe);
        }

    }
}


