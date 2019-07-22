import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 A list management program that implements an array of objects made from an object class (Movie). In that list of objects, user can
 remove, add, edit, and search. The searchable string we use is the film name and that is what is only allowed by the input of the textField
 (javaFX). The user interface is very easy to use and quick. Buttons on the UI have a task that can be understood just by reading them.
 @author: Zakaria Suleman
 @version: 1.0
 @due: 06/25/2019
 @borrowedcode: Lines URL: https://docs.oracle.com/javafx/2/get_started/form.htm#CFHIJGHC (Fig 2-2)
 */

public class MainClass extends Application {

    MovieList movieList = emptyList();

    public static void main(String[] args) {

        launch(args);
    }

    /**
     * In this start method all the button characteristics and positions are declared and instantiated. Also inside there is setAction methods
     * with handles to put an action and a call back to the movieList class for the methods I wrote. i.e Remove, Add, Search, and AddDefaultData.
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {

        GridPane grid = new GridPane();
        primaryStage.setTitle("Top Ten Films");
        TextField searchKey = new TextField("");
        TextField directorKey = new TextField("");
        TextField awardsKey = new TextField("");
        TextField releaseKey = new TextField("");
        TextField ratingKey = new TextField("");
        Label filmLabel = new Label(" Enter Film Name");
        Label dirLabel = new Label(" Enter Film Director");
        Label awardsLabel = new Label(" Enter Film Awards");
        Label yearLabel = new Label(" Enter Film Year");
        Label ratingLabel = new Label(" Enter Film Rating");


        Button btnAddDefaultData = new Button("Default Data");
        Button btnAdd = new Button("Add film (edited or non-edited)");
        Button btnRemove = new Button("Remove by Film Name");
        Button btnSearch = new Button("Search by Film Name");
        Button btnCopy = new Button("Clone Film");
        Button btnSort = new Button("Sort by date");


        TextArea list = new TextArea(movieList.display());
        grid.add(list, 0, 0);
        grid.add(btnAddDefaultData, 0, 1);
        grid.add(searchKey, 0, 8);
        grid.add(directorKey, 0, 9);
        grid.add(awardsKey, 0, 10);
        grid.add(releaseKey, 0, 11);
        grid.add(ratingKey, 0, 12);
        grid.add(filmLabel, 0, 8);
        grid.add(dirLabel, 0, 9);
        grid.add(awardsLabel, 0, 10);
        grid.add(yearLabel, 0, 11);
        grid.add(ratingLabel, 0, 12);
        grid.add(btnAdd, 0, 3);
        grid.add(btnSearch, 0, 2);
        grid.add(btnRemove, 0, 4);
        grid.add(btnCopy, 0, 5);
        grid.add(btnSort, 0, 6);
        searchKey.setAlignment(Pos.TOP_RIGHT);
        directorKey.setAlignment(Pos.TOP_RIGHT);
        awardsKey.setAlignment(Pos.TOP_RIGHT);
        releaseKey.setAlignment(Pos.TOP_RIGHT);
        ratingKey.setAlignment(Pos.TOP_RIGHT);


        //setOnAction method puts a method call to a button
        btnAddDefaultData.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * Default data action button
             * @param event
             */
            @Override
            public void handle(ActionEvent event) {

                movieList = dataList();
                movieList.display();
                list.setText(movieList.display());
            }
        });
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * Add button action
             * @param event
             *
             */
            @Override
            public void handle(ActionEvent event) {
                String typedName = searchKey.getText();
                String typedDirector = directorKey.getText();
                try {
                    int getFilmAwards = Integer.parseInt(awardsKey.getText());
                    int getFilmYear = Integer.parseInt(releaseKey.getText());
                    double getFilmRating = Double.parseDouble(ratingKey.getText());
                    Movie chosen = new Movie(typedName, typedDirector, getFilmAwards, getFilmYear, getFilmRating);
                    movieList.add(chosen);
                    list.setText(movieList.display());
                } catch (NumberFormatException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Input Error");
                    alert.setContentText("You didn't enter a number where one was expected. Please check you input and try again.");
                    alert.showAndWait();
                }
            }
        });
        btnRemove.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * Remove button
             * @param event
             */
            @Override
            public void handle(ActionEvent event) {

                String typed = searchKey.getText();
                Movie chosen = movieList.remove(typed);
                if (chosen != null) {
                    list.setText(movieList.display());
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Input Error");
                    alert.setContentText("That film wasn't found. Try adding it before you remove it!");
                    alert.showAndWait();
                }
            }
        });

        btnSearch.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * Search button action
             * @param event
             */
            @Override
            public void handle(ActionEvent event) {
                String typed = searchKey.getText();
                Movie chosen = movieList.search(typed);

                if (chosen != null) {
                    searchKey.setText(chosen.getFilmName());
                    directorKey.setText(chosen.getDirector());
                    awardsKey.setText(String.valueOf(chosen.getAwardsWon()));
                    releaseKey.setText(String.valueOf(chosen.getReleaseDate()));
                    ratingKey.setText(String.valueOf(chosen.getFilmRating()));
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Input Error");
                    alert.setContentText("That film wasn't found. Try adding it!");
                    alert.showAndWait();
                }
            }
        });
        btnCopy.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * Copy button action
             * @param event
             */
            @Override
            public void handle(ActionEvent event) {
                String typed = searchKey.getText();
                Movie chosen = movieList.search(typed);

                if (chosen != null) try {
                    chosen.clone();
                    int numberOfCopy = 0;
                    //save it as a variable. You could reuse the chosen variable if you wanted, so:
                    chosen = (Movie) chosen.clone();
                    //then, add it to your Movie list
                    movieList.add(chosen);
                    //change the film name of the movie so it has "(Copy)" at the end
                    //call the method to update your GUI so that your new movie appears in the GUI also
                    list.setText(movieList.display());
                    searchKey.setText(chosen.getFilmName());
                    directorKey.setText(chosen.getDirector());
                    awardsKey.setText(String.valueOf(chosen.getAwardsWon()));
                    releaseKey.setText(String.valueOf(chosen.getReleaseDate()));
                    ratingKey.setText(String.valueOf(chosen.getFilmRating()));
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Input Error");
                    alert.setContentText("The film clone failed! Try again!");
                    alert.showAndWait();
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Input Error");
                    alert.setContentText("That film wasn't found. Try adding it!");
                    alert.showAndWait();
                }
            }
        });
        btnSort.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * Sort button action n
             * @param event
             */
            @Override
            public void handle(ActionEvent event) {
                //1. call movieList.sortByDate();
                movieList.sortByDate();
                //2. update the GUI's list (hint: look at your other handle methods. It will start with list.setText(...))
                list.setText(movieList.display());
            }
        });

        //For position alignment on the GUI along with show()
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        list.setPrefRowCount(15);
        list.setPrefColumnCount(35);
        primaryStage.setScene(new Scene(grid, 600, 550));
        primaryStage.show();
    }

    /**
     * @return mlemp - empty list.
     */
    public MovieList emptyList() {

        MovieList mlemp = new MovieList(20);

        return mlemp;
    }

    /**
     * This is the data class with some preset movie choices that can be edited in the GUI.
     *
     * @return ml
     */
    public MovieList dataList(){

        //ten movie objects of unique attributes
        Movie m0 = new Movie("Inception", "Christopher Nolan", 12, 2010, 9.7);
        Movie m1 = new Movie("Blade Runner 2049", "Denis Villeneuve", 6, 2016, 9.0);
        Movie m2 = new Movie("Roma", "Alfonso Cuaron", 5, 2018, 8.5);
        Movie m3 = new Movie("Ready Player One", "Steven Spielberg", 1, 2017, 8.9);
        Movie m4 = new Movie("Avatar", "James Cameron", 18, 2010, 9.1);
        Movie m5 = new Movie("Malcolm X", "Spike Lee", 8, 2001, 9.9);
        Movie m6 = new Movie("The Departed", "Martin Scorsese", 7, 2011, 9.3);
        Movie m7 = new Movie("Fight Club", "David Fincher", 2, 2009, 8.3);
        Movie m8 = new Movie("Pulp Fiction", "Quentin Tarantino", 22, 1998, 8.7);
        Movie m9 = new Movie("Gladiator", "Ridley Scott", 3, 2007, 7.7);

        MovieList ml = emptyList();

        //adds objects to list for default data
        ml.add(m0);
        ml.add(m1);
        ml.add(m2);
        ml.add(m3);
        ml.add(m4);
        ml.add(m5);
        ml.add(m6);
        ml.add(m7);
        ml.add(m8);
        ml.add(m9);

        return ml;
    }



}