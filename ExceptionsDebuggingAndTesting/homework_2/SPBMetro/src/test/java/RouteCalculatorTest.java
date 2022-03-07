import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    StationIndex stationIndex = new StationIndex();
    List<Station> route;

    @Override
    protected void setUp() throws Exception {
        Line line1 = new Line(1, "Красная");
        Line line2 = new Line(2, "Черная");
        Line line3 = new Line (3, "Белая");

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        stationIndex.addStation(new Station("Петровская",line1));
        stationIndex.addStation(new Station("Арбузная",line1));
        stationIndex.addStation(new Station("Казанская",line1));
        stationIndex.addStation(new Station("Летовская",line1));

        stationIndex.addStation(new Station("Морковная", line2));
        stationIndex.addStation(new Station("Яблочная", line2));
        stationIndex.addStation(new Station("Крапоткинская", line2));

        stationIndex.addStation(new Station("Сахарная", line3));
        stationIndex.addStation(new Station("Бумажная", line3));

        List<Station> connection1 = new ArrayList<>();
        connection1.add(stationIndex.getStation("Казанская", 1));
        connection1.add(stationIndex.getStation("Яблочная", 2));
        stationIndex.addConnection(connection1);

        List<Station> connection2 = new ArrayList<>();
        connection2.add(stationIndex.getStation("Кропоткинская", 2));
        connection2.add(stationIndex.getStation("Сахарная", 3));
        stationIndex.addConnection(connection2);
    }

    @Override
    protected void tearDown() throws Exception {

    }
}
