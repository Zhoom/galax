package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.dominio.AppDoUsuario;
import modelo.dominio.Usuario;

public class AppDoUsuarioDAO {
	private EntityManager manager;

	public AppDoUsuarioDAO() {
		super();

		this.manager = UtilJPA.criarEntityManager();
	}

	public void incluir(AppDoUsuario obj) {

		this.manager.getTransaction().begin();
		
		try {
			this.manager.persist(obj);
			this.manager.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
			this.manager.getTransaction().rollback();
		}

	}

	public void remover(AppDoUsuario obj) {

				this.manager.getTransaction().begin();
				
				try {
					this.manager.remove(obj);
					this.manager.getTransaction().commit();
					
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
					this.manager.getTransaction().rollback();
				}

	}

	public void alterar(AppDoUsuario obj) {

				this.manager.getTransaction().begin();
				
				try {
					this.manager.merge(obj);
					this.manager.getTransaction().commit();
					
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
					this.manager.getTransaction().rollback();
				}

	}

	public AppDoUsuario buscar(Usuario id) {

		AppDoUsuario retorno = this.manager.find(AppDoUsuario.class, id);

		return retorno;

	}

	public List<AppDoUsuario> buscarTodos(Usuario usuario) {
		
		String jpql = "FROM AppDoUsuario WHERE usuario = '" + usuario + "'";
		
		TypedQuery<AppDoUsuario> query = manager.createQuery(jpql, AppDoUsuario.class);
		List<AppDoUsuario> listaAppUser = query.getResultList();

		return listaAppUser;
	}
}
