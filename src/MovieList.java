import java.util.Arrays;

public class MovieList {

    private Movie[] movieList;
    private int beginningIndex = 0;

    /**
     *
     * @param listSize - asks constructor how big is list
     */
    MovieList(int listSize){

        this.movieList = new Movie[listSize];

    }

    /**
     *
     * @param film
     * @return a boolean if it was added or not
     */
    public boolean add(Movie film){

        boolean added = false;

        if(beginningIndex>=movieList.length) {

            //return false
            added = false;

        }
        else {
            movieList[beginningIndex] = film;
            beginningIndex++;
            added = true;
        }
        //return whether it's added it
        return added;
    }

    /**
     *
     * @param film the title of the film to remove
     * @return the movie object that was removed or if no movie object found then return null
     */
    public Movie remove(String film){

        for(int i = 0; i<movieList.length; i++){

            Movie currentFilm = movieList[i];

            if (movieList[i]!=null) {
                String movieName = currentFilm.getFilmName();
                if(film.equalsIgnoreCase(movieName)){
                    movieList[i]= null;
                    //if we've made it here, we've found the correct Movie object
                    return currentFilm;
                }
            }
        }
        return null;
    }

    /**
     *
     * @param target is to see if the movie object is in the list currently
     * @return the currentFilm if found a movie or null if program hasn't found anything
     */
    public Movie search(String target){

        for(int i = 0; i<movieList.length; i++){

            Movie currentFilm = movieList[i];

            //check to see if the list exists
            if (movieList[i]!=null) {
                String movieName = currentFilm.getFilmName();
                if(target.equalsIgnoreCase(movieName)){
                    return currentFilm;
                }
            }
        }

        //found nothing
        return null;
    }

    /**
     * Displays on a big String each film object
     * @return descFilm a big string of the film objects
     */
    public String display(){

        String descFilm= "";

        for(int i = 0; i < movieList.length; i++){
            if(movieList[i]!=null) {
                descFilm += movieList[i].toString() + "\n";
            }
        }
        return descFilm;
    }
}
