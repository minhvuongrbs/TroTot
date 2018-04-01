package trotot.dnvn.cndd.trotot;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Menu1Fragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    private List<Data> data;

    public Menu1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_menu1, container, false);

        //    recycler view for post
        mRecyclerView=(RecyclerView) rootView.findViewById(R.id.post);

        initData();

        mAdapter=new PostViewAdapter(data);


        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        // Inflate the layout for this fragment
        return rootView;
    }

    private void initData(){
        data=new ArrayList<>();
        Log.d("test1","vào init data");
        data.add(new Data("Minh Vương","số 50,đường Ngô Thì Nhậm,quận Liên Chiểu,tp Đà Nẵng",R.drawable.room1,R.drawable.user,"12/3/2018"));
        data.add(new Data("Hữu Nghĩa","đường Hồ Tùng Mậu,quận Liên Chiểu,tp Đà Nẵng",R.drawable.room2,R.drawable.user,"12/3/2018"));
        data.add(new Data("Tấn Nam","quận Hải Châu,tp Đà Nẵng",R.drawable.room3,R.drawable.user,"12/3/2018"));
        Log.d("test2","set data thành công");
    }


}
