package persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Admin;
import util.JPAUtil;

public class AdminDAO {

	public void salvar(Admin admin) {
		EntityManager gerente = JPAUtil.geEntityManager();
		gerente.getTransaction().begin();
		gerente.merge(admin);
		gerente.getTransaction().commit();
		gerente.close();

	}

	@SuppressWarnings("unchecked")
	public List<Admin> listarTodos() {
		EntityManager gerente = JPAUtil.geEntityManager();
		gerente.getTransaction().begin();

		return gerente.createQuery("from Admin").getResultList();

	}


	public Admin verificarDados(Admin admin) throws Exception {
		Admin us = null;

		try {

			EntityManager gerente = JPAUtil.geEntityManager();
			gerente.getTransaction().begin();

			Query query = gerente.createQuery(
					"FROM Admin where email ='" + admin.getEmail() + "' and senha = '" + admin.getSenha() + "'");

			if (!query.getResultList().isEmpty()) {
				us = (Admin) query.getResultList().get(0);

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return us;

	}

	public void deletar(Admin admin) {
		EntityManager gerente = JPAUtil.geEntityManager();
		gerente.getTransaction().begin();
		admin = gerente.merge(admin);
		gerente.remove(admin);
		gerente.getTransaction().commit();
		gerente.close();
	}

}
