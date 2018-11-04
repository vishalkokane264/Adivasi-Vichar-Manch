import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;


import javax.swing.*;
import javax.swing.table.TableColumn;


public class ViewList extends JFrame implements ActionListener
{
public static void main(String ar[])
{
	ViewList.setDefaultLookAndFeelDecorated(isDefaultLookAndFeelDecorated());
	Vector cnames=new Vector();
	Vector data=new Vector();
	
	
	try
	{	
		cnames.removeAllElements();
		data.removeAllElements();

		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    Connection c = DriverManager.getConnection("jdbc:odbc:TestDB");
		String sql="select * from Avmdata";
		Statement s=c.createStatement();
		ResultSetMetaData md;
		ResultSet rs=s.executeQuery(sql);
		md=rs.getMetaData();
		int columns = md.getColumnCount();
		for (int i = 1; i <= columns; i++)
		{
			cnames.addElement( md.getColumnName(i).toUpperCase() );
			//System.out.println(md.getColumnName(i).toUpperCase());
		}
		cnames.addElement("Do" );
		
		while (rs.next())
		{
			Vector row = new Vector(columns);
			for (int i = 1; i <= columns; i++)
			{
				row.addElement( rs.getObject(i) );
				
		}
			
			data.addElement(row);

			//			System.out.println(data.firstElement());
		}

		JFrame frame =new JFrame();
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Result");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width,screenSize.height-30);
		JTable table = new JTable(data, cnames);
		table.setRowHeight(20);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setFont(new Font("Arial",Font.PLAIN,18));
		table.setFont(new Font("Arial",Font.PLAIN,18));
		TableColumn column;
		for(int i=0;i<1;i++)
		{
			column=table.getColumnModel().getColumn(i);
			column.setMaxWidth(450);
		}	
		JScrollPane scrollPane = new JScrollPane( table );
		frame.add(scrollPane);
		frame.setVisible(true);
	


	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null,"Exception Occured:"+e);
	}

	}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}
}