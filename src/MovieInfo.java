public class MovieInfo {
    String movieName;
    int year;
    String genre;
    int ID;

    public MovieInfo(int id, String n, int y, String g) {
        ID = id;
        movieName = n;
        year = y;
        genre = g;
    }//Create a class MovieInfo that will hold all the data that can reasonably be read from the file, which is its movie
     // id, title, year and genre

}