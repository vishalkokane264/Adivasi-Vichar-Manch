
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class AboutUs extends JFrame implements ActionListener
{
	JPanel txtpanel;
    JLabel l1, l2, l3;
    Cursor cur;
    Container c;
    AboutUs()
    {
        setTitle("About Adivasi Vichar Manch");
        setVisible(true);
		setSize(750,400);
		setLocationRelativeTo(null);
        pack();
		c = getContentPane();
		c.setLayout(null); 
		cur = new Cursor(Cursor.DEFAULT_CURSOR);
		setCursor(cur);
		c.setBackground(new Color(140,140,119));	
		ImageIcon coll = new ImageIcon("resource/aboutus.png");
		JLabel LogoColl = new JLabel(coll);
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		LogoColl.setBounds(0,-50,480,480);
		c.add(LogoColl);
		JLabel copy3=new JLabel("Adivasi Vichar Manch,Maharashtra");
		copy3.setFont(new Font("serif",Font.BOLD,20));
		copy3.setBounds(90,410,300,30);
		copy3.setForeground(Color.white);
		c.add(copy3);
		JLabel copy2=new JLabel("Version 1.0.0");
		copy2.setFont(new Font("serif",Font.BOLD,20));
		copy2.setBounds(180,440,300,30);
		copy2.setForeground(Color.white);
		c.add(copy2);
		JLabel copy=new JLabel("Copyright © AVM 2016-2017");
		copy.setFont(new Font("serif",Font.BOLD,20));
		copy.setBounds(110,470,300,30);
		copy.setForeground(Color.white);
		c.add(copy);
		JLabel copy1=new JLabel("All rights reserved.");
		copy1.setFont(new Font("serif",Font.BOLD,20));
		copy1.setBounds(160,500,300,30);
		copy1.setForeground(Color.white);
		c.add(copy1);
    }
 
    public void actionPerformed(ActionEvent e)
    {
    	
    }

    public static void main(String arr[])
    {
        AboutUs log=new AboutUs();
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        log.setBounds(500,0,480,600);
        
		 log.setResizable(false);
         
    }
}