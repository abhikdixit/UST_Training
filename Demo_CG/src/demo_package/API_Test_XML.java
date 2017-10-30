package demo_package;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class API_Test_XML {
	@Test
	  public void apiXML() {
		  
		// This is request which we are sending to server 
		String restURL_XML = "http://parabank.parasoft.com/parabank/services/bank/customers/12212/";
		 
		try {
		 
		testStatusCode(restURL_XML);
		testMimeType(restURL_XML,"application/xml");
		testContent(restURL_XML,"lastName","Smithh");
				 
		} catch (ClientProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		}
		 
		public static void testStatusCode(String restURL) throws ClientProtocolException, IOException {
		 
		HttpUriRequest request = new HttpGet(restURL);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		 System.out.println(httpResponse);
		Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(),HttpStatus.SC_OK);
		}
		 
		public static void testMimeType(String restURL, String expectedMimeType) throws ClientProtocolException, IOException {
		 
		HttpUriRequest request = new HttpGet(restURL);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		 
		Assert.assertEquals(expectedMimeType,ContentType.getOrDefault(httpResponse.getEntity()).getMimeType());
		}
		 
		public static void testContent(String restURL, String element, String expectedValue) throws ClientProtocolException, IOException, SAXException, ParserConfigurationException {
		 
		 
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(restURL);
		NodeList nodelist = doc.getElementsByTagName(element);
		System.out.println(nodelist.item(0).getTextContent());
		Assert.assertEquals(expectedValue,nodelist.item(0).getTextContent()); 
		}
		 
		}