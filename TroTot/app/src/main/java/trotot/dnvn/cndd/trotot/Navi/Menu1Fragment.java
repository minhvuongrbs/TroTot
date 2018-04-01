package trotot.dnvn.cndd.trotot.Navi;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import trotot.dnvn.cndd.trotot.PostDetail.PostDetailActivity;
import trotot.dnvn.cndd.trotot.R;


public class Menu1Fragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    private TextView mTextViewXemThem;
    private Button mButtonPost;
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
        mTextViewXemThem=(TextView) rootView.findViewById(R.id.post_xem_them);
        mButtonPost=(Button) rootView.findViewById(R.id.btn_dang_bai);

        initData();

        mAdapter=new PostViewAdapter(data);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mButtonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), PostDetailActivity.class);
                getActivity().startActivity(intent);
            }
        });
        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                Intent intent=new Intent(getContext(), PostDetailActivity.class);
                getActivity().startActivity(intent);
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

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
