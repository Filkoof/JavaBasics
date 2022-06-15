import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.SQLException;

public class XMLHandler extends DefaultHandler {

    int number = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("voter")) {
            String name = attributes.getValue("name");
            String birtDate = attributes.getValue("birthDay");
            try {
                DBConnection.countVoter(name, birtDate);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            number++;
        }
    }
}
