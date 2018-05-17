package trotot.dnvn.cndd.trotot.Fragment;


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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.api.Api;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import trotot.dnvn.cndd.trotot.Activities.InforToPostActivity;
import trotot.dnvn.cndd.trotot.FragmentAdapter.PostViewAdapter;
import trotot.dnvn.cndd.trotot.Activities.PostDetailActivity;
import trotot.dnvn.cndd.trotot.Model.Data;
import trotot.dnvn.cndd.trotot.R;

import static trotot.dnvn.cndd.trotot.Activities.LoginActivity.SERVER;


public class Menu1Fragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private static String API="api/v1/post-room";
    private static String LINK = SERVER+API;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private Spinner mSpinnerRate;
    private ImageView mButtonSearch;
    private TextView mTextViewXemThem;
    private Button mButtonPost;
    private List<Data> data=new ArrayList<>();
    private static int k;

    public Menu1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("cho thue","vao create cho thue");

        View rootView=inflater.inflate(R.layout.fragment_menu1, container, false);

        //    recycler view for post
        mRecyclerView=(RecyclerView) rootView.findViewById(R.id.post);
        mTextViewXemThem=(TextView) rootView.findViewById(R.id.post_xem_them);
        mButtonPost=(Button) rootView.findViewById(R.id.btn_dang_bai);
        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(getContext() ,R.array.location,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mButtonSearch=rootView.findViewById(R.id.btn_search);

        mSpinnerRate=rootView.findViewById(R.id.spinner_rate);
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(getContext() ,R.array.rate,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerRate.setAdapter(adapter2);
        mSpinnerRate.setOnItemSelectedListener(this);

//        data.add(new Data("12/4/2018","Minh Vuong",0,"50 Ngô Thì Nhậm,thành phố Đà Nẵng","10 000m2","Điện nước,wifi"));
        Log.d("cho thue","link api"+LINK);
        Log.d("cho thue","truoc khi keo du lieu");
        initData();
        Log.d("cho thue","sau khi keo du lieu");

        mAdapter=new PostViewAdapter(data,getContext());
        Log.d("cho thue","set du lieu");
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mButtonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), InforToPostActivity.class);
                getActivity().startActivity(intent);
            }
        });
//        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
//            @Override
//            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
//                Intent intent=new Intent(getContext(), PostDetailActivity.class);
//                getActivity().startActivity(intent);
//                return false;
//            }
//
//            @Override
//            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
//
//            }
//
//            @Override
//            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//
//            }
//        });

        // Inflate the layout for this fragment
        return rootView;
    }

    private void initData(){
        Log.d("cho thue","vao initdata");
        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        Log.d("cho thue","sau requestQueue");


        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, LINK, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("get post","chay den day");
                        try {
                            JSONObject jsonObject = response.getJSONObject("data");
                            Log.d("response post", jsonObject.toString());
                            JSONArray getData=jsonObject.getJSONArray("data");
                            k = getData.length();
                            Log.d("so gia tri","kiem tra "+k);
                            for (int i = 0; i < k; i++) {
                                JSONObject dataInfor = getData.getJSONObject(i);
                                Log.d("dataInfor", dataInfor.toString());
                                JSONObject user = dataInfor.getJSONObject("user");
                                Log.d("user post", user.toString());
                                data.add(new Data(
                                        dataInfor.getString("created_at"),
                                        user.getString("username"),
                                        0,
                                        dataInfor.getString("address"),
                                        dataInfor.getString("acreage")+"  mét vuông",
                                        dataInfor.getString("description"),
                                        "700 000"+" đ",
                                        dataInfor.getInt("id")
                                ));
                                mAdapter.notifyDataSetChanged();
                            }
                        }catch(JSONException e){
                                e.printStackTrace();
                            }
                        }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(),error.toString(),Toast.LENGTH_SHORT).show();
//                        Log.d("error cho thue",error.toString());
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);

        Log.d("cho thue","vao add jsonarray");
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text=adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
