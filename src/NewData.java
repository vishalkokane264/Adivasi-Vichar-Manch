import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;
import java.util.Date;
import java.util.Calendar;
import java.awt.Container;
import java.io.*;
import java.util.Date;
public class NewData extends JFrame implements ActionListener
{
	JFrame txtpanel;
	String uid="";
	JOptionPane jp = new JOptionPane();
	JMenuBar menuBar,menuBar1;	
	JMenu menu1,menu2;
    JCheckBox jcb1;
    JCheckBox male,female;
	JMenuItem menuItemA,menuItemB,menuItemC,menuItemD,menuItemE,menuItemAA,menuItemBB;
	Container c;
	Cursor cur;
	AbstractButton aButton;
    ButtonGroup btg=new ButtonGroup();
    JRadioButton rb1=new JRadioButton("Monthly");
    JRadioButton rb2=new JRadioButton("Quarterly");
    JRadioButton rb3=new JRadioButton("Yearly");
    JRadioButton rb4=new JRadioButton("3 Yearly");

	JRadioButton avm,blr;
	int am;
	String t,cv,cv2,elt1,elt2,elt3,z,elt4,elt5,elt6,elt7,elt8,elt9,elt10,elt11,elt12,elt13,elt14,elt15,
	elt16,elt17,elt18,elt19,elt20,elt21,elt22,elt23,elt24,elt25,elt26,elt27,elt28,elt29,elt30;
	JComboBox bd,bm,by,state,bg,dist2,dist1,state1,tal,tal1,memtype,dontype;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8,jtf9,jtf10,jtf11,jtf12,jtf13,jtf14,jtf15,jtf16,jtf17,jtf18,jtf19,jtfa1,jtfa2,jtfa3;
	JLabel gn,l,ll,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
	
	DateFormat df=new SimpleDateFormat("dd/MM/yy");
	Date cdate=new Date();
	public NewData()
	{
		
		super("Adivasi Vichar Manch");
		c = getContentPane(); 
//		c.setBackground(new Color(200,222,122));	
		c.setLayout(null); 
		
		setBounds(0,0,850,590);
		setFont(new Font("verdana",3,14));
		
		cur = new Cursor(Cursor.DEFAULT_CURSOR);
		setCursor(cur);
		JPanel txtpanel=new JPanel();
		txtpanel.setBorder(BorderFactory.createTitledBorder("vishal"));
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Unsupported Look And Feel"+e);
		}

		
		ImageIcon coll = new ImageIcon("resource/t1.png");
		JLabel LogoColl = new JLabel(coll);
		LogoColl.setBounds(0,-53,1365,200);
		c.add(LogoColl);
		menuBar = new JMenuBar(); 	
		menu1 = new JMenu("File");
		menu1.setBackground(Color.black);
		menuBar.add(menu1);
		menuItemA = new JMenuItem("New",new ImageIcon("resource/edit.GIF"));
		menuItemA.setBackground(Color.white);
		menuItemA.setMnemonic('N');
		menu1.add(menuItemA);
		menuItemA.addActionListener(this);
        
		menuItemB = new JMenuItem("CreatePDF",new ImageIcon("resource/New.GIF")); 	
		menuItemB.setBackground(Color.white);
        menuItemB.setMnemonic('S');
        menu1.add(menuItemB);
        menuItemB.addActionListener(this);
        
/*        menuItemC = new JMenuItem("View List");
        menuItemC.setBackground(Color.black);
		menuItemC.setMnemonic('P');
		menu1.add(menuItemC);
		menuItemC.addActionListener(this);
  */      
		menuItemD = new JMenuItem("Exit",new ImageIcon("resource/delete.GIF"));
		menuItemD.setBackground(Color.white);
		menuItemD.setMnemonic('E');
		menu1.add(menuItemD);
		menuItemD.addActionListener(this);
        
        
		menu2 = new JMenu("About"); 	
		menu2.setMnemonic('H');	
		menu2.setBackground(Color.white);
		menuBar.add(menu2);

		menuItemBB = new JMenuItem("About Us",new ImageIcon("resource/solutions.png"));
		menuItemBB.setBackground(Color.white);
		menuItemBB.setMnemonic('A');
		menu2.add(menuItemBB);
		menuItemBB.addActionListener(this);
		setJMenuBar(menuBar);//Menubar is visible using this
		JLabel m1=new JLabel();

		l1= new JLabel("Application Id:");
        l1.setForeground(Color.black);
        l1.setFont(new Font("serif",Font.PLAIN,18));
		l1.setBounds(40,110,150,20);
		c.add(l1);
		int var;
		var=getno();
	    
		String v=String.valueOf(var);
		jtf17=new JTextField(v);
		jtf17.setBounds(180,110,150,20);
		jtf17.setEditable(false);
		c.add(jtf17);
		
		

		l=new JLabel("MEMBER DETAILS");
		l.setForeground(Color.black);
		l.setFont(new Font("serif",Font.BOLD,20));
		l.setBounds(40,140,250,20);
		c.add(l);
		
