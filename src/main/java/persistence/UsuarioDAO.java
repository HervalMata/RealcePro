package persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Usuario;
import util.JPAUtil;

public class UsuarioDAO {

	public void salvar(Usuario usuario) {
		EntityManager gerente = JPAUtil.geEntityManager();
		gerente.getTransaction().begin();
		gerente.merge(usuario);

		gerente.getTransaction().commit();
		gerente.close();

	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listarTodos() {
		EntityManager gerente = JPAUtil.geEntityManager();
		gerente.getTransaction().begin();

		return gerente.createQuery("from Usuario").getResultList();

	}

	public void Editar(Usuario usuario) {
		EntityManager gerente = JPAUtil.geEntityManager();
		gerente.getTransaction().begin();
		gerente.merge(usuario);
		gerente.getTransaction().commit();
		gerente.close();

	}

	public Usuario obterPorId(Long id) {
		EntityManager em = JPAUtil.geEntityManager();
		em.getTransaction().begin();

		return em.createQuery("from Usuario where id = :id", Usuario.class).setParameter("id", id).getSingleResult();

	}

	public Usuario verificarDados(Usuario usuario) throws Exception {
		Usuario us = null;

		try {

			EntityManager gerente = JPAUtil.geEntityManager();
			gerente.getTransaction().begin();

			Query query = gerente.createQuery(
					"FROM Usuario where email ='" + usuario.getEmail() + "' and senha = '" + usuario.getSenha() + "'");

			if (!query.getResultList().isEmpty()) {
				us = (Usuario) query.getResultList().get(0);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return us;

	}

	public Usuario findById(Long id) {
		EntityManager gerente = JPAUtil.geEntityManager();
		gerente.getTransaction().begin();
		Usuario usuario = new Usuario();
		usuario = gerente.find(Usuario.class, id);
		gerente.getTransaction().commit();
		return usuario;
	}

	public void deletar(Usuario usuario) {
		EntityManager gerente = JPAUtil.geEntityManager();
		gerente.getTransaction().begin();
		usuario = gerente.merge(usuario);
		gerente.remove(usuario);
		gerente.getTransaction().commit();
		gerente.close();
	}

}
