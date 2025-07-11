
package codes;

//import com.sun.jdi.connect.spi.Connection;
import com.mysql.cj.jdbc.Driver;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
//import com.mysql.jdbc.Driver;
import java.sql.Connection;

public class DBconnect {
    public static Connection connect(){
        Connection conn=null;
        
        try{
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store","root","");   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        return conn;
    }
    
   
}
