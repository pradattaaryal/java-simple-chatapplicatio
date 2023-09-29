 import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.io.*;
public class clientII implements ActionListener {
    static JTextField text;
    static JPanel a1;
    static Box vertical = Box.createVerticalBox();
    static JFrame f = new JFrame();
    JPanel p1 = new JPanel();
    JButton send = new JButton("Send");
    JButton back = new JButton("logout");
    static Calendar cal = Calendar.getInstance();
    static SimpleDateFormat time = new SimpleDateFormat("HH:mm");
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    clientII() {
        f.setLayout(null);
        ////////header panel//////////
        p1.setBackground(new Color(24,119,242));
        p1.setBounds(0, 0, 450, 50);
        p1.setLayout(null);
        f.add(p1);
		 ///////name tag//////////////
		JLabel Acc=new JLabel("Department B");
		Acc.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
		Acc.setBackground(new Color(51,204,255));
		Acc.setBounds(140,6, 160, 40);
		Acc.setForeground(Color.white);
		p1.add(Acc);
        ///////for display area////////
        a1 = new JPanel();
        a1.setBounds(7, 57, 422, 600);
        f.add(a1);
        ////user text field//////
       /* text = new JTextField();
        text.setBounds(3, 620, 310, 40);
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        f.add(text);
        //////send button//////
        send.setBounds(310, 620, 123, 40);
        send.setBackground(new Color(24,119,242));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);
        send.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        f.add(send);
        send.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
            	text.setText(" ");
            }
        });*/
        //////back button////////
        back.setBounds(7, 8, 117, 35);
        back.setForeground(Color.white);
        back.setBackground(Color.DARK_GRAY);
        back.addActionListener(this);
        back.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        p1.add(back);
        
        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
            	System.exit(0);

             }
        });
        ///////frame/////////
        f.setSize(450, 700);
        f.setLocation(850, 100);
        f. setDefaultCloseOperation (JFrame .EXIT_ON_CLOSE) ;
        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {	
    //////for taking data from text label////////
    	String data=text.getText();
    	JLabel output1 = new JLabel (data);
    	JPanel p2 = new JPanel();
    	//////////designing output1//////////////////
    	 output1.setFont(new Font("Tahoma", Font.PLAIN, 16));
         output1.setBackground(new Color(37, 211, 102));
         output1.setOpaque(true);//for color
         output1.setBorder(new EmptyBorder(15, 15, 15, 50));//for spacing
         ////////////adding time ///////////////
        
         JLabel jj = new JLabel();
         jj.setText(time.format(cal.getTime()));
         p2.add(jj);
         p2.add (output1);
         ////////for positioning the msg in frame /////////
    	a1.setLayout(new BorderLayout());
    	JPanel right = new JPanel(new BorderLayout());
    	right.add(p2, BorderLayout.LINE_END);//border can't take direct string so put string data from user in jlabel then pass through border layout
    	vertical.add(right);
    	vertical.add(Box.createVerticalStrut(15));
    	a1.add(vertical, BorderLayout.PAGE_START);
    	f.repaint();
    	f.invalidate();
        f.validate(); 
     // Send the message over the socket
        try{
            String msg=new String();
            msg=text.getText();
            dout.writeUTF(msg);
           
           
            
            }
            catch(Exception e1)
            {
            //handle the exception here
            }
         
    
    }
    public static void main(String[] args) 
    {
    new clientII();
    try {
    	String msgin = "";
        
        s = new Socket("127.0.0.2",609);  
        din = new DataInputStream(s.getInputStream());
        dout = new DataOutputStream(s.getOutputStream());

        while (true) {
            msgin = din.readUTF();
             
            String msg="";
           
         
           
            ///////////////////////
            JLabel output2 = new JLabel (msgin);
            JPanel p3 = new JPanel();
            JLabel jr = new JLabel();
            jr.setText(time.format(cal.getTime()));
            ///////database///////////////
            Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/clw", "root", "");
		    Statement stm = con.createStatement();
		    String sql="INSERT INTO clientii (data)VALUES ('"+msgin+"');";
			stm.executeUpdate(sql);
			stm.close();
			con.close();
           
            p3.add (output2);
            p3.add(jr);
            output2.setFont(new Font("Tahoma", Font.PLAIN, 16));
            output2.setBackground(new Color(37, 211, 102));
            output2.setOpaque(true);//for color
            output2.setBorder(new EmptyBorder(15, 15, 15, 50));//for spacing
            a1.setLayout(new BorderLayout());
        	JPanel left = new JPanel(new BorderLayout());
        	left.add(p3, BorderLayout.LINE_START);//border can't take direct string so put string data from user in jlabel then pass through border layout
        	vertical.add(left);
        	vertical.add(Box.createVerticalStrut(15));
        	a1.add(vertical, BorderLayout.PAGE_START);
        	f.repaint();
        	f.invalidate();
            f.validate(); 
             

        }

    } catch (Exception e) {
       
    }

    
}
    	}
    	  
    
    


