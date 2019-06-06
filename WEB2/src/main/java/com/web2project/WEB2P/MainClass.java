package com.web2project.WEB2P;
import com.web2project.WEB2P.jo.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//for Shiro
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.log4j.*;

//@SuppressWarnings("deprecation")
public class MainClass {
	//private static final transient Logger log = LoggerFactory.getLogger(MainClass.class);
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		//Enable Shiro
	    Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini"); //1.
	    
	    SecurityManager securityManager = factory.getInstance(); //2.
	    SecurityUtils.setSecurityManager(securityManager); //3.
	   
	    //Get the current User info
	    Subject currentUser = SecurityUtils.getSubject();
	    
	    //Create session to set user related attributes 
	    Session session = currentUser.getSession();
	    session.setAttribute( "someKey", "aValue" );
	     
	    
	    try {
	    	
	    	//collect user principals and credentials such as username/password	    
	    	if ( !currentUser.isAuthenticated() ) {
	    		UsernamePasswordToken token = new UsernamePasswordToken("elvis", "123456");
	        
	    		//if user check remember me, no additional configuration is required, just this one
	    		token.setRememberMe(true);
	    		currentUser.login(token);
	    	}
	    } catch ( UnknownAccountException uae ) {
	        //username wasn't in the system
	    } catch ( IncorrectCredentialsException ice ) {
	        //password didn't match
	    } catch ( LockedAccountException lae ) {
	        //account for that username is locked - can't login.  Show them a message?
	    } catch ( AuthenticationException ae ) {
	        //unknown error?
	    }
		
	    //print the user info
	    System.out.println(currentUser.getPrincipal());
	    
	    //removes all identifying information and invalidates their session too.
	    currentUser.logout(); 
	    
	    
	    /*
		DBTools DBC = new DBTools();
		//DBC.dropTable("userin");
		//DBC.createSequence();
		//DBC.createTable("testo");
		//DBC.createCustomTable();
		//DBC.createTable("Users");
		//DBC.insertIntoTable("Users", "Username1", "username2");
		//DBC.insertIntoTable("Users", "Username12", "username23");
		//DBC.insertIntoTable("Users", "ex", "dex");
		//DBC.insertIntoTable(2, "John", "John");
		DBC.printRecords("userin");
		//DBC.dropTable("userin");
		
		//test objects
		User user1 = new User();
		user1.setName("Username1");
		user1.setSurname("Surname1");
		user1.setEmail("ex@egegerx.com");
		user1.setBirthday("22.07.1994");
		//userin.setuID(10);
		
		
		User user2 = new User();
		user2.setName("Username2");
		user2.setSurname("Tesdsst2");
		user2.setEmail("eax@etgraszrx.com");
		user2.setBirthday("22.06.1994");
		
        ///*
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("userinfo");
		EntityManager EM = EMF.createEntityManager();
		EM.getTransaction().begin();
		EM.persist(user1);
		EM.persist(user2);
		EM.getTransaction().commit();
		EM.close();
		*/
		
		
		
	}

}
