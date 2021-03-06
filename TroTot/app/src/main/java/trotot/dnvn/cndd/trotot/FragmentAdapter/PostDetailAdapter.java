package trotot.dnvn.cndd.trotot.FragmentAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import trotot.dnvn.cndd.trotot.Fragment.PostDetailFirstFragment;
import trotot.dnvn.cndd.trotot.Fragment.PostDetailSecondFragment;
import trotot.dnvn.cndd.trotot.Fragment.PostDetailThirdFragment;

public class PostDetailAdapter extends FragmentStatePagerAdapter{
    int mNumOfTabs;

    public PostDetailAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                PostDetailSecondFragment tab2 = new PostDetailSecondFragment();
                return tab2;
            case 1:
                PostDetailThirdFragment tab3 = new PostDetailThirdFragment();
                return tab3;
            case 2:
                PostDetailFirstFragment tab1 = new PostDetailFirstFragment();
                return tab1;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
