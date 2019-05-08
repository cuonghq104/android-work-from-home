package ptit.cuonghq.workfromhome.youtube;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.lang.reflect.Field;
import java.util.List;

import ptit.cuonghq.workfromhome.R;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.GenreViewHolder> {

    List<String> genres;
    private Context mContext;

    public GenreAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GenreViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.genre_item, viewGroup, false);
        return new GenreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreViewHolder genreViewHolder, int i) {
        String genre = genres.get(i);
        genreViewHolder.bind(genre);
    }

    @Override
    public int getItemCount() {
        return (genres == null) ? 0 : genres.size();
    }

    class GenreViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView mTvGenre;
        AppCompatImageView mIvGenre;
        LinearLayout mLlGenre;

        public GenreViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvGenre = itemView.findViewById(R.id.tv_genre);
            mIvGenre = itemView.findViewById(R.id.iv_genre);
            mLlGenre = itemView.findViewById(R.id.ll_genre);
        }

        void bind(String genre) {
            mTvGenre.setText(genre);
            mIvGenre.setImageResource(getId("genre_" + genre.toLowerCase().replace(" ", "_") + "_icon", R.drawable.class));
            mLlGenre.setBackgroundResource(getId("genre_" + genre.toLowerCase().replace(" ", "_") + "_bg", R.drawable.class));
        }

        public int getId(String resourceName, Class<?> c) {
            try {
                Field idField = c.getDeclaredField(resourceName);
                return idField.getInt(idField);
            } catch (Exception e) {
                throw new RuntimeException("No resource ID found for: "
                        + resourceName + " / " + c, e);
            }
        }

    }
}
