import javafx.scene.text.Font;

public class Movie {

    private String filmName;
    private String director;
    private int awardsWon;
    private int releaseDate;
    private double filmRating;


    public Movie(String filmName, String director, int awardsWon, int releaseDate,double filmRating) {
        this.awardsWon = awardsWon;
        this.director = director;
        this.filmRating = filmRating;
        this.filmName = filmName;
        this.releaseDate = releaseDate;
    }

    public int getAwardsWon() {
        return awardsWon;
    }

    public void setAwardsWon(int awardsWon) {
        this.awardsWon = awardsWon;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getFilmRating() {
        return filmRating;
    }

    public void setFilmRating(double filmRating) {
        this.filmRating = filmRating;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return
                "["+"Film: " + filmName + ", " + " Director: " + director + ", " + " Awards Won: " + awardsWon +", "+ "Release Date: " + releaseDate +", " + "Film Rating: " + filmRating+"]";
    }
}
