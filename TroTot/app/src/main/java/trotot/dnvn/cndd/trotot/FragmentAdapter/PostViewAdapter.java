package trotot.dnvn.cndd.trotot.FragmentAdapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import trotot.dnvn.cndd.trotot.Activities.PostDetailActivity;
import trotot.dnvn.cndd.trotot.AsyncTask.LoadImageTask;
import trotot.dnvn.cndd.trotot.Model.Data;
import trotot.dnvn.cndd.trotot.R;

import static trotot.dnvn.cndd.trotot.Activities.LoginActivity.SERVER;

/**
 * Created by minhv on 3/3/2018.
 */

public class PostViewAdapter extends RecyclerView.Adapter<PostViewAdapter.RecyclerViewHolder> implements LoadImageTask.Listener{
    private Bitmap image_room=null;
    private List<Data> data=new ArrayList<>();
    private Context context;


    public PostViewAdapter(List<Data> data,Context context) {
        this.data=data;
        this.context=context;
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
        holder.area.setText(data.get(position).getArea());
        holder.rate.setText(data.get(position).getRate());
        String src=SERVER+data.get(position).getImage();
        Log.d("src",src);
        new LoadImageTask(this).execute(src);
//        holder.image_room.setImageBitmap(image_room);
        holder.image_room.setImageResource(R.drawable.room1);
        holder.image_profile.setImageResource(R.drawable.user);
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }

    @Override
    public void onImageLoaded(Bitmap bitmap) {
        image_room=bitmap;
        Log.d("bitmap",bitmap.toString());
    }

    @Override
    public void onError() {
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView username;
        TextView address;
        ImageView image_room;
        ImageView image_profile;
        TextView time_post;
        TextView area;
        TextView rate;
        Button xemthem;

        public RecyclerViewHolder(View itemView){
            super(itemView);
            username= itemView.findViewById(R.id.user_name);
            address=itemView.findViewById(R.id.address);
            image_room=itemView.findViewById(R.id.image_room);
            image_profile=itemView.findViewById(R.id.image_profile);
            time_post=itemView.findViewById(R.id.time_post);
            area=itemView.findViewById(R.id.txtViewArea);
            rate=itemView.findViewById(R.id.txtViewRate);
            xemthem= itemView.findViewById(R.id.post_xem_them);

            xemthem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context, PostDetailActivity.class);
                    intent.putExtra("idPost",data.get(getAdapterPosition()).getPostId());
                    context.startActivity(intent);
                }
            });
        }
    }

}

