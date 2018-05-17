package trotot.dnvn.cndd.trotot.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import trotot.dnvn.cndd.trotot.Model.FileTransfer;
import trotot.dnvn.cndd.trotot.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PostDetailThirdFragment extends Fragment implements OnMapReadyCallback{

    private GoogleMap mMap;
    private static double lat,lon;
    private String name;
    public PostDetailThirdFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_post_detail_third, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapDetail);
        mapFragment.getMapAsync(this);

        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {


        LatLng current = new LatLng(lat, lon);
        mMap = googleMap;
        mMap.addMarker(new MarkerOptions().position(current).title(name));
        CameraPosition cp = new CameraPosition.Builder().target(current).zoom(16).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
    }

    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(FileTransfer fileTransfer) {
        lat=fileTransfer.getData().get(0).getLatitude();
        lon=fileTransfer.getData().get(0).getLongitude();
        name=fileTransfer.getData().get(0).getName();
        EventBus.getDefault().removeStickyEvent(fileTransfer);
    }
}