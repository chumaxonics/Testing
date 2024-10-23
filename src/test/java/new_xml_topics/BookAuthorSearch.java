package new_xml_topics;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import org.w3c.dom.*;
public class BookAuthorSearch {
        public static void main(String[] args) {
        String filePath = "src/test/java/csvDataDriven/books.xml"; // Path to your XML file
        String authorToFind = "George Orwell"; // Author to search for

        try {
            // Initialize the XML parser
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filePath));

            // Normalize the XML structure
            document.getDocumentElement().normalize();

            // Get all book elements
            NodeList bookList = document.getElementsByTagName("book");
            boolean found = false;

            // Iterate through each book
            for (int i = 0; i < bookList.getLength(); i++) {
                Node bookNode = bookList.item(i);
                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) bookNode;
                    String author = bookElement.getElementsByTagName("author").item(0).getTextContent();

                    // Check if the author matches
                    if (author.equalsIgnoreCase(authorToFind)) {
                        String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                        System.out.println("Found: " + title + " by " + author);
                        found = true;
                    }
                }
            }
            if (!found) {
                System.out.println("Author not found: " + authorToFind);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }

