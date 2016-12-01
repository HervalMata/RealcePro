package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Aviso;
import persistence.AvisoDAO;




@ManagedBean
@SessionScoped
public class AvisoBean {
	
	private Aviso aviso;
	
	private List<Aviso> avisos = new ArrayList<Aviso>();
	
	public AvisoBean(){
		avisos = new AvisoDAO().listarTodos();
		aviso = new Aviso();
	}
	
	
	public String salvar(){
		new AvisoDAO().salvar(aviso);
		avisos = new AvisoDAO().listarTodos();
		aviso = new Aviso();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aviso cadastrado com sucesso!"));
		return "avisoadmin?faces-redirect=true";
	}
	
	public String editar(Aviso aviso){
		this.aviso = aviso;
		
		return "cadastro-aviso?faces-redirect=true";
	}
	
	public void deletar(Aviso aviso){
		new AvisoDAO().deletar(aviso);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario deletado com sucesso!"));
		avisos = new AvisoDAO().listarTodos();
	}

	public Aviso getAviso() {
		return aviso;
	}

	public void setAviso(Aviso aviso) {
		this.aviso = aviso;
	}

	public List<Aviso> getAvisos() {
		return avisos;
	}

	public void setAvisos(List<Aviso> avisos) {
		this.avisos = avisos;
	}
	


}
