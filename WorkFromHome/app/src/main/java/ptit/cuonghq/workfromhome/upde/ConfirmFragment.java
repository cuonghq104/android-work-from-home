package ptit.cuonghq.workfromhome.upde;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ptit.cuonghq.workfromhome.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmFragment extends Fragment {

    RecyclerView rvConfirm;
    ConfirmAdapter adapter;
    List<String> list;

    public ConfirmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_confirm, container, false);
        rvConfirm = view.findViewById(R.id.rv_confirm);
        adapter = new ConfirmAdapter(ConfirmFragment.this);
        rvConfirm.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        list.add("Dù");
        list.add("Ngày");
        list.add("Mai");
        list.add("Sóng");
        list.add("Gió");
        adapter.setList(list);
        rvConfirm.setAdapter(adapter);
        return view;
    }

    public void confirm(String title) {
        list.add(0, title);
        adapter.notifyItemInserted(0);
    }
}
