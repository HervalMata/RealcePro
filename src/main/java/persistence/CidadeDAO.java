package persistence;

import java.util.List;

import javax.persistence.EntityManager;

import model.Cid;

import model.Estado;
import util.JPAUtil;

public class CidadeDAO {

	@SuppressWarnings("unchecked")
	public static List<Cid> obterCidadesDoEstado(Estado estado) {
		EntityManager em = JPAUtil.geEntityManager();

		List<Cid> cidades = em.createQuery("Select p from Cidade p where estado = :uf").setParameter("uf", estado).getResultList();

		em.close();

		return cidades;
	}

	public Cid findById(Long id) {
		EntityManager gerente = JPAUtil.geEntityManager();
		gerente.getTransaction().begin();
		Cid p = new Cid();
		p = gerente.find(Cid.class, id);
		gerente.getTransaction().commit();
		return p;
	}

}
