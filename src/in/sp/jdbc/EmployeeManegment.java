package in.sp.jdbc;
import java.util.*;
import java.sql.*;
public class EmployeeManegment {
	private static final String url= "jdbc:mysql://localhost:3306/EmployeeDB";
	private static final String user ="root";
	private static final String password="Ark3218@";
	public static void main(String[]args) {
		Scanner s= new Scanner(System.in);
		try(Connection conn = DriverManager.getConnection(url,user,password))
		{
			while(true) {
				System.out.println("1:Add Employee");
				System.out.println("2:View Employee");
				System.out.println("3:Update Employee");
				System.out.println("4:Delete Employee");
				System.out.println("5: Exit ");
				System.out.println("Choose an Option:");
				int choice= s.nextInt();
				switch(choice) {
				case 1:
					addEmployee(conn,s);
					break;
				case 2:
					viewEmployee(conn,s);
					break;
				case 3:
					updateEmployee(conn,s);
					break;
				case 4:
					deleteEmployee(conn,s);
					break;
				case 5:
					System.exit(0);
					default:
						System.out.println("Invalid  choice try Agian!!..");
				}
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void  addEmployee(Connection conn,Scanner s) throws SQLException{
		System.out.println("Enter Name");
		s.nextLine();
		String name=s.nextLine();
		System.out.println("Enter Age:");
		int age=s.nextInt();
		s.nextLine();
		System.out.println("Enter Department");
		String department=s.nextLine();
		System.out.println("Enter Sallary");
		double sallary=s.nextDouble();
		String sql="INSERT INTO Employees(name,age,department,sallary) VALUES(?,?,?,?)";
		try(PreparedStatement pstm=conn.prepareStatement(sql)){
			pstm.setString(1,name);
			pstm.setInt(2, age);
			pstm.setString(3,department);
			pstm.setDouble(4, sallary);
			pstm.executeUpdate();
			System.out.println("Employee Addeed Successfully");
			
		}
		System.out.println();
		
	}
	private static void  viewEmployee(Connection conn ,Scanner s) throws SQLException{
		String sql="SELECT * FROM Employees";
		try(Statement stmt = conn.createStatement(); ResultSet rs=stmt.executeQuery(sql)){
			System.out.println("ID | Name | Age | Department | Sallary ");
			while(rs.next()) {
				System.out.printf("%d | %s | %d | %s | %2f" ,rs.getInt("id"),rs.getString("name")
				, rs.getInt("age"),rs.getString("Department"),rs.getDouble("Sallary"));
				System.out.println(); 
			}
		}
		System.out.println();
		
	}
	private static void updateEmployee(Connection conn,Scanner s) throws SQLException{
		System.out.println("Enter Employee id to Update");
	int id=s.nextInt();
	System.out.println("Enter New Sallary");
	double sallary=s.nextDouble();
	String sql="UPDATE Employees SET Sallary= ? WHERE id= ?";
	try(PreparedStatement pstm=conn.prepareStatement(sql)){
		pstm.setDouble(1, sallary);
		pstm.setInt(2, id);
		int rows=pstm.executeUpdate();
		if(rows>0) {
			System.out.println("Employee Updated Successfully!");
		}else {
			System.out.println("Employee ID not found!...");
		}
	}
	System.out.println();
	
	}
	private static void deleteEmployee(Connection conn,Scanner s) throws SQLException{
		System.out.println("Enter Employee id to Delete");
		int id=s.nextInt();
		String sql="DELETE FROM Employees WHERE id=?";
		try(PreparedStatement pstm=conn.prepareStatement(sql)){
			pstm.setInt(1, id);
			int rows=pstm.executeUpdate();
			if(rows>0) {
				System.out.println("Employee Deleted Successfully!");
			}
			else {
				System.out.println("Employee ID not Found!....");
			}
		}
		System.out.println();
		

		
	}

}
