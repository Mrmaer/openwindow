package lib;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;



public class Save {
	private Save() {}
	private static Save save;
	public static Save get() {
		if (save == null) {
			save = new Save();
		}
		return save;
	}
	public String gai(String juzhi) {
		return juzhi.replace("\\", "/");
	}
	public Boolean xie(String name,String src) {
		Properties prop = new Properties();     

		try {
			FileOutputStream oFile = new FileOutputStream("src\\lib\\src.properties",true);
			src = gai(src);
			prop.setProperty(name, src);
			prop.store(oFile, "");
			oFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
