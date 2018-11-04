
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.Container;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener
{
	Container conpane;
	JPanel txtpanel;
	JLabel username,password,company,log;
	JTextField user;
	JPasswordField pass;
	JButton signin,exit;
	JLabel java;
	String userchar="Admin";
	String passchar="Password";
	public Login()
	{

		create();
		setSize(750,400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Adivasi Vichar Manch");
		
		ImageIcon coll = new ImageIcon("resource/app.png");
		JLabel LogoColl = new JLabel(coll);
		LogoColl.setBounds(0,-10,450,400);
		add(LogoColl);

		java=new JLabel("Log in ");
		java.setBounds(560,50,150,30);
		java.setFont(new Font("Times New Roman",Font.BOLD,25));
		java.setForeground(Color.blue);
		username=new JLabel("User Name:");
		username.setFont(new Font("serif",Font.PLAIN,20));
		password=new JLabel("Password:");
		password.setOpaque(true);
		password.setFont(new Font("serif",Font.PLAIN,20));

		user=new JTextField(10);
		user.setFont(new Font("Times New Roman",Font.PLAIN,20));
		company=new JLabel("");
		company.setFont(new Font("TimesRoman",Font.BOLD,42));
		log=new JLabel("");
		pass=new JPasswordField(10);
		pass.setFont(new Font("Times New Roman",Font.PLAIN,20));
		signin=new JButton("Sign in");
		signin.setFont(new Font("serif",Font.PLAIN,16));
		exit=new JButton("Exit");
		exit.setFont(new Font("serif",Font.PLAIN,16));
		signin.addActionListener(this);
		exit.addActionListener(this);
		txtpanel=new JPanel();
		txtpanel.setLayout(null);
		conpane=getContentPane();
		conpane.add(txtpanel,BorderLayout.CENTER);
		txtpanel.add(company);
		txtpanel.add(log);
		txtpanel.add(username);
		txtpanel.add(user);
		txtpanel.add(password);
		txtpanel.add(pass);
		txtpanel.add(signin);
		txtpanel.add(exit);
		txtpanel.add(java);
		txtpanel.setBorder(BorderFactory.createTitledBorder(" "));
		company.setBounds(120,10,company.getPreferredSize().width,company.getPreferredSize().height);
		log.setBounds(270,110,log.getPreferredSize().width,log.getPreferredSize().height);
		
		user.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent evt)
			{
				if(evt.getKeyCode()==KeyEvent.VK_ENTER)
				{
						pass.requestFocus();
				}
				else
				if(evt.getKeyCode()==KeyEvent.VK_ESCAPE)
				{
						user.setText("");
				}
			}
		});
		pass.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent evt)
			{
				if(evt.getKeyCode()==KeyEvent.VK_ENTER)
				{
					signin.doClick();
				}
				else
				if(evt.getKeyCode()==KeyEvent.VK_ESCAPE)
				{
						pass.setText("");
				}
			}
		});
		username.setBounds(460,100,150,30);
		user.setBounds(570,100,150,30);
		password.setBounds(470,150,100,30);
		pass.setBounds(570,150,150,30);
		signin.setBounds(550,200,80,30);
		exit.setBounds(640,200,80,30);
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Unsupported Look And Feel"+e);
		}

	}
	private void add(Image background) {
		// TODO Auto-generated method stub
		
	}
	public void actionPerformed(ActionEvent evt)
	{
		String cmd=evt.getActionCommand();
		if(cmd.equals("Sign in"))
		{
			if(user.getText().equals(userchar) && pass.getText().equals(passchar))
			{
				NewData nd=new NewData();
				nd.setVisible(true);
	             Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
	             nd.setBounds(0,0,screenSize.width,screenSize.height-40);
	    		 nd.setResizable(false);
				dispose();
			}
			else
			{
					JOptionPane.showMessageDialog(null,"Invalid User Name or PassWord");
			}
		}
		else
		if(evt.getSource()==exit)
		{
			System.exit(0);
		}

	}
    public void create()
    {
    	try
    	{
    		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    		Connection conn=DriverManager.getConnection("jdbc:odbc:TestDB");
    		Statement st=conn.createStatement();
    	    String c = "Create table Avmdata( user_id varchar(40) primary key,Surname varchar(40),Name varchar(40),Father_Name varchar(40),Birth_Date date,Blood_Group varchar(5),Gender varchar(6),Communication_Address text,State varchar(100),District varchar(100),Taluka varchar(100),Pin_Code int,Permanent_Address text,P_State varchar(100),P_District varchar(100),P_Taluka varchar(100),P_Pin_Code int,E_mail_Id varchar(70),Contact_Number varchar(10),Alt_Cont_No varchar(10),Department varchar(50),Designation varchar(50),Private_Business varchar(50),Membership varchar(50),Donation_Period varchar(50),Amount varchar(50),Donation_By varchar(50),Distributor varchar(50),Subscription_date date,Expiry_date date)";
    		ResultSet rs=st.executeQuery(c);
    	    conn.close();
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}

    }

	public static void main(String args[])
	{
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new Login().setResizable(false);
            	
            }
        });
	}
}