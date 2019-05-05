package ptit.cuonghq.workfromhome.viewpager_inside_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import ptit.cuonghq.workfromhome.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment implements View.OnClickListener {

    RelativeLayout flContainer;
    Button btnAction;

    public static ColorFragment create(int color) {
        return create(color, false);
    }

    public static ColorFragment create(int color, boolean showButton) {
        ColorFragment fragment = new ColorFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("color", color);
        bundle.putBoolean("showButton", showButton);
        fragment.setArguments(bundle);
        return fragment;
    }

    public ColorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_color, container, false);
        flContainer = view.findViewById(R.id.fl_container);
        btnAction = view.findViewById(R.id.btn_action);
        Bundle bundle = getArguments();
        int color = bundle.getInt("color");
        boolean showButton = bundle.getBoolean("showButton");
        if (showButton)
            btnAction.setVisibility(View.VISIBLE);
        flContainer.setBackgroundColor(getContext().getColor(color));
        btnAction.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_action: {
                Fragment fragment = getParentFragment();
                if (fragment instanceof PagerFragment) {
                    ((PagerFragment) fragment).showToash("Congratulation");
                }

            }
        }
    }
}
