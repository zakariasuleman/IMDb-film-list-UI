import java.util.Arrays;
import java.util.Iterator;

public class MovieList implements Iterable<Movie> {

    private Movie[] movieList;
    private int beginningIndex = 0;

    /**
     * creates and caps the listSize for the array to make sure it doesn't go over that
     * @param listSize - asks constructor how big is list
     */
    public MovieList(int listSize){

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
     * This methods removes the selected index from the array of objects, if not there the error is handled
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
     * This method searches for the object that is searched by the Searchable string button on the UI
     * @param target is to see if the movie object is in the list currently
     * @return the currentFilm if found a movie or null if program hasn't found anything
     */
    public Movie search(String target){

        Iterator<Movie> iter = iterator();
        while (iter.hasNext()) {
            Movie currentFilm = iter.next();

            if (currentFilm != null) {
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
        Iterator<Movie> iter = iterator();
        while (iter.hasNext()) {
            Movie movie = iter.next();
            if(movie != null) {
                descFilm += movie.toString() + "\n";
            }
        }
        return descFilm;
    }

    @Override
    /**
     * Method to iterate through our array of movies. see more in the ListIterator class
     * @return returns an iterated list of movieList
     */
    public Iterator<Movie> iterator() {
        return new ListIterator<Movie>(movieList);
    }

    /**
     *This method was used for sorting a new array out to sort by releaseDates (int) it couldn't have happened without
     * the Comparable interface we implemented in the Movie class. In order to get Arrays.sort() to work, there
     * couldn't be any null values in the sort range
     * so a for loop was written to copy the old array into a new one and filter out any null values in between
     */
    public void sortByDate(){

        Movie[] newList = new Movie[movieList.length];
        Movie film;

        int newIndex = 0;

        for(int originalIndex = 0; originalIndex<beginningIndex; originalIndex++){

            if(movieList[originalIndex]!=null){
                film = movieList[originalIndex];
                newList[newIndex] = film;
                newIndex++;
            }else{

            }

        }
        //new empty array
        movieList = newList;
        //the index of the first null value in the new array
        beginningIndex = newIndex;
        Arrays.sort(movieList, 0, beginningIndex);

    }
}