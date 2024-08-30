package resources;

import java.util.ArrayList;
import java.util.List;

import serializeUsingPOJO.LocationPOJO;
import serializeUsingPOJO.POJOobjectClass;

public class TestDataBuild {
	public static POJOobjectClass addPlacePayload() {
		POJOobjectClass p=new POJOobjectClass();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setName("Frontline house");
		p.setWebsite("http://google.com");
		
		LocationPOJO l=new LocationPOJO();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		
		List<String> list=new ArrayList<String>();
		list.add("shoe park");
		list.add("shop");
		p.setTypes(list);
		
		return p;
	}
}
