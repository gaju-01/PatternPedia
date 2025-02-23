package TheatreInfra;

import java.util.ArrayList;
import java.util.List;

public class City {

    private String cityName;

    List<Theatre> theatreList;

    public City() {
        this.theatreList = new ArrayList<>();
    }
    public City setCityName(String name) {
        this.cityName = cityName;
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

}
