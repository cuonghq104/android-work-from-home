package ptit.cuonghq.workfromhome;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SavedMovieAdapter extends RecyclerView.Adapter<SavedMovieAdapter.SavedMovieViewHolder> {

    List<SavedMovie> movies;
    Context mContext;

    public SavedMovieAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setMovies(List<SavedMovie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SavedMovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View mView = inflater.inflate(R.layout.activity_save_movie_item, viewGroup, false);
        return new SavedMovieViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull SavedMovieViewHolder savedMovieViewHolder, int i) {
        SavedMovie movie = movies.get(i);
        savedMovieViewHolder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return (movies == null) ? 0 : movies.size();
    }

    class SavedMovieViewHolder extends RecyclerView.ViewHolder {

        SavedMovie movie;
        AppCompatTextView mTvTitle, mTvRating, mTvReleasedDate, mTvGenre, mTvProductCompany;
        AppCompatImageView mImvBackdrop;

        public SavedMovieViewHolder(@NonNull View itemView) {
            super(itemView);
            initView();
        }

        private void initView() {
            mTvTitle = itemView.findViewById(R.id.tv_title);
            mTvRating = itemView.findViewById(R.id.tv_rating);
            mTvReleasedDate = itemView.findViewById(R.id.tv_released_date);
            mTvGenre = itemView.findViewById(R.id.tv_genre);
            mTvProductCompany = itemView.findViewById(R.id.tv_company);
            mImvBackdrop = itemView.findViewById(R.id.imv_movie);
        }

        private void bind(SavedMovie movie) {
            this.movie = movie;
            setupUI();
        }

        private void setupUI() {
            mTvTitle.setText(movie.getTitle());
            mTvProductCompany.setText(movie.getCompany());
            mTvGenre.setText(movie.getGenre());
            mTvReleasedDate.setText(movie.getReleasedDate());
            mTvRating.setText(movie.getRating());
            Picasso.with(mContext)
                    .load(movie.getBackDropPath())
                    .into(mImvBackdrop);
        }
    }
}
