package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.SkipException;

public class Reader {

	public static String readerValue(String key) {
		Properties config = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./Configuration/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			config.load(fis);
		} catch (IOException e) {

		}

		if (key != null) {
			return (config.getProperty(key));
		} else {
			
			System.err.println("Invalid key provided");

		}
		return key;

	}

}
