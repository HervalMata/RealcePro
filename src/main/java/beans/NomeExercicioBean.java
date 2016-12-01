package beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.GrupoMuscular;
import model.NomeExercicio;
import persistence.GenericDAO;

@ManagedBean
@SessionScoped
public class NomeExercicioBean {

	private NomeExercicio nExercicio;

	private List<NomeExercicio> nExercicios = new ArrayList<NomeExercicio>();

	private List<GrupoMuscular> gMs;

	public NomeExercicioBean() {
		nExercicios = new GenericDAO<NomeExercicio>(NomeExercicio.class).listarTodos();
		nExercicio = new NomeExercicio();

		gMs = Arrays.asList(GrupoMuscular.values());
	}
	
	public String salvar(){
		new GenericDAO<NomeExercicio>(NomeExercicio.class).salvar(nExercicio);
		nExercicios = new GenericDAO<NomeExercicio>(NomeExercicio.class).listarTodos();
		nExercicio = new NomeExercicio();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exercicio salvo com Sucesso"));
		return "index_admin?faces-redirect=true";
	}
	
	public String editar(NomeExercicio nExercicio){
		this.nExercicio = nExercicio;
		return "cadastro-nomeExercicio?faces-redirect=true";
		
	}
	
	public void deletar(NomeExercicio nExercicio){
		new GenericDAO<NomeExercicio>(NomeExercicio.class).excluir(nExercicio);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exercicio deletado com Sucesso"));
	}

	public List<GrupoMuscular> getgMs() {
		return gMs;
	}

	public void setgMs(List<GrupoMuscular> gMs) {
		this.gMs = gMs;
	}

	public NomeExercicio getnExercicio() {
		return nExercicio;
	}

	public void setnExercicio(NomeExercicio nExercicio) {
		this.nExercicio = nExercicio;
	}

	public List<NomeExercicio> getnExercicios() {
		return nExercicios;
	}

	public void setnExercicios(List<NomeExercicio> nExercicios) {
		this.nExercicios = nExercicios;
	}

}
