package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Exercicio;
import model.GrupoMuscular;
import model.Metodo;
import model.NomeExercicio;
import model.Serie;
import model.SerieRepeti;
import model.TipoCarga;
import model.Usuario;
import persistence.ExercicioDAO;

import persistence.NomeExercicioDAO;
import persistence.UsuarioDAO;

@ManagedBean
@SessionScoped
public class ExercicioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Exercicio exercicio;

	private List<Exercicio> exercicios = new ArrayList<Exercicio>();

	private List<GrupoMuscular> gMs;

	private Long idNomeExer;

	private List<SerieRepeti> serieRep = new ArrayList<SerieRepeti>();

	private List<Serie> series = new ArrayList<Serie>();

	private List<Metodo> metodos = new ArrayList<Metodo>();

	private List<TipoCarga> tCargas = new ArrayList<TipoCarga>();

	private Long idUsuario;

	private Long idUser  = (long) 10;

	public ExercicioBean() {
		exercicios = new ExercicioDAO().listarTodos();
		exercicio = new Exercicio();
		gMs = Arrays.asList(GrupoMuscular.values());
		serieRep = Arrays.asList(SerieRepeti.values());
		series = Arrays.asList(Serie.values());
		metodos = Arrays.asList(Metodo.values());
		tCargas = Arrays.asList(TipoCarga.values());
	}

	public List<NomeExercicio> getNomeExerDoGrupo() {
		return NomeExercicioDAO.obterNomeExercicioPorGrupo(exercicio.getNomeExerc().getgMusc());
	}

	public List<Usuario> pegarUsuarios() {
		return new UsuarioDAO().listarTodos();
	}

	public String salvar() {
		exercicio.setNomeExerc(new NomeExercicioDAO().findById(idNomeExer));
		exercicio.setUsuario(new UsuarioDAO().findById(idUsuario));
		new ExercicioDAO().salvar(exercicio);
		exercicios = new ExercicioDAO().listarTodos();
		exercicio = new Exercicio();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exercicio cadastrado com sucesso!"));
		return "index_admin?faces-redirect=true";
	}

	public List<Exercicio> pegExercicioDoAluno() {

		// FacesContext fCtx = FacesContext.getCurrentInstance();
		// HttpSession session = (HttpSession)
		// fCtx.getExternalContext().getSession(false);
		// String sessionId = session.getId();

		//exercicio.setUsuario(new UsuarioDAO().findById(idUser));

		// idUsuario = sessionId;
		// exercicio.setUsuario(new UsuarioDAO().findById(idUsuario));
		idUsuario = exercicio.getUsuario().getId();
		return ExercicioDAO.obterExerciciosDoAluno(idUsuario);
	}

	public List<Exercicio> listarExercicioAlunoId() {

		return ExercicioDAO.obterExerciciosDoAluno(idUsuario);
	}

	public String editar(Exercicio exercicio) {
		this.exercicio = exercicio;

		return "cadastro-exercicio?faces-redirect=true";
	}

	public void deletar(Exercicio exercicio) {
		new ExercicioDAO().deletar(exercicio);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario deletado com sucesso!"));
		exercicios = new ExercicioDAO().listarTodos();

	}

	public Exercicio getExercicio() {
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

	public List<Exercicio> getExercicios() {
		return exercicios;
	}

	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}

	public List<GrupoMuscular> getgMs() {
		return gMs;
	}

	public void setgMs(List<GrupoMuscular> gMs) {
		this.gMs = gMs;
	}

	public Long getIdNomeExer() {
		return idNomeExer;
	}

	public void setIdNomeExer(Long idNomeExer) {
		this.idNomeExer = idNomeExer;
	}

	public List<SerieRepeti> getSerieRep() {
		return serieRep;
	}

	public void setSerieRep(List<SerieRepeti> serieRep) {
		this.serieRep = serieRep;
	}

	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	public List<Metodo> getMetodos() {
		return metodos;
	}

	public void setMetodos(List<Metodo> metodos) {
		this.metodos = metodos;
	}

	public List<TipoCarga> gettCargas() {
		return tCargas;
	}

	public void settCargas(List<TipoCarga> tCargas) {
		this.tCargas = tCargas;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	

}
