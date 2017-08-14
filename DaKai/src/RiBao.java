import java.io.File;
import java.io.IOException;

public class RiBao {
	public static void main(String[] args) {
		try {
			java.awt.Desktop.getDesktop().open(new File("Â·¾¶"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
}

