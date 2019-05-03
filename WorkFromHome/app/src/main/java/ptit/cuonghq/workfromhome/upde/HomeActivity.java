package ptit.cuonghq.workfromhome.upde;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ptit.cuonghq.workfromhome.R;

public class HomeActivity extends AppCompatActivity {

    ViewPager vpHome;
    private BookingFragment mBookingFragment;
    private CompleteFragment mCompleteFragment;
    private ConfirmFragment mConfirmFragment;
    private HomePagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        vpHome = findViewById(R.id.vp_home);
        mBookingFragment = new BookingFragment();
        mConfirmFragment = new ConfirmFragment();
        mCompleteFragment = new CompleteFragment();
        adapter = new HomePagerAdapter(getApplicationContext(), getSupportFragmentManager(), mBookingFragment, mConfirmFragment, mCompleteFragment);
        vpHome.setAdapter(adapter);
        vpHome.setOffscreenPageLimit(3);
    }

    public void confirm(String title) {
        mConfirmFragment.confirm(title);
    }
}
