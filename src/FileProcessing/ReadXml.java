package FileProcessing;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class ReadXml {

	public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException {
		
		File f = new File("domain.xml");
		 DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	            DocumentBuilder db = dbf.newDocumentBuilder();
	            Document doc = db.parse(f);
	            doc.getDocumentElement().normalize();
	            
	            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
	            
	            NodeList nodeList2 = doc.getDocumentElement().getChildNodes();
	            
//	            for(int i =0;i<nodeList2.getLength();i++) {
//	            	System.out.println("nodes "+i+" "+nodeList2.item(i).getNodeName()+" -> "+nodeList2.item(i).getChildNodes());
//	            }
	            
	            NodeList nodeList = doc.getElementsByTagName("jdbc-connection-pool");
	            System.out.println(nodeList.getLength());
	            for(int i=0;i<nodeList.getLength();i++) {
	            	NodeList nodes = nodeList.item(i).getChildNodes();
	            	Node node = nodeList.item(i);
            		Element el = (Element) node;
            		
            		if(el.getAttribute("name").equals("api_pool") || el.getAttribute("name").equals("event_pool")) {
            			System.out.println(" Element Name "+el.getAttribute("name")+" "+el.getAttribute("datasource-classname"));
            			NodeList ns = el.getElementsByTagName("property");
            			for(int j =0;j<ns.getLength();j++) {
            				Node no = ns.item(j);

                			Element el1 = (Element) no;
                			
                			System.out.println("  **** Attributue  "+el1.getAttribute("name")+" Value -"+el1.getAttribute("value"));
            			}
            			
            		}
//            		NamedNodeMap attrs = node.getAttributes();
//                    for (int k=0; k<attrs.getLength(); k++) {
//                        System.out.print("  "+(attrs.item(k)).getNodeName()+"=\""+(attrs.item(k)).getNodeValue()+"\"");
//                    }
            		
	            }	
            	
	            
	            try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/API_INT", "API_User", "postgres")) {
	            	 
	                System.out.println("Java JDBC PostgreSQL Example");
	                // When this class first attempts to establish a connection, it automatically loads any JDBC 4.0 drivers found within 
	                // the class path. Note that your application must manually load any JDBC drivers prior to version 4.0.
//	              Class.forName("org.postgresql.Driver"); 
	     
	                System.out.println("Connected to PostgreSQL database!");
	                Statement statement = connection.createStatement();
	                System.out.println("Reading car records...");
	                System.out.printf("%-30.30s  %-30.30s%n", "Model", "Price");
	                ResultSet resultSet = statement.executeQuery("SELECT * FROM mediated_service_config");
	                while (resultSet.next()) {
	                    System.out.printf("%-30.30s  %-30.30s%n", resultSet.getString("key"), resultSet.getString("value"));
	                }
	     
	            } /*catch (ClassNotFoundException e) {
	                System.out.println("PostgreSQL JDBC driver not found.");
	                e.printStackTrace();
	            }*/ catch (SQLException e) {
	                System.out.println("Connection failure.");
	                e.printStackTrace();
	            }
            	
	            
	            //System.out.println("database name -"+element.getElementsByTagName("DatabaseName").item(0).getTextContent());
	           
	                  
	}
}
