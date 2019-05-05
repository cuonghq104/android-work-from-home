package ptit.cuonghq.workfromhome.viewpager_inside_fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import ptit.cuonghq.workfromhome.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PagerFragment extends Fragment {

    ViewPager vp;
    TabLayout tl;
    PagerAdapter mAdapter;

    public PagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pager, container, false);
        vp = view.findViewById(R.id.vp_home);
        tl = view.findViewById(R.id.tl_home);
        mAdapter = new PagerAdapter(getChildFragmentManager());
        vp.setAdapter(mAdapter);
        tl.setupWithViewPager(vp);
        return view;
    }

    public void showToash(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

}
