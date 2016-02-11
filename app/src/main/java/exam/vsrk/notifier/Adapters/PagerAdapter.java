package exam.vsrk.notifier.Adapters;

/**
 * Created by VSRK on 12/22/2015.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import exam.vsrk.notifier.Fragments.AppNotificationsFragment;
import exam.vsrk.notifier.Fragments.AroundMeFragment;
import exam.vsrk.notifier.Fragments.OtherAppNotificationsFragment;
import exam.vsrk.notifier.Fragments.PhoneNotificationsFragment;


/**
 * Created by VSRK on 10/20/2015.
 */
//import android.support.v4.app.Fragment;


public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                AppNotificationsFragment tab1 = new AppNotificationsFragment();
                return tab1;

            case 1:
                AroundMeFragment tab2 = new AroundMeFragment();
                return tab2;
            case 2:
                OtherAppNotificationsFragment tab3=new OtherAppNotificationsFragment();
                return tab3;
            case 3:
                PhoneNotificationsFragment tab4=new PhoneNotificationsFragment();
                return tab4;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}