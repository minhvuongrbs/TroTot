package trotot.dnvn.cndd.trotot.FragmentAdapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import trotot.dnvn.cndd.trotot.Model.RoomManageData;
import trotot.dnvn.cndd.trotot.R;

public class RoomMnagerAdapter extends RecyclerView.Adapter<RoomMnagerAdapter.RecyclerViewHolder>{
    private List<RoomManageData> roomManageData=new ArrayList<>();


    public RoomMnagerAdapter(List<RoomManageData> roomManageData) {
        this.roomManageData=roomManageData;
    }

    @NonNull
    @Override
    public RoomMnagerAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.post,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomMnagerAdapter.RecyclerViewHolder holder, int position) {
        holder.username.setText(roomManageData.get(position).getUsername());

    }

    @Override
    public int getItemCount()
    {
        return roomManageData.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView username;

        public RecyclerViewHolder(View itemView){
            super(itemView);
            username= itemView.findViewById(R.id.user_name);


        }

    }
}


