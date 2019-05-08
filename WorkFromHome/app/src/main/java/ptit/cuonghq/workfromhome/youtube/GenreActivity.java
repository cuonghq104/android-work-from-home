package ptit.cuonghq.workfromhome.youtube;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;

import java.util.Arrays;

import ptit.cuonghq.workfromhome.R;

public class GenreActivity extends AppCompatActivity {

    RecyclerView rvGenre;
    String[] genres = new String[]{
            "Action",
            "Adventure",
            "Animation",
            "Comedy",
            "Crime",
            "Documentary",
            "Drama",
            "Family",
            "Fantasy",
            "History",
            "Horror",
            "Music",
            "Mystery",
            "Romance",
            "Science Fiction",
            "TV Movie",
            "Thriller",
            "War",
            "Western"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);
        rvGenre = findViewById(R.id.rv_genre);

        GenreAdapter adapter = new GenreAdapter(this);
        adapter.setGenres(Arrays.asList(genres));
        int numOfColumns = calculateNoOfColumns(this, 150);
        rvGenre.setLayoutManager(new GridLayoutManager(this, numOfColumns));
        rvGenre.setAdapter(adapter);
    }

    public int calculateNoOfColumns(Context context, float columnWidthDp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (screenWidthDp / columnWidthDp + 0.5); // +0.5 for correct rounding to int.
        return noOfColumns;
    }

}
