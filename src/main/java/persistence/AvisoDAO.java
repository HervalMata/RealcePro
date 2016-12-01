package persistence;

import java.util.List;

import javax.persistence.EntityManager;

import model.Aviso;
import util.JPAUtil;

public class AvisoDAO {

	public void salvar(Aviso aviso) {
		EntityManager gerente = JPAUtil.geEntityManager();
		gerente.getTransaction().begin();
		gerente.merge(aviso);
		gerente.getTransaction().commit();
		gerente.close();

	}

	@SuppressWarnings("unchecked")
	public List<Aviso> listarTodos() {
		EntityManager gerente = JPAUtil.geEntityManager();
		gerente.getTransaction().begin();

		return gerente.createQuery("from Aviso").getResultList();

	}


	public void deletar(Aviso aviso) {
		EntityManager gerente = JPAUtil.geEntityManager();
		gerente.getTransaction().begin();
		aviso = gerente.merge(aviso);
		gerente.remove(aviso);
		gerente.getTransaction().commit();
		gerente.close();
	}

}
