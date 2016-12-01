package persistence;

import java.util.List;

import javax.persistence.EntityManager;

import model.GrupoMuscular;
import model.NomeExercicio;
import util.JPAUtil;

public class NomeExercicioDAO {
	
	@SuppressWarnings("unchecked")
	public static List<NomeExercicio> obterNomeExercicioPorGrupo(GrupoMuscular gMusc) {
		EntityManager em = JPAUtil.geEntityManager();

		List<NomeExercicio> nExes = em.createQuery("from NomeExercicio where gMusc = :uf").setParameter("uf", gMusc)
				.getResultList();

		em.close();

		return nExes;
	}

	
	public NomeExercicio findById(Long id){
		EntityManager gerente = JPAUtil.geEntityManager();
		gerente.getTransaction().begin();
		NomeExercicio p = new NomeExercicio();
		p = gerente.find(NomeExercicio.class, id);
		gerente.getTransaction().commit();
		return p;
	}

}
