import javax.swing.*;
import java.awt.event.*;

public class contact implements ActionListener{
	private JFrame frm=new JFrame("contact list");
    private JLabel lbl = new JLabel("contact list");

    private JButton btn1=new JButton("Department A");
    private JButton btn2=new JButton("Department B");
    private JButton btn3=new JButton("Department C");
    private JButton btn4=new JButton("Department D");
    private JButton btn5=new JButton("Department E");
    
	public contact()
	{
		 
		frm.setSize(450,700);
		frm.setLocation(300,100);
		frm.setLayout(null);
		lbl.setBounds(190, 0, 420, 40);
	    frm.add(lbl);
		btn1.setBounds(8,40,420,40);
		frm.add(btn1);
		btn1.addActionListener(this);
		btn2.setBounds(8,90,420,40);
		frm.add(btn2);
		btn2.addActionListener(this);
		btn3.setBounds(8,140,420,40);
		frm.add(btn3);
		btn3.addActionListener(this);
		btn4.setBounds(8,190,420,40);
		frm.add(btn4);
		btn4.addActionListener(this);
		btn5.setBounds(8,240,420,40);
		frm.add(btn5);
		btn5.addActionListener(this);
		frm.setVisible(true);
 		
	frm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	frm.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
        	frm.setVisible(false); // Hide the window
         }
    });
	 
	}
	public static void main(String[] args) {
		new contact();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 
		if(e.getActionCommand()=="Department A") 
		{
			new clientI();
			
		}
		if(e.getActionCommand()=="Department B") 
		{
			new clientII();
		}
		if(e.getActionCommand()=="Department C") 
		{
			new clientIII();
		}
		if(e.getActionCommand()=="Department D") 
		{
			new clientIV();
		}
		if(e.getActionCommand()=="Department E") 
		{
			new clientV();
		}
	}
}
	
	 

