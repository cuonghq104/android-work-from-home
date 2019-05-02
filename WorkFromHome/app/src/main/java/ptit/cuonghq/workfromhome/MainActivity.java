package ptit.cuonghq.workfromhome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRvMovie;
    List<SavedMovie> movies;
    private SavedMovieAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        movies = new ArrayList<>();
        movies.add(new SavedMovie(1,
                "Avengers: Endgame",
                "2019-04-24",
                "https://image.tmdb.org/t/p/w1280/7RyHsO4yDXtBv1zUU3mTpHeQ0d5.jpg",
                "12",
                "Marvel Studio",
                "8.8"));
        movies.add(new SavedMovie(1,
                "Captain Marvel",
                "2019-03-06",
                "https://image.tmdb.org/t/p/w1280/w2PMyoyLU22YvrGK3smVM9fW1jj.jpg",
                "28",
                "Marvel Studio",
                "7.1"));
        movies.add(new SavedMovie(1,
                "Glass",
                "2019-01-16",
                "https://image.tmdb.org/t/p/w1280/lvjscO8wmpEbIfOEZi92Je8Ktlg.jpg",
                "53",
                "Sony Picture",
                "6.5"));

        mAdapter = new SavedMovieAdapter(getApplicationContext());
        mAdapter.setMovies(movies);
        mRvMovie.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRvMovie.setAdapter(mAdapter);
    }

    private void initView() {
        mRvMovie = findViewById(R.id.rv_movie);
    }
}
