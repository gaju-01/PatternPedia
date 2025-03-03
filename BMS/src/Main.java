import Cinemas.Movie;
import Cinemas.Show;
import Enums.Language;
import Enums.SeatType;
import TheatreInfra.Auditorium;
import TheatreInfra.City;
import TheatreInfra.Seat;
import TheatreInfra.Theatre;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        City honavar = new City().setCityName("Honavar");
        City bangalore = new City().setCityName("Bangalore");
        City hyderabad = new City().setCityName("Hyderabad");

        Theatre padmanjali = new Theatre().setTheatreName("Padmanjali").setCity(honavar);
        Theatre inox = new Theatre().setTheatreName("INOX").setCity(bangalore);
        Theatre cinesquare = new Theatre().setTheatreName("Cinesquare").setCity(hyderabad);

        Auditorium padmanjaliAuditorium = new Auditorium().setAuditoriumName("PadmanjaliAuditorium").setTheatre(padmanjali);
        Auditorium inoxAuditorium = new Auditorium().setAuditoriumName("INOXAuditorium").setTheatre(inox);
        Auditorium cinesquareAuditorium = new Auditorium().setAuditoriumName("CinesquareAuditorium").setTheatre(cinesquare);

        Seat seat1 = new Seat(SeatType.GOLD, padmanjaliAuditorium);
        Seat seat2 = new Seat(SeatType.NORMAL, inoxAuditorium);
        Seat seat3 = new Seat(SeatType.PLATINUM, cinesquareAuditorium);

        Movie padmavat = new Movie("Padmavat");
        Movie kantara = new Movie("Kantara");
        Movie matrix = new Movie("Matrix");

        Show show1 = new Show().setMovie(padmavat).Auditorium(inoxAuditorium).setStartTime("10").setEndTime("12").setLang(Language.HINDI);
        Show show2 = new Show().setMovie(kantara).Auditorium(padmanjaliAuditorium).setStartTime("10").setEndTime("12").setLang(Language.KANNADA);
        Show show3 = new Show().setMovie(matrix).Auditorium(cinesquareAuditorium).setStartTime("10").setEndTime("12").setLang(Language.TAMIL);

        Scanner scanner = new Scanner(System.in);
        System.out.println("************************************************************************************");

        City city = null;
        System.out.println("Enter the city: ");
        while(city == null) {
            char cityName = scanner.next().charAt(0);
            switch (cityName) {
                case 'B':
                    city = bangalore;
                    break;
                case 'H':
                    city = honavar;
                    break;
                case 'D':
                    city = hyderabad;
                default:
                    System.out.println("Please choose a valid city");
            }
        }

        System.out.println("************************************************************************************");

        int i, j, k, index;
        List<Movie> movieList = city.getMovieList();
        for(i = 0; i < movieList.size(); i++) {
            Movie movie = movieList.get(i);
            System.out.println("Enter " + i + " to select movie " + movie.getMovieName());
        }

        Movie movie = null;
        System.out.println("Enter the movie number: ");
        while(movie == null) {
            index = scanner.nextInt();
            if(index < movieList.size()  && index >= 0)
                movie = movieList.get(index);
            else
                System.out.println("Enter the valid  number");
        }

        System.out.println("************************************************************************************");

        List<Show> showList = movie.getShowList();
        for(k = 0; k<  showList.size(); k++) {
            City tempCity = showList.get(k).getCity();
            if(tempCity.equals(city)) {
                showList.get(k).printDetails();
                System.out.println("Enter " + k + " to book this show");
                System.out.println("************************************************************************************");
            }
        }

        System.out.println("Enter the show to book: ");
        Show show = null;
        while(show == null) {
            index = scanner.nextInt();
            if(index < showList.size() && index >= 0)
                show = showList.get(index);
            else
                System.out.println("Enter the valid show number");
        }

        System.out.println("************************************************************************************");

        show.printAvailableSeats();
        boolean ok = false;
        while(!ok) {
            int seatNumber = scanner.nextInt();
            ok = show.bookSeat(seatNumber);
        }

        System.out.println("************************************************************************************");
    }
}