		ll=new JLabel("DONATION DETAILS");
		ll.setForeground(Color.black);
		ll.setFont(new Font("serif",Font.BOLD,20));
		ll.setBounds(800,140,150,20);
		c.add(ll);
		
		
    	l1= new JLabel("Enter Full Name:");
        l1.setForeground(Color.black);
        l1.setFont(new Font("Calibri",Font.PLAIN,16));
		l1.setBounds(50,180,150,20);
		c.add(l1);
		jtf1=new JTextField();
		jtf1.setBounds(170,180,150,20);
		jtf1.setFont(new Font("Calibri",Font.PLAIN,15));
		c.add(jtf1);
		jtf1.addKeyListener(new KeyAdapter() {
	        public void keyTyped(KeyEvent evt) {

	         if(!(Character.isLetter(evt.getKeyChar()))){
	                evt.consume();
	                getToolkit().beep();
	            }
	        }
	    });
		jtf2=new JTextField();
		jtf2.setBounds(330,180,150,20);
		jtf2.setFont(new Font("Calibri",Font.PLAIN,15));
		c.add(jtf2);
		jtf2.addKeyListener(new KeyAdapter() {
	        public void keyTyped(KeyEvent evt) {

	         if(!(Character.isLetter(evt.getKeyChar()))){
	                evt.consume();
	                getToolkit().beep();
	            }
	        }
	    });
		
