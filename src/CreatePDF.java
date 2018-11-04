import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
public class CreatePDF extends JFrame implements ActionListener
{
JLabel l1;
JTextField jtf1;
JButton btn1;
Container c;
Cursor cur;
String str1;
CreatePDF()
	{
		super("Adiwasi Vichar Manch");
		c=getContentPane();
		c.setLayout(null);
//		c.setBackground(new Color(200,222,122));	

		c.setSize(getSize().width-10,getSize().height-130);
		cur = new Cursor(Cursor.DEFAULT_CURSOR);
		setCursor(cur);
		ImageIcon coll = new ImageIcon("resource/t1.png");
		JLabel LogoColl = new JLabel(coll);
		LogoColl.setBounds(0,-53,1365,200);
		c.add(LogoColl);
		l1=new JLabel("Enter Application Id:");
        l1.setForeground(Color.black);

		l1.setBounds(450,350,200,20);
		c.add(l1);
		jtf1=new JTextField();
		jtf1.setBounds(650,350,200,20);
		c.add(jtf1);
		btn1=new JButton("Submit");
		btn1.setBounds(700,400,100,20);
		c.add(btn1);
		btn1.addActionListener(this);
		dispose();
	}

public void actionPerformed(ActionEvent ae) {
		try
		{	
			String str=(String)jtf1.getText();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		    Connection c = DriverManager.getConnection("jdbc:odbc:TestDB");
			String sql="select * from Avmdata where user_id='"+jtf1.getText()+"'";
    		Statement s=c.createStatement();
			ResultSet rs=s.executeQuery(sql);
    			while (rs.next())				
    			{ 
		        Document document = new Document();
		        String string = rs.getString("user_id");
		        String s1;
	            s1=string.replace('/','_');
		        PdfWriter.getInstance(document,
	                    new FileOutputStream("Output Files/"+s1+".pdf"));
	                document.open();
	                Image image1 = Image.getInstance("resource/headbw.png");
	                image1.setAbsolutePosition(0f, 700f);
	                document.add(image1);
	                FontSelector selector = new FontSelector();
	                Font f1 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 22);
	                Font f2 = FontFactory.getFont(FontFactory.COURIER, 14);
	           	 
	                PdfPTable head = new PdfPTable(1);
	                selector.addFont(f1);
	                Paragraph ph=new Paragraph(" ",f1);
	                Paragraph ph1=new Paragraph(" ",f2);
	                ph.setAlignment(Paragraph.ALIGN_CENTER);
	                document.add(ph);
	                ph1.setAlignment(Paragraph.ALIGN_CENTER);
	                document.add(ph1);
	                Paragraph ph2=new Paragraph(" ");
	                document.add(ph2);
	                document.add(ph2);
	                document.add(ph2);
	                Paragraph ph3=new Paragraph("Application ID:"+string);
	                ph3.setAlignment(Paragraph.ALIGN_RIGHT);
	                document.add(ph3);
	                Paragraph ph4=new Paragraph("  ");
	                document.add(ph4);

	                PdfPTable table = new PdfPTable(1); // 3 columns.
	                PdfPCell cell1 = new PdfPCell(new Paragraph("Applicant Details"));
	                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(cell1);
	                document.add(table);
	                
	                PdfPTable table1 = new PdfPTable(2); // 3 columns.
	                float[] cw1 = {1f, 3f};
	                PdfPCell cell2 = new PdfPCell(new Paragraph("Full Name:"));
	                PdfPCell cell3 = new PdfPCell(new Paragraph(rs.getString("Surname")+" "+rs.getString("Name")+" "+rs.getString("Father_Name")));
	                table1.setWidths(cw1);
	                table1.addCell(cell2);
	                table1.addCell(cell3);
	                document.add(table1);
	                           
	                PdfPTable table2 = new PdfPTable(4); // 3 columns.
	                float[] cw2 = {1f, 1f,1,1};
	                PdfPCell cell4 = new PdfPCell(new Paragraph("Gender:"));
	                PdfPCell cell5 = new PdfPCell(new Paragraph(rs.getString("Gender")));
	                PdfPCell cell6 = new PdfPCell(new Paragraph("Birth Date:"));
	                PdfPCell cell7 = new PdfPCell(new Paragraph(rs.getString("Birth_Date")));
	                table2.setWidths(cw2);
	                table2.addCell(cell4);
	                table2.addCell(cell5);
	                table2.addCell(cell6);
	                table2.addCell(cell7);
	                document.add(table2);
	                  
	                PdfPTable table1A = new PdfPTable(2); // 3 columns.
	                PdfPCell cell2A = new PdfPCell(new Paragraph("Blood Group:"));
	                PdfPCell cell3A = new PdfPCell(new Paragraph(rs.getString("Blood_Group")));
	                table1A.setWidths(cw1);
	                table1A.addCell(cell2A);
	                table1A.addCell(cell3A);
	                document.add(table1A);

	                PdfPTable table3 = new PdfPTable(4); // 3 columns.
	                PdfPCell cell8 = new PdfPCell(new Paragraph("Occupation:"));
	                PdfPCell cell9 = new PdfPCell(new Paragraph(rs.getString("Department")));
	                PdfPCell cell10 = new PdfPCell(new Paragraph(rs.getString("Designation")));
	                PdfPCell cell11 = new PdfPCell(new Paragraph(rs.getString("Private_Business")));
	                table3.setWidths(cw2);
	                table3.addCell(cell8);
	                table3.addCell(cell9);
	                table3.addCell(cell10);
	                table3.addCell(cell11);
	                document.add(table3);

	                PdfPTable table4 = new PdfPTable(2); // 3 columns.
	                PdfPCell cell12 = new PdfPCell(new Paragraph("Communication Address:"));
	                PdfPCell cell13 = new PdfPCell(new Paragraph(rs.getString("Communication_Address")));
	                table4.setWidths(cw1);
	                table4.addCell(cell12);
	                table4.addCell(cell13);
	                document.add(table4);
	                
	                PdfPTable table4A = new PdfPTable(4); // 3 columns.
	                PdfPCell cell8A = new PdfPCell(new Paragraph("State:"));
	                PdfPCell cell9A = new PdfPCell(new Paragraph(rs.getString("State")));
	                PdfPCell cell10A = new PdfPCell(new Paragraph("District:"));
	                PdfPCell cell11A = new PdfPCell(new Paragraph(rs.getString("District")));
	                PdfPCell cell12A = new PdfPCell(new Paragraph("Taluka:"));
	                PdfPCell cell13A = new PdfPCell(new Paragraph(rs.getString("Taluka")));
	                PdfPCell cell14A = new PdfPCell(new Paragraph("Pin Code:"));
	                PdfPCell cell15A = new PdfPCell(new Paragraph(rs.getString("Pin_Code")));
	                table4A.setWidths(cw2);
	                table4A.addCell(cell8A);
	                table4A.addCell(cell9A);
	                table4A.addCell(cell10A);
	                table4A.addCell(cell11A);
	                table4A.addCell(cell12A);
	                table4A.addCell(cell13A);
	                table4A.addCell(cell14A);
	                table4A.addCell(cell15A);
	                document.add(table4A);
	                
	                PdfPTable table4B = new PdfPTable(2); // 3 columns.
	                PdfPCell cell14 = new PdfPCell(new Paragraph("Permanent Address:"));
	                PdfPCell cell15 = new PdfPCell(new Paragraph(rs.getString("Permanent_Address")));
	                table4B.setWidths(cw1);
	                table4B.addCell(cell14);
	                table4B.addCell(cell15);
	                document.add(table4B);
	                
	                PdfPTable table4C = new PdfPTable(4); // 3 columns.
	                PdfPCell cell8B = new PdfPCell(new Paragraph("State:"));
	                PdfPCell cell9B = new PdfPCell(new Paragraph(rs.getString("P_State")));
	                PdfPCell cell10B = new PdfPCell(new Paragraph("District:"));
	                PdfPCell cell11B = new PdfPCell(new Paragraph(rs.getString("P_District")));
	                PdfPCell cell12B = new PdfPCell(new Paragraph("Taluka:"));
	                PdfPCell cell13B = new PdfPCell(new Paragraph(rs.getString("P_Taluka")));
	                PdfPCell cell14B = new PdfPCell(new Paragraph("Pin Code:"));
	                PdfPCell cell15B = new PdfPCell(new Paragraph(rs.getString("P_Pin_Code")));
	                table4C.setWidths(cw2);
	                table4C.addCell(cell8B);
	                table4C.addCell(cell9B);
	                table4C.addCell(cell10B);
	                table4C.addCell(cell11B);
	                table4C.addCell(cell12B);
	                table4C.addCell(cell13B);
	                table4C.addCell(cell14B);
	                table4C.addCell(cell15B);
	                document.add(table4C);
	                
	            
	                PdfPTable table5 = new PdfPTable(4); // 3 columns.
	                PdfPCell cell16 = new PdfPCell(new Paragraph("Mobile Number:"));
	                PdfPCell cell17 = new PdfPCell(new Paragraph(rs.getString("Contact_Number")));
	                PdfPCell cell18 = new PdfPCell(new Paragraph(" Alternate Mobile Number:"));
	                PdfPCell cell19 = new PdfPCell(new Paragraph(rs.getString("Alt_Cont_No")));
	                table5.setWidths(cw2);
	                table5.addCell(cell16);
	                table5.addCell(cell17);
	                table5.addCell(cell18);
	                table5.addCell(cell19);
	                document.add(table5);
	                
	                PdfPTable table6 = new PdfPTable(2); // 3 columns.
	                PdfPCell cell20 = new PdfPCell(new Paragraph("Email ID:"));
	                PdfPCell cell21 = new PdfPCell(new Paragraph(rs.getString("E_mail_Id")));
	                table6.setWidths(cw1);
	                table6.addCell(cell20);
	                table6.addCell(cell21);
	                document.add(table6);
	                document.add(ph4);
	                document.add(ph4);
	                
	                PdfPTable table7 = new PdfPTable(1); // 3 columns.
	     
	                PdfPCell cell24 = new PdfPCell(new Paragraph("Donation Details"));
	                cell24.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table7.addCell(cell24);
	                document.add(table7);
	                PdfPTable table8 = new PdfPTable(2); // 3 columns.
	                
	                PdfPCell cell24A = new PdfPCell(new Paragraph("Membership:"));
	                PdfPCell cell24B = new PdfPCell(new Paragraph(rs.getString("Membership")));
	                PdfPCell cell26 = new PdfPCell(new Paragraph("Donation Period:"));
	                PdfPCell cell27 = new PdfPCell(new Paragraph(rs.getString("Donation_Period")));
	                PdfPCell cell28 = new PdfPCell(new Paragraph("Donation Amount:"));
	                PdfPCell cell29 = new PdfPCell(new Paragraph(rs.getString("Amount")));
	                PdfPCell cell30 = new PdfPCell(new Paragraph("Donation By:"));
	                PdfPCell cell31 = new PdfPCell(new Paragraph(rs.getString("Donation_By")));
	                PdfPCell cell32 = new PdfPCell(new Paragraph("Distributor:"));
	                PdfPCell cell33 = new PdfPCell(new Paragraph(rs.getString("Distributor")));
	                PdfPCell cell34 = new PdfPCell(new Paragraph("Subscription Date:"));
	                PdfPCell cell35 = new PdfPCell(new Paragraph(rs.getString("Subscription_date")));
	                PdfPCell cell36 = new PdfPCell(new Paragraph("Expiry Date:"));
	                PdfPCell cell37 = new PdfPCell(new Paragraph(rs.getString("Expiry_date")));
	                table8.setWidths(cw1);
	                table8.addCell(cell24A);
	                table8.addCell(cell24B);
	                table8.addCell(cell26);
	                table8.addCell(cell27);
	                table8.addCell(cell28);
	                table8.addCell(cell29);
	                table8.addCell(cell30);
	                table8.addCell(cell31);
	                table8.addCell(cell32);
	                table8.addCell(cell33);
	                table8.addCell(cell34);
	                table8.addCell(cell35);
	                table8.addCell(cell36);
	                table8.addCell(cell37);
	                document.add(table8);   
	                Paragraph ph10=new Paragraph("    ");
	                document.add(ph10);
	                document.add(ph10);
	                document.add(ph10);
	                document.add(ph10);
	                document.add(ph10);
	                
	                Image image2 = Image.getInstance("resource/footerbw.png");
	                image2.setAbsolutePosition(0f, 125f);
	                document.add(image2);
	                document.add(ph10);
	                document.add(ph10);
	                
	                Paragraph ph6=new Paragraph("Copyright © AVM 2016-2017 All rights reserved.");
	                Paragraph ph8=new Paragraph("For any query Contact us: Mayur Nawale:+919594650790/Rohit Raghatwan:+919833176150");
	                Paragraph ph9=new Paragraph("Email us on:adivasivicharmanch@gmail.com");
	                
	                ph6.setAlignment(Paragraph.ALIGN_CENTER);
	                ph8.setAlignment(Paragraph.ALIGN_CENTER);
	                ph9.setAlignment(Paragraph.ALIGN_CENTER);
	                document.add(ph6);
	                document.add(ph8);
	                document.add(ph9);
	                JOptionPane.showMessageDialog(this,"File created Successfully..","AVM",JOptionPane.INFORMATION_MESSAGE);
	  	             document.close();
			}
    			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"Error while generating file:","AVM_Error",JOptionPane.ERROR_MESSAGE);
		}

	}
	public static void main(String arg[])
	{
		CreatePDF sc=new CreatePDF();
		 sc.setResizable(false);
         Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
         sc.setBounds(0,0,screenSize.width,screenSize.height-40);
         sc.setVisible(true);
		
	}
}	