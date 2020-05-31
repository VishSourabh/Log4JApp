/*Here we a try to configure Logger information using Property file this approach is industry standard  beacuse here we can achieve loose coupling*/

package com.souratech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;

public class SelectTest1FileAndHtmlLayout {
	private static final String GET_ALL_EMPLOYEE="SELECT EMPNO,ENAME,SAL FROM EMP";

	//Create a logger object
	private static final Logger log=Logger.getLogger(SelectTest1FileAndHtmlLayout.class);

/*	static {
		HTMLLayout layout=null;
		FileAppender appender=null;
		
		try {
			//create HTML Layout
			layout=new HTMLLayout();
			
			//create appender
			appender=new FileAppender(layout, "Applog.html", true);
			
			  1st parameter->We are giving layout for appender like we want in this format here i want html
			  
			  2nd parameter--> we have to mentioned file name,where log meassages will we stored 
			 
			  3rd parameter-->if it is true so it will not overwrite it will 
			                  add new massages but if it is false it will override.
			
			//give that appender to logger object
			log.addAppender(appender);
			
			//Specify level to retrieve logger massages
			log.setLevel(Level.ALL);
			
			
		} catch (Exception e) {
			log.error("Problem with creating logger object "+e.getMessage());
		}
	}//static
		*/
	
	/*Note- All of the above thing we will mention in property file..{LineNo 25 to 53} just we need to specify location of the property file using 
	PropertyConfigurator.configure().. in main()*/
		

		
	
	public static void main(String[] args){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean flag=false;


		try {
			PropertyConfigurator.configure("src/main/java/com/souratech/commons/log4j.properties");
			
			//initializing the Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			log.debug("Jdbc Driver initialized");
			//Creating the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			log.debug("Established the connection");

			//create PreparedStatement object
			if (con!=null) {
				ps=con.prepareStatement(GET_ALL_EMPLOYEE);
				log.debug("Prepared Statement object is created");
			}

			//send and execute the query
			if (ps!=null) {
				rs=ps.executeQuery();
				log.debug("Resultset object is created");
			}

			//creating the Resultset object for fatching records
			if (rs!=null) {
				System.out.println("Employee  Details"+"\n\n");
				while(rs.next()) {
					System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"    "+rs.getInt(3));

				}
				log.debug("Getting the result");

			}
			if (flag){
				System.out.println("Data is not available");
				log.info("Data is not availble");
			}else
				System.out.println("Data is available   "+new Date());
			log.info("Data is fatched");
		} catch (SQLException se) {
			se.printStackTrace();
			log.error("Sql related issue "+se.getMessage());

		}//catch
		catch (ClassNotFoundException ce) {
			ce.printStackTrace();
			log.error("Driver releated issue "+ce.getMessage());

		}//catch
		catch (Exception e) {
			e.printStackTrace();
			log.error("unknown problem " +e.getMessage());

		}//catch


		finally {
			try {
				if (ps!=null) {

					ps.close();
					log.debug("Ps is closed");
				}
			} catch (Exception e2) {
				e2.printStackTrace();		
				log.equals("Ps is not Closed"+e2.getMessage());
			}

			try {
				if (rs!=null) {

					rs.close();
					log.debug("RS is closed");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
				log.equals("RS is not Closed"+e2.getMessage());
			}
			try {
				if (con!=null) {

					con.close();
					log.debug("Con is closed");
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
				log.equals("Con is not Closed"+e2.getMessage());
			}

		}//finally

	}//main
}//class
