import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageJDBC{
    public static void main(String[] args){
        String url="jdbc:mysql://127.0.0.1:3306/MyDatabase";
        String username="root";
        String password="12345678";
        String image_path="C:\\Users\\Deepanshu\\OneDrive\\Pictures\\Images\\Deepu.jpg";
        String query="insert into image(image_data) values (?)";

        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection connect= DriverManager.getConnection(url,username,password);
            FileInputStream fis=new FileInputStream(image_path);
            byte[] image_data=new byte[fis.available()];
            fis.read(image_data);
            PreparedStatement pst=connect.prepareStatement(query);
            pst.setBytes(1,image_data);
            int rowsAffect=pst.executeUpdate();
            if(rowsAffect>0){
                System.out.println("Image uploaded successfully");
            }
            else{
                System.out.println("Image not uploaded");
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