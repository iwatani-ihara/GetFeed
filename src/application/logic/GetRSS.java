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

	                // タイトルを取得（内容が空の場合に利用）
	                String title = element.getElementsByTagName("title").item(0) != null ?
	                    element.getElementsByTagName("title").item(0).getTextContent() : "No Title";

	                // 公開日時を取得（dc:date または pubDate のいずれか）
	                Node dateNode = element.getElementsByTagName("dc:date").item(0);
	                if (dateNode == null) {
	                    dateNode = element.getElementsByTagName("pubDate").item(0);
	                }
	                String pubDate = (dateNode != null) ? dateNode.getTextContent() : "No Date";

	                // 説明を取得（説明が空の場合はタイトルを代わりに使用）
	                Node descriptionNode = element.getElementsByTagName("description").item(0);
	                String description = (descriptionNode != null && !descriptionNode.getTextContent().isEmpty()) ?
	                    descriptionNode.getTextContent() : title;

	                // タイトルと日時があればリストに追加
	                if (pubDate != null && description != null) {
	                    itemsList.add(new RSSItem(title, description, pubDate));
	                }
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return itemsList;
	}





}
