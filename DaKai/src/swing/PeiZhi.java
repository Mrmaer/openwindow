package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.acl.Owner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import lib.Save;

public class PeiZhi {
	private PeiZhi() {
		
	}
	
	private static PeiZhi peiZhi;
	
	public static PeiZhi getpei() {
		if (peiZhi == null) {
			peiZhi = new PeiZhi();
		}
		return peiZhi;
	}
	
	public void show() {
		JFrame jFrame = new JFrame("");
		jFrame.setSize(450, 80);
		JButton jButton = new JButton("添加");
		JPanel jPanel = new JPanel();
		JLabel jl_src = new JLabel("链接:");
		JTextField src = new JTextField(20);
		JLabel jl_name = new JLabel("名字:");
		JTextField name = new JTextField(5);
		jPanel.add(jButton);
		jPanel.add(jl_src);
		jPanel.add(src);
		jPanel.add(jl_name);
		jPanel.add(name);
		jFrame.add(jPanel);
		
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(name.getText());
				if (!name.getText().trim().equals("") && !src.getText().trim().equals("")) {
					boolean qk = Save.get().xie(name.getText(), src.getText());
					if (qk == true) {
						JOptionPane.showMessageDialog(null, "添加成功");
						name.setText("");
						src.setText("");
					}
				}
			}
		});
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);
	}
	
	
}
