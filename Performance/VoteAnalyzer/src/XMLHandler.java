import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class XMLHandler extends DefaultHandler {

    private Voter voter;
    private final HashMap<Voter, Integer> voterCounts;

    public  XMLHandler () {
        voterCounts = new HashMap<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("voter")) {
            voter = new Voter(attributes.getValue("name"), attributes.getValue("birthDay"));
        } else if (qName.equals("visit") && voter != null) {
            int count = voterCounts.getOrDefault(voter, 0);
            voterCounts.put(voter, count + 1);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("voter") ) {
            voter = null;
        }
    }

    public void printDuplicatedVoters() {
        for (Voter voter : voterCounts.keySet()) {
            int count = voterCounts.get(voter);
            if (count > 1) {
                System.out.println(voter.toString() + " - " + count);
            }
        }
    }
}
