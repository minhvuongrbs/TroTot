package trotot.dnvn.cndd.trotot.Activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import trotot.dnvn.cndd.trotot.FragmentAdapter.PostDetailAdapter;
import trotot.dnvn.cndd.trotot.R;

public class PostDetailActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
////        getSupportActionBar().hide();
//        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.post_detail_tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Giới thiệu"));
        tabLayout.addTab(tabLayout.newTab().setText("Thông tin"));
        tabLayout.addTab(tabLayout.newTab().setText("Bản đồ"));
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