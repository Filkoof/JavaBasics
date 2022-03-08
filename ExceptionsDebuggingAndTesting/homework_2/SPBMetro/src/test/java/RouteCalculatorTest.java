import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    StationIndex stationIndex = new StationIndex();
    RouteCalculator routeCalculator = new RouteCalculator(stationIndex);

    @Override
    protected void setUp() throws Exception {
        Line line1 = new Line(1, "Красная");
        Line line2 = new Line(2, "Черная");
        Line line3 = new Line (3, "Белая");

        stationIndex.getLine(1).addStation(new Station("Петровская", line1));
        stationIndex.getLine(1).addStation(new Station("Казанская", line1));
        stationIndex.getLine(1).addStation(new Station("Летовская", line1));

        stationIndex.getLine(2).addStation(new Station("Морковная", line2));
        stationIndex.getLine(2).addStation(new Station("Яблочная", line2));
        stationIndex.getLine(2).addStation(new Station("Кропоткинская", line2));

        stationIndex.getLine(3).addStation(new Station("Сахарная", line3));
        stationIndex.getLine(3).addStation(new Station("Бумажная", line3));

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);


        List<Station> connection1 = new ArrayList<>();
        connection1.add(stationIndex.getStation("Казанская", 1));
        connection1.add(stationIndex.getStation("Яблочная", 2));
        stationIndex.addConnection(connection1);

        List<Station> connection2 = new ArrayList<>();
        connection2.add(stationIndex.getStation("Кропоткинская", 2));
        connection2.add(stationIndex.getStation("Сахарная", 3));
        stationIndex.addConnection(connection2);
    }

    public void testGetShortestRoute(){
        List<Station> excepted = new ArrayList<>();

        excepted.add(stationIndex.getStation("Петровская", 1));
        excepted.add(stationIndex.getStation("Казанская", 1));
        excepted.add(stationIndex.getStation("Летовская", 1));

        List<Station> actual;
        actual =

        assertEquals(excepted, actual);
    }

    public void testCalculateDuration(){
        List<Station> route = new ArrayList<>();

        route.add(stationIndex.getStation("Летовская"));
        route.add(stationIndex.getStation("Казанская"));
        route.add(stationIndex.getStation("Морковная"));

        double actual = RouteCalculator.calculateDuration(route);
        double excepted = 6;
        assertEquals(excepted, actual);
    }

    @Override
    protected void tearDown() throws Exception {

    }
}
