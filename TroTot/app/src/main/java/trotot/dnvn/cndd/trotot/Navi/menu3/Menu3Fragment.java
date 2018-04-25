package trotot.dnvn.cndd.trotot.Navi.menu3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import trotot.dnvn.cndd.trotot.R;


public class Menu3Fragment extends Fragment {
    private Button mButtonRoomManager;

    public Menu3Fragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_menu3, container, false);
        mButtonRoomManager=rootView.findViewById(R.id.button_room_manage);

        mButtonRoomManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return rootView;
    }

}
