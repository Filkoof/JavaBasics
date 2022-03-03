import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        List<Flight> nearestFlights;
        List<Flight> flights = new ArrayList<>();
        List<Terminal> terminals = airport.getTerminals();

        terminals.forEach(terminal -> flights.addAll(terminal.getFlights()));

        Calendar c = Calendar.getInstance();
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.HOUR,2);

        nearestFlights = flights.stream()
                .filter(flight -> flight.getType() == Flight.Type.DEPARTURE)
                .filter(flight -> flight.getDate().after(c.getTime()))
                .filter(flight -> flight.getDate().before(c1.getTime()))
                .collect(Collectors.toList());

        return nearestFlights;
    }

}