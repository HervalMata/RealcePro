package persistence;

import java.util.List;

import javax.persistence.EntityManager;

import model.Exercicio;

import util.JPAUtil;

public class ExercicioDAO {

	public void salvar(Exercicio exercicio) {
		EntityManager gerente = JPAUtil.geEntityManager();
		gerente.getTransaction().begin();
		gerente.merge(exercicio);
		gerente.getTransaction().commit();
		gerente.close();

	}

	@SuppressWarnings("unchecked")
	public List<Exercicio> listarTodos() {
		EntityManager gerente = JPAUtil.geEntityManager();
		gerente.getTransaction().begin();

		return gerente.createQuery("from Exercicio").getResultList();

	}

	public void deletar(Exercicio exercicio) {
		EntityManager gerente = JPAUtil.geEntityManager();
		gerente.getTransaction().begin();
		exercicio = gerente.merge(exercicio);
		gerente.remove(exercicio);
		gerente.getTransaction().commit();
		gerente.close();
	}

	public Exercicio findById(Long id) {
		EntityManager gerente = JPAUtil.geEntityManager();
		gerente.getTransaction().begin();
		Exercicio p = new Exercicio();
		p = gerente.find(Exercicio.class, id);
		gerente.getTransaction().commit();
		return p;
	}

	// @SuppressWarnings("unchecked")
	public static List<Exercicio> obterExerciciosDoAluno(Long id) {
		EntityManager em = JPAUtil.geEntityManager();

		List<Exercicio> exercicios = em.createQuery("Select p from Exercicio p where usuario_id = :id", Exercicio.class).setParameter("id", id).getResultList();
		em.close();

		return exercicios;
	}
}
