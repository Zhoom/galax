package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.dominio.Usuario;

public class UsuarioDAO {
	private EntityManager manager;

	public UsuarioDAO() {
		super();

		this.manager = UtilJPA.criarEntityManager();
	}

	public void incluir(Usuario obj) {

		this.manager.getTransaction().begin();
		
		try {
			this.manager.persist(obj);
			this.manager.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
			this.manager.getTransaction().rollback();
		}

	}

	public void remover(Usuario obj) {

				this.manager.getTransaction().begin();
				
				try {
					this.manager.remove(obj);
					this.manager.getTransaction().commit();
					
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
					this.manager.getTransaction().rollback();
				}

	}

	public void alterar(Usuario obj) {

				this.manager.getTransaction().begin();
				
				try {
					this.manager.merge(obj);
					this.manager.getTransaction().commit();
					
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
					this.manager.getTransaction().rollback();
				}

	}

	public Usuario buscarId(Integer userID) {

		Usuario retorno = this.manager.find(Usuario.class, userID);

		return retorno;

	}
	
	public Usuario buscarLogin(String login) {

		Usuario retorno = this.manager.find(Usuario.class, login);

		return retorno;
	}

	public List<Usuario> buscarTodos() {
		
		String jpql = "FROM Usuario ORDER BY userID";
		
		TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
		List<Usuario> lista = query.getResultList();

		return lista;
	}
}
