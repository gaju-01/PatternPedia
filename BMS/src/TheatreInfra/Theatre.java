package TheatreInfra;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

    private String theatreName;

    private City city;

    private List<Auditorium> auditoriumList;

    public Theatre() {
        this.auditoriumList = new ArrayList<>();
    }

    public Theatre setTheatreName(String theatreName) {
        this.theatreName = theatreName;
        return this;
    }

    public Theatre setCity(City city) {
        this.city = city;
        this.city.addTheatre(this);
        return this;
    }

    public String getTheatreName() {
        return this.theatreName;
    }

    public City getCity() {
        return this.city;
    }

    public void addAuditorium(Auditorium auditorium) {
        this.auditoriumList.add(auditorium);
    }

    public List<Auditorium> getAuditoriums() {
        return this.auditoriumList;
    }
}
