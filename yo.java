 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.*;
public class yo implements ActionListener{
	  JFrame window=new JFrame("My Registration Form");
	  JPanel container = new JPanel();
	  JLabel Name=new JLabel("Name:");
	  static JTextField N=new JTextField(15);
	  JLabel Passowrd=new JLabel("Password:");
	  static JPasswordField P=new JPasswordField(15);
	  static Button Login=new Button("Login:");
	  static Button Register=new Button("Register:");

	public yo()
	
	{ 
		container.setLayout(null);
		window.add(container);	 
		container.add(Name );
		container.add(N );
		container.add(Passowrd );
		container.add(P);
		container.add(Login);
		container.add(Register);
		container.setBackground(new Color(51,153,255));
		N.setBounds(170, 140, 200, 20);
		Name.setBounds(90, 140, 200, 20);
		P.setBounds(170, 180, 200, 20);
		Passowrd.setBounds(90, 180, 200, 20);
		Login.setBounds(110, 220, 100, 30);
		Login.addActionListener(this);
		Register.setBounds(230, 220, 100, 30);
		Register.addActionListener(this);
		window.setSize(450, 700);
		window.setLocation(550, 100);
		window. setDefaultCloseOperation (JFrame .EXIT_ON_CLOSE) ;
 		window.setVisible(true);
		window.setDefaultCloseOperation(3);
		window.getContentPane();
		
		
	}

	public static void main(String args[])
	{
		new yo();
		Register.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae)
			{
			      
					try 
					{
						String name=null; 
						name=N.getText();
					    char[] pass = P.getPassword();
					    String pas=null;  
					    pas= new String(pass);
					   if( pass.equals(null)&pas.equals(null)) 
					   {
					    	JOptionPane.showMessageDialog(null, " All DataField must be filed");


					 }
					    
					    else 
					    {
					    	 Class.forName("com.mysql.cj.jdbc.Driver");
							    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/clw", "root", "");
							    Statement stm = con.createStatement();
							    String sql="INSERT INTO serverr (name,pass)VALUES ('"+name+"','"+pas+"');";
								stm.executeUpdate(sql);
								stm.close();
								con.close();
								JOptionPane.showMessageDialog(null, "DATA SUCESSFULLY REGISTERED");
								N.setText("");
								P.setText("");
					    }
					    }
					catch(ClassNotFoundException|SQLException e)
					{
						System.out.println(e.getMessage());
					 
					 }
			  }
			}
		
		);
		Login.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ae)
			{
			      
					try 
					{
						 String name =N.getText();
					    char[] pass = P.getPassword();
					    String pas  = new String(pass);
					    Class.forName("com.mysql.cj.jdbc.Driver");
					    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/clw", "root", "");
					    Statement stm = con.createStatement();
					    String sql="SELECT * FROM serverr";
					    ResultSet resultSet = stm.executeQuery(sql);
					    while (resultSet.next()) {
					         
					    	String security = resultSet.getString("pass");
					        String nam = resultSet.getString("name");
					        if(nam.equals(name) && security.equals(pas)) 
					        {
					        	new server();
					        }
					         
					    }
						stm.close();
						con.close();
 						N.setText("");
						P.setText("");

					 }
					catch(ClassNotFoundException|SQLException e)
					{
						System.out.println(e.getMessage());
					 
					 }
			  }
			}
		
		);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	  
		
	}
}