		jtf3=new JTextField();
		jtf3.setBounds(490,180,150,20);
		jtf3.setFont(new Font("Calibri",Font.PLAIN,15));
		c.add(jtf3);
		jtf3.addKeyListener(new KeyAdapter() {
	        public void keyTyped(KeyEvent evt) {

	         if(!(Character.isLetter(evt.getKeyChar()))){
	                evt.consume();
	                getToolkit().beep();
	            }
	        }
	    });
		
		
		l5= new JLabel("Date Of Birth:");
        l5.setForeground(Color.black);
        l5.setFont(new Font("Calibri",Font.PLAIN,16));
        l5.setBounds(50,210,200,20);
        c.add(l5);         
		String[] bdt = new String[] {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		System.out.println(bdt);
		dist2=new JComboBox(bdt);
        bd=new JComboBox(bdt);
        bd.setFont(new Font("Calibri",Font.PLAIN,16));
        String getdte;
        bd.setBounds(170,210,50,20);
        c.add(bd);
        bd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JComboBox bd = (JComboBox) event.getSource();
                String getdte=(String)bd.getSelectedItem();
                System.out.println(getdte);
             }
        });
		String[] bdm = new String[] {"January","February","March","April","May","June","July","August","September","October","November","December"};
        bm=new JComboBox(bdm);
        bm.setFont(new Font("Calibri",Font.PLAIN,16));

        bm.setBounds(230,210,100,20);
        c.add(bm);
        bm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JComboBox bm = (JComboBox) event.getSource();
                String getdtm=(String)bm.getSelectedItem();
                System.out.println(getdtm);
             }
        });
		
		String[] bdy = new String[] {"1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009"
				,"2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025"};
		by=new JComboBox(bdy);
		by.setBounds(340,210,100,20);
		by.setFont(new Font("Calibri",Font.PLAIN,16));
		c.add(by);
        by.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JComboBox by = (JComboBox) event.getSource();
                String getdty=(String)by.getSelectedItem();
                System.out.println(getdty);
             }
        });
		l5= new JLabel("Blood Group:");
        l5.setFont(new Font("Calibri",Font.PLAIN,16));
        l5.setForeground(Color.black);
        l5.setBounds(460,210,100,20);
		bg=new JComboBox();
		bg.setFont(new Font("Calibri",Font.PLAIN,16));
		bg.setBounds(560,210,50,20);
		bg.addItem("A");		
		bg.addItem("B");		
		bg.addItem("AB");		
		bg.addItem("O");		
        c.add(l5);
        c.add(bg);
		
		l6= new JLabel("Communication Address:");
        l6.setForeground(Color.black);
        l6.setFont(new Font("Calibri",Font.PLAIN,16));
        l6.setBounds(50,240,200,20);
        c.add(l6);
       	jtf5=new JTextField();
		jtf5.setFont(new Font("Calibri",Font.PLAIN,15));
		jtf5.setBounds(230,240,400,20);
		c.add(jtf5);
		final JComboBox dist2;
	
		
		l6= new JLabel("Taluka");
		l6.setFont(new Font("Calibri",Font.PLAIN,16));
        l6.setForeground(Color.black);
		l6.setBounds(130,300,150,20);
		c.add(l6);
		
		l6= new JLabel("State");						
        l6.setForeground(Color.black);
        l6.setFont(new Font("Calibri",Font.PLAIN,16));        
		l6.setBounds(130,270,150,20);
		c.add(l6);
		
		l6= new JLabel("District:");
        l6.setForeground(Color.black);
        l6.setFont(new Font("Calibri",Font.PLAIN,16));

		l6.setBounds(400,270,100,20);
		c.add(l6);
		dist2=new JComboBox();
		dist2.setBounds(480,270,150,20);
		tal=new JComboBox();
		tal.setBounds(230,300,150,20);
		
		c.add(l6);
		state=new JComboBox();
		state.setFont(new Font("Calibri",Font.PLAIN,16));

		state.setBounds(230,270,150,20);
		try{
    		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    		Connection conn=DriverManager.getConnection("jdbc:odbc:TestDB");
    		String ss="Select distinct(state) from sdata";
    		Statement st=conn.createStatement();
    		  ResultSet rs = st.executeQuery(ss);
      			while(rs.next())
      			{
      	    		state.addItem(rs.getString(1));		
      	    		c.add(state);      	  					
      			}
      			conn.close();
      			st.close();
    		}
    		catch (Exception ex)
    		{
    		    System.out.println(ex);
    		}

		c.add(state);
		repaint();
		state.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	state.getSelectedItem();
            	System.out.println("STATE 1 is"+state.getSelectedItem());
            	repaint();
            	try{
            		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            		Connection conn=DriverManager.getConnection("jdbc:odbc:TestDB");
            		String ss1="Select distinct(district) from sdata where state='"+state.getSelectedItem()+"'";
            		Statement st1=conn.createStatement();
            		dist2.removeAllItems();
            		  ResultSet rs1 = st1.executeQuery(ss1);
              			while(rs1.next())
              			{
              	    		dist2.addItem(rs1.getString(1));		
              	    		c.add(dist2);
              			}
            		}
            	
            		catch (Exception ex)
            		{
            		    System.out.println(ex);
            		}
                     }
        });
			
    		c.add(dist2);
    		dist2.setFont(new Font("Calibri",Font.PLAIN,16));
    		tal.setFont(new Font("Calibri",Font.PLAIN,16));

    		dist2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                cv2=(String)dist2.getSelectedItem();	
                System.out.println("District1 IS"+dist2.getSelectedItem());
                System.out.println("District1 IS cv2"+cv2);
            	   	try{
                		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                		Connection conn=DriverManager.getConnection("jdbc:odbc:TestDB");
                		String ss2="Select distinct(taluka) from sdata where district='"+dist2.getSelectedItem()+"'";
                		Statement st=conn.createStatement();
//                		System.out.println(var1);
                		tal.removeAllItems();
                		  ResultSet rs2 = st.executeQuery(ss2);
                				while(rs2.next())
                				{
                		    		tal.addItem(rs2.getString(1));		
                		    		c.add(tal);
                		  					
                				}
                				
                				conn.close();
                				st.close();
                		}
                		catch (Exception ex)
                		{
                		    System.out.println(ex);
                		}
                		c.add(tal);
                 }
            });
    		tal.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                	 cv=(String)tal.getSelectedItem();
                	System.out.println(tal.getSelectedItem());
                }
            });

    	l6= new JLabel("Pin Code");
        l6.setForeground(Color.black);
        l6.setFont(new Font("Calibri",Font.PLAIN,16));
        l6.setBounds(400,300,150,20);
		c.add(l6);
		jtf7=new JTextField();
		jtf7.setFont(new Font("Calibri",Font.PLAIN,15));
		jtf7.setBounds(480,300,100,20);
		c.add(jtf7);
		 jtf7.addKeyListener(new KeyAdapter() {
			    public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if (!((c >= '0') && (c <= '9') ||
			         (c == KeyEvent.VK_BACK_SPACE) ||
			         (c == KeyEvent.VK_DELETE))) {
			        getToolkit().beep();
			        e.consume();
			      }
			    }
			  });
        l6= new JLabel("Permanant Address:");
        l6.setForeground(Color.black);
        l6.setFont(new Font("Calibri",Font.PLAIN,16));
        l6.setBounds(50,330,200,20);
        c.add(l6);
        jcb1=new JCheckBox("Same as Above");
        jcb1.setFont(new Font("Calibri",Font.PLAIN,16));

        jcb1.setBounds(230,330,130,20);
        c.add(jcb1);
        jcb1.setSelected(false);
       	jcb1.addActionListener(new ActionListener(){
        
            public void actionPerformed(ActionEvent a)
            {
        		// TODO Auto-generated method stub
            	JCheckBox jcb1 = (JCheckBox) a.getSource();
            	if(jcb1.isSelected())
                {
            		JComboBox tal=new JComboBox();
                	jtf8.setText(jtf5.getText());
                	jtf8.setEditable(false);
                	
                	jtf6.setText(jtf7.getText());
                	jtf6.setEditable(false);
                	
                	state1.setSelectedItem((String)state.getSelectedItem());
                	state1.setEditable(false);
                	state1.enable(false);
                	
                	dist1.setSelectedItem(dist2.getSelectedItem());
                	dist1.setEditable(false);
                	dist1.enable(false);
              	
                	System.out.println(tal.getSelectedItem());
                	tal1.setSelectedItem(cv);
                	tal1.setEditable(false);
                	tal1.enable(false);
                }
                else
                {
                jtf8.setText("");
                jtf8.setEditable(true);
                jtf6.setText("");
                jtf6.setEditable(true);
            	state1.enable(true);
            	dist1.enable(true);
            	tal1.enable(true);
                }
        	}
        });  
		jtf8=new JTextField();
		jtf8.setBounds(230,360,400,20);
		jtf8.setFont(new Font("Calibri",Font.PLAIN,15));
		c.add(jtf8);
		
		l6= new JLabel("State");
        l6.setForeground(Color.black);
        l6.setFont(new Font("Calibri",Font.PLAIN,16));
        l6.setBounds(130,390,190,20);
		c.add(l6);
		
		state1=new JComboBox();
		state1.setBounds(230,390,150,20);
		state1.setFont(new Font("Calibri",Font.PLAIN,16));

		l6= new JLabel("District");
        l6.setForeground(Color.black);
        l6.setFont(new Font("Calibri",Font.PLAIN,16));
        l6.setBounds(400,390,190,20);
		c.add(l6);
		
		dist1=new JComboBox();
		dist1.setFont(new Font("Calibri",Font.PLAIN,16));
		dist1.setBounds(480,390,150,20);

		l6= new JLabel("Taluka");
        l6.setForeground(Color.black);
		l6.setBounds(130,420,190,20);
		l6.setFont(new Font("Calibri",Font.PLAIN,16));
        c.add(l6);
		
        tal1=new JComboBox();
		tal1.setFont(new Font("Calibri",Font.PLAIN,16));
		tal1.setBounds(230,420,150,20);
		
		repaint();
		selectstate1();
		
		l6= new JLabel("Pin Code");
        l6.setForeground(Color.black);
		l6.setBounds(400,420,150,20);
		l6.setFont(new Font("Calibri",Font.PLAIN,16));
        c.add(l6);
		
        jtf6=new JTextField();
		jtf6.setBounds(490,420,100,20);
		jtf6.setFont(new Font("Calibri",Font.PLAIN,15));
		c.add(jtf6);
		 jtf6.addKeyListener(new KeyAdapter() {
			    public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if (!((c >= '0') && (c <= '9') ||
			         (c == KeyEvent.VK_BACK_SPACE) ||
			         (c == KeyEvent.VK_DELETE))) {
			        getToolkit().beep();
			        e.consume();
			      }
			    }
			  });

        l7= new JLabel("Email ID:");
        l7.setForeground(Color.black);
        l7.setBounds(50,450,200,20);
        l7.setFont(new Font("Calibri",Font.PLAIN,16));
        c.add(l7);
        jtf11=new JTextField();
		jtf11.setBounds(230,450,250,20);
		jtf11.setFont(new Font("Calibri",Font.PLAIN,15));
		c.add(jtf11);
		
		l8= new JLabel("Contact Number:");
        l8.setForeground(Color.black);
		l8.setFont(new Font("Calibri",Font.PLAIN,16));
        l8.setBounds(50,480,200,20);
        c.add(l8);
        jtf9=new JTextField();
		jtf9.setBounds(230,480,150,20);
		jtf9.setFont(new Font("Calibri",Font.PLAIN,15));
		c.add(jtf9);
		 jtf9.addKeyListener(new KeyAdapter() {
			    public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if (!((c >= '0') && (c <= '9') ||
			         (c == KeyEvent.VK_BACK_SPACE) ||
			         (c == KeyEvent.VK_DELETE))) {
			        getToolkit().beep();
			        e.consume();
			      }
			    }
			  });
		l9= new JLabel("Alternate Contact Number:");
        l9.setForeground(Color.black);
		l9.setFont(new Font("Calibri",Font.PLAIN,16));
		l9.setBounds(50,510,200,20);
        c.add(l9);
        jtf10=new JTextField("");
		jtf10.setBounds(230,510,150,20);
		jtf10.setFont(new Font("Calibri",Font.PLAIN,15));
		c.add(jtf10);
		 jtf10.addKeyListener(new KeyAdapter() {
			    public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if (!((c >= '0') && (c <= '9') ||
			         (c == KeyEvent.VK_BACK_SPACE) ||
			         (c == KeyEvent.VK_DELETE))) {
			        getToolkit().beep();
			        e.consume();
			      }
			    }
			  });
		l15= new JLabel("Gender:");
        l15.setForeground(Color.black);
        l15.setBounds(410,480,100,20);
		l15.setFont(new Font("Calibri",Font.PLAIN,16));
		c.add(l15);
         JRadioButton male=new JRadioButton("Male");
        male.setBounds(480,480,70,20);
        male.setFont(new Font("Calibri",Font.PLAIN,16));
        JRadioButton female=new JRadioButton("Female");
        female.setBounds(550,480,80,20);
        female.setFont(new Font("Calibri",Font.PLAIN,16));
        ButtonGroup grp=new ButtonGroup();
        
        grp.add(male);
        grp.add(female);
        c.add(male);
        c.add(female);
        ActionListener sliceActionListener2 = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
              AbstractButton aButton2 = (AbstractButton) actionEvent.getSource();
           jtf18=new JTextField(aButton2.getText());
            }
          };
        male.addActionListener(sliceActionListener2);
        female.addActionListener(sliceActionListener2);
		
		l10= new JLabel("Occupation:");
        l10.setForeground(Color.black);
        l10.setFont(new Font("Calibri",Font.PLAIN,16));
        l10.setBounds(50,540,200,20);
        c.add(l10);
        JRadioButton govt=new JRadioButton("Government");
        govt.setBounds(230,540,110,20);
        govt.setFont(new Font("Calibri",Font.PLAIN,16));
        JRadioButton pvt=new JRadioButton("Private/Business");
        pvt.setBounds(340,540,150,20);
        pvt.setFont(new Font("Calibri",Font.PLAIN,16));

        ButtonGroup grp1=new ButtonGroup();
        grp1.add(govt);
        
        grp1.add(pvt);
        c.add(govt);
        c.add(pvt);
        govt.setSelected(true);
        ActionListener sliceActionListener1 = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
              AbstractButton aButton1 = (AbstractButton) actionEvent.getSource();
            System.out.println(aButton1.getText());

            if(aButton1.getText()=="Government")
            {            	
            	jtf14.setVisible(false);
            	l15.setVisible(true);
            	l16.setVisible(true);
            	jtf12.setVisible(true);
            	jtf12.setEditable(true);
            	jtf13.setVisible(true);
            	jtf13.setEditable(true);
            	jtf12.setFont(new Font("Calibri",Font.PLAIN,15));	
            	jtf13.setFont(new Font("Calibri",Font.PLAIN,15));
            }
            if(aButton1.getText()=="Private/Business")
            {
            	l15.setVisible(false);
            	l16.setVisible(false);
            	jtf13.setVisible(false);
            	jtf12.setVisible(false);
            	jtf13.setEditable(false);
            	jtf14.setEditable(true);
            	jtf14.setVisible(true);
            	jtf14.setFont(new Font("Calibri",Font.PLAIN,15));
            }
            }
        };
        govt.addActionListener(sliceActionListener1);
        pvt.addActionListener(sliceActionListener1);

        l15=new JLabel("Department");
        l15.setForeground(Color.black);
        l15.setFont(new Font("Calibri",Font.PLAIN,16));
        l15.setBounds(130,570,150,20);
        c.add(l15);
        
        jtf12=new JTextField();
        jtf12.setBounds(230,570,150,20);
		jtf12.setFont(new Font("Calibri",Font.PLAIN,15));
		c.add(jtf12);
        l16=new JLabel("Post");
        l16.setFont(new Font("Calibri",Font.PLAIN,16));
        l16.setForeground(Color.black);
        l16.setBounds(420,570,150,20);
        c.add(l16);

        jtf13=new JTextField();
        jtf13.setBounds(480,570,150,20);
		jtf13.setFont(new Font("Calibri",Font.PLAIN,15));
        c.add(jtf13);

        jtf14=new JTextField();
        jtf14.setBounds(230,570,150,20);
		jtf14.setFont(new Font("Calibri",Font.PLAIN,15));
        c.add(jtf14);

        rb1.setFont(new Font("Calibri",Font.PLAIN,16));
        rb2.setFont(new Font("Calibri",Font.PLAIN,16));
        rb3.setFont(new Font("Calibri",Font.PLAIN,16));
        rb4.setFont(new Font("Calibri",Font.PLAIN,16));

        c.add(rb1);											
        c.add(rb2);
        c.add(rb3);
        c.add(rb4);
        btg.add(rb1);
        btg.add(rb2);
        btg.add(rb3);
        btg.add(rb4);

        	ActionListener sliceActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
               aButton = (AbstractButton) actionEvent.getSource();
              jtf19=new JTextField(aButton.getText());
              System.out.println("Hi"+aButton.getText());
    			 elt24=jtf19.getText();//donation by
    			    Calendar now=Calendar.getInstance();
    				String newdate ="";
       			 
            }
          };
        rb1.addActionListener(sliceActionListener);
        rb2.addActionListener(sliceActionListener);
        rb3.addActionListener(sliceActionListener);
        rb4.addActionListener(sliceActionListener);

        
        l14= new JLabel("Membership:");
        l14.setForeground(Color.black);
        l14.setFont(new Font("Calibri",Font.PLAIN,16));
        l14.setBounds(800,180,150,20);
        c.add(l14);
        final JComboBox memtype;
        ButtonGroup btg1=new ButtonGroup();
        JRadioButton avm=new JRadioButton("AVM");
        JRadioButton blr=new JRadioButton("BHALAR");
		avm.setBounds(950,180,100,20);
		blr.setBounds(1050,180,100,20);
        avm.setFont(new Font("Calibri",Font.PLAIN,16));
        blr.setFont(new Font("Calibri",Font.PLAIN,16));
        c.add(avm);											
        c.add(blr);
        btg1.add(avm);
        btg1.add(blr);
    	ActionListener sliceActionListeneri = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
              AbstractButton aButtoni = (AbstractButton) actionEvent.getSource();
              z=aButtoni.getText();
              System.out.println(aButtoni.getText());
              elt23.valueOf(aButtoni.getText());
              if(aButtoni.getText()=="AVM")
              {                  
                  rb4.setVisible(false);
                  rb1.setBounds(950,210,100,20);
                  rb2.setBounds(1050,210,100,20);
                  rb3.setBounds(1150,210,100,20);
                  rb1.setVisible(true);
                  rb2.setVisible(true);
                  rb3.setVisible(true);
                  jtfa1.setVisible(false);              
              }
              else
              {
            	  rb1.setVisible(false);
                  rb2.setVisible(false);
                  rb3.setVisible(false);
                  rb3.setBounds(950,210,100,20);
                  rb4.setBounds(1050,210,100,20);
                  rb3.setVisible(true);
                  rb4.setVisible(true);
                  jtfa1.setVisible(true);              
              }
            }
          };
        avm.addActionListener(sliceActionListeneri);
        blr.addActionListener(sliceActionListeneri);
		l11= new JLabel("Donation:");
        l11.setForeground(Color.black);
        l11.setFont(new Font("Calibri",Font.PLAIN,16));
        l11.setBounds(800,210,150,20);
        c.add(l11);
     
        l12= new JLabel("Donation Amount(Rs):");
        l12.setForeground(Color.black);
        l12.setFont(new Font("Calibri",Font.PLAIN,16));
        l12.setBounds(800,240,160,20);
        c.add(l12);
        
        jtf4=new JTextField();
        jtf4.setBounds(950,240,150,20);
		jtf4.setFont(new Font("Calibri",Font.PLAIN,15));
		c.add(jtf4);
		 jtf4.addKeyListener(new KeyAdapter() {
			    public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if (!((c >= '0') && (c <= '9') ||
			         (c == KeyEvent.VK_BACK_SPACE) ||
			         (c == KeyEvent.VK_DELETE))) {
			        getToolkit().beep();
			        e.consume();
			       
			      }
			    }
			  });

        l13= new JLabel("Donation By:");
        l13.setFont(new Font("Calibri",Font.PLAIN,16));
        l13.setBounds(800,270,150,20);
        c.add(l13);
        final JComboBox dontype;
        dontype=new JComboBox();
        dontype.setFont(new Font("Calibri",Font.PLAIN,16));
        dontype.setBounds(950,270,150,20);
		dontype.addItem("Cash");		
		dontype.addItem("Net Banking");
		dontype.addItem("ECS");
		dontype.addItem("Cheque");
		c.add(dontype);
		dontype.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	dontype.getSelectedItem();
            	System.out.println(dontype.getSelectedItem());
       		 elt27=(String)dontype.getSelectedItem();//donation by
             }
        });
			 System.out.println(elt27);

		        l14= new JLabel("Distributor:");
		        l14.setFont(new Font("Calibri",Font.PLAIN,16));
		        l14.setBounds(800,300,150,20);
		        c.add(l14);
		        
		        jtfa1=new JTextField();
		        jtfa1.setBounds(950,300,150,20);
				jtfa1.setFont(new Font("Calibri",Font.PLAIN,15));
				c.add(jtfa1);
			 
		        l14= new JLabel("Subscription Date:");
		        l14.setFont(new Font("Calibri",Font.PLAIN,16));
		        l14.setBounds(800,330,150,20);
		        c.add(l14);
		        jtfa2=new JTextField();
		        
		        jtfa2.setBounds(950,330,150,20);
				jtfa2.setFont(new Font("Calibri",Font.PLAIN,15));
				c.add(jtfa2);
				JButton b = new JButton("Date");
				b.setBounds(1100,330,20,20);
				c.add(b);
				b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						datep fp=new datep();
						jtfa2.setText(fp.setPickedDate());
						t=jtfa2.getText();
						setdate();	
					}
				});

				l14= new JLabel("Expiry Date:");
		        l14.setFont(new Font("Calibri",Font.PLAIN,16));
		        l14.setBounds(800,360,150,20);
		        c.add(l14);
				JButton save;
				save=new JButton("Save &Continue");
				save.setFont(new Font("Calibri",Font.PLAIN,16));
				save.setForeground(Color.black);
				save.setToolTipText("Save Record");
				save.setBounds(550,610,200,20);
				c.add(save);
     
				save.addActionListener(this);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				setVisible(true);
				save.addKeyListener(new KeyAdapter(){
					public void keyPressed(KeyEvent evt)
					{
						if(evt.getKeyCode()==KeyEvent.VK_ENTER)
							requestFocus();
					}
				});
	}
	
	public void setdate()
	{
		String arg=t;
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		Calendar cl=Calendar.getInstance();
		try {
			cl.setTime(sdf.parse(t));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(aButton.getText()=="Monthly")
		 {
			cl.add(Calendar.MONTH,1);
				cl.add(Calendar.DATE,-1);
				
				jtfa3=new JTextField(sdf.format(cl.getTime()));
			    jtfa3.setBounds(950,360,150,20);
				jtfa3.setFont(new Font("Calibri",Font.PLAIN,15));
//				jtfa3.setEditable(false);
				jtfa3.setVisible(true);
				c.add(jtfa3);
		 }
		 if(aButton.getText()=="Quarterly")
		 {
				cl.add(Calendar.MONTH,4);
				cl.add(Calendar.DATE,-1);
				
				jtfa3=new JTextField(sdf.format(cl.getTime()));
			    jtfa3.setBounds(950,360,150,20);
				jtfa3.setFont(new Font("Calibri",Font.PLAIN,15));
//					jtfa3.setEditable(false);
				jtfa3.setVisible(true);
				c.add(jtfa3);
		 }

		 if(aButton.getText()=="Yearly")
		 {
				cl.add(Calendar.YEAR,1);
				cl.add(Calendar.DATE,-1);
				jtfa3=new JTextField(sdf.format(cl.getTime()));
			    jtfa3.setBounds(950,360,150,20);
				jtfa3.setFont(new Font("Calibri",Font.PLAIN,15));
//  					jtfa3.setEditable(false);
				jtfa3.setVisible(true);
				c.add(jtfa3);
		 }
		 if(aButton.getText()=="3 Yearly")
		 {

			 	cl.add(Calendar.YEAR,3);
				cl.add(Calendar.DATE,-1);

				jtfa3=new JTextField(sdf.format(cl.getTime()));
			    jtfa3.setBounds(950,360,150,20);
				jtfa3.setFont(new Font("Calibri",Font.PLAIN,15));
//				jtfa3.setEditable(false);
				jtfa3.setVisible(true);
				c.add(jtfa3);
		 }

	}
public void selectstate1()
{
	try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection conn1=DriverManager.getConnection("jdbc:odbc:TestDB");
		String ss3="Select distinct(state) from sdata";
		Statement st=conn1.createStatement();
//		System.out.println(var1);
		  ResultSet rs = st.executeQuery(ss3);
  			while(rs.next())
  			{
  	    		state1.addItem(rs.getString(1));		
  	    		c.add(state1);
  			}
  			conn1.close();
  			st.close();
		}
		catch (Exception ex)
		{
		    System.out.println(ex);
		}

	c.add(state1);
	repaint();
	state1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
        	state.getSelectedItem();
        	System.out.println("STATE1 IS"+state.getSelectedItem());
        	repaint();
        	try{
        		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        		Connection conn1=DriverManager.getConnection("jdbc:odbc:TestDB");
        		String ss4="Select distinct(district) from sdata where state='"+state1.getSelectedItem()+"'";
        		Statement st1=conn1.createStatement();
        		dist2.removeAllItems();
//        		System.out.println(var1);
        		  ResultSet rs3 = st1.executeQuery(ss4);
          			while(rs3.next())
          			{
          	    		dist1.addItem(rs3.getString(1));		
          	    		c.add(dist1);
          	  					
          			}
        		conn1.close();
        		st1.close();
        		}
        	
        		catch (Exception ex)
        		{
        		    System.out.println(ex);
        		}
                 }
    });
		
		c.add(dist1);

		dist1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	try{
            		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            		Connection conn1=DriverManager.getConnection("jdbc:odbc:TestDB");
            		System.out.println("District 1 IS"+dist1.getSelectedItem());
                		
            		String ss5="Select distinct(taluka) from sdata where district='"+dist1.getSelectedItem()+"'";
            		Statement st=conn1.createStatement();
            		tal1.removeAllItems();
            		  ResultSet rs4 = st.executeQuery(ss5);
            				while(rs4.next())
            				{
            		    		tal1.addItem(rs4.getString(1));		
            		    		c.add(tal1);
            		  					
            				}
            				
            				conn1.close();
            				st.close();
            		}
            		catch (Exception ex)
            		{
            		    System.out.println(ex);
            		}
            		c.add(tal1);
             }
        });
}
	
