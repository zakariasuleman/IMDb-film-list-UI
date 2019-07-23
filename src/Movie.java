/* implementing Cloneable and Comparable of a Movie object */
public class Movie implements Cloneable, Comparable<Movie> {

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

    /**
     *
     * @return will return the same copy of the object with the same characteristics ; will later be used in the jAVAfx to copy and put into
     * the array of the list
     * @throws CloneNotSupportedException
     */
    public Object clone() throws
            CloneNotSupportedException
    {
        return super.clone();
    }

    @Override
    /**
     * @return will create a format for the list of data
     */
    public String toString() {
        return
                "["+"Film: " + filmName + ", " + " Director: " + director + ", " + " Awards Won: " + awardsWon +", "+ "Release Date: " + releaseDate +", " + "Film Rating: " + filmRating+"]";
    }

    /**
     * @param  otherMovie this methods compares two objects's
     * releaseDate to further sort the list in the compareTo method
     * @return the subtraction of the two movie's to sort the releaseDates
     */
    @Override
    public int compareTo(Movie otherMovie) {

        return this.getReleaseDate()-otherMovie.getReleaseDate();
    }
}
