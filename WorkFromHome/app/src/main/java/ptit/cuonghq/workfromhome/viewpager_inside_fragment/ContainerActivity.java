package ptit.cuonghq.workfromhome.viewpager_inside_fragment;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import ptit.cuonghq.workfromhome.R;

public class ContainerActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    FrameLayout flContainer;
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        flContainer = findViewById(R.id.fl_container);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(this);
        changeFragment(new PagerFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_red:
                changeFragment(new PagerFragment());
                break;
            case R.id.menu_orange:
                changeFragment(R.color.colorOrange);
                break;
            case R.id.menu_yellow:
                changeFragment(R.color.colorYellow);
                break;
            default:
                break;
        }
        return true;
    }

    public void changeFragment(int color) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, ColorFragment.create(color))
                .commit();
    }

    public void changeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, fragment)
                .commit();
    }

}
