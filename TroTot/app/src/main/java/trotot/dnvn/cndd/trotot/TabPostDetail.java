package trotot.dnvn.cndd.trotot;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
public class TabPostDetail extends FragmentStatePagerAdapter {
    public TabPostDetail(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position) {
            case 0 :
                frag=new fragment_post_detail_first();
                break;
            case 1 :
                frag=new fragment_post_detail_second();
                break;
            case 2 :
                frag=new fragment_post_detail_third();
                break;
        }
        return frag;
    }


    @Override
    public int getCount() {
        return 3;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title="";
        switch (position){
            case 0:
                title="First";
                break;
            case 1:
                title="Two";
                break;
            case 2:
                title="Three";
                break;
        }
        return title;
    }
}
