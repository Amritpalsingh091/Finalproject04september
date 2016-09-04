import java.sql.*;
public class FirstExample {
	static final String JDBC_DRIVER="org.apache.derby.jdbc.EmbeddedDriver";
	static final String DB_URL ="jdbc:derby://localhost:1527/cegep";
	static final String USER="student";
	static final String PASS="cegepgim";

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Connection conn =null;
		Statement stmt = null;
		try{
			Class.forName(JDBC_DRIVER);
			System.out.println("Connection to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);

			System.out.println("Creating statement..." );
			stmt = conn.createStatement();
			String sql;
			sql ="Select id, name,address FROM student";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");

				System.out.print("ID: " + id);
				System.out.print(", First : " +  name);
				System.out.println(", Last : " + address);
			}
			sql = "insert into student values(76,'amritpal','address 2')";
			int number = stmt.executeUpdate(sql);
			System.out.println(" the change 1:" +  number);

			sql = "update student set address = 'amritpal address' where id = 4";
			number = stmt.executeUpdate(sql);
			System.out.println(" the change 2:" +  number);

			sql = "Delete from student where id = 6";
			number = stmt.executeUpdate(sql);
			System.out.println(" the change 3:" +  number);

			rs.close();
			stmt.close();
			conn.close();
		}
		catch(Exception se){
			se.printStackTrace();
		}
		System.out.println("GOODBYE!");

	}
}




