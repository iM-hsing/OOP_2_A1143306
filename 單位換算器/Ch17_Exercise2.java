import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Ch17_Exercise2 extends JFrame implements ActionListener{
	static Ch17_Exercise2 frm = new Ch17_Exercise2();
	static JButton btn = new JButton("換算");
	
	static String[] types = {"長度", "重量", "溫度"};
	static JComboBox<String> jcb = new JComboBox<>(types);
	
	static JTextField txf1 = new JTextField();
	static JTextField txf2 = new JTextField("換算為......");
	
	static String[] length = {"公尺", "公分", "英吋", "英尺"};
	static String[] weight = {"公斤", "公克", "磅", "盎司"};
	static String[] temp = {"攝氏", "華氏", "克氏"};
	static JComboBox<String> jcb1 = new JComboBox<>(length);
	static JComboBox<String> jcb2 = new JComboBox<>(length);
	
	public static void main(String[] args){
		btn.addActionListener(frm);
		
		frm.setLayout(new BorderLayout());
		frm.setSize(480, 280);
		frm.setTitle("單位換算器");
		
		frm.add(jcb, BorderLayout.NORTH);
		
		jcb.addActionListener(e -> {
			jcb1.removeAllItems();
			jcb2.removeAllItems();
			
			if(jcb.getSelectedItem().equals("長度")){
				for(int i = 0; i < length.length; i++){
					jcb1.addItem(length[i]);
					jcb2.addItem(length[i]);
				}
			}else if(jcb.getSelectedItem().equals("重量")){
				for(int i = 0; i < weight.length; i++){
					jcb1.addItem(weight[i]);
					jcb2.addItem(weight[i]);
				}
			}else if(jcb.getSelectedItem().equals("溫度")){
				for(int i = 0; i < temp.length; i++){
					jcb1.addItem(temp[i]);
					jcb2.addItem(temp[i]);
				}
			}
		});
		
		JPanel p = new JPanel(new GridLayout(2, 2, 10, 10));
		p.add(txf1);
		p.add(jcb1);
		p.add(txf2);
		p.add(jcb2);
		
		frm.add(p, BorderLayout.CENTER);
		
		frm.add(btn, BorderLayout.SOUTH);
		
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			double num = Double.parseDouble(txf1.getText());
			
			String type = jcb.getSelectedItem().toString();
			String from = jcb1.getSelectedItem().toString();
			String to = jcb2.getSelectedItem().toString();

			double result = 0;

			if (type.equals("長度")) {
				double meter = 0;

				switch (from) {
					case "公尺":
					meter = num;
					break;
					
					case "公分":
					meter = num / 100;
					break;
					
					case "英吋":
					meter = num * 0.0254;
					break;
					
					case "英尺":
					meter = num * 0.3048;
					break;
				}

				switch (to) {
					case "公尺":
					result = meter;
					break;
					
					case "公分":
					result = meter * 100;
					break;
					
					case "英吋":
					result = meter / 0.0254;
					break;
					
					case "英尺":
					result = meter / 0.3048;
					break;
				}
			}else if (type.equals("重量")) {
				double kg = 0;

				switch (from) {
					case "公斤":
					kg = num;
					break;
					
					case "公克":
					kg = num / 1000;
					break;
					
					case "磅":
					kg = num * 0.454;
					break;
					
					case "盎司":
					kg = num * 0.028;
					break;
				}

				switch (to) {
					case "公斤":
					result = kg;
					break;
					
					case "公克":
					result = kg * 1000;
					break;
					
					case "磅":
					result = kg / 0.454;
					break;
					
                    case "盎司":
					result = kg / 0.028;
					break;
				}
			}else if (type.equals("溫度")) {
				double c = 0;

				switch (from) {
					case "攝氏":
					c = num;
					break;
					
					case "華氏":
					c = (num - 32) * 5 / 9;
					break;
					
					case "克氏":
					c = num - 273.15;
					break;
				}
				
				switch (to) {
					case "攝氏":
					result = c;
					break;
					
					case "華氏":
					result = c * 9 / 5 + 32;
					break;
					
					case "克氏":
					result = c + 273.15;
					break;
				}
			}

			txf2.setText(String.valueOf(result));

		}catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(frm, "請輸入正確的數字！");
		}
	}
}