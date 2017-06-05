package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.dominio.Pedido;

public class PedidoDAO {
	private EntityManager manager;

	public PedidoDAO() {
		super();

		this.manager = UtilJPA.criarEntityManager();
	}

	public void incluir(Pedido obj) {

		this.manager.getTransaction().begin();
		
		try {
			this.manager.persist(obj);
			this.manager.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage() + "/nRollback será realizado");
			this.manager.getTransaction().rollback();
		}

	}

	public Pedido buscar(Integer pedidoID) {

		Pedido retorno = this.manager.find(Pedido.class, pedidoID);

		return retorno;

	}

	public List<Pedido> buscarTodos() {
		
		String jpql = "FROM Pedido ORDER BY pedidoID";
		
		TypedQuery<Pedido> query = manager.createQuery(jpql, Pedido.class);
		List<Pedido> lista = query.getResultList();

		return lista;
	}
}
