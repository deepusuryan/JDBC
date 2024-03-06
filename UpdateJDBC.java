import java.sql.*;
public class UpdateJDBC{
    public static void main(String[] args) throws Exception{
        String url="jdbc:mysql://127.0.0.1:3306/MyDatabase";
        String username="root";
        String password="12345678";
        String query="update employees\n" +
                "set name='Big Hulu lulu', location='Delhi', salary=40000.0\n" +
                "where id=2;";
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
                System.out.println("Data updated successful "+rows_affect+" Rows affected");
            }else{
                System.out.println("Update failed");
            }
            connect.close();
            st.close();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
