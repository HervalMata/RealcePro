package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Cid;
import model.Estado;
import model.Usuario;
import persistence.CidadeDAO;
import persistence.UsuarioDAO;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	private List<Usuario> usuarios = new ArrayList<Usuario>();

	private List<Estado> estados;

	private Long idCidade;

	public UsuarioBean() {
		usuarios = new UsuarioDAO().listarTodos();
		usuario = new Usuario();
		estados = Arrays.asList(Estado.values());
	}

	public List<Cid> pegarCidadesEstado() {
		return CidadeDAO.obterCidadesDoEstado(usuario.getEndereco().getCidade().getEstado());
	}

	
	public String salvar() {
		usuario.getEndereco().setCidade(new CidadeDAO().findById(idCidade));
		new UsuarioDAO().salvar(usuario);
		usuarios = new UsuarioDAO().listarTodos();
		usuario = new Usuario();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario cadastrado com sucesso!"));
		return "index_admin?faces-redirect=true";
	}

	public String editar(Usuario usuario) {
		
		this.usuario = usuario;
		
		idCidade = usuario.getEndereco().getCidade().getId();

		return "cadastro-usuario?faces-redirect=true";
	}

	public void deletar(Usuario usuario) {
		new UsuarioDAO().deletar(usuario);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario deletado com sucesso!"));
		usuarios = new UsuarioDAO().listarTodos();

	}

	public String verificarUsuario() throws Exception {
		UsuarioDAO usuDAO = new UsuarioDAO();
		Usuario us;
		String resultado;

		try {
			us = usuDAO.verificarDados(this.usuario);

			if (us != null) {
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);

				System.out.println("to no metodo");

				resultado = "logado?faces-redirect=true";

			} else {
				resultado = "Error";
				System.out.println("entrei no error");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario nao existe"));
			}

		} catch (Exception e) {
			throw e;
		}

		return resultado;

	}

	// verificar se o usuario esta logado
	public boolean verificarSessao() {
		boolean estado;

		if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario") == null) {
			estado = false;
		} else {
			estado = true;
		}
		return estado;
	}

	// logout
	public String encerrarSessao() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		System.out.println("usei metodo");
		return "index?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Long getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}

}
