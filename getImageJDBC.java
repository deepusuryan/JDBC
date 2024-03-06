import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class getImageJDBC{
    public static void main(String[] args){
        String url="jdbc:mysql://127.0.0.1:3306/MyDatabase";
        String username="root";
        String password="12345678";
        String folder_path="C:\\Users\\Deepanshu\\OneDrive\\Pictures\\Deepu\\";
        String query="select image_data from image where image_ID= (?)";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connect= DriverManager.getConnection(url,username,password);
            PreparedStatement pst=connect.prepareStatement(query);
            pst.setInt(1,1);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                byte[] image_data=rs.getBytes("image_data");
                String image_path=folder_path+"Tannu loves Deepu.pdf";
                OutputStream recieve=new FileOutputStream(image_path);
                recieve.write(image_data);
                System.out.println("image recieved successfully...");
            }
            else{
                System.out.println("Image not found");
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
