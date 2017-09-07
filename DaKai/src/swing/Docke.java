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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import lib.Read;
import lib.Save;

public class Docke {

	public void docke() {
		JFrame jFrame = new JFrame();
		jFrame.setSize(450, 100);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jPanel = new JPanel();
		jPanel = tubutton(jPanel);
		jFrame.add(jPanel);
		JPanel zidiyi = new JPanel();
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("…Ë÷√");
		JMenuItem item = new JMenuItem("–¬Ω®");
		menu.add(item);
		bar.add(menu);
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PeiZhi peiZhi = PeiZhi.getpei();
				peiZhi.show();
				
			}
		});
		
		jFrame.setJMenuBar(bar);
		jFrame.setLocationRelativeTo(null);
		jFrame.setResizable(false);
		jFrame.setVisible(true);
		
	}
	
	
	private JPanel tubutton(JPanel jPanel) {
		Properties properties = Read.getsrc().getProperties();
		Iterator<String> names = properties.stringPropertyNames().iterator();
		while (names.hasNext()) {
			Button button = new Button(names.next());
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
