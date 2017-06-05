package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.dominio.AppDoPedido;

public class AppDoPedidoDAO {
	private EntityManager manager;

	public AppDoPedidoDAO() {
		super();

		this.manager = UtilJPA.criarEntityManager();
	}

	public void incluir(AppDoPedido obj) {

		this.manager.getTransaction().begin();
		
		try {
			this.manager.persist(obj);
			this.manager.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
			this.manager.getTransaction().rollback();
		}

	}

	public void remover(AppDoPedido obj) {

				this.manager.getTransaction().begin();
				
				try {
					this.manager.remove(obj);
					this.manager.getTransaction().commit();
					
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
					this.manager.getTransaction().rollback();
				}

	}

	public List<AppDoPedido> buscarTodos() {
		
		String jpql = "FROM AppDoPedido ORDER BY id";
		
		TypedQuery<AppDoPedido> query = manager.createQuery(jpql, AppDoPedido.class);
		List<AppDoPedido> lista = query.getResultList();

		return lista;
	}
}
