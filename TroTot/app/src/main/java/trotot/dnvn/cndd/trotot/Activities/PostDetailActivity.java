package trotot.dnvn.cndd.trotot.Activities;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import trotot.dnvn.cndd.trotot.Fragment.PostDetailSecondFragment;
import trotot.dnvn.cndd.trotot.FragmentAdapter.PostDetailAdapter;
import trotot.dnvn.cndd.trotot.MainActivity;
import trotot.dnvn.cndd.trotot.Model.Data;
import trotot.dnvn.cndd.trotot.Model.FileTransfer;
import trotot.dnvn.cndd.trotot.R;

import static trotot.dnvn.cndd.trotot.Activities.LoginActivity.SERVER;

public class PostDetailActivity extends AppCompatActivity{
    private static String API="api/v1/post-room";
    private static String LINK = SERVER+API;
    private static int idPost;
    private List<Data> data=new ArrayList<>();


    public interface OnSelectedListener {
        public void onSelected(String value);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        Log.d("test api","dong nay nhan kg");
        idPost=getIntent().getIntExtra("idPost",0);
        Log.d("test api",Integer.toString(idPost));
        getThing();
    }

    private void getThing() {
        final RequestQueue requestQueue=Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, LINK+"/"+idPost, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject getDatabase=response.getJSONObject("data");
                    JSONObject user=getDatabase.getJSONObject("user");
                    Log.d("tag", getDatabase.toString());
                    JSONArray galleryA=getDatabase.getJSONArray("gallery");
                    JSONObject gallery=galleryA.getJSONObject(0);
                    data.add(new Data(
                            getDatabase.getString("created_at"),
                            user.getString("username"),
                            gallery.getString("path"),
                            getDatabase.getString("address"),
                            getDatabase.getString("acreage"),
                            getDatabase.getString("description"),
                            getDatabase.getString("rate"),
                            getDatabase.getInt("id"),
                            getDatabase.getDouble("longitude"),
                            getDatabase.getDouble("latitude"),
                            user.getString("name"),
                            getDatabase.getString("phone"),
                            getDatabase.getString("water_bill"),
                            getDatabase.getString("electric_bill"),
                            user.getString("image")
                    ));
                    Log.d("data",data.toString());
                    EventBus.getDefault().postSticky(new FileTransfer(data));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        requestQueue.add(jsonObjectRequest);

    }

    private void init() {
        setContentView(R.layout.activity_post_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.post_detail_third_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundResource(R.color.toobar);
        getSupportActionBar().setTitle("Trở lại");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

        TabLayout tabLayout = (TabLayout) findViewById(R.id.post_detail_tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Thông tin"));
        tabLayout.addTab(tabLayout.newTab().setText("Bản đồ"));
        tabLayout.addTab(tabLayout.newTab().setText("Nhận xét"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.post_detail_pager);
        final PostDetailAdapter adapter = new PostDetailAdapter(
                getSupportFragmentManager(),tabLayout.getTabCount()
        );
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}