package ptit.cuonghq.workfromhome.upde;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class HomePagerAdapter extends FragmentStatePagerAdapter {

    private Context context;
    private BookingFragment bookingFragment;
    private ConfirmFragment confirmFragment;
    private CompleteFragment completeFragment;

    public HomePagerAdapter(Context context, FragmentManager fm, BookingFragment bookingFragment, ConfirmFragment confirmFragment, CompleteFragment completeFragment) {
        super(fm);
        this.context = context;
        this.bookingFragment = bookingFragment;
        this.confirmFragment = confirmFragment;
        this.completeFragment = completeFragment;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return bookingFragment;
            case 1:
                return confirmFragment;
            case 2:
                return completeFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
