package trotot.dnvn.cndd.trotot;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fragment_post_detail_first extends Fragment {

    public fragment_post_detail_first(){}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_post_detail_1,container,false);
    }
}
