package application.logic;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GetRSS {

    public static List<RSSItem> fetchRSSItems(String rssUrl) {
        List<RSSItem> itemsList = new ArrayList<>();
        try {
            InputStream stream = new URL(rssUrl).openStream();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(stream);
            doc.getDocumentElement().normalize();

            NodeList items = doc.getElementsByTagName("item");
            for (int i = 0; i < items.getLength(); i++) {
                Node item = items.item(i);
                if (item.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) item;

                    // タイトルと内容を取得
                    String title = element.getElementsByTagName("title").item(0).getTextContent();
                    String description = element.getElementsByTagName("description").item(0).getTextContent();

                    // RSSItemオブジェクトを作成してリストに追加
                    itemsList.add(new RSSItem(title, description));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemsList;
    }
}
