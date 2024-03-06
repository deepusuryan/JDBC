import java.io.FileNotFoundException;
import java.sql.*;
public class InsertJDBC{
    public static void main(String[] args) throws Exception{
        String url="jdbc:mysql://127.0.0.1:3306/MyDatabase";
        String username="root";
        String password="12345678";
        String query="insert into employees(id,name,location,salary) values (3, 'Hulu lulu', 'noida', 50000);";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connect=DriverManager.getConnection(url, username, password);
            Statement st=connect.createStatement();
            int rows_affect=st.executeUpdate(query);

            if(rows_affect>0){
                System.out.println("Data insertion successful "+rows_affect+" Rows affected");
            }else{
                System.out.println("Insertion failed");
            }
            connect.close();
            st.close();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
