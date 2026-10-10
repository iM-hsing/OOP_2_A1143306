import javax.swing.*;
import java.awt.*;

public class Login extends JFrame{
	public Login(){
		setTitle("登入");
		setSize(300, 200);
		setLayout(new GridLayout(3, 2));
		
		JLabel l1 = new JLabel("帳號 :");
		JTextField t1 = new JTextField();
		JLabel l2 = new JLabel("密碼 :");
		JTextField t2 = new JTextField();
		JButton btn = new JButton("登入");
		
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(btn);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn.addActionListener(e -> {
			if(t1.getText().equals("admin") && t2.getText().equals("")){
				System.out.println("登入成功");
			}
		});
	}
	
	public static void main(String args[]){
		new Login();
	}
}