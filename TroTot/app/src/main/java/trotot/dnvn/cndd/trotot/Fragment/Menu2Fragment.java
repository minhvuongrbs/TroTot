package trotot.dnvn.cndd.trotot.Fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import trotot.dnvn.cndd.trotot.FragmentAdapter.Post2Adapter;
import trotot.dnvn.cndd.trotot.Model.Post2Data;
import trotot.dnvn.cndd.trotot.R;

import static android.app.Activity.RESULT_OK;


public class Menu2Fragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private ImageView mButtonGetImage;
    private ImageView mButtonGetLocation;
    private ImageView mImageView;
    private List<Post2Data> post2Data;

    public Menu2Fragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_menu2, container, false);

        Log.d("log","create fragment 2");

        mButtonGetImage=rootView.findViewById(R.id.addPhoto);
        mButtonGetLocation=rootView.findViewById(R.id.addLocation);
        mImageView=rootView.findViewById(R.id.setImageDemo);
        mRecyclerView=rootView.findViewById(R.id.recyclerview_post2);

        initData();

        mAdapter=new Post2Adapter(post2Data);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mButtonGetImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("log","click button get image");
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
            }
        });


        return rootView;
    }

    private void initData() {
        post2Data=new ArrayList<>();
        post2Data.add(new Post2Data(R.drawable.room2,"Lien Chieu","Mình muốn nhượng lại trọ này "));
        post2Data.add(new Post2Data(R.drawable.room1,"Hai Chau","Mình tìm bạn ở ghép "));
        post2Data.add(new Post2Data(R.drawable.room2,"Thanh Khê","Mình tìm bạn ở ghép "));

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);


                mImageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
