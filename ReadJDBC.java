import java.sql.*;
public class ReadJDBC{
    public static void main(String[] args) throws ClassNotFoundException{
        String url="jdbc:mysql://127.0.0.1:3306/MyDatabase";
        String username="root";
        String password="12345678";
        String query="select * from employees;";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connect=DriverManager.getConnection(url, username, password);
            System.out.println("Connection established");
            Statement st=connect.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String location=rs.getString("location");
                double salary=rs.getDouble("salary");
                System.out.println();
                System.out.println("************************");
                System.out.println("iD :"+id);
                System.out.println("name :"+name);
                System.out.println("location :"+location);
                System.out.println("Salary :"+salary);
            }
            connect.close();
            st.close();
            rs.close();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}