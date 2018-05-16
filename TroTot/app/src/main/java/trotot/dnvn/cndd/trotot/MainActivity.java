package trotot.dnvn.cndd.trotot;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import trotot.dnvn.cndd.trotot.Activities.LoginActivity;
import trotot.dnvn.cndd.trotot.Fragment.Menu4Fragment;
import trotot.dnvn.cndd.trotot.Fragment.Menu5Fragment;
import trotot.dnvn.cndd.trotot.Model.Account;
import trotot.dnvn.cndd.trotot.Fragment.Menu1Fragment;
import trotot.dnvn.cndd.trotot.Fragment.Menu2Fragment;
import trotot.dnvn.cndd.trotot.Fragment.Menu3Fragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView mTextViewUsernameNaviHeader;
    private TextView mTextViewEmailNaviHeader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        try{
            setSupportActionBar(toolbar);
        }catch (Exception e){
        }
        Log.d("log"," test bug2");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        mTextViewUsernameNaviHeader=headerView.findViewById(R.id.usernameNaviHeader);
        mTextViewEmailNaviHeader=headerView.findViewById(R.id.emailNaviHeader);

        Intent intent=getIntent();
        SharedPreference sharedPreference=new SharedPreference(this);
        Account account=(Account) sharedPreference.getUserLogin();

        mTextViewEmailNaviHeader.setText(account.getEmail());
        mTextViewUsernameNaviHeader.setText(account.getUserName());

        displayNavigation(R.id.nav_home);
        Log.d("test3","chạy hết create");
    }


    @Override
    public void onBackPressed() {
        Log.d("test4","chạy back press");
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        Log.d("test5","chạy option menu");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.logout) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
        Log.d("test6","chạy option item selected");
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        displayNavigation(id);
        return true;
    }

    private void displayNavigation(int id) {

        Fragment fragment;
        if (id == R.id.nav_home) {
            fragment=new Menu1Fragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, fragment);
            ft.commit();

        } else if (id == R.id.nav_add) {
            fragment=new Menu2Fragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, fragment);
            ft.commit();

        } else if (id == R.id.nav_money) {

        } else if (id == R.id.nav_manage) {
            fragment=new Menu3Fragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, fragment);
            ft.commit();

        } else if (id == R.id.nav_about) {
            fragment=new Menu4Fragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, fragment);
            ft.commit();
        } else if (id == R.id.nav_support) {
            fragment=new Menu5Fragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

}
