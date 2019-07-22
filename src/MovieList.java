import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class MovieList implements Iterable<Movie> {

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
/*
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
*/
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
    /*
    public String display(){

            String descFilm= "";

            for(int i = 0; i < movieList.length; i++){
                if(movieList[i]!=null) {
                    descFilm += movieList[i].toString() + "";
                }
            }
            return descFilm;
        }
    */
    @Override
    public Iterator<Movie> iterator() {
        return new ListIterator<Movie>(movieList);
    }

    public void sortByDate(){
        //The overview:
        int listSize = 10;
        //You want to sort your movieList array using compareTo()
        //There's a method that will make this really easy:
        //Arrays.sort(movieList, 0, beginningIndex)
        Arrays.sort(movieList, 0, beginningIndex);
        //You'll need to ask your IDE to import Arrays
        //The trouble with this is that it won't work if there are null values in your array
        //So you'll need to take out the null values first.

        //The steps:
        //1. Get rid of the null values
        //      - create a new array of the same size as movieList
        Movie[] newList = new Movie[listSize];


        //      - copy everything from the old movieList into the new movieList
        //				- don't copy over null values! Make sure there are no nulls between each Movie
        //				- it's ok if there are null values at the very end
        //      - set movieList = your new array with no null values
        //		- set beginningIndex = the new beginningIndex (the index of the first null value in your new array)
        //2. Call Arrays.sort(movieList, 0, beginningIndex)
        if(newList!=null) {

            Arrays.sort(movieList, 0, beginningIndex);
        }
    }
}



