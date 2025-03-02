package Cinemas;

import TheatreInfra.City;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String name;

    List<City> cityList;

    private List<Show> showList;
    public Movie(String name) {
        this.name = name;
        this.showList = new ArrayList<>();
        this.cityList = new ArrayList<>();
    }

    public String getMovieName() {
        return  this.name;
    }

    public void addShow(Show show) {
        this.showList.add(show);
    }

    public void addCity(City city) {
            if (!this.cityList.contains(city))
                this.cityList.add(city);
    }

    public List<Show> getShowList() {
        return this.showList;
    }
}
