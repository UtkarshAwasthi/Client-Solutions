
package db;

import java.sql.*;
import javax.swing.JOptionPane;

public class DbConnect {
    public static Connection c;
    public static Statement st;
    public static PreparedStatement insertClient,getClients,updateClient;
    static{
        try{
    Class.forName("oracle.jdbc.driver.OracleDriver");
c=DriverManager.getConnection(
"jdbc:oracle:thin:@localhost:1521:xe","clientsoldb","clientsoldb");
st=c.createStatement();
insertClient=c.prepareStatement("insert into client_info (name,gender,dob,country,address,language) "
 + "values(?,?,?,?,?,?)");
getClients=c.prepareStatement("select * from client_info  where name like ?");
updateClient=c.prepareStatement("update client_info set name=?,gender=?,dob=?,country=?,"
        + "address=?,language=?  where cid=?");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    static public void dbClose(){
         try{
            c.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }
}
