package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.dominio.AppDoCarrinho;

public class AppDoCarrinhoDAO {
	private EntityManager manager;

	public AppDoCarrinhoDAO() {
		super();

		this.manager = UtilJPA.criarEntityManager();
	}

	public void incluir(AppDoCarrinho obj) {

		this.manager.getTransaction().begin();
		
		try {
			this.manager.persist(obj);
			this.manager.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
			this.manager.getTransaction().rollback();
		}

	}

	public void remover(AppDoCarrinho obj) {

				this.manager.getTransaction().begin();
				
				try {
					this.manager.remove(obj);
					this.manager.getTransaction().commit();
					
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
					this.manager.getTransaction().rollback();
				}

	}

	public void alterar(AppDoCarrinho obj) {

				this.manager.getTransaction().begin();
				
				try {
					this.manager.merge(obj);
					this.manager.getTransaction().commit();
					
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
					this.manager.getTransaction().rollback();
				}

	}

	public List<AppDoCarrinho> buscarTodos() {
		
		String jpql = "FROM AppDoCarrinho ORDER BY id";
		
		TypedQuery<AppDoCarrinho> query = manager.createQuery(jpql, AppDoCarrinho.class);
		List<AppDoCarrinho> lista = query.getResultList();

		return lista;
	}
}
