package ptit.cuonghq.workfromhome.upde;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ptit.cuonghq.workfromhome.R;

public class ConfirmAdapter extends  RecyclerView.Adapter<ConfirmAdapter.BookingViewHolder> {

    private List<String> list;
    private ConfirmFragment fragment;

    public ConfirmAdapter(ConfirmFragment fragment) {
        this.fragment = fragment;
    }

    public void setList(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_confirm, viewGroup, false);
        return new BookingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingViewHolder bookingViewHolder, int i) {
        bookingViewHolder.bind(list.get(i));
    }

    @Override
    public int getItemCount() {
        return (list == null) ? 0 : list.size();
    }

    class BookingViewHolder extends RecyclerView.ViewHolder {

        private AppCompatTextView tvTitle;
        private String title;

        public BookingViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }

        void bind(String title) {
            this.title = title;
            tvTitle.setText(title);
        }
    }
}
