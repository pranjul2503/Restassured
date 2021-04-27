package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class Yamlreader {
	private static Yamlreader yamlreader;
	public static String yamlFilePath ="src/main/resources/Details.yaml";
	public static String getValue(String token) throws FileNotFoundException {
		Reader doc = new FileReader(yamlFilePath);
		Yaml yaml = new Yaml();
		Map<String, Object> object = (Map<String, Object>) yaml.load(doc);
		return (String) object.get(token);
	}
}
