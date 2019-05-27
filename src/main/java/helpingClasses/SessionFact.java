package helpingClasses;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFact {

	private static  SessionFactory sf = buildSessionfactory();

	private static SessionFactory buildSessionfactory() {
		
		try {
			
		 sf = new Configuration().configure().buildSessionFactory();
			
		} catch (Exception e) {
			System.out.println("Error in session factory building");
			System.out.println(e+"-------------------------------------");
		}
		
		return sf;
	}
	
	
	public static SessionFactory getSessionFactory() {
		
		return sf;
	}
	
	public static void main(String[] args) {
		SessionFactory sf = SessionFact.getSessionFactory();
		
		if(sf != null) {
			System.out.println("Not null");
		}
		else {
			System.out.println("Null ");
		}
	}
}
