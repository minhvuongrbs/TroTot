package trotot.dnvn.cndd.trotot.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

import trotot.dnvn.cndd.trotot.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PostDetailThirdFragment extends Fragment implements OnMapReadyCallback{

    private GoogleMap mMap;
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
        LatLng hcm = new LatLng(10.762622, 106.660172);
        mMap = googleMap;
        mMap.addMarker(new MarkerOptions().position(hcm).title("Minh Vương").snippet("demo tp hcm"));
        CameraPosition cp = new CameraPosition.Builder().target(hcm).zoom(13).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
    }
}