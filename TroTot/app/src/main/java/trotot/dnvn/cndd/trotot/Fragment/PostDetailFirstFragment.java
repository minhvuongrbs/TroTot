package trotot.dnvn.cndd.trotot.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import trotot.dnvn.cndd.trotot.Model.FileTransfer;
import trotot.dnvn.cndd.trotot.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PostDetailFirstFragment extends Fragment {


    public PostDetailFirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_post_detail_first, container, false);
    }

    @Override
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
        Log.d("tag1", fileTransfer.getData().get(0).getAddress());

        EventBus.getDefault().removeStickyEvent(fileTransfer);
    }
}
