package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class ConnectionTest {
	
	static Session session = null;
	static int lport;
    static String rhost;
    static int rport;
    
    public static void go(){
        String user = "ricardo";
        String password = "ahnit39BAZ+";
        String host = "www1.websaver.ca";
        int port=22;
        
        try
            {
            JSch jsch = new JSch();
            session = jsch.getSession(user, host, port);
            lport = 3306;
            rhost = "10.5.3.147";
            rport = 3306;
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            System.out.println("Establishing Connection...");
            session.connect();
            int assinged_port=session.setPortForwardingL(lport, rhost, rport);
            System.out.println("localhost:" + assinged_port + " -> " + rhost + ":" + rport);
            }
        catch(Exception e){
        	System.err.print(e);
        	}
        
    }
    
    public static void main (String[] args){
  
    	try{
            go();
        } catch(Exception ex){
            ex.printStackTrace();
        }
         
    	System.out.println("An example for updating a Row from Mysql Database!");
        Connection con = null;
        String driver = "com.mysql.jdbc.Driver";
        String dbUser = "club_app_stg";
        String dbPasswd = "qp@0pjjsud";
        String url = "jdbc:mysql://localhost:"+lport+"/WSCLUB_stg";
          try{
        	  Class.forName(driver).newInstance();
        	  con = DriverManager.getConnection(url, dbUser, dbPasswd);
        	  try{
        		  Statement st = con.createStatement();
        		  String sql = "UPDATE ws_users"  +  " " + "SET enabled = 0 WHERE email='qa5@bamstrategy.com'";
        		  int update = st.executeUpdate(sql);
    
        		  if(update >= 1){
        			  System.out.println("Row is updated.");
        		  }
        		  else{
        			  System.out.println("Row is not updated.");
        		  }
          		}catch (SQLException s){
          			System.out.println("SQL statement is not executed!");
          		}
          	} catch (Exception e){
          		e.printStackTrace();
          	}finally {
        	  if(session !=null && session.isConnected()){
                  System.out.println("Closing SSH Connection");
                  session.disconnect();
              }
             }
    }
 }
  


		   

	   
	   
	