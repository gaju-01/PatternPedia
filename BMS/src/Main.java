import java.util.*;

public class Main {
    public static void main(String[] args) {

        City Honavar = new City().setCityName("Honavar");
        City Bangalore = new City().setCityName("Bangalore");
        City Hyderabad = new City().setCityName("Hyderabad");

        Theatre Padmanjali = new Theatre().setTheatreName("Padmanjali").setCity(Honavar);
        Theatre INOX = new Theatre().setTheatreName("INOX").setCity(Bangalore);
        Theatre Cinesquare = new Theatre().setTheatreName("Cinesquare").setCity(Hyderabad);

        Auditorium PadmanjaliAuditorium = new Auditorium().setAuditoriumName("PadmanjaliAuditorium").setTheatre(Padmanjali);
        Auditorium INOXAuditorium = new Auditorium().setAuditoriumName("INOXAuditorium").setTheatre(INOX);
        Auditorium CinesquareAuditorium = new Auditorium().setAuditoriumName("CinesquareAuditorium").setTheatre(Cinesquare);

        Seat seat1 = new Seat(SeatType.GOLD, PadmanjaliAuditorium);
        Seat seat2 = new Seat(SeatType.NORMAL, INOXAuditorium);
        Seat seat3 = new Seat(SeatType.PLATINUM, CinesquareAuditorium);

        Movie Padmavat = new Movie("Padmavat");
        Movie Kantara = new Movie("Kantara");
        Movie Matrix = new Movie("Matrix");

        Show show1 = new Show().setMovie(Padmavat).Auditorium(INOXAuditorium).setStartTime("10").setEndTime("12").setLang(Language.HINDI);
        Show show2 = new Show().setMovie(Kantara).Auditorium(PadmanjaliAuditorium).setStartTime("10").setEndTime("12").setLang(Language.KANNADA);
        Show show3 = new Show().setMovie(Matrix).Auditorium(CinesquareAuditorium).setStartTime("10").setEndTime("12").setLang(Language.TAMIL);

        Scanner scanner = new Scanner(System.in);
        System.out.println("************************************************************************************");

        City city = null;
        while(city == null) {
            System.out.println("Enter the city: ");
            char cityName = scanner.next().charAt(0);
            switch (cityName) {
                case 'B':
                    city = Bangalore;
                    break;
                case 'H':
                    city = Honavar;
                    break;
                case 'D':
                    city = Hyderabad;
                default:
                    System.out.println("Please choose a valid city");
            }
        }

        System.out.println("************************************************************************************");

        List<Theatre> theatreList = city.getTheatres();
        int size = theatreList.size(), i, j, k;
        HashMap<Integer, Show> maps = new HashMap<>();
        int cnt = 0;
        for (i = 0; i < size; i++) {
            List<Auditorium> auditoriums = theatreList.get(i).getAuditoriums();
            for(j = 0; j< auditoriums.size(); j++) {
                List<Show> showList = auditoriums.get(j).showList();
                for(k = 0; k<  showList.size(); k++) {
                    showList.get(k).printDetails();
                    maps.put(cnt, showList.get(k));
                    System.out.println("Enter " + cnt + " to book this show");
                    System.out.println("************************************************************************************");
                    cnt++;
                }
            }
        }

        System.out.println("Enter the show to book: ");
        Show show = null;
        while(show == null) {
            int index = scanner.nextInt();
            if(index < cnt)
                show = maps.get(index);
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