package JsonReaderFile;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ReaderJson {
	private static final String path = "/Users/udarajayawardhane/Documents/KavindiEclipse/JsonSelTestSat/testdata.json";
	
	public static JsonNode ReadJsonData() throws JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readTree(new File(path));
		
		
	}

}