public int getno()
	{
		int i=1;
		try
	{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection conn=DriverManager.getConnection("jdbc:odbc:TestDB");
		Statement st=conn.createStatement();
	    String c ="Select * from Avmdata";
		ResultSet rs=st.executeQuery(c);
		while(rs.next())
		{
			i=i+1;
		}
		conn.close();
		
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	return i;
		}

    	public void actionPerformed(ActionEvent ae)
    	{
    		String str1=(String)ae.getActionCommand();
    		Object source = ae.getSource();
         	System.out.println(str1);
    		if(str1=="New")
    		{
    			int var;
    			var=getno();
    			String v=String.valueOf(var);
    			jtf17=new JTextField(v);
    			jtf17.setBounds(180,110,150,20);
    			jtf17.setEditable(false);
    			c.add(jtf17);
				jtf1.setText(null);
				jtf2.setText(null);
				jtf3.setText(null);
				jtf4.setText(null);
				jtf5.setText(null);
				jtf7.setText(null);
				jtf6.setText(null);
				jtf11.setText(null);
				jtf8.setText(null);
				jtf9.setText(null);
				jtf10.setText(null);
				jtf12.setText(null);//for dept
				jtf13.setText(null);//for post
				jtf14.setText(null);//for nrivate
				jtfa1.setText(null);
				jtfa2.setText(null);
				jtfa3.setText(null);
				jcb1.setSelected(false);
		        repaint();
		        state1.setVisible(true);
		        dist1.setVisible(true);
		        tal1.setVisible(true);
    		}
    		if(str1=="CreatePDF")
    		{
    			CreatePDF sc=new CreatePDF();
    			Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
    			sc.setBounds(0,0,screenSize.width,(screenSize.height-40));
   	         	sc.setVisible(true);
   	         	sc.setResizable(false);
    		}
    		if(str1=="View List")
    		{
    			ViewList vl=new ViewList();
   	            Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
     			vl.setBounds(0,0,screenSize.width,(screenSize.height-40));
   	         	vl.setVisible(true);
   	         	vl.setResizable(false);
    		}
    		if(str1=="Exit")
    		{
    			System.exit(0);
    		}
    		if(str1=="About Us")
    		{
    			AboutUs us=new AboutUs();
    	         Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
    	         us.setBounds(500,0,480,600);
    	         us.setVisible(true);
    	         us.setResizable(false);
    		}
    		if(str1=="Save &Continue")
    		{
				System.out.println(jtfa2.getText());
			     System.out.println(jtfa3.getText());
       			elt1=jtf17.getText();//Avm id
       			Calendar localCalendar=Calendar.getInstance(TimeZone.getDefault());
       			Date currentTime=localCalendar.getTime();
       			int currentYear=localCalendar.get(Calendar.YEAR);		
    			String y=String.valueOf(currentYear);
       			String elt90;
       			elt2=jtf1.getText();//surname
    			 elt3=jtf2.getText();//Name
    			 elt4=jtf3.getText();//Fathersname
    			 elt5=(String)bd.getSelectedItem()+"/"+(String)bm.getSelectedItem()+"/"+(String)by.getSelectedItem();//Birthdate
    			 elt6=(String)bg.getSelectedItem();//BloodGroup
    			 elt7=(String)jtf5.getText();//Communication address
    			 elt26=jtf18.getText();//gender
    			 elt8=(String)state.getSelectedItem();//state
    			 elt9=(String)dist2.getSelectedItem();//district
    			 
    			 elt10=cv;//Taluka
    			 elt11=jtf7.getText();//Pincode
    			 int s=Integer.parseInt(elt11);
    			 elt12=jtf8.getText();//permanent address
    			 elt13=(String)state1.getSelectedItem();//p_state
    			 elt14=(String)dist1.getSelectedItem();//p_dist
    			 elt15=(String)tal1.getSelectedItem();//p_tal
    			 elt16=jtf6.getText();//p_pincode
    			 int ss=Integer.parseInt(elt16);
      			 elt17=jtf11.getText();//Email
    			 elt18=jtf9.getText();//mob no
    			 Double no=Double.parseDouble(elt18);
    			 elt19=jtf10.getText();//alternate mob no
    			 elt20=jtf12.getText();//department
    			 elt21=jtf13.getText();//post
    			 elt22=jtf14.getText();//private/business
    			 elt23=z;//membership
    			 elt24=jtf19.getText();//donationPeriod
    			 elt25=jtf4.getText();//amount
    			 //elt27=//donation by
    			 elt28=jtfa1.getText();//distributor
    			 elt29=t;//subscription date
    			 elt30=jtfa3.getText();//expiry date    			 
    			 elt90=elt23+y+"/"+elt1;
    			 try
    			 {
    				 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			    	 Connection c = DriverManager.getConnection("jdbc:odbc:TestDB");
			    	 Statement st = c.createStatement();
			    	 PreparedStatement ps  = c.prepareStatement("INSERT into Avmdata VALUES('"+elt90+"','"+elt2+"','"+elt3+"','"+elt4+"','"+elt5+"','"+elt6+"','"+elt26+"','"+elt7+"','"+elt8+"','"+cv2+"','"+elt10+"','"+s+"','"+elt12+"','"+elt13+"','"+elt14+"','"+elt15+"','"+ss+"','"+elt17+"','"+elt18+"','"+elt19+"','"+elt20+"','"+elt21+"','"+elt22+"','"+elt23+"','"+elt24+"','"+elt25+"','"+elt27+"','"+elt28+"','"+elt29+"','"+elt30+"')");
			    	 ps.execute();
			    	 jp.showMessageDialog(this,"Record Inserted Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
			    	 c.close();
			    	 st.close();
			 	 }
    			catch(ClassNotFoundException cnf)
    			{
    				System.out.println("Class Not Found Exception");
    			}

			catch(Exception e)
			{
				jp.showMessageDialog(this,"Record Already Exists","Exception",jp.ERROR_MESSAGE);
			}
    		}
    	}
    	public static void main(String arg[])
     	{
     		 NewData p4 = new NewData();
             Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
             p4.setBounds(0,0,screenSize.width,screenSize.height-40);
    		 p4.setResizable(false);
    	 }

}
