package trotot.dnvn.cndd.trotot.Navi.menu3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import trotot.dnvn.cndd.trotot.R;


public class RoomManageFragment extends Fragment {

    private List<RoomManageData> mRoomManageData=new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    public RoomManageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_room_manage, container, false);

        mRecyclerView=(RecyclerView) rootView.findViewById(R.id.room_manage);

        initData();
        mAdapter=new RoomMnagerAdapter(mRoomManageData);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);


        return rootView;
    }

    private void initData() {
        mRoomManageData=new ArrayList<>();
        mRoomManageData.add(new RoomManageData("Nguyen Hoai Nam","Đang cho thuê"));
        mRoomManageData.add(new RoomManageData("Nguyen Hai Hoa","Phòng trống"));
        mRoomManageData.add(new RoomManageData("Nguyen Hoai Nam","Đang cho thuê"));
        mRoomManageData.add(new RoomManageData("Nguyen Hai Manh","Phòng trống"));
        mRoomManageData.add(new RoomManageData("Nguyen Qua Nam","Phòng trống"));
        mRoomManageData.add(new RoomManageData("Nguyen Hai Hoa","Phòng trống"));

    }

}
