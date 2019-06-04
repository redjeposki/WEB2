package com.web2project.WEB2P;
import com.web2project.WEB2P.jo.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClass {

	public static void main(String[] args) {
		
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
		
        /*
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
