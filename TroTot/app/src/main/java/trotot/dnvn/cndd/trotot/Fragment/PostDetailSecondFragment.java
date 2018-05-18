package trotot.dnvn.cndd.trotot.Fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import trotot.dnvn.cndd.trotot.Activities.PostDetailActivity;
import trotot.dnvn.cndd.trotot.Model.Data;
import trotot.dnvn.cndd.trotot.Model.FileTransfer;
import trotot.dnvn.cndd.trotot.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PostDetailSecondFragment extends Fragment {
    private TextView mTextViewAddress, mTextViewArea, mTextViewElectricRate, mTextViewWaterRate, mTextViewDescribe, mTextViewPhone,mTextViewRate,mTextViewName;

    public PostDetailSecondFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_post_detail_second, container, false);
        mTextViewAddress=rootView.findViewById(R.id.second_address);
        mTextViewArea=rootView.findViewById(R.id.second_area);
        mTextViewWaterRate=rootView.findViewById(R.id.second_water);
        mTextViewDescribe=rootView.findViewById(R.id.second_des);
        mTextViewPhone=rootView.findViewById(R.id.second_phone);
        mTextViewName=rootView.findViewById(R.id.second_name);
        mTextViewRate=rootView.findViewById(R.id.second_rate);
        mTextViewElectricRate=rootView.findViewById(R.id.second_elec);

//        String username=getArguments().getString("username");
//        mTextViewAddress.setText(username);
        return rootView;
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
        Log.d("second", fileTransfer.getData().get(0).getAddress());

        mTextViewAddress.setText(fileTransfer.getData().get(0).getAddress());
        mTextViewArea.setText(fileTransfer.getData().get(0).getArea()+" m2");
        mTextViewWaterRate.setText(fileTransfer.getData().get(0).getWater_bill()+" đ");
        mTextViewDescribe.setText(fileTransfer.getData().get(0).getDescribe());
        mTextViewPhone.setText(fileTransfer.getData().get(0).getPhone());
        mTextViewName.setText(fileTransfer.getData().get(0).getName());
        mTextViewRate.setText(fileTransfer.getData().get(0).getRate()+" đ");
        mTextViewElectricRate.setText(fileTransfer.getData().get(0).getElectric_bill()+" đ");

        EventBus.getDefault().removeStickyEvent(fileTransfer);
    }
}
