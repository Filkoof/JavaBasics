import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    StationIndex stationIndex = new StationIndex();
    RouteCalculator routeCalculator = new RouteCalculator(stationIndex);

    @Override
    protected void setUp() throws Exception {
        Line line1 = new Line(1, "Красная");
        Line line2 = new Line(2, "Черная");
        Line line3 = new Line (3, "Белая");

        line1.addStation(new Station("Петровская", line1));
        line1.addStation(new Station("Казанская", line1));
        line1.addStation(new Station("Летовская", line1));
        stationIndex.addStation(new Station("Петровская", line1));
        stationIndex.addStation(new Station("Казанская", line1));
        stationIndex.addStation(new Station("Летовская", line1));

        line2.addStation(new Station("Морковная", line2));
        line2.addStation(new Station("Яблочная", line2));
        line2.addStation(new Station("Кропоткинская", line2));
        stationIndex.addStation(new Station("Морковная", line2));
        stationIndex.addStation(new Station("Яблочная", line2));
        stationIndex.addStation(new Station("Кропоткинская", line2));

        line3.addStation(new Station("Сахарная", line3));
        line3.addStation(new Station("Бумажная", line3));
        stationIndex.addStation(new Station("Сахарная", line3));
        stationIndex.addStation(new Station("Бумажная", line3));

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        stationIndex.addConnection(Arrays.asList(stationIndex.getStation("Казанская"),
                stationIndex.getStation("Яблочная")));
        stationIndex.addConnection(Arrays.asList(stationIndex.getStation("Кропоткинская"),
                stationIndex.getStation("Сахарная")));
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

    public void testGetShortestRouteOnTheLine(){
        List<Station> excepted = new ArrayList<>();

        excepted.add(stationIndex.getStation("Петровская"));
        excepted.add(stationIndex.getStation("Казанская"));
        excepted.add(stationIndex.getStation("Летовская"));

        List<Station> actual;
        actual = routeCalculator.getShortestRoute(stationIndex.getStation("Петровская"),
                stationIndex.getStation("Летовская"));
        assertEquals(excepted, actual);
    }

    public void testGetShortestRouteWithOneConnection(){
        List<Station> excepted = new ArrayList<>();

        excepted.add(stationIndex.getStation("Кропоткинская"));
        excepted.add(stationIndex.getStation("Яблочная"));
        excepted.add(stationIndex.getStation("Казанская"));
        excepted.add(stationIndex.getStation("Летовская"));

        List<Station> actual;
        actual = routeCalculator.getShortestRoute(stationIndex.getStation("Кропоткинская"),
                stationIndex.getStation("Летовская"));
        assertEquals(excepted, actual);
    }

    public void testGetShortestRouteWithTwoConnections(){
        List<Station> excepted = new ArrayList<>();

        excepted.add(stationIndex.getStation("Бумажная"));
        excepted.add(stationIndex.getStation("Сахарная"));
        excepted.add(stationIndex.getStation("Кропоткинская"));
        excepted.add(stationIndex.getStation("Яблочная"));
        excepted.add(stationIndex.getStation("Казанская"));
        excepted.add(stationIndex.getStation("Петровская"));

        List<Station> actual;
        actual = routeCalculator.getShortestRoute(stationIndex.getStation("Бумажная"),
                stationIndex.getStation("Петровская"));
        assertEquals(excepted, actual);
    }

    @Override
    protected void tearDown() throws Exception {

    }
}
