import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String name;

    private List<Show> showList;

    Movie(String name) {
        this.name = name;
        this.showList = new ArrayList<>();
    }

    public String getMovieName() {
        return  this.name;
    }

    public void addShow(Show show) {
        this.showList.add(show);
    }
}
