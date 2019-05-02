package ptit.cuonghq.workfromhome;

public class SavedMovie {

    private int id;
    private String title;
    private String releasedDate;
    private String backDropPath;
    private String genre;
    private String company;
    private String rating;

    public SavedMovie() {
    }

    public SavedMovie(int id, String title, String releasedDate, String backDropPath, String genre, String company, String rating) {
        this.id = id;
        this.title = title;
        this.releasedDate = releasedDate;
        this.backDropPath = backDropPath;
        this.genre = genre;
        this.company = company;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(String releasedDate) {
        this.releasedDate = releasedDate;
    }

    public String getBackDropPath() {
        return backDropPath;
    }

    public void setBackDropPath(String backDropPath) {
        this.backDropPath = backDropPath;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
