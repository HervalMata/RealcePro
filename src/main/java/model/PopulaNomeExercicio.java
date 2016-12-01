package model;

import javax.persistence.EntityManager;

import util.JPAUtil;


public class PopulaNomeExercicio {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.geEntityManager();
		em.getTransaction().begin();
		
		NomeExercicio cidadePb1 = new NomeExercicio();
		cidadePb1.setNome("Supino declinado");
		cidadePb1.setgMusc(GrupoMuscular.P);
		em.persist(cidadePb1);
		
		NomeExercicio exe2 = new NomeExercicio();
		exe2.setNome("Supino Reto");
		exe2.setgMusc(GrupoMuscular.P);
		em.persist(exe2);
		
		NomeExercicio exe3 = new NomeExercicio();
		exe3.setNome("Supino com Alteres");
		exe3.setgMusc(GrupoMuscular.P);
		em.persist(exe3);
		
		em.getTransaction().commit();
		
		em.close();
	}
	
}
