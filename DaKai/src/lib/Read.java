package lib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;


public class Read {
	private static Properties properties;

	private static void get() {
		properties = new Properties();
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream("src\\lib\\src.properties");
			properties.load(inputStream);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static Read read;

	private Read() {
	}

	public static Read getsrc() {
		if (read == null) {
			read = new Read();
			get();
		}
		return read;
	}
	public Properties getProperties() {
		return properties;
	}

	
}
