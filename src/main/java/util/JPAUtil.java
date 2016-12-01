package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	public static EntityManager geEntityManager(){
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("realcepro");
		return fabrica.createEntityManager();
	}

}
