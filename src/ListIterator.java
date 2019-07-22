import java.util.Iterator;

class ListIterator<Movie> implements Iterator<Movie> {
    private int current;
    private Movie[] movieList;

    // initialize pointer to head of the list for iteration 
    public ListIterator(Movie[] list)
    {
        movieList = list;
        current = 0;
    }

    // returns false if next element does not exist 
    public boolean hasNext()
    {
        return current < movieList.length;
    }

    // return current data and update pointer 
    public Movie next()
    {
        return movieList[current++];
    }

    // implement if needed 
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
} 