import java.sql.*;
public class DeleteJDBC{
    public static void main(String[] args) throws Exception{
        String url="jdbc:mysql://127.0.0.1:3306/MyDatabase";
        String username="root";
        String password="12345678";
        String query="delete from employees where id=2;";
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
                System.out.println("Data deleted successful "+rows_affect+" Rows affected");
            }else{
                System.out.println("Deletion failed");
            }
            connect.close();
            st.close();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
