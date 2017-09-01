package swing;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lib.Read;

public class Docke {

	public void docke() {
		JFrame jFrame = new JFrame("ceshi");
	
		jFrame.setSize(200, 300);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setLayout(new BorderLayout());
		
//		JPanel dibujPanel = new JPanel();
//		jFrame.add(dibujPanel);
//		dibujPanel.setLayout(new BorderLayout());
		
		
		
		JPanel jPanel = new JPanel(new GridLayout(0, 1,20,20));
		jPanel = tubutton(jPanel);
	
		jFrame.add(jPanel,BorderLayout.CENTER);
	
		JPanel zidiyi = new JPanel();
		
	
		zidiyi.setLayout(new BorderLayout(5,5));
		
		Button pezui = new Button("≈‰÷√");
		zidiyi.add(pezui,BorderLayout.WEST);
		
		
		JTextField src = new JTextField();
		zidiyi.add(src,BorderLayout.CENTER);
		JPanel jPanel2 = new JPanel(new BorderLayout());
		jPanel2.setSize(100,100);
		JTextField name = new JTextField();
		name.setText("   ");
		jPanel2.add(name);
		zidiyi.add(jPanel2,BorderLayout.EAST);
		
		
		
		jFrame.add(zidiyi,BorderLayout.EAST);
		jFrame.setVisible(true);
		
	}
	
	
	private JPanel tubutton(JPanel jPanel) {
		Properties properties = Read.getsrc().getProperties();
		Iterator<String> names = properties.stringPropertyNames().iterator();
		while (names.hasNext()) {
			Button button = new Button(names.next());
			System.out.println(button.getName().toString());
			jPanel.add(button);
			button.addActionListener(new On());
		}
		return jPanel;
	}
	
	
	class On implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				String name = e.getActionCommand();
				Properties properties = Read.getsrc().getProperties();
				String src = properties.getProperty(name);
				System.out.println(src);
				java.awt.Desktop.getDesktop().open(new File(src));
			} catch (IOException e1) {
//				 TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
}
