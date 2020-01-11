package com.deloitte.session.repo;
import com.deloitte.sessionmanagement.model.Person;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonRepoImpl implements PersonRepo {

	Connection con=null;
@Override
   public boolean addPerson(Person person) throws Exception {

	Connection con=getDbConnection();
	PreparedStatement ps=con.prepareStatement("insert into person values(?,?)");
    ps.setString(1, person.getUserName());
    ps.setString(2, person.getPassword());
    if(ps.executeUpdate()>0)
     return true;
    return false;
   }
   
@Override
public Person getPersonById(String userName) throws Exception {
  
	Connection con=getDbConnection();
    Statement st=con.createStatement();
    ResultSet rs=st.executeQuery("select uname,password from person where uname='"+userName+"'");
    Person prod=new Person();
    if(rs.next()) {
    prod.setUserName(rs.getString(1));
    prod.setPassword(rs.getString(2));
    return prod;

   }
    return null;
}
	
@Override
	public Connection getDbConnection() throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
		return con;
	}

}