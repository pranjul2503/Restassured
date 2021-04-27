package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configmanager {
	
	public static final Properties prop = new Properties();
	public static String readProperty(String property) 
	{
		InputStream inPropFile = null;
		try {
			inPropFile = new FileInputStream("./src/main/resources/config.properties");
			prop.load(inPropFile);
		} catch (IOException e) {
		}
		String value=prop.getProperty(property);	
		return value;
	}
}
