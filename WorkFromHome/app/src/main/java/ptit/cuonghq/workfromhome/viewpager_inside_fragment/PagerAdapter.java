package ptit.cuonghq.workfromhome.viewpager_inside_fragment;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import ptit.cuonghq.workfromhome.R;

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return ColorFragment.create(R.color.colorGreen, true);
            case 1:
                return ColorFragment.create(R.color.colorBlue, true);
            case 2:
                return ColorFragment.create(R.color.colorTeal);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Green";
            case 1:
                return "Blue";
            case 2:
                return "Teal";
        }
        return "";
    }
}
