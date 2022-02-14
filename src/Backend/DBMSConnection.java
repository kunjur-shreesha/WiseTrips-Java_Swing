package Backend;

import java.sql.*;

public class DBMSConnection {
	static Connection con;
	static Statement st;
	static ResultSet rs;
	
	public DBMSConnection() throws SQLException{
		try {
		//Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBMSProj", "root", "shreeshak@02");	
		}
		catch(SQLException e)
		{
			System.out.println("*cannot connect to database*");
			System.exit(1);
		}
		 st = con.createStatement();	
	}
	
	public int CheckUser(String k) throws SQLException
	{
		String s = "SELECT * FROM USER WHERE username='"+k+"'";
		rs = st.executeQuery(s);
		if (!rs.next())
			return 1;
		else
			return -1;
	}
	
	public int createUser(String username,String name,String password,String address,int age,String gender,String contact) throws SQLException
	{
		int r=0;
		String s = "INSERT into USER values ('"+username+"','"+name+"','"+password+"','"+address+"',"+age+",'"+gender+"','"+contact+"')";
		r = st.executeUpdate(s);
		return r;
	}
	
	public int userLogin(String username,String password) throws SQLException
	{
		String s = "Select * FROM USER where username='"+username+"' and password='"+password+"'";
		rs = st.executeQuery(s);
		if (!rs.next())
			return -1;
		else
			return 1;
	}
	public String[] trainSearch(String from,String to) throws SQLException
	{
		String[] searched = new String[8];
		String s = "Select * FROM train_table where source='"+from+"' and destination='"+to+"'";
		rs = st.executeQuery(s);
		if (rs.next())
		{
			searched[0] = String.valueOf(rs.getInt(1));
			searched[1] = rs.getString(2);
			searched[2] = rs.getString(3);
			searched[3] = rs.getString(4);
			searched[4] = rs.getString(5);
			searched[5] = rs.getString(6);
			searched[6] = rs.getString(7);
			searched[7] = String.valueOf(rs.getInt(8));
			return searched;
		}
			
		else
			return null;
		
	}
	public int booking(String username,int price,int train_no,int no_of_pass) throws SQLException
	{
		int r=0;
		String s = "INSERT into BOOKING values (null,'"+username+"',"+price+","+train_no+","+no_of_pass+")";
		r = st.executeUpdate(s);
		return r;
	}
	public int ticket(String username,int price) throws SQLException
	{
		int r=0;
		String s = "INSERT into TICKET values (null,"+price+",'"+username+"')";
		r = st.executeUpdate(s);
		return r;
	}
	
	public void closecon() throws SQLException
	{
		st.close();
		con.close();
	}
}