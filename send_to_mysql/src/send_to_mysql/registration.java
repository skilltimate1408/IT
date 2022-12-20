package send_to_mysql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class registration {

	private JFrame frame;
	private JTextField tname;
	private JTextField trollno;
	private JTextField temail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registration window = new registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 773, 614);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(174, 22, 307, 76);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(38, 141, 213, 62);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Roll no");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(38, 218, 213, 62);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Gender");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(38, 290, 213, 62);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Fav. prog,lang");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_2.setBounds(38, 362, 213, 62);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Email ");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_3.setBounds(38, 434, 213, 62);
		frame.getContentPane().add(lblNewLabel_1_1_3);
		
		tname = new JTextField();
		tname.setBounds(209, 162, 197, 30);
		frame.getContentPane().add(tname);
		tname.setColumns(10);
		
		trollno = new JTextField();
		trollno.setColumns(10);
		trollno.setBounds(209, 244, 197, 30);
		frame.getContentPane().add(trollno);
		
		temail = new JTextField();
		temail.setColumns(10);
		temail.setBounds(209, 460, 197, 30);
		frame.getContentPane().add(temail);
		
		
		JRadioButton r1 = new JRadioButton("Female");
		r1.setFont(new Font("Tahoma", Font.BOLD, 15));
		r1.setBounds(229, 315, 103, 21);
		frame.getContentPane().add(r1);
		
		JRadioButton r2 = new JRadioButton("Male");
		r2.setFont(new Font("Tahoma", Font.BOLD, 15));
		r2.setBounds(364, 315, 103, 21);
		frame.getContentPane().add(r2);
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		
		JComboBox c1 = new JComboBox();
		c1.setModel(new DefaultComboBoxModel(new String[] {"C", "Python", "Java", "Dart", "R "}));
		c1.setBounds(246, 387, 160, 21);
		frame.getContentPane().add(c1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tname.getText();
				String rollno=trollno.getText();
				String gender;
				if(r1.isSelected())
				{
					gender="Female";
				}
				else
				{
				   gender="Male";
				}
				String pro=(String) c1.getSelectedItem();
				String email=temail.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/it","root","Welcome@123");
					String q="insert into student values('"+name+"','"+rollno+"','"+gender+"','"+pro+"','"+email+"')";
					Statement st=con.createStatement();
					st.executeUpdate(q);
					JOptionPane.showMessageDialog(btnNewButton, "Done!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(229, 522, 146, 45);
		frame.getContentPane().add(btnNewButton);
	}
}
