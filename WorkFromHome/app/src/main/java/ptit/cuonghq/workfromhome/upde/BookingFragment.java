package ptit.cuonghq.workfromhome.upde;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
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
public class BookingFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private HomeActivity activity;

    RecyclerView rvBooking;
    BookingAdapter adapter;
    List<String> list;
    SwipeRefreshLayout srlRefresh;

    public BookingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_booking, container, false);
        rvBooking = view.findViewById(R.id.rv_booking);
        adapter = new BookingAdapter(BookingFragment.this);
        srlRefresh = view.findViewById(R.id.srl_refresh);
        rvBooking.setLayoutManager(new LinearLayoutManager(getContext()));
        srlRefresh.setOnRefreshListener(this);
        list = new ArrayList<>();
        list.add("Từ");
        list.add("Ngày");
        list.add("Em");
        list.add("Đến");
        list.add("Ánh");
        list.add("Nắng");
        adapter.setList(list);
        rvBooking.setAdapter(adapter);
        return view;
    }

    public void changeStatus(String title) {
        int position = list.indexOf(title);
        list.remove(position);
        adapter.notifyItemRemoved(position);
        Activity appCompatActivity = getActivity();
        if (appCompatActivity instanceof HomeActivity) {
            ((HomeActivity) appCompatActivity).confirm(title);
        }
    }

    @Override
    public void onRefresh() {
        list = new ArrayList<>();
        list.add("Từ");
        list.add("Ngày");
        list.add("Em");
        list.add("Đến");
        list.add("Ánh");
        list.add("Nắng");
        if (adapter != null) {
            adapter.setList(list);
        }
        srlRefresh.setRefreshing(false);
    }
}
