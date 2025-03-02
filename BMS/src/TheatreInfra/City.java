package TheatreInfra;

import Cinemas.Movie;

import java.util.ArrayList;
import java.util.List;

public class City {

    private String cityName;

    private List<Theatre> theatreList;

    private List<Movie> movieList;

    public City() {
        this.movieList = new ArrayList<>();
        this.theatreList = new ArrayList<>();
    }
    public City setCityName(String name) {
        this.cityName = name;
        return this;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void addTheatre(Theatre theatre) {
        this.theatreList.add(theatre);
    }
    public List<Theatre> getTheatres() {
        return this.theatreList;
    }

    public void addMovie(Movie movie) {
        synchronized (City.class) {
            if (!this.movieList.contains(movie)) {
                this.movieList.add(movie);
                movie.addCity(this);
            }
        }
    }

    public List<Movie> getMovieList() {
        return this.movieList;
    }
}
