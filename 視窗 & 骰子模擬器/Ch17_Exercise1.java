import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Ch17_Exercise1 extends JFrame implements ActionListener {
	static Ch17_Exercise1 frm = new Ch17_Exercise1();
	static JButton btn = new JButton("擲骰子");
	static JLabel lab1 = new JLabel();
	static JLabel lab2 = new JLabel();

	int sum = 0;
	int count = 0;

	public static void main(String args[]) {
		btn.addActionListener(frm);

		frm.setLayout(new BorderLayout());
		frm.setSize(400, 320);
		frm.setTitle("擲骰子");
		
		lab1.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 20));
		lab1.setHorizontalAlignment(JLabel.CENTER);
		frm.add(lab1, BorderLayout.NORTH);
		
		lab2.setFont(new Font("Microsoft JhengHei", Font.BOLD, 60));
		lab2.setHorizontalAlignment(JLabel.CENTER);
		frm.add(lab2, BorderLayout.CENTER);
		
		frm.add(btn, BorderLayout.SOUTH);

		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
		frm.setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		int num;
		String str;

		Random rand = new Random();

		num = rand.nextInt(6) + 1;
		str = String.valueOf(num);

		if (num == 1) {
			lab2.setForeground(Color.RED);
		} else if (num == 6) {
			lab2.setForeground(Color.GREEN);
		} else {
			lab2.setForeground(Color.BLACK);
		}

		lab2.setHorizontalAlignment(JLabel.CENTER);

		sum += num;
		count++;

		double avg = (double) sum / count;
		
		lab1.setText("已擲 " + count + "次，總和 " + sum + "，平均 " + String.format("%.2f", avg));
		lab2.setText(str);
	}
}