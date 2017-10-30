package demo_package;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

public class API_Test_JSON {
  @Test
  public void apiJSON() {
	  
	// sending request and we are passing parameter in url itself
	//String restURL_JSON = "http://maps.googleapis.com/maps/api/geocode/json?address=chicago&sensor=false&#8221";
	  String restURL_JSON = "http://api.worldweatheronline.com/premium/v1/weather.ashx?key=99b0382a15c4463db91112512171001&q=Bangalore&format=json&num_of_days=5";
	try {
	 
	testStatusCode(restURL_JSON);
	testMimeType(restURL_JSON,"application/json");
	//testContentJSON(restURL_JSON,"formatted_address","Chicago, IL, USA");
	testContentJSON(restURL_JSON,"query","Bangalore, India");
	 
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
	} catch (JSONException e) {
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
		
	public static void testContentJSON(String restURL, String element, String expectedValue) throws ClientProtocolException, IOException, SAXException, ParserConfigurationException, JSONException {
	 
	HttpUriRequest request = new HttpGet(restURL);
	HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
	 
	// Convert the response to a String format
	String result = EntityUtils.toString(httpResponse.getEntity());
	 System.out.println(result);
	// Convert the result as a String to a JSON object
	JSONObject jo = new JSONObject(result);
	//System.out.println(jo);
	String test =jo.getString(element);
	System.out.println(test);
	Assert.assertEquals(expectedValue, jo.getString(element));
	
	 System.out.println(expectedValue);
	 System.out.println(jo.getString(element));
	}
	 
	}