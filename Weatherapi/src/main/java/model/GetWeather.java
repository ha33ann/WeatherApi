package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class GetWeather {

	public static void getWeather(WeatherBean wBean) throws IOException {

		
		String URLtoSend = "http://api.openweathermap.org/data/2.5/weather?q=" + wBean.getCityStr() + ","
				+ wBean.getCountryStr() + "&APPID=0b1fc4a863dbe9ca25032ffe077d9017&mode=xml";

		
		System.out.println(URLtoSend);

		URL line_api_url = new URL(URLtoSend);


		HttpURLConnection linec = (HttpURLConnection) line_api_url.openConnection();
		linec.setDoInput(true);
		linec.setDoOutput(true);
		linec.setRequestMethod("GET");


		BufferedReader in = new BufferedReader(new InputStreamReader(linec.getInputStream()));


		String inputLine;


		String ApiResponse = "";


		while ((inputLine = in.readLine()) != null) {

			
			ApiResponse += inputLine;
		}
		in.close();


		System.out.println(ApiResponse);


		Document doc = convertStringToXMLDocument(ApiResponse);


		doc.getDocumentElement().normalize();


		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

		
		wBean.setCloudsStr(getElementString("clouds", wBean, doc, "name"));
		wBean.setTemperature(getElementString("temperature", wBean, doc, "value"));
		wBean.setPrecipitation(getElementString("precipitation",wBean, doc, "mode"));
		String iconID = getElementString("weather", wBean, doc,"icon");
		wBean.generateIcon(iconID);
	}
	
	private static String getElementString (String element, WeatherBean wBean, Document doc, String attributeType) {
		NodeList nList = doc.getElementsByTagName(element);
		System.out.println(nList);

		for (int i = 0; i < nList.getLength(); i++) {

			Node node = nList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) node;

			
				String stringToSend = eElement.getAttribute(attributeType);
				
				System.out.println("getElementString sent " + stringToSend);
				return stringToSend;
				
			}
		}
		String fail="Failed to get property";
		return fail;
	}

	
	private static Document convertStringToXMLDocument(String xmlString) {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();


		DocumentBuilder builder = null;
		try {

			builder = factory.newDocumentBuilder();


			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
